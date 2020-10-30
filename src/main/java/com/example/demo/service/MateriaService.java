package com.example.demo.service;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.dto.mapper.MateriaDtoMapper;
import com.example.demo.dto.mapper.MateriaEntityMapper;
import com.example.demo.entity.MateriaEntity;
import com.example.demo.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public Iterable<MateriaEntity> getMaterias() {
        Iterable<MateriaEntity> materias = materiaRepository.findAll();
        return materias;
    }

    public MateriaDTO getMateriaByIndex(Long id) {
        Optional<MateriaEntity> materiaEntity = materiaRepository.findById(id);
        MateriaDTO materiaDTO = new MateriaDTO();
        if(materiaEntity.isPresent()) {
            materiaDTO = MateriaDtoMapper.converteMateriaEntity(materiaEntity.get());
        }
        return materiaDTO;
    }

    public void criaMateria(MateriaDTO materiaDTO) {
        MateriaEntity materiaEntity = MateriaEntityMapper.converteMateriaDto(materiaDTO);
        materiaRepository.save(materiaEntity);
    }

    public void excluiMateria(Long id) {
        MateriaEntity materiaEntity = new MateriaEntity();
        materiaEntity.setId(id);
        materiaRepository.delete(materiaEntity);
    }

    public Boolean alteraMateria(MateriaDTO materiaDTO, Long id) {
        Optional<MateriaEntity> materiaEntity = materiaRepository.findById(id);
        if (materiaEntity.isPresent()) {
            MateriaEntity materiaParaAlterar =
                    MateriaEntityMapper.setaInformacoesMateria(materiaDTO, materiaEntity.get());
            materiaRepository.save(materiaParaAlterar);
            return true;
        }
        return false;
    }
}
