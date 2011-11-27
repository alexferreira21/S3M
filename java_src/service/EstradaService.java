package service;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

import entity.Estrada;
import entity.FluxoAlternativo;
import entity.Segmento;

public class EstradaService {
	
	
	public Estrada salvarEstrada(Estrada estrada){
		Session session = HibernateUtil.getInstance().getSession();
		
		session.beginTransaction();
		
		if(estrada.getIdEstrada() ==null){
			
			session.save(estrada);
		}
		else{
			session.merge(estrada);
		}
		
		session.getTransaction().commit();
		
		estrada = (Estrada)session.createQuery("from Estrada where idEstrada = "+ estrada.getIdEstrada()).uniqueResult(); //Gambiarra para atualizar os ids dos fluxos, consertar isso!
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
	
	public FluxoAlternativo removerFluxoAlternativo(FluxoAlternativo fluxoAlternativo){
		Session session = HibernateUtil.getInstance().getSession();
		session.beginTransaction();
		
		Estrada estradaDoFluxoAlternativo = (Estrada)session.createQuery("from Estrada where idEstrada = "+ fluxoAlternativo.getEstrada().getIdEstrada()).uniqueResult();
		FluxoAlternativo fluxoAlternativoAExcluir = (FluxoAlternativo) session.createQuery("from FluxoAlternativo where idFluxoAlternativo = "+ fluxoAlternativo.getIdFluxoAlternativo()).uniqueResult();
		
		estradaDoFluxoAlternativo.getFluxosAlternativos().remove(fluxoAlternativoAExcluir);
		
		session.delete(fluxoAlternativoAExcluir);
		session.save(estradaDoFluxoAlternativo);
		
		session.getTransaction().commit();
		
		return fluxoAlternativoAExcluir;
	}
	
	
}
