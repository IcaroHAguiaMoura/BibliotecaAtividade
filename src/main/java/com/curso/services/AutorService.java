package com.curso.services;

import jakarta.persistence.EntityNotFoundException;
import com.curso.domains.Autor;
import com.curso.domains.dtos.AutorDTO;
import com.curso.domains.dtos.LivroDTO;
import com.curso.repositories.AutorRepository;
import com.curso.repositories.LivroRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepo;

    public List<AutorDTO> findAll() {
        return autorRepo.findAll().stream()
                .map(obj -> new AutorDTO(obj))
                .collect(Collectors.toList());
    }

    public Autor findbyId(int idAutor) {
        Optional<Autor> obj = autorRepo.findById(idAutor);
        return obj.orElseThrow(() -> new EntityNotFoundException("Autor não encontrado! Id: " + idAutor));
    }
}

