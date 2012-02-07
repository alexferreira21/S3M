package dto;

import java.util.Date;
import java.util.List;


import entity.Estrada;
import entity.FluxoAlternativo;
import entity.Segmento;
import entity.SentidoEnum;
import entity.TipoMercadoria;

public class GeradorDTO {

	private Date dataInicial; 
	private Date dataFinal ;

	private Integer horaInicial;
	private Integer minutoInicial;

	private Integer horaFinal;
	private Integer minutoFinal;

	private Estrada estrada;

	private Segmento segmentoInicial;
	private Segmento segmentoFinal;

	private List<FluxoAlternativo> fluxosEntrada;
	private List<FluxoAlternativo> fluxosSaida;
	
	private Integer qtdCaminhoes;	
	private Integer qtdOutrosVeiculos;

	private Integer velocidadeInicial;
	private Integer velocidadeFinal;
	
	private SentidoEnum sentido;

	private List<TipoMercadoria> tiposCarga;
	

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Integer horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Integer getMinutoInicial() {
		return minutoInicial;
	}

	public void setMinutoInicial(Integer minutoInicial) {
		this.minutoInicial = minutoInicial;
	}

	public Integer getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Integer getMinutoFinal() {
		return minutoFinal;
	}

	public void setMinutoFinal(Integer minutoFinal) {
		this.minutoFinal = minutoFinal;
	}

	public Estrada getEstrada() {
		return estrada;
	}

	public void setEstrada(Estrada estrada) {
		this.estrada = estrada;
	}

	public Segmento getSegmentoInicial() {
		return segmentoInicial;
	}

	public void setSegmentoInicial(Segmento segmentoInicial) {
		this.segmentoInicial = segmentoInicial;
	}

	public Segmento getSegmentoFinal() {
		return segmentoFinal;
	}

	public void setSegmentoFinal(Segmento segmentoFinal) {
		this.segmentoFinal = segmentoFinal;
	}

	public List<FluxoAlternativo> getFluxosEntrada() {
		return fluxosEntrada;
	}

	public void setFluxosEntrada(List<FluxoAlternativo> fluxosEntrada) {
		this.fluxosEntrada = fluxosEntrada;
	}

	public List<FluxoAlternativo> getFluxosSaida() {
		return fluxosSaida;
	}

	public void setFluxosSaida(List<FluxoAlternativo> fluxosSaida) {
		this.fluxosSaida = fluxosSaida;
	}

	public Integer getQtdCaminhoes() {
		return qtdCaminhoes;
	}

	public void setQtdCaminhoes(Integer qtdCaminhoes) {
		this.qtdCaminhoes = qtdCaminhoes;
	}

	public Integer getQtdOutrosVeiculos() {
		return qtdOutrosVeiculos;
	}

	public void setQtdOutrosVeiculos(Integer qtdOutrosVeiculos) {
		this.qtdOutrosVeiculos = qtdOutrosVeiculos;
	}

	public Integer getVelocidadeInicial() {
		return velocidadeInicial;
	}

	public void setVelocidadeInicial(Integer velocidadeInicial) {
		this.velocidadeInicial = velocidadeInicial;
	}

	public Integer getVelocidadeFinal() {
		return velocidadeFinal;
	}

	public void setVelocidadeFinal(Integer velocidadeFinal) {
		this.velocidadeFinal = velocidadeFinal;
	}

	public List<TipoMercadoria> getTiposCarga() {
		return tiposCarga;
	}

	public void setTiposCarga(List<TipoMercadoria> tiposCarga) {
		this.tiposCarga = tiposCarga;
	}

	public SentidoEnum getSentido() {
		return sentido;
	}

	public void setSentido(SentidoEnum sentidoOriginal) {
		this.sentido = sentidoOriginal;
	}

}
