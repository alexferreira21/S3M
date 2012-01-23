package service;

import hibernate.HibernateUtil;

import java.util.List;

import entity.TipoMercadoria;


public class CargaService {
	
	
	public List<TipoMercadoria> carregarTipoMercadoria(){
		return HibernateUtil.getInstance().getSession().createQuery("from TipoMercadoria").list();
	}

}
