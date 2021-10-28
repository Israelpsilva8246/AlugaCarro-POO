package br.com.ufpb.cadastroDeCarros.main;

import java.util.Collection;
import java.util.List;

public interface SistemaAlugaCarro {

	boolean existeCarro(Carro carro);
	
	public boolean cadastrarCarro(Carro carro);

	boolean existeCliente(String cpf);

	boolean cadastrarCliente(String nome, String endereco, String id) throws ClienteJaExisteException;

	List<Carro> buscaCarroPorCategoria(CategoriaCarro categoria);

	List<Cliente> pesquisaCliente(String cpf);

	boolean alugarCarro(Carro carro);

	boolean remove(String id);

	public void setClientes(Collection<Cliente> clientes);

	public Collection<Cliente> getClientes();
}
