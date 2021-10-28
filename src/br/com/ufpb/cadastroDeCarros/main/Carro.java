package br.com.ufpb.cadastroDeCarros.main;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Carro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modelo;
    private String placa;
    private double valorAluguelPorKmRodado;
    private boolean estahAlugado;
    private List<CategoriaCarro> categorias;
    
    public Carro(){
        this("","",0.0,new LinkedList<>());
        this.estahAlugado = false;
    }
    
    public Carro(String modelo,String placa, double valorAluguelKmRodado, List<CategoriaCarro> categorias){
        this.modelo = modelo;
        this.placa = placa;
        this.valorAluguelPorKmRodado = valorAluguelKmRodado;
        this.estahAlugado = false;
        this.setCategorias(categorias);
    }

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValorAluguelPorKmRodado() {
		return valorAluguelPorKmRodado;
	}

	public void setValorAluguelPorKmRodado(double valorAluguelPorKmRodado) {
		this.valorAluguelPorKmRodado = valorAluguelPorKmRodado;
	}

	public boolean isEstahAlugado() {
		return estahAlugado;
	}

	public void setEstahAlugado(boolean estahAlugado) {
		this.estahAlugado = estahAlugado;
	}

	public List<CategoriaCarro> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaCarro> categorias) {
		this.categorias = categorias;
	}
    
    
}
