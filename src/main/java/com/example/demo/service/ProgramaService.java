package com.example.demo.service;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.dto.mapper.ProgramaDtoMapper;
import com.example.demo.dto.mapper.ProgramaEntityMapper;
import com.example.demo.entity.ProgramaEntity;
import com.example.demo.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    public Iterable<ProgramaEntity> getProgramas() {
        Iterable<ProgramaEntity> programas = programaRepository.findAll();
        return programas;
    }

    public ProgramaDTO getProgramaByIndex(Long id) {
        Optional<ProgramaEntity> programaEntity = programaRepository.findById(id);
        ProgramaDTO programaDTO = new ProgramaDTO();
        if (programaEntity.isPresent()) {
            programaDTO = ProgramaDtoMapper.converteProgramaEntity(programaEntity.get());
        }
        return programaDTO;
    }

    public void criaPrograma(ProgramaDTO programaDTO) {
        ProgramaEntity programaEntity = ProgramaEntityMapper.converteProgramaDto(programaDTO);
        programaRepository.save(programaEntity);
    }

    public void excluiPrograma(Long id) {
        Optional<ProgramaEntity> programaEntity = programaRepository.findById(id);
        if (programaEntity.isPresent()) {
            programaRepository.delete(programaEntity.get());
        }
    }

    public Boolean alteraPrograma(ProgramaDTO programaDTO, Long id) {
        Optional<ProgramaEntity> programaEntity = programaRepository.findById(id);
        if (programaEntity.isPresent()) {
            ProgramaEntity programaParaAlterar =
                    ProgramaEntityMapper.setaInformacoesPrograma(programaDTO, programaEntity.get());
            programaRepository.save(programaParaAlterar);
            return true;
        }
        return false;
    }
}
