package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import dao.MunicipioDao;

import hibernate.HibernateUtil;
import entity.Equipamento;
import entity.Municipio;
import entity.Portal;
import entity.UF;

public class PortalService {
	
	MunicipioDao municipoDao = new MunicipioDao();

	public Portal salvarPortal(Portal portal){
		Session session = HibernateUtil.getInstance().getSession();
		
		session.beginTransaction();
		
		
		if(portal.getIdPortal()==null){
			portal.setMunicipio(municipoDao.persistirMunicipio(portal.getMunicipio()));
			session.save(portal);
			session.refresh(portal);
		}
		else{
			portal.setMunicipio(municipoDao.persistirMunicipio(portal.getMunicipio()));
			session.merge(portal);
		}
		session.getTransaction().commit();
		
		return portal;
	}
	
	public UF buscarUF(UF uf){
		
		return municipoDao.buscarUF(uf);
		
	}
	
	public List<UF> getUFDataProvider(){
		return municipoDao.buscarTodasAsUFs();
	}
	
	
	public List<Portal> findPortal(){
		Session session = HibernateUtil.getInstance().getSession();
		List<Portal> portais = session.createQuery("from Portal").list();
		
		return portais;
		
	}
	
}
