package service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.GraficosDAO;
import dto.ValorGrafico;

public class GraficosService {
	
	GraficosDAO graficosDAO = new GraficosDAO();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public  List<ValorGrafico> graficoValorPorMes(Long idEstrada, Date dataInicio, Date dataFim){
		
		List<Object[]> retornoDAO = graficosDAO.graficoValorPorMes(idEstrada, dataInicio, dataFim);
		List<ValorGrafico> retornoService = new ArrayList<ValorGrafico>();
		
		for( Object[] array : retornoDAO){
			ValorGrafico valorGrafico = new ValorGrafico();
			valorGrafico.setDescricao(substituirMes(Integer.valueOf((String)array[0])));
			valorGrafico.setValor((Float)array[1]);
			
			retornoService.add(valorGrafico);
		}
		
		
		return retornoService;
	}
	
	
	public List<ValorGrafico> graficoTiposDeVeiculos(Long idEstrada, Date dataInicio, Date dataFim){
		
		List<Object[]> retornoDAO = graficosDAO.graficoTiposDeVeiculos(idEstrada, dataInicio, dataFim);
		List<ValorGrafico> retornoService = new ArrayList<ValorGrafico>();
		
		for( Object[] array : retornoDAO){
			ValorGrafico valorGrafico = new ValorGrafico();
			valorGrafico.setDescricao((String)array[0]);
			
			BigInteger bigValor = (BigInteger)array[1];
			valorGrafico.setValor(bigValor.floatValue()); 
					
			retornoService.add(valorGrafico);
		}
		
		
		return retornoService;
	}
	
	public List<ValorGrafico> graficoPesoPorSemana(Long idEstrada, Date dataInicio, Date dataFim){
		
		List<Object[]> retornoDAO = graficosDAO.graficoPesoPorSemana(idEstrada, dataInicio, dataFim);
		List<ValorGrafico> retornoService = new ArrayList<ValorGrafico>();

		
		for( Object[] array : retornoDAO){
			ValorGrafico valorGrafico = new ValorGrafico();
			valorGrafico.setDescricao(substituirDiasDaSemana(Integer.valueOf((String)array[0])));
			
			Double valorDouble = (Double)array[1];
			valorGrafico.setValor(valorDouble.floatValue()/1000); 
					
			retornoService.add(valorGrafico);
		}
		
		
		return retornoService;
	}
	
	
	private String substituirDiasDaSemana(Integer numero){
		
		switch ( numero ) {

		case 0:
			return "Domingo";
		case 1:
			return "Segunda";

		case 2:
			return "Terça";

		case 3:
			return "Quarta";

		case 4:
			return "Quinta";

		case 5:
			return "Sexta";

		case 6:
			return "Sábado";

		default:
			return "";
		}
		
	}
	
	
	
	
	private String substituirMes(Integer numero){
		
		switch ( numero ) {

		case 1:
			return "Janeiro";

		case 2:
			return "Fevereiro";

		case 3:
			return "Março";

		case 4:
			return "Abril";

		case 5:
			return "Maio";

		case 6:
			return "Junho";

		case 7:
			return "Julho";

		case 8:
			return "Agosto";

		case 9:
			return "Setembro";

		case 10:
			return "Outubro";

		case 11:
			return "Novembro";

		case 12:
			return "Dezembro";

			
		default:
			return "";
		}
	}
	

}

