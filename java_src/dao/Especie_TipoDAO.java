package dao;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entity.Especie_Tipo;

public class Especie_TipoDAO {
	
	private Session session = HibernateUtil.getInstance().getSession(); 
 	
	
	public Especie_Tipo getEspecieCaminhao(){
		return (Especie_Tipo)session.createCriteria(Especie_Tipo.class)
				.add(Restrictions.like("descricao", "%Caminhão%"))
				.uniqueResult(); 
	}
	
	public List<Especie_Tipo> getEspecieOutros(){
		return session.createCriteria(Especie_Tipo.class)
				.add(Restrictions.not(Restrictions.like("descricao", "%Caminhão%")))
				.list();
	}
	
	

}
