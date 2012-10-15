package org.quasarsd.jprova.dao;

import org.hibernate.Session;
import org.quasarsd.jprova.orm.Questao;
import org.quasarsd.jprova.orm.Resposta;

public class RespostaDAO
{
	private Session session;
	
	public RespostaDAO(Session session) 
	{
		this.session = session;
	}
	
	public void inserir(Resposta questao)
	{
		session.beginTransaction();
		session.save(questao);
		session.getTransaction().commit();
	}
	public void deletar(Resposta questao)
	{
		session.beginTransaction();
		session.delete(questao);
		session.getTransaction().commit();
	}
	public void atualizar(Resposta questao)
	{
		session.beginTransaction();
		session.update(questao);
		session.getTransaction().commit();
	}
	public Resposta pesquisar(Integer id)
	{
		return (Resposta) session.load(Resposta.class, id);
	}
}
