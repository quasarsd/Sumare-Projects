package org.quasar.arvore;

import java.util.List;

public class Solucao<T> 
{
	private Arvore<T> arvorePesquisada;
	private List<Arvore<T>> solucoes;
	
	public Arvore<T> getArvorePesquisada() {
		return arvorePesquisada;
	}
	public void setArvorePesquisada(Arvore<T> arvorePesquisada) {
		this.arvorePesquisada = arvorePesquisada;
	}
	public List<Arvore<T>> getSolucoes() {
		return solucoes;
	}
	public void setSolucoes(List<Arvore<T>> solucoes) {
		this.solucoes = solucoes;
	}
}
