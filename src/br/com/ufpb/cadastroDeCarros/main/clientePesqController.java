package br.com.ufpb.cadastroDeCarros.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class clientePesqController implements ActionListener {

	private SisAlugaCarro cliente;
	private JFrame janelaPrincipal;

	public clientePesqController(SisAlugaCarro cliente, JFrame janela) {
		this.cliente = cliente;
		this.janelaPrincipal = janela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = JOptionPane.showInputDialog("Informe o cpf do cliente");
		try {

			JOptionPane.showMessageDialog(janelaPrincipal, cliente.pesquisaCliente(id));

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Cliente não encontrado");
		}
	}

}
