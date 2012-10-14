package org.quasarsd.jprova.tester;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistryBuilder;
import org.quasarsd.jprova.dao.QuestaoDAO;
import org.quasarsd.jprova.orm.Questao;

public class QuestaoTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().configure().buildServiceRegistry();
		SessionFactory sessionFactory = null;
			
		
		
		Session session = sessionFactory.openSession();
		
		Questao questao = new Questao();
		questao.setPeso(new Byte((byte) 2));
		questao.setDescricao("Quem descobriu o Brasil?");
		
		
		QuestaoDAO questaoDAO = new QuestaoDAO(session);
		
		System.out.println("Inserindo uma questao");
		questaoDAO.inserir(questao);
		System.out.println("Questao inserida");
		session.close();
		
		session = sessionFactory.openSession();
		System.out.println("Pesquisando uma questao");
		System.out.println(questaoDAO.pesquisar(questao.getIdQuestao()).getDescricao());
		session.close();
		
		
		
		
		
		

	}

}
