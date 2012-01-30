package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {
	
	@Id
	@GeneratedValue
	private Long id;
 
	@Column(unique = true)
	private String placa;
	 
	private String anoFabricacao;
	 
	private String marcaModelo;
	 
	private String RNTRC;
	 
	private Double tara;
	 
	private Float capacidadeKg;
	 
	private Float capacidadeM3;
	 
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;
	 
	@ManyToOne
	@JoinColumn(name = "idEspecie_Tipo", nullable = false)
	private Especie_Tipo especie_Tipo;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getRNTRC() {
		return RNTRC;
	}

	public void setRNTRC(String rNTRC) {
		RNTRC = rNTRC;
	}

	public Double getTara() {
		return tara;
	}

	public void setTara(Double tara) {
		this.tara = tara;
	}

	public Float getCapacidadeKg() {
		return capacidadeKg;
	}

	public void setCapacidadeKg(Float capacidadeKg) {
		this.capacidadeKg = capacidadeKg;
	}

	public Float getCapacidadeM3() {
		return capacidadeM3;
	}

	public void setCapacidadeM3(Float capacidadeM3) {
		this.capacidadeM3 = capacidadeM3;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Especie_Tipo getEspecie_Tipo() {
		return especie_Tipo;
	}

	public void setEspecie_Tipo(Especie_Tipo especie_Tipo) {
		this.especie_Tipo = especie_Tipo;
	}
	 
}
 
