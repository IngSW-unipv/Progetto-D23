package it.unipv.sfw.view.login;

import java.awt.GridLayout;

import javax.swing.*;

public class RegistratiPanel extends JPanel{
	
	private JLabel registrazione, nuoviDati;
	private JLabel nome, cognome, cf, sesso;
	private JLabel dataNascita, luogoNascita, provinciaNascita; 
	private JLabel regioneResidenza, provinciaResidenza, cittaResidenza, indirizzo;
	private JLabel email, cellulare;
	private JLabel idAccount, tipo, idAccountAssegnato, tipoAssegnato;
	private JLabel password;
	
	private JTextField nomeField, cognomeField, cfField, sessoField;
	private JTextField dataNascitaField, luogoNascitaField, provinciaNascitaField;
	private JTextField regioneResidenzaField, provinciaResidenzaField, cittaResidenzaField, indirizzoField;
	private JTextField emailField, cellulareField;
	private JPasswordField passwordField;
	
	public RegistratiPanel() {
		
		setLayout(new GridLayout(18,2));
		
		nomeField = new JTextField();
		cognomeField = new JTextField();
		cfField = new JTextField();
		sessoField = new JTextField();
		dataNascitaField = new JTextField();
		luogoNascitaField = new JTextField();
		provinciaNascitaField = new JTextField();
		regioneResidenzaField = new JTextField();
		provinciaResidenzaField = new JTextField();
		cittaResidenzaField = new JTextField();
		indirizzoField = new JTextField();
		emailField = new JTextField();
		cellulareField = new JTextField();
		passwordField = new JPasswordField();
		
		registrazione = new JLabel("REGISTRAZIONE");
		nuoviDati = new JLabel("NUOVO ACCOUNT");
		
		nome = new JLabel("Nome");
		cognome = new JLabel("Cognome");
		cf = new JLabel("Codice Fiscale");
		sesso = new JLabel("Sesso");
		dataNascita = new JLabel("Data di nascita");
		luogoNascita = new JLabel("Luogo di nascita");
		provinciaNascita = new JLabel("Provincia di nascita");
		regioneResidenza = new JLabel("Regione di residenza");
		provinciaResidenza = new JLabel("Provincia di residenza");
		cittaResidenza = new JLabel("Citta di residenza");
		indirizzo = new JLabel("Indirizzo");
		email = new JLabel("Email");
		cellulare = new JLabel("Cellulare");
		
		idAccount = new JLabel("Id Account");
		tipo = new JLabel("Tipo Account");
		idAccountAssegnato = new JLabel("Da Assegnare");
		tipoAssegnato = new JLabel("Da Assegnare");
		
		password = new JLabel("Password");
		
		add(registrazione);
		add(nuoviDati);
		add(idAccount);
		add(idAccountAssegnato);
		add(tipo);
		add(tipoAssegnato);
		add(nome);
		add(nomeField);
		add(cognome);
		add(cognomeField);
		add(cf);
		add(cfField);
		add(sesso);
		add(sessoField);
		add(dataNascita);
		add(dataNascitaField);
		add(luogoNascita);
		add(luogoNascitaField);
		add(provinciaNascita);
		add(provinciaNascitaField);
		add(regioneResidenza);
		add(regioneResidenzaField);
		add(provinciaResidenza);
		add(provinciaResidenzaField);
		add(cittaResidenza);
		add(cittaResidenzaField);
		add(indirizzo);
		add(indirizzoField);
		add(email);
		add(emailField);
		add(cellulare);
		add(cellulareField);
		add(password);
		add(passwordField);
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public JLabel getCognome() {
		return cognome;
	}

	public void setCognome(JLabel cognome) {
		this.cognome = cognome;
	}

	public JLabel getCf() {
		return cf;
	}

	public void setCf(JLabel cf) {
		this.cf = cf;
	}

	public JLabel getSesso() {
		return sesso;
	}

	public void setSesso(JLabel sesso) {
		this.sesso = sesso;
	}

	public JLabel getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(JLabel dataNascita) {
		this.dataNascita = dataNascita;
	}

	public JLabel getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(JLabel luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public JLabel getProvinciaNascita() {
		return provinciaNascita;
	}

	public void setProvinciaNascita(JLabel provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}

	public JLabel getRegioneResidenza() {
		return regioneResidenza;
	}

	public void setRegioneResidenza(JLabel regioneResidenza) {
		this.regioneResidenza = regioneResidenza;
	}

	public JLabel getProvinciaResidenza() {
		return provinciaResidenza;
	}

	public void setProvinciaResidenza(JLabel provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}

	public JLabel getCittaResidenza() {
		return cittaResidenza;
	}

	public void setCittaResidenza(JLabel cittaResidenza) {
		this.cittaResidenza = cittaResidenza;
	}

	public JLabel getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(JLabel indirizzo) {
		this.indirizzo = indirizzo;
	}

	public JLabel getEmail() {
		return email;
	}

	public void setEmail(JLabel email) {
		this.email = email;
	}

	public JLabel getCellulare() {
		return cellulare;
	}

	public void setCellulare(JLabel cellulare) {
		this.cellulare = cellulare;
	}

	public JLabel getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(JLabel idAccount) {
		this.idAccount = idAccount;
	}

	public JLabel getTipo() {
		return tipo;
	}

	public void setTipo(JLabel tipo) {
		this.tipo = tipo;
	}

	public JLabel getIdAccountAssegnato() {
		return idAccountAssegnato;
	}

	public void setIdAccountAssegnato(JLabel idAccountAssegnato) {
		this.idAccountAssegnato = idAccountAssegnato;
	}

	public JLabel getTipoAssegnato() {
		return tipoAssegnato;
	}

	public void setTipoAssegnato(JLabel tipoAssegnato) {
		this.tipoAssegnato = tipoAssegnato;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getCognomeField() {
		return cognomeField;
	}

	public void setCognomeField(JTextField cognomeField) {
		this.cognomeField = cognomeField;
	}

	public JTextField getCfField() {
		return cfField;
	}

	public void setCfField(JTextField cfField) {
		this.cfField = cfField;
	}

	public JTextField getSessoField() {
		return sessoField;
	}

	public void setSessoField(JTextField sessoField) {
		this.sessoField = sessoField;
	}

	public JTextField getDataNascitaField() {
		return dataNascitaField;
	}

	public void setDataNascitaField(JTextField dataNascitaField) {
		this.dataNascitaField = dataNascitaField;
	}

	public JTextField getLuogoNascitaField() {
		return luogoNascitaField;
	}

	public void setLuogoNascitaField(JTextField luogoNascitaField) {
		this.luogoNascitaField = luogoNascitaField;
	}

	public JTextField getProvinciaNascitaField() {
		return provinciaNascitaField;
	}

	public void setProvinciaNascitaField(JTextField provinciaNascitaField) {
		this.provinciaNascitaField = provinciaNascitaField;
	}

	public JTextField getRegioneResidenzaField() {
		return regioneResidenzaField;
	}

	public void setRegioneResidenzaField(JTextField regioneResidenzaField) {
		this.regioneResidenzaField = regioneResidenzaField;
	}

	public JTextField getProvinciaResidenzaField() {
		return provinciaResidenzaField;
	}

	public void setProvinciaResidenzaField(JTextField provinciaResidenzaField) {
		this.provinciaResidenzaField = provinciaResidenzaField;
	}

	public JTextField getCittaResidenzaField() {
		return cittaResidenzaField;
	}

	public void setCittaResidenzaField(JTextField cittaResidenzaField) {
		this.cittaResidenzaField = cittaResidenzaField;
	}

	public JTextField getIndirizzoField() {
		return indirizzoField;
	}

	public void setIndirizzoField(JTextField indirizzoField) {
		this.indirizzoField = indirizzoField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getCellulareField() {
		return cellulareField;
	}

	public void setCellulareField(JTextField cellulareField) {
		this.cellulareField = cellulareField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	

}
