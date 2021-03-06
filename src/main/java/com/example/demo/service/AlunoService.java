package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.AlunoEntity;
import com.example.demo.entity.MentoriaEntity;
import com.example.demo.exceptions.ImpossivelExcluir;
import com.example.demo.dto.mapper.AlunoMapper;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    public Iterable<AlunoEntity> getAlunos() {
        Iterable<AlunoEntity> alunos = alunoRepository.findAll();
        return alunos;
    }

    @Transactional(readOnly = true)
    public AlunoDTO getAlunoByIndex(Long id) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
        AlunoDTO alunoDTO = new AlunoDTO();
        if (alunoEntity.isPresent()) {
            alunoDTO = alunoMapper.toAlunoDTO(alunoEntity.get());
        }
        return alunoDTO;
    }

    @Transactional(readOnly = true)
    public void criaAluno(AlunoDTO alunoDTO) {
        AlunoEntity alunoEntity = alunoMapper.toAlunoEntity(alunoDTO);
        alunoRepository.save(alunoEntity);
    }

    @Transactional(readOnly = true)
    public void excluiAluno(Long id) {
        List<MentoriaEntity> mentoriaEntities = mentoriaRepository.findByAluno_Id(id);
        if(!mentoriaEntities.isEmpty()){
            throw new ImpossivelExcluir("Impossível excluir aluno, pois está em uso na mentoria.");

        }
            Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
            alunoEntity.ifPresent(entity -> alunoRepository.delete(entity));
    }

    private AlunoEntity setaInformacoesAluno(AlunoDTO alunoDTO, AlunoEntity alunoEntity) {
        if (Objects.nonNull(alunoDTO.getNome())) {
            alunoEntity.setNome(alunoDTO.getNome());
        }
        if (Objects.nonNull(alunoDTO.getClasse())) {
            alunoEntity.setClasse(alunoDTO.getClasse());
        }
        return alunoEntity;
    }

    @Transactional(readOnly = true)
    public Boolean alteraAluno(AlunoDTO alunoDTO, Long id) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
        if (alunoEntity.isPresent()) {
            AlunoEntity alunoParaAlterar = setaInformacoesAluno(alunoDTO, alunoEntity.get());
            alunoRepository.save(alunoParaAlterar);
            return true;
        }
        return false;
    }
}
