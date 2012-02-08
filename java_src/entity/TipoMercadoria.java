package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_TIPO_MERCADORIA")
public class TipoMercadoria {
	
	@Id
	@GeneratedValue
	private Long idTipoMercadoria;
 
	private String descricao;
	 
	private Float fatorPeso;
	
	@ManyToOne
	@JoinColumn(name = "idUnidadeMedida", nullable = false)
	private UnidadeMedida unidadeMedida;

	public Long getIdTipoMercadoria() {
		return idTipoMercadoria;
	}

	public void setIdTipoMercadoria(Long idTipoMercadoria) {
		this.idTipoMercadoria = idTipoMercadoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getFatorPeso() {
		return fatorPeso;
	}

	public void setFatorPeso(Float fatorPeso) {
		this.fatorPeso = fatorPeso;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	 
}
 
