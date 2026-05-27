package com.livraria1.livrarias;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

public class LivroController {
        public void cadastrarLivro( int id, String titulo, String autor, Date dataPublicacao, String editora, int numeroPaginas, int edicao) {
            Livro livro = new Livro(id ,titulo, autor, dataPublicacao, editora, numeroPaginas, edicao);
            LivroDAO livroDAO = new LivroDAO(); //Sugestão 1: o `LivroController` instancia `LivroDAO` diretamente em cada método. Isso aumenta o acoplamento e dificulta testes com mock. Seria melhor receber o DAO por construtor ou usar injeção de dependência do Spring com `@Service`/`@Repository`.
            livroDAO.cadastrarLivro(livro);
        }
        public void deletarLivro(String titulo){
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.deletarLivro(titulo);
        }
        public void atualizarLivro(String editora, int Edicao){ //Sugestão 2: O parâmetro Edicao começa com letra maiúscula, fugindo do padrão Java para variáveis. Sugestão: usar edicao para manter consistência e legibilidade.
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.atualizarLivro(editora, Edicao);
        }
        public void listarLivros(){  //Sugestão 3: O método listarLivros() cria uma lista vazia e nunca consulta o DAO, então nenhum livro será listado. O ideal seria chamar livroDAO.listarLivros() e iterar sobre o retorno.
            List <Livro> livros = new ArrayList<>();
            for(Livro livro : livros){
                System.out.println("Titulo: " + livro.getTitulo()); //Sugestão 4: O controller imprime diretamente no console. Isso mistura regra de aplicação com apresentação. Uma arquitetura mais limpa deixaria o controller retornar dados e a view/API decidir como exibir.
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Data de Publicação: " + livro.getDataPublicacao());
                System.out.println("Editora: " + livro.getEditora());
                System.out.println("Numero de Paginas: " + livro.getNumeroPaginas());
                System.out.println("Edição: " + livro.getEdicao());
            }
        }
}
