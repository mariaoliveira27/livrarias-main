package com.livraria1.livrarias;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

public class LivroController {
        public void cadastrarLivro( int id, String titulo, String autor, Date dataPublicacao, String editora, int numeroPaginas, int edicao) {
            Livro livro = new Livro(id ,titulo, autor, dataPublicacao, editora, numeroPaginas, edicao);
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.cadastrarLivro(livro);
        }
        public void deletarLivro(String titulo){
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.deletarLivro(titulo);
        }
        public void atualizarLivro(String editora, int Edicao){
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.atualizarLivro(editora, Edicao);
        }
        public void listarLivros(){
            List <Livro> livros = new ArrayList<>();
            for(Livro livro : livros){
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Data de Publicação: " + livro.getDataPublicacao());
                System.out.println("Editora: " + livro.getEditora());
                System.out.println("Numero de Paginas: " + livro.getNumeroPaginas());
                System.out.println("Edição: " + livro.getEdicao());
            }
        }
}
