package it.unipv.sfw.jdbc.bean.calendario;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotCalendarioDB {
	private LocalDate data;
	private String giorno;
	private String vacanza;
	private LocalTime orario;
	private int idPren1;
	private int idPren2;
	private int idPren3;
	private int idPren4;
	private int idPren5;
	private int idPren6;
	private int idPren7;
	
	public SlotCalendarioDB(String data, String giorno, String vacanza, String orario, int idPren1, int idPren2, int idPren3,
			int idPren4, int idPren5, int idPren6, int idPren7) {
		super();
		this.data = LocalDate.parse(data);
		this.giorno = giorno;
		this.vacanza = vacanza;
		this.orario = LocalTime.parse(orario);
		this.idPren1 = idPren1;
		this.idPren2 = idPren2;
		this.idPren3 = idPren3;
		this.idPren4 = idPren4;
		this.idPren5 = idPren5;
		this.idPren6 = idPren6;
		this.idPren7 = idPren7;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public String getVacanza() {
		return vacanza;
	}

	public void setVacanza(String vacanza) {
		this.vacanza = vacanza;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

	public int getIdPren1() {
		return idPren1;
	}

	public void setIdPren1(int idPren1) {
		this.idPren1 = idPren1;
	}

	public int getIdPren2() {
		return idPren2;
	}

	public void setIdPren2(int idPren2) {
		this.idPren2 = idPren2;
	}

	public int getIdPren3() {
		return idPren3;
	}

	public void setIdPren3(int idPren3) {
		this.idPren3 = idPren3;
	}

	public int getIdPren4() {
		return idPren4;
	}

	public void setIdPren4(int idPren4) {
		this.idPren4 = idPren4;
	}

	public int getIdPren5() {
		return idPren5;
	}

	public void setIdPren5(int idPren5) {
		this.idPren5 = idPren5;
	}

	public int getIdPren6() {
		return idPren6;
	}

	public void setIdPren6(int idPren6) {
		this.idPren6 = idPren6;
	}

	public int getIdPren7() {
		return idPren7;
	}

	public void setIdPren7(int idPren7) {
		this.idPren7 = idPren7;
	}
	
	

}