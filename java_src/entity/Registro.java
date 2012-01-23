package entity;

import java.util.Date;

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
	 
	@ManyToOne
	@JoinColumn(name = "idCTE", nullable = false)
	private CTe cTe;
	 
	@ManyToOne
	@JoinColumn(name = "idEquipamento", nullable = false)
	private Equipamento equipamento;
	
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

	public CTe getcTe() {
		return cTe;
	}

	public void setcTe(CTe cTe) {
		this.cTe = cTe;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
 
