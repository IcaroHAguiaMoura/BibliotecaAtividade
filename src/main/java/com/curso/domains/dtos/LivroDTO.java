package com.curso.domains.dtos;

import com.curso.domains.Autor;
import com.curso.domains.Editora;
import com.curso.domains.GrupoLivro;
import com.curso.domains.Livro;
import com.curso.domains.enums.Conservacao;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class LivroDTO {


    LivroDTO livroDTO = new LivroDTO();

    private Long idLivro;

    @NotNull(message = "O campo titulo nao pode ser nulo")
    @NotBlank(message = "O campo titulo nao pode estar vazio")
    private  String titulo;

    @NotNull(message = "O campo isbn nao pode ser nulo")
    @NotBlank(message = "O campo isbn nao pode estar vazio")
    private String isbn;

    @NotNull(message = "O campo numero de paginas nao pode ser nulo")
    private int numeroPaginas;

    @NotNull(message = "O campo valorCompra nao pode ser nulo")
    @Digits(integer = 15,fraction = 3)
    private BigDecimal valorCompra;

    @NotNull(message = "O campo conservação nao pode ser nulo")
    @NotBlank(message = "O campo conservação nao pode estar vazio")
    private Conservacao conservacao;

    @NotNull(message = "O campo data de compra nao pode ser nulo")
    @NotBlank(message = "O campo data de compra nao pode estar vazio")
    private LocalDate dataCompra;

    @NotNull(message = "O campo GrupoLivro nao pode ser nulo")
    @NotBlank(message = "O campo GrupoLivro  nao pode estar vazio")
    private GrupoLivro grupoLivro;

    @NotNull(message = "O campo Autores nao pode ser nulo")
    @NotBlank(message = "O campo Autores nao pode estar vazio")
    private Set<Autor> autores;

    @NotNull(message = "O campo Editora nao pode ser nulo")
    @NotBlank(message = "O campo Editora nao pode estar vazio")
    private Editora editora;


    private int status;

    public LivroDTO(){}

    public LivroDTO(Livro livro) {
        this.idLivro = livro.getIdLivro();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.valorCompra = livro.getValorCompra();
        this.status = livro.getStatus().getId();
        this.conservacao = livro.getConservacao();
        this.dataCompra = livro.getDataCompra();
        this.grupoLivro = livro.getGrupoLivro();
        this.autores = livro.getAutores();
        this.editora = livro.getEditora();
    }

    public LivroDTO getLivroDTO() {
        return livroDTO;
    }

    public void setLivroDTO(LivroDTO livroDTO) {
        this.livroDTO = livroDTO;
    }

    public  Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public @NotNull(message = "O campo titulo nao pode ser nulo") @NotBlank(message = "O campo titulo nao pode estar vazio") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull(message = "O campo titulo nao pode ser nulo") @NotBlank(message = "O campo titulo nao pode estar vazio") String titulo) {
        this.titulo = titulo;
    }

    public @NotNull(message = "O campo isbn nao pode ser nulo") @NotBlank(message = "O campo isbn nao pode estar vazio") String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotNull(message = "O campo isbn nao pode ser nulo") @NotBlank(message = "O campo isbn nao pode estar vazio") String isbn) {
        this.isbn = isbn;
    }

    @NotNull(message = "O campo numero de paginas nao pode ser nulo")
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(@NotNull(message = "O campo numero de paginas nao pode ser nulo") int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public @NotNull(message = "O campo valorCompra nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(@NotNull(message = "O campo valorCompra nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public @NotNull(message = "O campo conservação nao pode ser nulo") @NotBlank(message = "O campo conservação nao pode estar vazio") Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(@NotNull(message = "O campo conservação nao pode ser nulo") @NotBlank(message = "O campo conservação nao pode estar vazio") Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    public @NotNull(message = "O campo data de compra nao pode ser nulo") @NotBlank(message = "O campo data de compra nao pode estar vazio") LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(@NotNull(message = "O campo data de compra nao pode ser nulo") @NotBlank(message = "O campo data de compra nao pode estar vazio") LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public @NotNull(message = "O campo GrupoLivro nao pode ser nulo") @NotBlank(message = "O campo GrupoLivro  nao pode estar vazio") GrupoLivro getGrupoLivro() {
        return grupoLivro;
    }

    public void setGrupoLivro(@NotNull(message = "O campo GrupoLivro nao pode ser nulo") @NotBlank(message = "O campo GrupoLivro  nao pode estar vazio") GrupoLivro grupoLivro) {
        this.grupoLivro = grupoLivro;
    }

    public @NotNull(message = "O campo Autores nao pode ser nulo") @NotBlank(message = "O campo Autores nao pode estar vazio") Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(@NotNull(message = "O campo Autores nao pode ser nulo") @NotBlank(message = "O campo Autores nao pode estar vazio") Set<Autor> autores) {
        this.autores = autores;
    }

    public @NotNull(message = "O campo Editora nao pode ser nulo") @NotBlank(message = "O campo Editora nao pode estar vazio") Editora getEditora() {
        return editora;
    }

    public void setEditora(@NotNull(message = "O campo Editora nao pode ser nulo") @NotBlank(message = "O campo Editora nao pode estar vazio") Editora editora) {
        this.editora = editora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
