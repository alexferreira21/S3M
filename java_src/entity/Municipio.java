package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Municipio {
 
	@Id
	@GeneratedValue
	private Long idMunicipio;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_UF", nullable=false)
	private UF uf;

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}
	 
}
 
