package it.unipv.sfw.model;

public class Esito {
	private int idPren;
	private String referto;
	private String terapia;
	
	public Esito(int idPren, String referto, String terapia) {
		super();
		this.idPren = idPren;
		this.referto = referto;
		this.terapia = terapia;
	}

	public int getIdPren() {
		return idPren;
	}

	public String getReferto() {
		return referto;
	}

	public String getTerapia() {
		return terapia;
	}
}
