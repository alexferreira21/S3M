package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import hibernate.HibernateUtil;
import entity.Equipamento;
import entity.Municipio;
import entity.Portal;
import entity.UF;

public class PortalService {

	public void salvarPortal(Portal portal){
		Session session = HibernateUtil.getInstance().getSession();
		
		session.beginTransaction();
		
		session.save(portal.getMunicipio().getUf());
		session.save(portal.getMunicipio());
		session.save(portal);
		
		session.getTransaction().commit();
	}
	
	
}
