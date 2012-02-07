package service.GeradorTrafegoService;

import java.util.List;

import entity.Equipamento;
import entity.Portal;

public class PortalKm {

	private Portal portal;
	private Integer km;
	private List<Equipamento> equipamentosNoSentido;

	
	
	public PortalKm(Portal portal, Integer km) {
		super();
		this.portal = portal;
		this.km = km;
	}

	
	public Portal getPortal() {
		return portal;
	}
	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	public Integer getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public List<Equipamento> getEquipamentosNoSentido() {
		return equipamentosNoSentido;
	}
	public void setEquipamentosNoSentido(List<Equipamento> equipamentosNoSentido) {
		this.equipamentosNoSentido = equipamentosNoSentido;
	}
	
}
