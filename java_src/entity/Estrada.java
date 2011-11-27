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
	private List<UF> ufs;
	
	@OneToMany(targetEntity=Segmento.class, mappedBy="estrada",
			cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Segmento> segmentos;
	
	@OneToMany(targetEntity=FluxoAlternativo.class, mappedBy="estrada", cascade = CascadeType.ALL)
	private List<FluxoAlternativo> fluxosAlternativos;
	
	private Integer corEstrada;
	
	private String encodedPolylineString;
	
	
	public Long getIdEstrada() {
		return idEstrada;
	}

	public void setIdEstrada(Long idEstrada) {
		this.idEstrada = idEstrada;
	}


	public void getPrimeiroSegmento() {
	 
	}
	 
	public void getUltimoSegmento() {
	 
	}
	 
	public void inserirSegmentos() {
	 
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

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

	public List<Segmento> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<Segmento> segmento) {
		this.segmentos = segmento;
	}

	public Integer getCorEstrada() {
		return corEstrada;
	}

	public void setCorEstrada(Integer corEstrada) {
		this.corEstrada = corEstrada;
	}

	public String getEncodedPolylineString() {
		return encodedPolylineString;
	}

	public void setEncodedPolylineString(String encodedPolylineString) {
		this.encodedPolylineString = encodedPolylineString;
	}

	public List<FluxoAlternativo> getFluxosAlternativos() {
		return fluxosAlternativos;
	}

	public void setFluxosAlternativos(List<FluxoAlternativo> fluxosAlternativos) {
		this.fluxosAlternativos = fluxosAlternativos;
	}


		 
}
 
