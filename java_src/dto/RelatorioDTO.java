package dto;

import java.util.List;

import entity.UF;

public class RelatorioDTO {
	
	private UF uf;
	private List destinos;
	
	
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	public List getDestinos() {
		return destinos;
	}
	public void setDestinos(List destinos) {
		this.destinos = destinos;
	}

}
