/*package com.livraria1.livrarias;

import javax.swing.*;
import java.awt.*;

public class LivroViewImpl implements LivroView {

    @Override
    public void criarJanela() {
        
        JFrame frame = new JFrame("Cadastro de Livros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 300);
        frame.setLayout(new GridLayout(6, 6, 20, 10));

        frame.add(new JLabel("Título:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Autor:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Data da Publicação:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Editora:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Numero de Paginas:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Edição:"));
        frame.add(new JTextField());

        JButton salvarButton = new JButton("Salvar");
        frame.add(new JLabel()); // Espaço vazio
        frame.add(salvarButton);

        JButton listarButton = new JButton("Historico");
        frame.add(new JLabel()); // Espaço vazio
        frame.add(listarButton);

        JButton deletarButton = new JButton("Deletar");
        frame.add(new JLabel()); // Espaço vazio
        frame.add(deletarButton);

        JButton atualizarButton = new JButton("Atualizar");
        frame.add(new JLabel()); // Espaço vazio
        frame.add(atualizarButton);

        // Tornar a janela visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        LivroView view = new LivroViewImpl();
        view.criarJanela(); // Criar e exibir a janela
    }
}
*/