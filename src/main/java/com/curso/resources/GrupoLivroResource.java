package com.curso.resources;

import com.curso.domains.GrupoLivro;
import com.curso.domains.dtos.GrupoLivroDTO;
import com.curso.services.GrupoLivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value ="/grupolivro")
public class GrupoLivroResource {

    @Autowired
    private GrupoLivroService grupoLivroService;

    @GetMapping
    public ResponseEntity<List<GrupoLivroDTO>> findAll(){
        return ResponseEntity.ok().body(grupoLivroService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoLivroDTO> findById(@PathVariable Integer id){
        GrupoLivro obj = this.grupoLivroService.findbyId(id);
        return ResponseEntity.ok().body(new GrupoLivroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<GrupoLivroDTO> create(@Valid @RequestBody GrupoLivroDTO dto){
        GrupoLivro grupoLivro = grupoLivroService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(grupoLivro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GrupoLivroDTO> update(@PathVariable Integer id, @Valid @RequestBody GrupoLivroDTO objDto){
        GrupoLivro Obj = grupoLivroService.update(id,objDto);
        return ResponseEntity.ok().body(new GrupoLivroDTO(Obj));
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<GrupoLivroDTO> delete(@PathVariable Integer id){
        grupoLivroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
