package entity;

public class CargaPredominante {
	
	private Long id;
 
	private Float peso;
	 
	private Float quantidade;
	 
	private Float valor;
	 
	private CTe cTe;
	 
	private TipoMeradoria tipoMeradoria;
	
	
	 
	public Double calculaPeso() {
		return null;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Float getPeso() {
		return peso;
	}



	public void setPeso(Float peso) {
		this.peso = peso;
	}



	public Float getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}



	public Float getValor() {
		return valor;
	}



	public void setValor(Float valor) {
		this.valor = valor;
	}



	public CTe getcTe() {
		return cTe;
	}



	public void setcTe(CTe cTe) {
		this.cTe = cTe;
	}



	public TipoMeradoria getTipoMeradoria() {
		return tipoMeradoria;
	}



	public void setTipoMeradoria(TipoMeradoria tipoMeradoria) {
		this.tipoMeradoria = tipoMeradoria;
	}
	
	
	 
}
 
