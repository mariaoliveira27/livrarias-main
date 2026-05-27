package com.livraria1.livrarias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


import java.sql.ResultSet;


public class LivroDAO {

    private String jdbcURL ="jdbc:sqlite:sqlite/livraria.db"; //Sugestão 5: A URL do banco está fixa dentro da classe. Isso dificulta trocar ambiente de teste, desenvolvimento e produção. Sugestão: mover para application.properties e injetar via configuração.
    public LivroDAO() { //Sugestão 6: O construtor cria a tabela automaticamente. Embora funcione em projeto pequeno, essa responsabilidade poderia ir para migrations, como Flyway/Liquibase, ou para scripts de inicialização, evitando efeitos colaterais ao apenas instanciar o DAO.
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = """
                CREATE TABLE IF NOT EXISTS livros (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    autor TEXT NOT NULL,
                    dataPublicacao DATE NOT NULL,
                    editora TEXT NOT NULL,
                    numeroPaginas INTEGER ,
                    edicao INTEGER NOT NULL
                );
                """;

        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) { //Sugestão 7: O uso de e.printStackTrace() não é ideal para aplicação real. Sugestão: usar logging estruturado e lançar uma exceção de domínio/persistência para a camada superior decidir como tratar o erro.
            e.printStackTrace();
        }
    }

    public void cadastrarLivro(Livro livro) {
        String sql = """
                INSERT INTO livros (titulo, autor, dataPublicacao, editora, numeroPaginas, edicao)
                VALUES (?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setDate(3, livro.getDataPublicacao());
            pstmt.setString(4, livro.getEditora());
            pstmt.setInt(5, livro.getNumeroPaginas());
            pstmt.setInt(6, livro.getEdicao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarLivro(String titulo) { //Sugestão 8: Excluir livro por titulo pode apagar múltiplos registros com o mesmo nome. Seria mais seguro deletar por id, que é a chave primária.
        String sql = "DELETE FROM livros WHERE titulo = ?;";

        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLivro(String editora, int edicao) {
        String sql = "UPDATE livros SET editora = ?, edicao = ? WHERE edicao = ?;"; //Sugestão 9: O UPDATE usa WHERE edicao = ?, mas também altera a própria edição para o mesmo valor. Isso torna a atualização ambígua e pode afetar vários livros. Sugestão: atualizar por id.

        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, editora);
            pstmt.setInt(2, edicao);
            pstmt.setInt(3, edicao);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros;";
    
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
    
            while (rs.next()) {
                Livro livro = new Livro( //Sugestão 10: Ao listar livros, o objeto é criado com id igual a 0, ignorando o id real do banco. Sugestão: usar rs.getInt("id") para preservar a identidade do registro.
                        0, rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDate("dataPublicacao"),
                        rs.getString("editora"),
                        rs.getInt("numeroPaginas"),
                        rs.getInt("edicao")
                );
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return livros;
    }
}
