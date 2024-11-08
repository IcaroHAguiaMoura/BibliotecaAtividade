package com.curso.domains;

import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {

    @JsonIgnore
    @OneToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
    private Integer idAutor;

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String documentoPessoal;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Autor() {
        this.status = Status.ATIVO;
    }

    public Autor(Integer idAutor, String nome, String documentoPessoal, Status status) {
        this.idAutor = idAutor;
        this.nome = nome;
        this.documentoPessoal = documentoPessoal;
        this.status = status;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public @NotBlank @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @NotNull String nome) {
        this.nome = nome;
    }

    public @NotBlank @NotNull String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(@NotBlank @NotNull String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(idAutor, autor.idAutor) && Objects.equals(nome, autor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor, nome);
    }
}
