package it.unipv.sfw.jdbc.bean.esiti;

public class EsitiDB {
	private int idPren;
	private String referto;
	private String terapia;
	
	public EsitiDB(int idPren, String referto, String terapia) {
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
