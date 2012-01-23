package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import entity.CTe;
import entity.CargaPredominante;
import entity.Categoria;
import entity.Equipamento;
import entity.Especie_Tipo;
import entity.Estrada;
import entity.FluxoAlternativo;
import entity.Municipio;
import entity.Portal;
import entity.Registro;
import entity.Segmento;
import entity.TipoMercadoria;
import entity.UF;
import entity.UnidadeMedida;
import entity.Veiculo;

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
		.addAnnotatedClass(FluxoAlternativo.class)
		.addAnnotatedClass(CTe.class)
		.addAnnotatedClass(Veiculo.class)
		.addAnnotatedClass(Categoria.class)
		.addAnnotatedClass(Especie_Tipo.class)
		.addAnnotatedClass(CargaPredominante.class)
		.addAnnotatedClass(UnidadeMedida.class)
		.addAnnotatedClass(TipoMercadoria.class)
		.addAnnotatedClass(Registro.class);
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
