package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARGA_PREDOMINANTE")
public class CargaPredominante {
	
	@Id
	@GeneratedValue
	private Long id;
 
	 
	private Float quantidade;
	 
	private Float valor;
	 
	@ManyToOne
	@JoinColumn(name = "idTipoMercadoria", nullable = false)
	private TipoMercadoria tipoMeradoria;
	
	 
	public Float getPeso() {
		return tipoMeradoria.getFatorPeso() * quantidade;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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


	public TipoMercadoria getTipoMeradoria() {
		return tipoMeradoria;
	}



	public void setTipoMeradoria(TipoMercadoria tipoMeradoria) {
		this.tipoMeradoria = tipoMeradoria;
	}
	
	
	 
}
 
