package com.curso.services;

import com.curso.domains.GrupoLivro;
import com.curso.domains.Livro;
import com.curso.domains.dtos.LivroDTO;
import com.curso.repositories.GrupoLivroRepository;
import com.curso.repositories.LivroRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepo;

    @Autowired
    private GrupoLivroRepository grupoLivroRepo;

    public List<LivroDTO> findAll() {
        return livroRepo.findAll().stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public Livro findbyId(long idLivro) {
        return livroRepo.findById(idLivro)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado! Id: " + idLivro));
    }

    public Livro findbyisbn(String isbn) {
        return livroRepo.findByIsbn(isbn)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado! ISBN: " + isbn));
    }

    public LivroDTO create(LivroDTO dto) {
        dto.setIdLivro(null);
        validaLivro(dto);
        Livro obj = new Livro(dto);
        return new LivroDTO(obj);
    }
    private void validaLivro(LivroDTO dto){
        Optional<Livro> obj = livroRepo.findByIsbn(dto.getIsbn());
        if(obj.isPresent() && obj.get().getIdLivro() != dto.getIdLivro()){
            throw new DataIntegrityViolationException("ISBN já cadastrado!");
        }

        Optional<GrupoLivro> grupoLivro = grupoLivroRepo.findById(dto.getGrupoLivro().getId());
        if (!grupoLivro.isPresent()) {
            throw new DataIntegrityViolationException("Grupo de Livro - " + dto.getGrupoLivro().getId() + " não está cadastrado");
        }
    }
    public Livro update(Long id,LivroDTO objDto){
        objDto.setIdLivro(id);
        Livro oldObj = findbyId(id);
        validaLivro(objDto);
        oldObj = new Livro(objDto);
        return livroRepo.save(oldObj);
    }
    public void delete(Long idLivro){
        Livro obj = findbyId(idLivro);
        livroRepo.deleteById(idLivro);
    }

}