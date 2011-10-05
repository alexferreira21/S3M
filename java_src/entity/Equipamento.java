package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Equipamento {
 
	@Id
	@GeneratedValue
	private Long idEquipamento;
	
	private String nome;
	
	private Integer ordem;
	 
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="idPortal")
	private Portal portal;

	public Long getIdEquipamento() {
		return idEquipamento;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	 
}
 
