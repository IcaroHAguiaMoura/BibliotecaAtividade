package com.curso.services;

import java.util.Optional;
import java.util.stream.Collectors;

import com.curso.domains.GrupoLivro;
import com.curso.domains.Livro;
import com.curso.domains.dtos.GrupoLivroDTO;
import com.curso.repositories.GrupoLivroRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GrupoLivroService {

    @Autowired
    private GrupoLivroRepository grupoLivroRepo;

    public List<GrupoLivroDTO> findAll(){
        return grupoLivroRepo.findAll().stream()
                .map(GrupoLivroDTO::new)
                .collect(Collectors.toList());
    }

    public GrupoLivro findbyId(Integer id){
        Optional<GrupoLivro> obj = grupoLivroRepo.findById(id);
        return obj.orElse(null);
    }

    public GrupoLivro create(GrupoLivroDTO dto){
        dto.setId(null);
        GrupoLivro grupoLivro = new GrupoLivro(dto);
        return grupoLivroRepo.save(grupoLivro);
    }
    public  GrupoLivro update(Integer id,GrupoLivroDTO objDto){
        objDto.setId(id);
        GrupoLivro oldobj = findbyId(id);
        oldobj = new GrupoLivro(objDto);
        return grupoLivroRepo.save(oldobj);
    }
    public void delete(Integer id) {
        GrupoLivro grupoLivro = findbyId(id);
        grupoLivroRepo.delete(grupoLivro);
    }



}
