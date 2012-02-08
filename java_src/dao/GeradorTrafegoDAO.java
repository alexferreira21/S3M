package dao;

import hibernate.HibernateUtil;

import org.hibernate.Session;

import entity.Registro;

public class GeradorTrafegoDAO {
	
	private Session session = HibernateUtil.getInstance().getSession();

	public void salvarRegistro(Registro registro){

		session.beginTransaction();

		session.saveOrUpdate(registro);
		
		session.getTransaction().commit();
	}




}
