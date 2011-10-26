package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_ESTRADA")
public class Estrada {
	
	@Id
	@GeneratedValue
	private Long idEstrada;
 
	private String nome;
	 
	private Integer numeroSegmentos;
	
	@ManyToMany
	@JoinTable(name="tb_rel_estrada_uf",
			joinColumns={@JoinColumn(name="idEstrada")}, 
			inverseJoinColumns={@JoinColumn(name="idUF")})
	private List<UF> uf;
	 
	@OneToMany(targetEntity=Segmento.class, mappedBy="estrada", 
	cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Segmento> segmento;
	 
	
	
	public void getPrimeiroSegmento() {
	 
	}
	 
	public void getUltimoSegmento() {
	 
	}
	 
	public void inserirSegmentos() {
	 
	}

	public Long getId() {
		return idEstrada;
	}

	public void setId(Long id) {
		this.idEstrada = id;
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
 
