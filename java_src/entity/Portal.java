package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Portal {
	
	@Id
	@GeneratedValue
	private Long idPortal;
	
	private String nome;
	 
	private Double latitude;
	 
	private Double longitude;
	 
	private Double altitude;
	
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	@OneToMany(targetEntity=Equipamento.class, mappedBy="portal", 
			cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Equipamento> equipamento;
	 
	@Transient
	private OrgaoResponsavel orgaoResponsavel;

	
	public Long getIdPortal() {
		return idPortal;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Equipamento> getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(List<Equipamento> equipamento) {
		this.equipamento = equipamento;
	}

	public OrgaoResponsavel getOrgaoResponsavel() {
		return orgaoResponsavel;
	}

	public void setOrgaoResponsavel(OrgaoResponsavel orgaoResponsavel) {
		this.orgaoResponsavel = orgaoResponsavel;
	}
	 
	 
}
 
