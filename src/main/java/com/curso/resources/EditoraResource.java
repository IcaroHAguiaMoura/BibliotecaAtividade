package com.curso.resources;

import com.curso.domains.Editora;
import com.curso.domains.dtos.EditoraDTO;
import com.curso.services.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/editora")
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @GetMapping(value = "/idEditora")
    public ResponseEntity<EditoraDTO> findbyId(@PathVariable int idEditora){
        Editora obj = this.editoraService.findbyId(idEditora);
        return ResponseEntity.ok().body(new EditoraDTO(obj));

    }
}
