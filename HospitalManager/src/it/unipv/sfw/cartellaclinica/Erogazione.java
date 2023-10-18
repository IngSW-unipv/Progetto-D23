package it.unipv.sfw.cartellaclinica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Erogazione {
	private int idPren;
	private LocalDate dataErog;
	private LocalTime oraErog;
	private boolean accreditamento;
	
	public Erogazione(int idPren, String dataErog, String oraErog, boolean accreditamento) {
		super();
		this.idPren = idPren;
		this.dataErog = LocalDate.parse(dataErog);
		this.oraErog = LocalTime.parse(oraErog);
		this.accreditamento = accreditamento;
	}

	public int getIdPren() {
		return idPren;
	}

	public LocalDate getDataErog() {
		return dataErog;
	}

	public LocalTime getOraErog() {
		return oraErog;
	}

	public boolean isAccreditamento() {
		return accreditamento;
	}

	public void setIdPren(int idPren) {
		this.idPren = idPren;
	}

	public void setDataErog(LocalDate dataErog) {
		this.dataErog = dataErog;
	}

	public void setOraErog(LocalTime oraErog) {
		this.oraErog = oraErog;
	}

	public void setAccreditamento(boolean accreditamento) {
		this.accreditamento = accreditamento;
	}
	
	
	
	
	
}
