package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_FLUXO_AUXILIAR")
public class FluxoAuxiliar {
	
	@Id
	@GeneratedValue
	private Long idFluxoAuxiliar;
	
	@OneToOne
	private Portal portal;
	
	private Integer tipo;

	@ManyToOne
	@JoinColumn(name="idEstrada")
	private Estrada estrada;
	
	public Long getIdFluxoAuxiliar() {
		return idFluxoAuxiliar;
	}

	public void setIdFluxoAuxiliar(Long idFluxoAuxiliar) {
		this.idFluxoAuxiliar = idFluxoAuxiliar;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Estrada getEstrada() {
		return estrada;
	}

	public void setEstrada(Estrada estrada) {
		this.estrada = estrada;
	}
	

		

}
