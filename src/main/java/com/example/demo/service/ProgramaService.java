package com.example.demo.service;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.entity.ProgramaEntity;
import com.example.demo.dto.mapper.ProgramaMapper;
import com.example.demo.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    @Autowired
    private ProgramaMapper programaMapper;

    public Iterable<ProgramaEntity> getProgramas() {
        Iterable<ProgramaEntity> programas = programaRepository.findAll();
        return programas;
    }

    public ProgramaDTO getProgramaByIndex(Long id) {
        Optional<ProgramaEntity> programaEntity = programaRepository.findById(id);
        ProgramaDTO programaDTO = new ProgramaDTO();
        if (programaEntity.isPresent()) {
            programaDTO = programaMapper.toProgramaDTO(programaEntity.get());
        }
        return programaDTO;
    }

    public void criaPrograma(ProgramaDTO programaDTO) {
        ProgramaEntity programaEntity = programaMapper.toProgramaEntity(programaDTO);
        programaRepository.save(programaEntity);
    }

    public void excluiPrograma(Long id) {
        Optional<ProgramaEntity> programaEntity = programaRepository.findById(id);
        if (programaEntity.isPresent()) {
            programaRepository.delete(programaEntity.get());
        }
    }

    ProgramaEntity setaInformacoesPrograma(ProgramaDTO programaDTO, ProgramaEntity programaEntity) {
        if (Objects.nonNull(programaDTO.getNome())) {
            programaEntity.setNome(programaDTO.getNome());
        }
        if (Objects.nonNull(programaDTO.getAno())) {
            programaEntity.setAno(programaDTO.getAno());
        }
        if (Objects.nonNull(programaDTO.getDataInicio())) {
            programaEntity.setDataInicio(programaDTO.getDataInicio());
        }
        if (Objects.nonNull(programaDTO.getDataFim())) {
            programaEntity.setDataFim(programaDTO.getDataFim());
        }
        return programaEntity;
    }

    public Boolean alteraPrograma(ProgramaDTO programaDTO, Long id) {
        Optional<ProgramaEntity> programaEntity = programaRepository.findById(id);
        if (programaEntity.isPresent()) {
            ProgramaEntity programaParaAlterar = setaInformacoesPrograma(programaDTO, programaEntity.get());
            programaRepository.save(programaParaAlterar);
            return true;
        }
        return false;
    }
}
