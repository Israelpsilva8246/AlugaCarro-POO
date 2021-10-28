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
		String modeloCar = JOptionPane.showInputDialog("Informe o modelo do carro");
		String placa = JOptionPane.showInputDialog("Informe a placa di carro");
		double valorAluguel = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do aluguel"));
		boolean estaAlugado = false;
		Carro alugarCarro = new Carro(modeloCar, placa, valorAluguel, new LinkedList<CategoriaCarro>());
		configurarCategorias(alugarCarro);
		try {
			carro.alugarCarro(alugarCarro);
			estaAlugado = true;
			JOptionPane.showMessageDialog(janelaPrincipal, "Carro alugado com sucesso");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possivel alugar o carro");
		}
		
	}
	
	private static void configurarCategorias(Carro carro) {
		List<CategoriaCarro> categorias = new LinkedList<>();
		boolean continuar = true;
		while (continuar) {
			String opcao = JOptionPane.showInputDialog("Qual categoria você deseja adicionar?\n1."
					+ CategoriaCarro.PICAPE + "\n2." + CategoriaCarro.CONVERSIVEL + "\n3." + CategoriaCarro.SUV
					+ "\n4." + CategoriaCarro.DESCONHECIDO + "\n5 Para sair");
			switch (opcao) {
			case "1": 
				categorias.add(CategoriaCarro.PICAPE);
				break;
			case "2":
				categorias.add(CategoriaCarro.CONVERSIVEL);
				break;
			case "3":
				categorias.add(CategoriaCarro.SUV);
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

		}
		carro.setCategorias(categorias);
	}

}
