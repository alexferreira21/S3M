package service;

import java.util.List;

import org.hibernate.Session;
import dao.MunicipioDao;

import hibernate.HibernateUtil;
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
	
	public Portal removerPortal(Portal portal){
		Session session = HibernateUtil.getInstance().getSession();
		session.beginTransaction();
		
		Portal portalAExcluir = (Portal)session.createQuery("from Portal where idPortal = "+portal.getIdPortal()).uniqueResult();
		session.delete(portalAExcluir);
		
		session.getTransaction().commit();
		
		return portalAExcluir;
		
	}
	
	
	public List<Portal> carregarPortais(){
		Session session = HibernateUtil.getInstance().getSession();
		List<Portal> portais = session.createQuery("from Portal").list();
		
		return portais;
		
	}
	
}
