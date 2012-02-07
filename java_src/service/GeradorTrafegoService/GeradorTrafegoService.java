package service.GeradorTrafegoService;

import hibernate.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.omg.DynamicAny.DynValueOperations;

import util.RandomUtils;

import dao.Especie_TipoDAO;
import dto.GeradorDTO;
import entity.ConhecimentoTransporte;
import entity.CargaPredominante;
import entity.Categoria;
import entity.Equipamento;
import entity.Especie_Tipo;
import entity.FluxoAlternativo;
import entity.Portal;
import entity.Registro;
import entity.Segmento;
import entity.SentidoEnum;
import entity.TipoMercadoria;
import entity.Veiculo;

public class GeradorTrafegoService {

	private Especie_TipoDAO especieDAO = new Especie_TipoDAO();
	private GeradorDTO geradorDTO;
	private List<PortalKm> portaisNaEstrada = new ArrayList<PortalKm>();


	@SuppressWarnings("all")
	public void gerarTrafego(GeradorDTO geradorDTO){
		this.geradorDTO = geradorDTO;

		prepararListaDePortais();

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

			novoVeiculo.setCte(ct);

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
					gerarRegistros(fluxoEntradaItem, fluxoSaidaItem, (int)( (listaEntrada.size() * fluxoSaidaItem.getPercentual()) / 100), listaEntrada);
				}
			}
		}		

	}


	private void prepararListaDePortais(){
		this.portaisNaEstrada = new ArrayList<PortalKm>();

		int indexInicial = geradorDTO.getEstrada().getSegmentos().indexOf(geradorDTO.getSegmentoInicial());
		int indexFinal = geradorDTO.getEstrada().getSegmentos().indexOf(geradorDTO.getSegmentoFinal());

		if(geradorDTO.getSentido().equals(SentidoEnum.POSITIVO)){

			PortalKm portalInicial = new PortalKm(geradorDTO.getEstrada().getSegmentos().get(indexInicial).getPortalOrigem(), geradorDTO.getEstrada().getSegmentos().get(indexInicial).getKmInicial());
			portalInicial.setEquipamentosNoSentido(procurarEquipamentosNoSentido(portalInicial.getPortal()));
			portaisNaEstrada.add(portalInicial);

			for(int i = indexInicial ; i<= indexFinal ; i++){
				PortalKm portalFinal = new PortalKm(geradorDTO.getEstrada().getSegmentos().get(i).getPortalDestino(), geradorDTO.getEstrada().getSegmentos().get(i).getKmFinal());
				portalFinal.setEquipamentosNoSentido(procurarEquipamentosNoSentido(portalFinal.getPortal()));
				portaisNaEstrada.add(portalFinal);
			}

		}
		else{

			PortalKm portalInicial = new PortalKm(geradorDTO.getEstrada().getSegmentos().get(indexInicial).getPortalDestino(), geradorDTO.getEstrada().getSegmentos().get(indexInicial).getKmFinal());
			portalInicial.setEquipamentosNoSentido(procurarEquipamentosNoSentido(portalInicial.getPortal()));
			portaisNaEstrada.add(portalInicial);

			for(int i = indexInicial ; i>= indexFinal ; i--){
				PortalKm portalFinal = new PortalKm(geradorDTO.getEstrada().getSegmentos().get(i).getPortalOrigem(), geradorDTO.getEstrada().getSegmentos().get(i).getKmInicial());
				portalFinal.setEquipamentosNoSentido(procurarEquipamentosNoSentido(portalFinal.getPortal()));
				portaisNaEstrada.add(portalFinal);
			}
		}
	}


	private List<Equipamento> procurarEquipamentosNoSentido(Portal portal){
		List<Equipamento> retorno = new ArrayList<Equipamento>();
		Boolean temEqp = false;
		for(Equipamento equipamentoItem : portal.getEquipamento()){
			if(equipamentoItem.getSentido().equals(geradorDTO.getSentido())){
				retorno.add(equipamentoItem);
				temEqp = true;
			}
		}

		if(temEqp){
			return retorno;
		}
		else{
			throw new RuntimeException("Portal " + portal.getNome() +" não possui uma pista neste sentido.");
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

	private void gerarRegistros(FluxoAlternativo inicio, FluxoAlternativo fim, Integer qtd, List<Veiculo> listaVeiculos){

		for(int k=0 ; k < qtd ; k++){
			Integer indexPortalInicial = -1;
			Integer indexPortalFinal = -1;

			for(PortalKm portalItem : portaisNaEstrada){
				if(portalItem.getPortal().getIdPortal() == inicio.getPortal().getIdPortal()){
					indexPortalInicial = portaisNaEstrada.indexOf(portalItem);
				}
				if(portalItem.getPortal().getIdPortal() == fim.getPortal().getIdPortal()){
					indexPortalFinal = portaisNaEstrada.indexOf(portalItem);
				}
			}

			Veiculo veiculo = listaVeiculos.remove(RandomUtils.menorQue(listaVeiculos.size()));

			Registro primeiroRegistro = new Registro();
			primeiroRegistro.setVeiculo(veiculo);
			Equipamento eqp = portaisNaEstrada.get(indexPortalInicial).getPortal().getEquipamento().get(RandomUtils.menorQue(portaisNaEstrada.get(indexPortalFinal).getPortal().getEquipamento().size()));
			primeiroRegistro.setEquipamento(eqp);
			primeiroRegistro.setcTe(veiculo.getCte());

			Calendar timestamp = Calendar.getInstance();
			timestamp.setTime(geradorDTO.getDataInicial());

			Integer minutosInicial = calcularMinutos(geradorDTO.getHoraInicial(), geradorDTO.getMinutoInicial());
			Integer minutosFinal = calcularMinutos(geradorDTO.getHoraFinal(), geradorDTO.getMinutoFinal());

			Integer minutosgerado = RandomUtils.entreValores(minutosInicial, minutosFinal);

			timestamp.set(Calendar.HOUR_OF_DAY, minutosgerado / 60);
			timestamp.set(Calendar.MINUTE, minutosgerado % 60);
			timestamp.set(Calendar.SECOND, 0);

			primeiroRegistro.setTimestamp(new Date(timestamp.getTimeInMillis()));

			HibernateUtil.getInstance().getSession().save(primeiroRegistro);
			
			Registro ultimoRegistro = primeiroRegistro;

			for(int i=0 ; i<Math.abs(indexPortalFinal - indexPortalInicial) ; i++){
				Registro proxRegistro = new Registro();
				Integer velocidade = RandomUtils.entreValores(geradorDTO.getVelocidadeInicial(), geradorDTO.getVelocidadeFinal());
				Integer distancia = Math.abs(portaisNaEstrada.get(indexPortalFinal).getKm() - portaisNaEstrada.get(indexPortalInicial).getKm());
				Double tempo = (double) distancia / velocidade;

				Date timestampFinal = new Date(ultimoRegistro.getTimestamp().getTime() + (long)(tempo * 60 * 60 * 1000));
				proxRegistro.setTimestamp(timestampFinal);
				proxRegistro.setVeiculo(veiculo);
				proxRegistro.setcTe(veiculo.getCte());
				proxRegistro.setEquipamento(portaisNaEstrada.get(indexPortalInicial + i).getPortal().getEquipamento().get(RandomUtils.menorQue(portaisNaEstrada.get(indexPortalFinal).getPortal().getEquipamento().size())));

				HibernateUtil.getInstance().getSession().save(proxRegistro);
				
				ultimoRegistro = proxRegistro;
			}
		}

	}

	private Integer calcularMinutos(Integer hora, Integer minuto){

		return hora * 60 + minuto;
	}




}
