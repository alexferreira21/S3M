package entity;

public class Segmento {
	
	private Long id;
 
	private String nome;
	 
	private Integer km;
	 
	private Portal portalDestino;
	 
	private Portal portalOrigem;
	 
	private Estrada estrada;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Portal getPortalDestino() {
		return portalDestino;
	}

	public void setPortalDestino(Portal portalDestino) {
		this.portalDestino = portalDestino;
	}

	public Portal getPortalOrigem() {
		return portalOrigem;
	}

	public void setPortalOrigem(Portal portalOrigem) {
		this.portalOrigem = portalOrigem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public Portal getDestino() {
		return portalDestino;
	}

	public void setDestino(Portal destino) {
		portalDestino = destino;
	}

	public Portal getOrigem() {
		return portalOrigem;
	}

	public void setOrigem(Portal origem) {
		portalOrigem = origem;
	}

	public Estrada getEstrada() {
		return estrada;
	}

	public void setEstrada(Estrada estrada) {
		this.estrada = estrada;
	}
	 
}
 
