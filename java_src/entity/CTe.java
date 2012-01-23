package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CTE")
public class CTe {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer identificador;
	 
	private Date dataEmissao;
	 
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cTe")
	private List<Registro> registro;
	 
	@ManyToOne
	@JoinColumn(name = "idVeiculo", nullable = false)
	private Veiculo veiculo;
	 
	@OneToOne
	@JoinColumn(name = "idCargaPredominante", nullable = false)
	private CargaPredominante cargaPredominante;
	 
	@OneToOne
	@JoinColumn(name = "idMunicipioOrigem", nullable = false)
	private Municipio municipioOrigem;
	 
	@OneToOne
	@JoinColumn(name = "idMunicipioDestino", nullable = false)
	private Municipio municipioDestino;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public List<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public CargaPredominante getCargaPredominante() {
		return cargaPredominante;
	}

	public void setCargaPredominante(CargaPredominante cargaPredominante) {
		this.cargaPredominante = cargaPredominante;
	}

	public Municipio getMunicipioOrigem() {
		return municipioOrigem;
	}

	public void setMunicipioOrigem(Municipio municipioOrigem) {
		this.municipioOrigem = municipioOrigem;
	}

	public Municipio getMunicipioDestino() {
		return municipioDestino;
	}

	public void setMunicipioDestino(Municipio municipioDestino) {
		this.municipioDestino = municipioDestino;
	}
	 
}
 
