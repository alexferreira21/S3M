package testes;

import hibernate.HibernateUtil;

import org.hibernate.Session;

public class gerarSchema {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getInstance().getSession();
		session.close();
		
		
	}

}
