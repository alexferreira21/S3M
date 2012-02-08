package service;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

import entity.TipoMercadoria;


public class CargaService {
	
	private Session session = HibernateUtil.getInstance().getSession();
	
	public List<TipoMercadoria> carregarTipoMercadoria(){
		List<TipoMercadoria> list = session.createCriteria(TipoMercadoria.class).list();
		
		return list;
	}

}
