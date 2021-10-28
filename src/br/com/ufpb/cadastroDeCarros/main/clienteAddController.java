package br.com.ufpb.cadastroDeCarros.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class clienteAddController implements ActionListener {

	private SisAlugaCarro cliente;
	private JFrame janelaPrincipal;

	public clienteAddController(SisAlugaCarro cliente, JFrame janela) {
		this.cliente = cliente;
		this.janelaPrincipal = janela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String nome = JOptionPane.showInputDialog("Informe o nome do cliente");
		String endereco = JOptionPane.showInputDialog("Informe o endereco do cliente");
		String id = JOptionPane.showInputDialog("Informe o cpf");

		try {
			cliente.cadastrarCliente(nome, endereco, id);
			JOptionPane.showMessageDialog(janelaPrincipal, "Cliente cadastrado com sucesso!!");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Falha ao cadastrar cliente!");
		}
	}

}
