package entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_EQUIPAMENTO")
public class Equipamento {
 
	@Id
	@GeneratedValue
	private Long idEquipamento;
	
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private SentidoEnum sentido;
	
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


	public SentidoEnum getSentido() {
		return sentido;
	}

	public void setSentido(SentidoEnum sentido) {
		this.sentido = sentido;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	 
}
 
