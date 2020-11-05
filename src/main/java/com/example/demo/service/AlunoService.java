package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.mapper.AlunoDtoMapper;
import com.example.demo.dto.mapper.AlunoEntityMapper;
import com.example.demo.entity.AlunoEntity;
import com.example.demo.entity.MentoriaEntity;
import com.example.demo.exceptions.ImpossivelExcluir;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    public Iterable<AlunoEntity> getAlunos() {
        Iterable<AlunoEntity> alunos = alunoRepository.findAll();
        return alunos;
    }

    public AlunoDTO getAlunoByIndex(Long id) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
        AlunoDTO alunoDTO = new AlunoDTO();
        if (alunoEntity.isPresent()) {
            alunoDTO = AlunoDtoMapper.converteAlunoEntity(alunoEntity.get());
        }
        return alunoDTO;
    }

    public void criaAluno(AlunoDTO alunoDTO) {
        AlunoEntity alunoEntity = AlunoEntityMapper.converteAlunoDto(alunoDTO);
        alunoRepository.save(alunoEntity);
    }

    public void excluiAluno(Long id) {
        List<MentoriaEntity> mentoriaEntities = mentoriaRepository.findByAluno_Id(id);
        if (mentoriaEntities.isEmpty()) {
            Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
            if (alunoEntity.isPresent()) {
                alunoRepository.delete(alunoEntity.get());
            }
        } else {
            throw new ImpossivelExcluir("Impossível excluir aluno, pois está em uso na mentoria.");
        }
    }

    public Boolean alteraAluno(AlunoDTO alunoDTO, Long id) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
        if (alunoEntity.isPresent()) {
            AlunoEntity alunoParaAlterar =
                    AlunoEntityMapper.setaInformacoesAluno(alunoDTO, alunoEntity.get());
            alunoRepository.save(alunoParaAlterar);
            return true;
        }
        return false;
    }
}
