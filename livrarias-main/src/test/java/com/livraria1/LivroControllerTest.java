package com.livraria1;

import com.livraria1.livrarias.Livro;
import com.livraria1.livrarias.LivroController;
import com.livraria1.livrarias.LivroDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LivroControllerTest {

    private LivroDAO livroDAOMock;
    private LivroController livroController;

    @BeforeEach
    public void setup() {
        // Criar um mock de LivroDAO
        livroDAOMock = Mockito.mock(LivroDAO.class);
        livroController = new LivroController();
    }

    @Test
    public void testCadastrarLivro() {
        // Configurar os dados do livro
        int id = 1;
        String titulo = "O Senhor dos Anéis";
        String autor = "J.R.R. Tolkien";
        Date dataPublicacao = Date.valueOf("1954-07-29");
        String editora = "HarperCollins";
        int numeroPaginas = 1178;
        int edicao = 1;

        // Simular a operação de cadastro
        Livro livro = new Livro(id, titulo, autor, dataPublicacao, editora, numeroPaginas, edicao);

        // Chamar o método de cadastro
        livroController.cadastrarLivro(id, titulo, autor, dataPublicacao, editora, numeroPaginas, edicao);

        // Verificar se o método do DAO foi chamado corretamente
        verify(livroDAOMock, times(1)).cadastrarLivro(livro);
    }

    @Test
    public void testDeletarLivro() {
        // Configurar o título do livro a ser deletado
        String titulo = "O Senhor dos Anéis";

        // Chamar o método de deletar
        livroController.deletarLivro(titulo);

        // Verificar se o método do DAO foi chamado corretamente
        verify(livroDAOMock, times(1)).deletarLivro(titulo);
    }

    @Test
    public void testAtualizarLivro() {
        // Configurar os dados de atualização
        String novaEditora = "Nova Editora";
        int novaEdicao = 2;

        // Chamar o método de atualização
        livroController.atualizarLivro(novaEditora, novaEdicao);

        // Verificar se o método do DAO foi chamado corretamente
        verify(livroDAOMock, times(1)).atualizarLivro(novaEditora, novaEdicao);
    }

    @Test
    public void testListarLivros() {
        // Configurar a lista de livros simulada
        List<Livro> livrosMock = new ArrayList<>();
        livrosMock.add(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", Date.valueOf("1954-07-29"), "HarperCollins", 1178, 1));
        livrosMock.add(new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", Date.valueOf("1997-06-26"), "Bloomsbury", 223, 1));

        // Simular o comportamento do DAO
        when(livroDAOMock.listarLivros()).thenReturn(livrosMock);

        // Chamar o método de listar
        livroController.listarLivros();

        // Verificar se os dados foram listados corretamente
        verify(livroDAOMock, times(1)).listarLivros();
    }
}
