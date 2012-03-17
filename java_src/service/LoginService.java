package service;

import hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entity.Usuario;

public class LoginService {
	
	
	public Usuario login(String login, String senha){
	
		Session session = HibernateUtil.getInstance().getSession();
		Criteria query =  session.createCriteria(Usuario.class)
						.add(Restrictions.eq("login", login))
						.add(Restrictions.like("senha", senha));
						
					   
		
		
		Usuario usuarioRetornado = (Usuario)query.uniqueResult();
		return usuarioRetornado;
	}

}
