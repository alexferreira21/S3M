package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import entity.Equipamento;
import entity.Estrada;
import entity.FluxoAlternativo;
import entity.Municipio;
import entity.Portal;
import entity.Segmento;
import entity.UF;

public class HibernateUtil {
	
	private static HibernateUtil instance;
	private Session session;

	private HibernateUtil(){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Equipamento.class)
		.addAnnotatedClass(Portal.class)
		.addAnnotatedClass(Municipio.class)
		.addAnnotatedClass(UF.class)
		.addAnnotatedClass(Segmento.class)
		.addAnnotatedClass(Estrada.class)
		.addAnnotatedClass(FluxoAlternativo.class);
		config.configure("hibernate.cfg.xml");
		
		//new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		session = factory.openSession();
	}

	
	public static HibernateUtil getInstance(){
		if(instance == null){
			instance =  new HibernateUtil();
			return instance;
		}
		else{
			return instance;
		}
			
	}
	
	public Session getSession(){
		return session;
	}
	
	

}
