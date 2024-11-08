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
@Table(name = "editora")
public class Editora {

    @JsonIgnore
    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_editora")
    private Integer idEditora;

    @NotBlank
    @NotNull
    private String cnpj;

    @NotBlank
    @NotNull
    private String razaoSocial;

    @Enumerated(EnumType.STRING)
    private Status status =Status.ATIVO;

    public Editora() {
        this.status = Status.ATIVO;
    }


    public Editora(Integer idEditora, String cnpj, String razaoSocial, Status status) {
        this.idEditora = idEditora;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.status = status;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Integer getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Integer idEditora) {
        this.idEditora = idEditora;
    }

    public @NotBlank @NotNull String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank @NotNull String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank @NotNull String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotBlank @NotNull String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
        Editora editora = (Editora) o;
        return Objects.equals(idEditora, editora.idEditora) && Objects.equals(cnpj, editora.cnpj);

    }

    @Override
    public int hashCode() {
        return Objects.hash(idEditora, cnpj);
    }
}
