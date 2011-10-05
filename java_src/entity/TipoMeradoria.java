package entity;

public class TipoMeradoria {
	
	private Long id;
 
	private Integer descricao;
	 
	private Float fatorPeso;
	 
	private UnidadeMedida unidadeMedida;

	public Integer getDescricao() {
		return descricao;
	}

	public void setDescricao(Integer descricao) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 
}
 
