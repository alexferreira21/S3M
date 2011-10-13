package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class UF {
	
	@Id
	@GeneratedValue
	private Long idUF;
 
	private String nome;
	 
	private String sigla;
	
	@OneToMany(targetEntity=Municipio.class, mappedBy="uf", 
			cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Municipio> municipios;
	
	@Transient
	private List<Estrada> estrada;
	

	public Long getIdUF() {
		return idUF;
	}


	public void setIdUF(Long idUF) {
		this.idUF = idUF;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Estrada> getEstrada() {
		return estrada;
	}

	public void setEstrada(List<Estrada> estrada) {
		this.estrada = estrada;
	}


	public List<Municipio> getMunicipios() {
		return municipios;
	}


	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
}
 
