package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.Editora;
import com.curso.domains.GrupoLivro;
import com.curso.domains.Livro;
import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.curso.repositories.AutorRepository;
import com.curso.repositories.EditoraRepository;
import com.curso.repositories.GrupoLivroRepository;
import com.curso.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class DBService {

    @Autowired
    private GrupoLivroRepository grupoLivroRepo;

    @Autowired
    private LivroRepository livroRepo;

    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private EditoraRepository editoraRepo;

    public void initDB() {

        Editora editora1 = new Editora(null, "12345678000195", "Editora Srgood", Status.ATIVO);

        Autor autor1 = new Autor(null, "Charles Perrault", "123456789", Status.ATIVO);
        Autor autor2 = new Autor(null, "Kouta Hirano.", "987654321", Status.ATIVO);

        GrupoLivro grupo01 = new GrupoLivro(null, "Infantis", Status.ATIVO, Conservacao.EXCELENTE);
        GrupoLivro grupo02 = new GrupoLivro(null, "Adultos", Status.ATIVO, Conservacao.BOM);

        Set<Autor> autores1 = new HashSet<>();
        autores1.add(autor1);

        Set<Autor> autores2 = new HashSet<>();
        autores2.add(autor2);

        Livro livro1 = new Livro(null, "Teste", "1234567890", 120, LocalDate.now(),
                new BigDecimal("100.00"), Status.ATIVO, Conservacao.EXCELENTE, grupo01, autores1, editora1);
        Livro livro2 = new Livro(null, "Alucard", "0987654321", 300, LocalDate.now(),
                new BigDecimal("100.00"), Status.ATIVO, Conservacao.BOM, grupo02, autores2, editora1);
        Livro livro3 = new Livro(null, "Hellsing", "4984354321", 500, LocalDate.now(),
                new BigDecimal("100.00"), Status.ATIVO, Conservacao.BOM, grupo02, autores2, editora1);
        Livro livro4 = new Livro(null, "Tropa do 155", "49435321", 155, LocalDate.now(),
                new BigDecimal("100.00"), Status.ATIVO, Conservacao.BOM, grupo01, autores1, editora1);

        editoraRepo.save(editora1);
        autorRepo.save(autor1);
        autorRepo.save(autor2);
        grupoLivroRepo.save(grupo01);
        grupoLivroRepo.save(grupo02);
        livroRepo.save(livro1);
        livroRepo.save(livro2);
        livroRepo.save(livro3);
        livroRepo.save(livro4);
    }
}
