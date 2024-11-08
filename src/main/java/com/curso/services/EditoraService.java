package com.curso.services;

import com.curso.domains.Editora;
import com.curso.domains.dtos.EditoraDTO;
import com.curso.repositories.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepo;

    public List<EditoraDTO> findAll() {
        return editoraRepo.findAll().stream()
                .map(obj -> new EditoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Editora findbyId(int idEditora) {
        Optional<Editora> obj = editoraRepo.findById(idEditora);
        return obj.orElseThrow(() -> new EntityNotFoundException("Editora não encontrado! Id: " + idEditora));
    }
}
