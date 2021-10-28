package br.com.ufpb.cadastroDeCarros.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class carroAddController implements ActionListener {

	private SisAlugaCarro carro;
	private JFrame janelaPrincipal;
	
	public carroAddController(SisAlugaCarro carro, JFrame janela) {
		this.carro = carro;
		this.janelaPrincipal = janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String modelo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o modelo do carro?"); 
		String placa = JOptionPane.showInputDialog(janelaPrincipal, "Qual a placa do carro?");
		double valorAluguel = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do aluguel por km"));
		Carro newCarro = new Carro(modelo, placa, valorAluguel, new LinkedList<CategoriaCarro>());
		configurarCategorias(newCarro);
		
		try {
			carro.alugarCarro(newCarro);
			JOptionPane.showMessageDialog(janelaPrincipal, "Carro cadastrado com sucesso");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Jogo não foi cadastrado");
		}
	}
	
	private static void configurarCategorias(Carro carro) {
		List<CategoriaCarro> categorias = new LinkedList<>();
		boolean continuar = true;
		while (continuar) {
			String opcao = JOptionPane.showInputDialog("Qual categoria você deseja adicionar?\n1."
					+ CategoriaCarro.PICAPE + "\n2." + CategoriaCarro.SUV + "\n3." + CategoriaCarro.CONVERSIVEL
					+ "\n4." + CategoriaCarro.DESCONHECIDO + "\n5.Não adicionar mais categorias");
			switch (opcao) {
			case "1": 
				categorias.add(CategoriaCarro.PICAPE);
				break;
			case "2":
				categorias.add(CategoriaCarro.SUV);
				break;
			case "3":
				categorias.add(CategoriaCarro.CONVERSIVEL);
				break;
			case "4":
				categorias.add(CategoriaCarro.DESCONHECIDO);
				break;
			case "5":
				continuar = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
			carro.setCategorias(categorias);
		}
		
	}

}
