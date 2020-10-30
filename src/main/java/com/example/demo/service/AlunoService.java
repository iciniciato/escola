package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.mapper.AlunoDtoMapper;
import com.example.demo.dto.mapper.AlunoEntityMapper;
import com.example.demo.entity.AlunoEntity;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

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
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setId(id);
        alunoRepository.delete(alunoEntity);
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
