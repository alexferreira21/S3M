package service;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import util.RandomUtils;

import dao.Especie_TipoDAO;
import dto.GeradorDTO;
import entity.ConhecimentoTransporte;
import entity.CargaPredominante;
import entity.Categoria;
import entity.Especie_Tipo;
import entity.FluxoAlternativo;
import entity.Segmento;
import entity.TipoMercadoria;
import entity.Veiculo;

public class GeradorTrafegoService {
	
	private Especie_TipoDAO especieDAO = new Especie_TipoDAO();
	private GeradorDTO geradorDTO;
	
	@SuppressWarnings("all")
	public void gerarTrafego(GeradorDTO geradorDTO){
		this.geradorDTO = geradorDTO;
		
		Integer minutosInicial = calcularMinutos(geradorDTO.getHoraInicial(), geradorDTO.getMinutoInicial());
		Integer minutosFinal = calcularMinutos(geradorDTO.getHoraFinal(), geradorDTO.getMinutoFinal());
		
		List<Categoria> categorias = HibernateUtil.getInstance().getSession().createQuery("from Categoria").list(); //CRIAR GENERIC DAO

		Especie_Tipo especieCaminhao = especieDAO.getEspecieCaminhao();
		List<Especie_Tipo> especieOutros = especieDAO.getEspecieOutros();
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		List<ConhecimentoTransporte> CTs = new ArrayList<ConhecimentoTransporte>();
		
		for(int i=1; i<= geradorDTO.getQtdCaminhoes() ; i++){
			Veiculo novoVeiculo = new Veiculo();
			novoVeiculo.setCategoria(categorias.get(0));
			novoVeiculo.setEspecie_Tipo(especieCaminhao);
			
			CargaPredominante novaCarga = new CargaPredominante();
			novaCarga.setTipoMeradoria((TipoMercadoria)RandomUtils.selecionarAleatoriamente(geradorDTO.getTiposCarga()));
			novaCarga.setQuantidade(RandomUtils.entreValores(100.0f, 15000.0f));		
			novaCarga.setValor(RandomUtils.entreValores(0.0f, 10000000.0f));
			
			ConhecimentoTransporte ct = new ConhecimentoTransporte();
			ct.setVeiculo(novoVeiculo);
			ct.setCargaPredominante(novaCarga);
			
			veiculos.add(novoVeiculo);
		}
		
		for(int i=1; i<= geradorDTO.getQtdOutrosVeiculos() ; i++){
			Veiculo novoVeiculo = new Veiculo();
			novoVeiculo.setCategoria(categorias.get(0));
			novoVeiculo.setEspecie_Tipo((Especie_Tipo)RandomUtils.selecionarAleatoriamente(especieOutros));
			
			veiculos.add(novoVeiculo);
		}
		
		Integer totalVeiculos = veiculos.size();
		for (FluxoAlternativo fluxoEntradaItem : geradorDTO.getFluxosEntrada()){
			List<Veiculo> listaEntrada = new ArrayList<Veiculo>();
			Integer percentual = (int) ((fluxoEntradaItem.getPercentual() * totalVeiculos) / 100); 
			for(int i=0 ; i < percentual ; i++){
				listaEntrada.add(veiculos.remove(RandomUtils.menorQue(veiculos.size())));
			}
	
			for(FluxoAlternativo fluxoSaidaItem : geradorDTO.getFluxosSaida()){
				if(ordemDoFluxo(fluxoSaidaItem) > ordemDoFluxo(fluxoEntradaItem)){
					gerarRegistros(fluxoEntradaItem, fluxoSaidaItem, (int)( (listaEntrada.size() * fluxoSaidaItem.getPercentual()) / 100));
				}
			}
		}		
		
	}
	
	private Integer ordemDoFluxo(FluxoAlternativo fluxo){
		if(fluxo.getPortal().getIdPortal() == geradorDTO.getEstrada().getSegmentos().get(0).getPortalOrigem().getIdPortal()){
			return 0;
		}
		
		for(Segmento segmentoItem : geradorDTO.getEstrada().getSegmentos()){
			if(fluxo.getPortal().getIdPortal() == segmentoItem.getPortalDestino().getIdPortal()){
				return geradorDTO.getEstrada().getSegmentos().indexOf(segmentoItem) + 1;
			}
		}
		
		return null;
	}
	
	private void gerarRegistros(FluxoAlternativo inicio, FluxoAlternativo fim, Integer qtd){
		System.out.println("Gerar " + qtd + " registros de: " + inicio.getPortal().getNome() + " até: "+ fim.getPortal().getNome());
		
		//IMPLEMENTAR ISSO AQUI!
	}
	
	private Integer calcularMinutos(Integer hora, Integer minuto){
		
		return hora * 60 + minuto;
	}
	
	
	

}
