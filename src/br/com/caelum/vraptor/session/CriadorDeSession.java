package br.com.caelum.vraptor.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CriadorDeSession {

	public static Session getSession() {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure();
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

}
