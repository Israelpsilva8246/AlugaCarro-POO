package br.com.ufpb.cadastroDeCarros.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class alugaCarroController implements ActionListener {

	private SisAlugaCarro carro;
	private JFrame janelaPrincipal;
	
	public alugaCarroController(SisAlugaCarro carro, JFrame janela) {
		this.carro = carro;
		this.janelaPrincipal = janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
