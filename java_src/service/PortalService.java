package service;

import java.util.List;

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

	public Portal salvarPortal(Portal portal){
		Session session = HibernateUtil.getInstance().getSession();
		
		session.beginTransaction();
		
		
		if(portal.getIdPortal()==null){
			session.save(portal.getMunicipio().getUf());
			session.save(portal.getMunicipio());
			session.save(portal);
			session.refresh(portal);
		}
		else{
			session.save(portal.getMunicipio().getUf());
			session.save(portal.getMunicipio());
			session.merge(portal);
		}
		session.getTransaction().commit();
		
		return portal;
	}
	
	public List<Portal> findPortal(){
		Session session = HibernateUtil.getInstance().getSession();
		List<Portal> portais = session.createQuery("from Portal").list();
		
		return portais;
		
	}
	
}
