package org.quasarsd.jprova.orm;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resposta
	implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2112300580958196326L;

	@Id
	@GeneratedValue
	private long idResposta;
	
	private String descricao;
	
	private boolean correta;
	
	@ManyToOne
	@JoinColumn(name= "idQuestao" , nullable = false)
	private Questao questao;

	public long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(long idResposta) {
		this.idResposta = idResposta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
	@Override
	public String toString() {
		return "Resposta [idResposta=" + idResposta + ", descricao="
				+ descricao + ", correta=" + correta + ", questao=" + questao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correta ? 1231 : 1237);
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (idResposta ^ (idResposta >>> 32));
		result = prime * result + ((questao == null) ? 0 : questao.hashCode());
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
		Resposta other = (Resposta) obj;
		if (correta != other.correta)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idResposta != other.idResposta)
			return false;
		if (questao == null) {
			if (other.questao != null)
				return false;
		} else if (!questao.equals(other.questao))
			return false;
		return true;
	}
}
