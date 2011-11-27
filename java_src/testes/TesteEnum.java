package testes;

import hibernate.HibernateUtil;

import org.hibernate.Session;

import entity.FluxoAlternativo;
import entity.TipoFluxoAlternativoEnum;

public class TesteEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getInstance().getSession();
		
		//Portal p1 = (Portal)session.createQuery("from Portal where idPortal = 1").uniqueResult(); 
		FluxoAlternativo fa1 = new FluxoAlternativo();
		
		//fa1.setPortal(p1);
		fa1.setTipo(TipoFluxoAlternativoEnum.SAIDA);
		
		session.beginTransaction();
		session.saveOrUpdate(fa1);
		session.getTransaction().commit();
	}

}
