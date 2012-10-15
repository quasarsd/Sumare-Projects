package org.quasarsd.jprova.dao;

import org.hibernate.Session;
import org.quasarsd.jprova.orm.Questao;

public class QuestaoDAO
{
	private Session session;
	
	public QuestaoDAO(Session session) 
	{
		this.session = session;
	}
	
	public void inserir(Questao questao)
	{
		session.beginTransaction();
		session.save(questao);
		session.getTransaction().commit();
	}
	public void deletar(Questao questao)
	{
		session.beginTransaction();
		session.delete(questao);
		session.getTransaction().commit();
	}
	public void atualizar(Questao questao)
	{
		session.beginTransaction();
		session.update(questao);
		session.getTransaction().commit();
	}
	public Questao pesquisar(Integer id)
	{
		return (Questao) session.load(Questao.class, id);
	}
}
