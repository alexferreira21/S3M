package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PERFIL")
public class Perfil {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long idPerfil;
	
	private String descricao;

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setidPerfil(Long id) {
		this.idPerfil = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
