package entity;

import java.util.List;

public class Estrada {
	
	private Long id;
 
	private String nome;
	 
	private Integer numeroSegmentos;
	 
	private List<UF> uf;
	 
	private List<Segmento> segmento;
	 
	
	public void getPrimeiroSegmento() {
	 
	}
	 
	public void getUltimoSegmento() {
	 
	}
	 
	public void inserirSegmentos() {
	 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroSegmentos() {
		return numeroSegmentos;
	}

	public void setNumeroSegmentos(Integer numeroSegmentos) {
		this.numeroSegmentos = numeroSegmentos;
	}

	public List<UF> getUf() {
		return uf;
	}

	public void setUf(List<UF> uf) {
		this.uf = uf;
	}

	public List<Segmento> getSegmento() {
		return segmento;
	}

	public void setSegmento(List<Segmento> segmento) {
		this.segmento = segmento;
	}
	 
}
 
