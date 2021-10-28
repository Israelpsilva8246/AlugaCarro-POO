package br.com.ufpb.cadastroDeCarros.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SisAlugaCarro implements SistemaAlugaCarro {

	private Map<String, Cliente> clientes;
	private List<Carro> carros;

	public SisAlugaCarro() {
		this.clientes = new HashMap<>();
		this.carros = new ArrayList<>();
	}

	public boolean existeCarro(Carro carro) {
		for (Carro c : this.carros) {
			if (c.getPlaca().equals(carro.getPlaca())) {
				return true;
			}
		}
		return false;
	}

	public boolean existeCliente(String cpf) {
		for (Cliente c : this.clientes.values()) {
			if (c.getId().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean cadastrarCliente(String nome, String endereco, String id) throws ClienteJaExisteException {
		if (!clientes.containsKey(id)) {
			this.clientes.put(id, new Cliente(nome, endereco, id));
			return true;
		} else {
			return false;
		}
	}

	public List<Carro> buscaCarroPorCategoria(CategoriaCarro categoria) {
		List<Carro> carrosAchados = new ArrayList<>();
		for (Carro c : this.carros) {
			if (c.getCategorias().equals(categoria)) {
				carrosAchados.add(c);
			}
		}
		return carrosAchados;
	}

	public List<Cliente> pesquisaCliente(String cpf) {
		List<Cliente> clienteAchado = new ArrayList<Cliente>();
		for (Cliente cl : clientes.values()) {
			if (cl.getId().equals(cpf)) {
				clienteAchado.add(cl);
			}
		}
		return clienteAchado;
	}

	public boolean alugarCarro(Carro carro) {
		if (existeCarro(carro)) {
			return false;
		}
		carros.add(carro);
		return true;
	}

	public boolean remove(String id) {
		Cliente clienteRemove = this.clientes.remove(id);
		if (clienteRemove == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void setClientes(Collection<Cliente> clientesList) {
		for (Cliente c : clientesList) {
			this.clientes.put(c.getId(), c);
		}

	}

	@Override
	public Collection<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return this.clientes.values();
	}

}
