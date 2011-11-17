package service;

import java.util.List;

import hibernate.HibernateUtil;

import org.hibernate.Session;

import entity.Estrada;
import entity.Portal;

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
	
	public List<Estrada> carregarEstradas(){
		Session session = HibernateUtil.getInstance().getSession();
		List<Estrada> estradas = session.createQuery("from Estrada").list();
		
		return estradas;
	}

}
