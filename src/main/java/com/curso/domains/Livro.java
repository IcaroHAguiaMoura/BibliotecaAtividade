package com.curso.domains;

import com.curso.domains.dtos.LivroDTO;
import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "livro")
@SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro", allocationSize = 1)
public class Livro {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
    private Long idLivro;

    @NotBlank
    @NotNull
    private String titulo;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String isbn;

    @NotNull
    private int numeroPaginas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra = LocalDate.now();

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorCompra;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Conservacao conservacao;

    @ManyToOne
    @JoinColumn(name = "id_grupolivro")
    private GrupoLivro grupoLivro;

    @ManyToMany
    @JoinTable(name = "livro_autor",
            joinColumns = @JoinColumn(name = "id_livro"),
            inverseJoinColumns = @JoinColumn(name = "id_autor"))
    private Set<Autor> autores;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    public Livro() {
        this.valorCompra = BigDecimal.ZERO;
        this.status = Status.ATIVO;
    }

    public Livro(Long idLivro, String titulo, String isbn, int numeroPaginas, LocalDate dataCompra,
                 BigDecimal valorCompra, Status status, Conservacao conservacao, GrupoLivro grupoLivro,
                 Set<Autor> autores, Editora editora) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra != null ? valorCompra : BigDecimal.ZERO;
        this.status = status;
        this.conservacao = conservacao;
        this.grupoLivro = grupoLivro;
        this.autores = autores;
        this.editora = editora;
    }
    public Livro(LivroDTO dto){
        this.idLivro = dto.getIdLivro();
        this.titulo = dto.getTitulo();
        this.isbn = dto.getIsbn();
        this.numeroPaginas = dto.getNumeroPaginas();
        this.valorCompra = dto.getValorCompra();
        this.conservacao = dto.getConservacao();
        this.dataCompra = dto.getDataCompra();
        this.grupoLivro = dto.getGrupoLivro();
        this.autores = dto.getAutores();
        this.editora = dto.getEditora();


    }


    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
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

    public GrupoLivro getGrupoLivro() {
        return grupoLivro;
    }

    public void setGrupoLivro(GrupoLivro grupoLivro) {
        this.grupoLivro = grupoLivro;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return idLivro == livro.idLivro && Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLivro, titulo);
    }
}
