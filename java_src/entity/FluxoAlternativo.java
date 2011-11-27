package entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_FLUXO_ALTERNATIVO")
public class FluxoAlternativo {
	
	@Id
	@GeneratedValue
	private Long idFluxoAlternativo;
	
	@OneToOne
	private Portal portal;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoFluxoAlternativoEnum tipo;

	@ManyToOne
	@JoinColumn(name="idEstrada")
	private Estrada estrada;
	
	
	
	
	
	
	public Long getIdFluxoAlternativo() {
		return idFluxoAlternativo;
	}

	public void setIdFluxoAlternativo(Long idFluxoAlternativo) {
		this.idFluxoAlternativo = idFluxoAlternativo;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public TipoFluxoAlternativoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoFluxoAlternativoEnum tipo) {
		this.tipo = tipo;
	}

	public Estrada getEstrada() {
		return estrada;
	}

	public void setEstrada(Estrada estrada) {
		this.estrada = estrada;
	}
	

		

}
