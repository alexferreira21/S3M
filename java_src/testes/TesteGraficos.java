package testes;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import service.GraficosService;

import dao.GraficosDAO;

public class TesteGraficos {

	private GraficosDAO dao = new GraficosDAO();
	private GraficosService service = new GraficosService();

	//	@Test
	//	public void testGraficoValorPorMesDAO() throws ParseException {
	//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//		
	//		Date ini = formatter.parse("01/01/2012");
	//		Date fim = formatter.parse("01/05/2012");
	//		
	//		dao.graficoValorPorMes(3L, ini, fim);
	//	}
	//	
	//	@Test
	//	public void testGraficoValorPorMesService() throws ParseException {
	//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//		
	//		Date ini = formatter.parse("01/01/2012");
	//		Date fim = formatter.parse("01/05/2012");
	//		
	//		service.graficoValorPorMes(3L, ini, fim);
	//	}
	//	
	//	@Test
	//	public void testGraficoTiposDeVeiculosDAO() throws ParseException {
	//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//		
	//		Date ini = formatter.parse("01/03/2012");
	//		Date fim = formatter.parse("01/04/2012");
	//		
	//		dao.graficoTiposDeVeiculos(3L, ini, fim);
	//	}
	//	
	//	@Test
	//	public void testGraficoTiposDeVeiculosService() throws ParseException {
	//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//		
	//		Date ini = formatter.parse("01/03/2012");
	//		Date fim = formatter.parse("01/04/2012");
	//		
	//		service.graficoTiposDeVeiculos(3L, ini, fim);
	//	}
	//	
	//	@Test
	//	public void testGraficoPesosPorSemanaDAO() throws ParseException {
	//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//		
	//		Date ini = formatter.parse("01/03/2012");
	//		Date fim = formatter.parse("01/04/2012");
	//		
	//		dao.graficoPesoPorSemana(3L, ini, fim);
	//	}
	//	
	//	
	//	@Test
	//	public void testGraficoPesosPorSemanaService() throws ParseException {
	//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//		
	//		Date ini = formatter.parse("01/01/2012");
	//		Date fim = formatter.parse("01/02/2012");
	//		
	//		service.graficoPesoPorSemana(3L, ini, fim);
	//	}
//
//	@Test
//	public void testGraficoTipoDeCargaPorSemanaDAO() throws ParseException {
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		
//		Date ini = formatter.parse("01/01/2012");
//		Date fim = formatter.parse("01/08/2012");
//		
//		dao.graficoTipoDeCargaPorSemana(3L, 1, ini, fim);
//	}
//
	@Test
	public void testGraficoTipoDeCargaPorSemanaService() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Date ini = formatter.parse("01/01/2012");
		Date fim = formatter.parse("01/02/2012");
		
		service.graficoTipoDeCargaPorSemana(3L, 1, ini, fim);
	}

}
