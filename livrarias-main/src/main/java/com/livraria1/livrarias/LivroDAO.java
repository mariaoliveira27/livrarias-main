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

    private String jdbcURL ="jdbc:sqlite:sqlite/livraria.db"; 
    public LivroDAO() {
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
        } catch (SQLException e) {
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

    public void deletarLivro(String titulo) {
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
        String sql = "UPDATE livros SET editora = ?, edicao = ? WHERE edicao = ?;";

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
                Livro livro = new Livro(
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