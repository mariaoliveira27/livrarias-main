package com.livraria1.livrarias;

import java.sql.Date; //Sugestão 11: O modelo usa java.sql.Date, que prende a entidade a detalhes de banco de dados. Para domínio, java.time.LocalDate costuma ser mais adequado e moderno.
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private Date dataPublicacao; 
    private String editora;
    private int numeroPaginas;
    private int edicao; 

    
    public Livro(int id2, String titulo, String autor, Date dataPublicacao, String editora, int numeroPaginas, int edicao) { //Sugestão 12: O construtor recebe id2, mas não atribui esse valor ao campo id. Isso pode causar inconsistência entre o objeto em memória e o registro no banco.
        setTitulo(titulo);
        setAutor(autor);
        setDataPublicacao(dataPublicacao);
        this.editora = editora; //Sugestão 13:Alguns campos usam setters com validação, mas editora, numeroPaginas e edicao são atribuídos diretamente. Sugestão: usar os setters no construtor para centralizar validações.
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

    public void setNumeroPaginas(int numeroPaginas) { //Sugestão 14: numeroPaginas aceita valores negativos ou zero. Uma validação simples evitaria objetos inválidos, por exemplo lançando exceção quando numeroPaginas <= 0.
        this.numeroPaginas = numeroPaginas;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) { //Sugestão 15: edicao também aceita valores inválidos. Seria interessante validar se a edição é maior que zero.
        this.edicao = edicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
