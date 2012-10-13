package org.quasarsd.jprova.orm;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Resposta implements Serializable
{
	@Id
	@GeneratedValue
	private Integer idResposta;
	
	@OneToMany(targetEntity=Questao.class)
	private Questao questao;
}
