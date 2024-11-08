package com.curso.domains.dtos;

import com.curso.domains.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EditoraDTO {

    private int idEditora;

    @NotNull(message = "O campo CNPJ nao pode ser nulo")
    @NotBlank(message = "O campo CNPJ nao pode estar vazio")
    private String cnpj;

    @NotNull(message = "O campo razaoSocial nao pode ser nulo")
    @NotBlank(message = "O campo razaoSocial nao pode estar vazio")
    private String razaoSocial;

    public EditoraDTO(){
    }

    public EditoraDTO(Editora editora) {
        this.idEditora = editora.getIdEditora();
        this.cnpj = editora.getCnpj();
        this.razaoSocial = editora.getRazaoSocial();
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public @NotNull(message = "O campo CNPJ nao pode ser nulo") @NotBlank(message = "O campo CNPJ nao pode estar vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo CNPJ nao pode ser nulo") @NotBlank(message = "O campo CNPJ nao pode estar vazio") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo razaoSocial nao pode ser nulo") @NotBlank(message = "O campo razaoSocial nao pode estar vazio") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razaoSocial nao pode ser nulo") @NotBlank(message = "O campo razaoSocial nao pode estar vazio") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
