package com.livraria1.livrarias;

import java.sql.Date;
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private Date dataPublicacao; 
    private String editora;
    private int numeroPaginas;
    private int edicao; 

    
    public Livro(int id2, String titulo, String autor, Date dataPublicacao, String editora, int numeroPaginas, int edicao) {
        setTitulo(titulo);
        setAutor(autor);
        setDataPublicacao(dataPublicacao);
        this.editora = editora; 
        this.numeroPaginas = numeroPaginas; 
        this.edicao = edicao; 
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo não pode ser nulo ou vazio");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
        }
        this.autor = autor;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        if (dataPublicacao == null) {
            throw new IllegalArgumentException("Data de publicação não pode ser nula");
        }
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
