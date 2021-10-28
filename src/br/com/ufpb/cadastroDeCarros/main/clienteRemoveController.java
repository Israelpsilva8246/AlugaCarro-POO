package br.com.ufpb.cadastroDeCarros.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clienteRemoveController implements ActionListener{

    private SisAlugaCarro cliente;
	private JFrame janelaPrincipal;

    public clienteRemoveController(SisAlugaCarro cliente, JFrame janela) {
		this.cliente = cliente;
		this.janelaPrincipal = janela;
	}

    @Override
	public void actionPerformed(ActionEvent e) {

        String id = JOptionPane.showInputDialog(janelaPrincipal, "Informe o id do cliente");
		try {
			
			cliente.remove(id);
			JOptionPane.showMessageDialog(janelaPrincipal, "Cliente removido com sucesso!!");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Erro para remover");
		}
		
		
    }
}
