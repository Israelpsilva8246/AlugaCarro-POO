package br.com.ufpb.cadastroDeCarros.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.ufpb.cadastroDeCarros.main.Carro;
import br.com.ufpb.cadastroDeCarros.main.CategoriaCarro;
import br.com.ufpb.cadastroDeCarros.main.SisAlugaCarro;

class testaAlugaCarro {

	@Test
	void buscaCarroPorCategoria() {
		List<CategoriaCarro> categorias = new LinkedList<>();
		categorias.add(CategoriaCarro.CONVERSIVEL);
		Carro carro = new Carro("Fiat", "HJP5462", 500.00, categorias);
		SisAlugaCarro sistema = new SisAlugaCarro();
			sistema.cadastrarCarro(carro);
			List<Carro> carrosConversivel = sistema.buscaCarroPorCategoria(CategoriaCarro.CONVERSIVEL);
			assertTrue(carrosConversivel.size()==1);
			assertTrue(carrosConversivel.get(0).getModelo().equals("Fiat"));
			List<Carro> carrosPicape = sistema.buscaCarroPorCategoria(CategoriaCarro.PICAPE);
			assertTrue(carrosPicape.size()==0);
	}

}
