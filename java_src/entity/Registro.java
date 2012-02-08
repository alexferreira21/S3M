package entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_REGISTRO")
public class Registro {
	
	@Id
	@GeneratedValue
	private Long id;
 
	private Date timestamp;
	 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCTE")
	private ConhecimentoTransporte cTe;
	 
	@ManyToOne
	@JoinColumn(name = "idEquipamento", nullable = false)
	private Equipamento equipamento;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idVeiculo", nullable = false)
	private Veiculo veiculo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public ConhecimentoTransporte getcTe() {
		return cTe;
	}

	public void setcTe(ConhecimentoTransporte cTe) {
		this.cTe = cTe;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
 
