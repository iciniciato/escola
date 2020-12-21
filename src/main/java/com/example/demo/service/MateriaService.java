package com.example.demo.service;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.entity.MateriaEntity;
import com.example.demo.dto.mapper.MateriaMapper;
import com.example.demo.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private MateriaMapper materiaMapper;

    public Iterable<MateriaEntity> getMaterias() {
        Iterable<MateriaEntity> materias = materiaRepository.findAll();
        return materias;
    }

    public MateriaDTO getMateriaByIndex(Long id) {
        Optional<MateriaEntity> materiaEntity = materiaRepository.findById(id);
        MateriaDTO materiaDTO = new MateriaDTO();
        if (materiaEntity.isPresent()) {
            materiaDTO = materiaMapper.toMateriaDTO(materiaEntity.get());
        }
        return materiaDTO;
    }

    public void criaMateria(MateriaDTO materiaDTO) {
        MateriaEntity materiaEntity = materiaMapper.toMateriaEntity(materiaDTO);
        materiaRepository.save(materiaEntity);
    }

    public void excluiMateria(Long id) {
        Optional<MateriaEntity> materiaEntity = materiaRepository.findById(id);
        if (materiaEntity.isPresent()) {
            materiaRepository.delete(materiaEntity.get());
        }
    }

    private MateriaEntity setaInformacoesMateria(MateriaDTO materiaDTO, MateriaEntity materiaEntity) {
        materiaEntity.setNome(materiaDTO.getNome());
        return materiaEntity;
    }

    public Boolean alteraMateria(MateriaDTO materiaDTO, Long id) {
        Optional<MateriaEntity> materiaEntity = materiaRepository.findById(id);
        if (materiaEntity.isPresent()) {
            MateriaEntity materiaParaAlterar = setaInformacoesMateria(materiaDTO, materiaEntity.get());
            materiaRepository.save(materiaParaAlterar);
            return true;
        }
        return false;
    }
}
