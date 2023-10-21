package it.unipv.sfw.model;
import java.time.LocalDate;
import java.time.LocalTime;


public class Prenotazione {
	private int idPren;
	private Account paziente;
	private PrestazioneSanitaria prestazione;
	private Account medico;
	private Account opSanitario;
	private LocalDate data;
	private LocalTime orario;
	private boolean accreditamento;
	private Esito esiti;
	
	public Prenotazione(int idPren, Account paziente, PrestazioneSanitaria prestazione, Account medico, Account opSanitario,
			LocalDate data, LocalTime orario) {
		super();
		this.idPren = idPren;
		this.paziente = paziente;
		this.prestazione= prestazione;
		this.medico = medico;
		this.opSanitario = opSanitario;
		this.data = data;
		this.orario = orario;
		this.accreditamento = false;
		this.esiti = new Esito(null, null);
	}

	public int getIdPren() {
		return idPren;
	}

	public void setIdPren(int idPren) {
		this.idPren = idPren;
	}

	public Account getPaziente() {
		return paziente;
	}

	public void setPaziente(Account paziente) {
		this.paziente = paziente;
	}

	public PrestazioneSanitaria getPrestazione() {
		return prestazione;
	}

	public void setPrestazione(PrestazioneSanitaria prestazione) {
		this.prestazione = prestazione;
	}

	public Account getMedico() {
		return medico;
	}

	public void setMedico(Account medico) {
		this.medico = medico;
	}

	public Account getOpSanitario() {
		return opSanitario;
	}

	public void setOpSanitario(Account opSanitario) {
		this.opSanitario = opSanitario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

	public boolean isAccreditamento() {
		return accreditamento;
	}

	public void setAccreditamento(boolean accreditamento) {
		this.accreditamento = accreditamento;
	}

	public Esito getEsiti() {
		return esiti;
	}

	public void setEsiti(Esito esiti) {
		this.esiti = esiti;
	}


	
}