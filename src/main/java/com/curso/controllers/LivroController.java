package com.curso.controllers;

import com.curso.domains.dtos.LivroDTO;
import com.curso.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroDTO> create(@RequestBody LivroDTO dto) {
        LivroDTO createdLivro = livroService.create(dto);
        return ResponseEntity.ok(createdLivro);
    }


}
