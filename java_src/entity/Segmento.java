package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="TB_SEGMENTO")
public class Segmento {
	
	@Id
	@GeneratedValue
	private Long idSegmento;
 
	private String nome;
	 
	private Integer km;
	
	@OneToOne
	private Portal portalDestino;
	
	@OneToOne
	private Portal portalOrigem;
	 
	@ManyToOne
	@JoinColumn(name="idEstrada")
	private Estrada estrada;

	
	
	public Long getId() {
		return idSegmento;
	}

	public void setId(Long id) {
		this.idSegmento = id;
	}

	public Portal getPortalDestino() {
		return portalDestino;
	}

	public void setPortalDestino(Portal portalDestino) {
		this.portalDestino = portalDestino;
	}

	public Portal getPortalOrigem() {
		return portalOrigem;
	}

	public void setPortalOrigem(Portal portalOrigem) {
		this.portalOrigem = portalOrigem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public Portal getDestino() {
		return portalDestino;
	}

	public void setDestino(Portal destino) {
		portalDestino = destino;
	}

	public Portal getOrigem() {
		return portalOrigem;
	}

	public void setOrigem(Portal origem) {
		portalOrigem = origem;
	}

	public Estrada getEstrada() {
		return estrada;
	}

	public void setEstrada(Estrada estrada) {
		this.estrada = estrada;
	}
	 
}
 
