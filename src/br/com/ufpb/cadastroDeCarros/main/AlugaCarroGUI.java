package br.com.ufpb.cadastroDeCarros.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class AlugaCarroGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GravadorDeDados gravador;
	private SisAlugaCarro sistema;
	JLabel linha1, linha2;
	ImageIcon carro = new ImageIcon("img/carro.png");
	ImageIcon addcarro = new ImageIcon("img/add.png");
	ImageIcon pesqCarro = new ImageIcon("img/pesq2.png");
	ImageIcon addCliente = new ImageIcon("img/adicionar.png");
	ImageIcon removeCli = new ImageIcon("img/remove.png");
	ImageIcon alugaCarro = new ImageIcon("img/alugar.png");
	JButton botaoAdicionar, botaoPesquisar, botaoaddCliente, botaoRemoveCliente, botaoAlugarCarro;

	JMenuBar barraDeMenu = new JMenuBar();

	public AlugaCarroGUI() {
		gravador = new GravadorDeDados();
		sistema = new SisAlugaCarro();

		try {
			Collection<Cliente> clientesRecuperados = gravador.recuperaClientes();
			sistema.setClientes(clientesRecuperados);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar dados");
		}

		setTitle("Aluga Carros");
		setSize(800, 600);
		setLocation(150, 150);
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		linha1 = new JLabel("locadora de carros", JLabel.CENTER);
		linha1.setForeground(Color.BLACK);
		linha1.setFont(new Font("Serif", Font.BOLD, 24));
		linha2 = new JLabel(carro, JLabel.CENTER);
		botaoAdicionar = new JButton("Cadastrar carro", addcarro);
		botaoAdicionar.addActionListener(new carroAddController(sistema, this));
		botaoPesquisar = new JButton("Pesquisar cliente", pesqCarro);
		botaoPesquisar.addActionListener(new clientePesqController(sistema, this));
		botaoaddCliente = new JButton("cadastrar cliente", addCliente);
		botaoaddCliente.addActionListener(new clienteAddController(sistema, this));
		botaoRemoveCliente = new JButton("Remover cliente", removeCli);
		botaoRemoveCliente.addActionListener(new clienteRemoveController(sistema, this));
		botaoAlugarCarro = new JButton("Alugar carro", alugaCarro);
		botaoAlugarCarro.addActionListener(new alugaCarroController(sistema, this));
		getContentPane().setLayout(new GridLayout(4, 2));
		getContentPane().add(linha1);
		getContentPane().add(botaoAdicionar);
		getContentPane().add(linha2);
		getContentPane().add(botaoaddCliente);
		getContentPane().add(new JLabel());
		getContentPane().add(botaoPesquisar);
		getContentPane().add(botaoRemoveCliente);
		getContentPane().add(botaoAlugarCarro);

		JMenu menuSalvar = new JMenu("Salvar");
		JMenuItem menuSalvarDados = new JMenuItem("Salvar clientes");
		menuSalvar.add(menuSalvarDados);

		menuSalvarDados.addActionListener((ae) -> {
			try {
				gravador.gravarClientes(sistema.getClientes());
				JOptionPane.showMessageDialog(this, "Contatos salvos com sucesso!");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Problema ao salvar dados");
			}
		});

		barraDeMenu.add(menuSalvar);
		setJMenuBar(barraDeMenu);
	}

	public static void main(String[] args) {
		JFrame janela = new AlugaCarroGUI();
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
