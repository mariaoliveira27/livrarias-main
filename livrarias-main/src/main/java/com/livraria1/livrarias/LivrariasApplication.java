package com.livraria1.livrarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariasApplication {

	public static void main(String[] args) throws ClassNotFoundException{
		LivroController lc = new LivroController();
		
		//lc.deletarLivro(null);
		//lc.atualizarLivro("Allen & Unwin", 2)
		lc.listarLivros();
		SpringApplication.run(LivrariasApplication.class, args);
	}
	

}
