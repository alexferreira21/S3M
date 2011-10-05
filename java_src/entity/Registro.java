package entity;

import java.util.Date;

public class Registro {
	
	private Long id;
 
	private Date timestamp;
	 
	private Integer direcao;
	 
	private Integer pista;
	 
	private CTe cTe;
	 
	private Portal portal;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getDirecao() {
		return direcao;
	}

	public void setDirecao(Integer direcao) {
		this.direcao = direcao;
	}

	public Integer getPista() {
		return pista;
	}

	public void setPista(Integer pista) {
		this.pista = pista;
	}

	public CTe getcTe() {
		return cTe;
	}

	public void setcTe(CTe cTe) {
		this.cTe = cTe;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	 
}
 
