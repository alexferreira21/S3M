package entity;

import java.util.Date;
import java.util.List;

public class CTe {
	
	private Long id;
	
	private Integer identificador;
	 
	private Date dataEmissao;
	 
	private Integer status;
	 
	private List<Registro> registro;
	 
	private Veiculo veiculo;
	 
	private CargaPredominante cargaPredominante;
	 
	private Municipio municipioOrigem;
	 
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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
 
