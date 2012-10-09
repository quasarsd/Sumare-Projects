package org.quasar.arvore;

import java.io.Serializable;
import java.util.List;

public class No<T> implements Serializable 
{
	private static final long serialVersionUID = 6159214831185109202L;
	private No<T> pai;
	private List<No<T>> filhos;
	private T valor;
	private boolean consultado;
	private long profundidade;
	public No<T> getPai() {
		return pai;
	}
	public void setPai(No<T> pai) {
		this.pai = pai;
	}
	public List<No<T>>getFilhos() {
		return filhos;
	}
	public void setFilhos(List<No<T>> filhos) {
		this.filhos = filhos;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public boolean isConsultado() {
		return consultado;
	}
	public void setConsultado(boolean consultado) {
		this.consultado = consultado;
	}
	public long getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(long profundidade) {
		this.profundidade = profundidade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (consultado ? 1231 : 1237);
		result = prime * result + ((filhos == null) ? 0 : filhos.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + (int) (profundidade ^ (profundidade >>> 32));
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		No other = (No) obj;
		if (consultado != other.consultado)
			return false;
		if (filhos == null) {
			if (other.filhos != null)
				return false;
		} else if (!filhos.equals(other.filhos))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (profundidade != other.profundidade)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
