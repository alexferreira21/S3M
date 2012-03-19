package dto;

import java.util.List;

import entity.UF;

public class RelatorioDTO {

	private UF uf;
	private String tipoMercadoria;
	private String dataInicial;
	private String dataFinal;
	private String totalVeiculos;
	private String totalPeso;
	private String totalValor;

	private List<UfInfo> destinos;


	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	public List<UfInfo> getDestinos() {
		return destinos;
	}
	public void setDestinos(List<UfInfo> destinos) {
		this.destinos = destinos;
	}
	public String getTipoMercadoria() {
		return tipoMercadoria;
	}
	public void setTipoMercadoria(String tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getTotalVeiculos() {
		return totalVeiculos;
	}
	public void setTotalVeiculos() {
		Long total = 0L;

		for(UfInfo item : destinos)
		{
			total += item.getVeiculos();
		}
		this.totalVeiculos = total.toString();
	}
	public String getTotalPeso() {
		return totalPeso;
	}
	public void setTotalPeso() {
		Double total = 0.0;

		for(UfInfo item : destinos)
		{
			total = total + item.getQtd();
		}
		this.totalPeso = total.toString();
	}
	
	public String getTotalValor() {
		return totalValor;
	}
	public void setTotalValor() {
		Double total = 0.0;

		for(UfInfo item : destinos)
		{
			total = total + item.getValor();
		}
		this.totalValor=total.toString();
	}

}
