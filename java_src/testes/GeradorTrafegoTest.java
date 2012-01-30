package testes;

import static org.junit.Assert.assertEquals;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.generic.NEW;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import dto.GeradorDTO;
import entity.Estrada;
import entity.FluxoAlternativo;

import service.GeradorTrafegoService;

public class GeradorTrafegoTest {

	public GeradorTrafegoService service = new GeradorTrafegoService();
	
	@Test
	public void testGerador(){
//		GeradorDTO dto = new GeradorDTO();
//		
//		
//		Session session = HibernateUtil.getInstance().getSession();
//		
//		Estrada estrada = (Estrada)session.createCriteria(Estrada.class)
//								.add(Restrictions.like("nome", "%101%"))
//								.uniqueResult();
//		
//		dto.setEstrada(estrada);
//		dto.setSegmentoInicial(estrada.getSegmentos().get(0));
//		dto.setSegmentoFinal(estrada.getSegmentos().get(estrada.getSegmentos().size()-1));
//		
//		List<FluxoAlternativo> fluxosEntrada = new ArrayList<FluxoAlternativo>();
//
//		FluxoAlternativo inicial = new FluxoAlternativo();
//		inicial.setPortal(estrada.getSegmentos().get(0).getPortalDestino());
//		inicial.setPercentual(70);
//		fluxosEntrada.add(inicial);
//		
//		FluxoAlternativo fa1 = estrada.getFluxosAlternativos().get(0);
//		fa1.setPercentual(30);
//		fluxosEntrada.add(fa1);
//		
//		List<FluxoAlternativo> fluxosSaida = new ArrayList<FluxoAlternativo>();
//		
//		FluxoAlternativo saida = new FluxoAlternativo(); 
//		saida.setPortal(estrada.getSegmentos().get(estrada.getSegmentos().size()-1).getPortalDestino());
//		saida.setPercentual(50);
	}
	
	
//	@Test
//	public void calcularMinutosTest() {
//		Integer HORA_INICIAL = 9;
//		Integer MINUTO_INICIAL = 15;
//		
//		assertEquals(new Integer(555), service.calcularMinutos(HORA_INICIAL, MINUTO_INICIAL));
//	}
	
	
	@Test
	public void getRand(){
		System.out.println((int)(Math.random() * 6));
	}
	
	@Test
	public void testRemoveArray(){
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();
		
		for(Integer i=0 ; i<10 ; i++){
			a.add(i.toString());
		}
		
		
		while(a.size() > 0 ){
			int rand = (int)(Math.random() * a.size());
			b.add(a.remove(rand));
			System.out.println(rand);
		}
		
		System.out.println("a");
	}

}
