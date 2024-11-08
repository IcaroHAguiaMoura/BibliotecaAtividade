package com.curso.resources;

import com.curso.domains.Livro;
import com.curso.domains.dtos.GrupoLivroDTO;
import com.curso.domains.dtos.LivroDTO;
import com.curso.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll() {
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroDTO> findbyId(@PathVariable Long idLivro) {
        Livro obj = this.livroService.findbyId(idLivro);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @GetMapping(value = "/isbn/{isbn}")
    public ResponseEntity<LivroDTO> findbyisbn(@PathVariable String isbn) {
        Livro obj = this.livroService.findbyisbn(isbn);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO dto) {
        LivroDTO createdLivro = livroService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLivro}")
                .buildAndExpand(createdLivro.getIdLivro()).toUri();
        return ResponseEntity.created(uri).body(createdLivro);
    }
    @PutMapping(value = "/{idLivro}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long idLivro, @Valid @RequestBody LivroDTO objDto) {
        Livro obj = livroService.update(idLivro, objDto);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @DeleteMapping(value = "/{idLivro}")
    public ResponseEntity<GrupoLivroDTO> delete(@PathVariable Long idLivro){
        livroService.delete(idLivro);
        return ResponseEntity.noContent().build();
    }

}
