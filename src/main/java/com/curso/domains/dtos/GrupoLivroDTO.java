package com.curso.domains.dtos;

import com.curso.domains.GrupoLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GrupoLivroDTO {

    private Integer id;
    @NotNull(message = "O campo descriçao não pode ser nulo")
    @NotBlank(message = "O campo descriçao nao pode estar vazio")
    private String descricao;
    private int status;

     public GrupoLivroDTO(){}

    public GrupoLivroDTO(Integer id, String descricao, int status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public GrupoLivroDTO(GrupoLivro obj) {
    }

    public int getId(){
         return id;
}

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descriçao não pode ser nulo") @NotBlank(message = "O campo descriçao nao pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descriçao não pode ser nulo") @NotBlank(message = "O campo descriçao nao pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
