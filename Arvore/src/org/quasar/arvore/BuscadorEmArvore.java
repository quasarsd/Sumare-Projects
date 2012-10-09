//Leo mais um teste LeoLeo teste 3

package org.quasar.arvore;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BuscadorEmArvore<T> {

	public Set<List<No<T>>> buscarIterativamente(No<T> raiz, T valor)
	{
		return null;
	}
	
	
    public Set<List<No<T>>> buscarEmProfundidade(No<T> raiz, T valor) {
		return buscarEmProfundidade(raiz,valor, new HashSet<List<No<T>>>());
	}
	
	public Set<List<No<T>>> buscarEmProfundidade(No<T> raiz, T valor, Set<List<No<T>>> solucao) {
        if (!raiz.isConsultado()) {
            raiz.setConsultado(true);
            if (raiz.getValor().equals(valor)) {
                
                solucao.add(montarArvoreSolucao(raiz));
            } else {
                for (No<T> noFilho : raiz.getFilhos()) {
                    noFilho.setPai(raiz);
                    if (noFilho.getValor().equals(valor)) {
                    	solucao.add(montarArvoreSolucao(noFilho));
                    } else {
                        if (noFilho.getFilhos().size() > 0)
                        	buscarEmProfundidade(noFilho, valor, solucao);
                    }
                }
            }
        }

        return solucao;
    }
	
	public Set<List<No<T>>> buscarEmLargura(No<T> raiz, T valor) {
		return buscarEmLargura(raiz,valor, new HashSet<List<No<T>>>());
	}
    public Set<List<No<T>>> buscarEmLargura(No<T> raiz, T valor, Set<List<No<T>>> solucao) {
        if (!raiz.isConsultado()) {
            raiz.setConsultado(true);
            if (raiz.getValor().equals(valor)) {
                
                solucao.add(montarArvoreSolucao(raiz));
            } else {
                for (No<T> noFilho : raiz.getFilhos()) {
                    noFilho.setPai(raiz);
                    if (noFilho.getValor().equals(valor)) {
                    	solucao.add(montarArvoreSolucao(noFilho));
                    }
                }
                for (No<T> noFilho : raiz.getFilhos()) {
                    if (noFilho.getFilhos().size() > 0)
                    buscarEmLargura(noFilho, valor, solucao);
                }
            }
        }

        return solucao;
    }
    public List<No<T>> montarArvoreSolucao(No<T> no)
    {
    	List<No<T>> arvoreSolucao = new LinkedList<No<T>>();
    	return montarArvoreSolucao(no, arvoreSolucao);
    }
    
    public List<No<T>> montarArvoreSolucao(No<T> no, List<No<T>> arvoreSolucao)
    {
    	if(no.getPai() != null)
    	{
    		montarArvoreSolucao(no.getPai(), arvoreSolucao);
    	}
    	arvoreSolucao.add(no);
    	return arvoreSolucao;
    }
}

