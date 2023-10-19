package it.unipv.sfw.model;

public class Esito {
	private String referto;
	private String terapia;
	
	public Esito(String referto, String terapia) {
		super();
		this.referto = referto;
		this.terapia = terapia;
	}


	public String getReferto() {
		return referto;
	}

	public String getTerapia() {
		return terapia;
	}


	public void setReferto(String referto) {
		this.referto = referto;
	}


	public void setTerapia(String terapia) {
		this.terapia = terapia;
	}
	
	
}