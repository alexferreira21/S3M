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
	 
	private Integer kmInicial;
	
	private Integer kmFinal;
	
	@OneToOne
	private Portal portalDestino;
	
	@OneToOne
	private Portal portalOrigem;
	 

	@ManyToOne
	@JoinColumn(name="idEstrada", nullable = false)
	private Estrada estrada;

	
	public Long getIdSegmento() {
		return idSegmento;
	}

	public void setIdSegmento(Long idSegmento) {
		this.idSegmento = idSegmento;
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
	
	public Integer getKmInicial() {
		return kmInicial;
	}

	public void setKmInicial(Integer kmInicial) {
		this.kmInicial = kmInicial;
	}

	public Integer getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(Integer kmFinal) {
		this.kmFinal = kmFinal;
	}

	public Estrada getEstrada() {
		return estrada;
	}

	public void setEstrada(Estrada estrada) {
		this.estrada = estrada;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estrada == null) ? 0 : estrada.hashCode());
		result = prime * result
				+ ((idSegmento == null) ? 0 : idSegmento.hashCode());
		result = prime * result + ((kmFinal == null) ? 0 : kmFinal.hashCode());
		result = prime * result
				+ ((kmInicial == null) ? 0 : kmInicial.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((portalDestino == null) ? 0 : portalDestino.hashCode());
		result = prime * result
				+ ((portalOrigem == null) ? 0 : portalOrigem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segmento other = (Segmento) obj;
		if (estrada == null) {
			if (other.estrada != null)
				return false;
		} else if (!estrada.equals(other.estrada))
			return false;
		if (idSegmento == null) {
			if (other.idSegmento != null)
				return false;
		} else if (!idSegmento.equals(other.idSegmento))
			return false;
		if (kmFinal == null) {
			if (other.kmFinal != null)
				return false;
		} else if (!kmFinal.equals(other.kmFinal))
			return false;
		if (kmInicial == null) {
			if (other.kmInicial != null)
				return false;
		} else if (!kmInicial.equals(other.kmInicial))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (portalDestino == null) {
			if (other.portalDestino != null)
				return false;
		} else if (!portalDestino.equals(other.portalDestino))
			return false;
		if (portalOrigem == null) {
			if (other.portalOrigem != null)
				return false;
		} else if (!portalOrigem.equals(other.portalOrigem))
			return false;
		return true;
	}
	 
}
 
