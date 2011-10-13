package dao;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.Municipio;
import entity.Portal;
import entity.UF;
import flex.messaging.io.ArrayCollection;

public class MunicipioDao {
	
	
	public Municipio persistirMunicipio(Municipio municipio)
	{
		Session session = HibernateUtil.getInstance().getSession();
		
		
		String hql = "from Municipio as m" +
					 "	where m.nome = '"+ municipio.getNome() + "'" +
					 "  and m.uf.sigla = '"+municipio.getUf().getSigla()+"'";
		
		
		Municipio municipioRetornado = (Municipio)session.createQuery(hql).uniqueResult();
		
		if(municipioRetornado == null)
		{
			session.save(municipio);
			return municipio;
		}
		else
		{
			return municipioRetornado;
		}
		
		
		
	}
	
	
	public UF buscarUF(UF uf)
	{
		Session session = HibernateUtil.getInstance().getSession();
		
		
		String hql = "from UF as uf" +
					 "	where uf.sigla = '"+ uf.getSigla() + "'";
		
		
		UF ufRetornada = (UF)session.createQuery(hql).uniqueResult();
		
		return ufRetornada;
	}
	
	public List<UF> buscarTodasAsUFs(){
		Session session = HibernateUtil.getInstance().getSession();
		List<?> listaObject =  session.createQuery("from UF").list();
		List<UF> listaUF = new ArrayList<UF>();
		
		for (Object obj  : listaObject){
			listaUF.add((UF)obj);
		}
		
		return listaUF;
	}
			
	

}
