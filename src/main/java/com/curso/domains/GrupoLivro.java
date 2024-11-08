package com.curso.domains;

import com.curso.domains.dtos.GrupoLivroDTO;
import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "grupolivro")
@SequenceGenerator(name = "seq_grupolivro", sequenceName = "seq_grupolivro", allocationSize = 1)
public class GrupoLivro {



    @JsonIgnore
    @OneToMany(mappedBy = "grupoLivro")
    private List<Livro> livros = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupolivro")
    private Integer id;

    @NotNull
    @NotBlank
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private Conservacao conservacao;

    public GrupoLivro() {
        this.status = Status.ATIVO;
    }

    public GrupoLivro(Integer id, String descricao, Status status, Conservacao conservacao) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.conservacao = conservacao;
    }
    public  GrupoLivro(GrupoLivroDTO dto){
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.status = Status.toEnum((dto.getStatus()));
        this.conservacao = getConservacao();

    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoLivro that = (GrupoLivro) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
