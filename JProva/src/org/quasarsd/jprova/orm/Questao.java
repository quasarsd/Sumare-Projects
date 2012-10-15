package org.quasarsd.jprova.orm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questao
	implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9165018818506354961L;

	@Id
	@GeneratedValue
	private long idQuestao;
	
	private String descricao;
	
	private short peso;
	
	@OneToMany(mappedBy="questao" , targetEntity=Resposta.class , fetch=FetchType.EAGER , cascade=CascadeType.ALL)
	private List<Resposta> respostas;

	public long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public short getPeso() {
		return peso;
	}

	public void setPeso(short peso) {
		this.peso = peso;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	@Override
	public String toString() {
		return "Questao [idQuestao=" + idQuestao + ", descricao=" + descricao
				+ ", peso=" + peso + ", respostas=" + respostas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (idQuestao ^ (idQuestao >>> 32));
		result = prime * result + peso;
		result = prime * result
				+ ((respostas == null) ? 0 : respostas.hashCode());
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
		Questao other = (Questao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idQuestao != other.idQuestao)
			return false;
		if (peso != other.peso)
			return false;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
			return false;
		return true;
	}
}
