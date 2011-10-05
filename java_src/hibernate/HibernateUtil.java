package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import entity.Equipamento;
import entity.Municipio;
import entity.Portal;
import entity.UF;

public class HibernateUtil {
	
	private static HibernateUtil instance;
	private Session session;

	private HibernateUtil(){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Equipamento.class)
		.addAnnotatedClass(Portal.class)
		.addAnnotatedClass(Municipio.class)
		.addAnnotatedClass(UF.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		session = factory.openSession();
	}

	
	public static HibernateUtil getInstance(){
		if(instance == null){
			return new HibernateUtil();
		}
		else{
			return instance;
		}
			
	}
	
	public Session getSession(){
		return session;
	}
	
	

}
