package br.com.ufpb.cadastroDeCarros.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GravadorDeDados {

	private String nomeArquivo;

	public GravadorDeDados() {
		this.nomeArquivo = "cliente.txt";
	}

	public GravadorDeDados(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void gravarClientes(Collection<Cliente> clientes) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			List<Cliente> clientesAGravar = new ArrayList<Cliente>();
			clientesAGravar.addAll(clientes);
			out.writeObject(clientesAGravar);
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo " + nomeArquivo);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public Collection<Cliente> recuperaClientes() throws IOException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Collection<Cliente> clientesAchados = (Collection<Cliente>) in.readObject();
			return clientesAchados;
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo " + nomeArquivo);
		} catch (IOException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos gravados no arquivo " + "cliente.txt não existe", e);
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}
