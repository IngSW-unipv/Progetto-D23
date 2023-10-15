package it.unipv.sfw.jdbc.bean;

import java.time.LocalDate;

public class AnagraficaDB {
	private String cf;
	private String nome;
	private String cognome;
	private String genere;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String provinciaNascita;
	private String regioneRes;
	private String provinciaRes;
	private String cittaRes;
	private String indirizzo;
	private String cap;
	private String eMail;
	private String cellulare;
	
	public AnagraficaDB(String cf, String nome, String cognome, String genere, String dataNascita, String luogoNascita,
			String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes, String indirizzo, String cap,
			String eMail, String cellulare) {
		super();
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.dataNascita = LocalDate.parse(dataNascita);
		this.luogoNascita = luogoNascita;
		this.provinciaNascita = provinciaNascita;
		this.regioneRes = regioneRes;
		this.provinciaRes = provinciaRes;
		this.cittaRes = cittaRes;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.eMail = eMail;
		this.cellulare = cellulare;
	}

	public String getCf() {
		return cf;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getGenere() {
		return genere;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	public String getRegioneRes() {
		return regioneRes;
	}

	public String getProvinciaRes() {
		return provinciaRes;
	}

	public String getCittaRes() {
		return cittaRes;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
	
	public String getCap() {
		return cap;
	}

	public String geteMail() {
		return eMail;
	}

	public String getCellulare() {
		return cellulare;
	}
	
	
	
	
}
