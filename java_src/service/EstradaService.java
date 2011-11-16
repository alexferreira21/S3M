package service;

import hibernate.HibernateUtil;

import org.hibernate.Session;

import entity.Estrada;

public class EstradaService {
	
	
	public Estrada salvarEstrada(Estrada estrada){
		Session session = HibernateUtil.getInstance().getSession();
		
		session.beginTransaction();
		
		if(estrada.getId() ==null){
			
			session.save(estrada);
		}
		else{
			session.merge(estrada);
		}
		session.getTransaction().commit();
		
		return estrada;
	}

}
