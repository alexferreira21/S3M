package dao;

import hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entity.Equipamento;

public class PortalDAO {

	private Session session = HibernateUtil.getInstance().getSession(); 
	
	public Equipamento findEquipamentoById(Long id){
		Equipamento e =  (Equipamento)session.createCriteria(Equipamento.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult(); 
		
		return e;
	}
}
