package com.livraria1.livrarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariasApplication {

	public static void main(String[] args) throws ClassNotFoundException{ //Sugestão 19: A aplicação Spring instancia manualmente LivroController. Em um projeto Spring Boot, seria melhor deixar o Spring gerenciar os componentes com @Component, @Service e @Repository.
		LivroController lc = new LivroController();
		
		//lc.deletarLivro(null);
		//lc.atualizarLivro("Allen & Unwin", 2)
		lc.listarLivros(); //Sugestão 20: A chamada lc.listarLivros() roda antes da aplicação iniciar. Isso mistura inicialização da aplicação com regra de negócio. Se precisar executar algo no start, considere CommandLineRunner.
		SpringApplication.run(LivrariasApplication.class, args);
	}
	

}
