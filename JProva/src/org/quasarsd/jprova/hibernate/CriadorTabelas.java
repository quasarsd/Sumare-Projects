package org.quasarsd.jprova.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.quasarsd.jprova.orm.Questao;
import org.quasarsd.jprova.orm.Resposta;

@SuppressWarnings("deprecation")
public class CriadorTabelas {
	
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Questao.class);
		cfg.addAnnotatedClass(Resposta.class);
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);		
	}

}
