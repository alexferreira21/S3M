package service;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

import entity.Estrada;
import entity.Segmento;

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
	
	public Estrada removerEstrada(Estrada estrada){
		Session session = HibernateUtil.getInstance().getSession();
		session.beginTransaction();
		
		Estrada estradaAExcluir = (Estrada)session.createQuery("from Estrada where idEstrada = "+ estrada.getIdEstrada()).uniqueResult();
		session.delete(estradaAExcluir);
		
		session.getTransaction().commit();
		
		return estradaAExcluir;
	}
}
