package it.unipv.sfw.view.login;

import java.awt.GridLayout;
import javax.swing.*;

public class RegistratiPanelPaziente extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel registrazione, nuoviDati;
	private JLabel nome, cognome, cf, sesso;
	private JLabel dataNascita, luogoNascita, provinciaNascita; 
	private JLabel regioneResidenza, provinciaResidenza, cittaResidenza, indirizzo, cap;
	private JLabel email, cellulare;
	private JLabel tipo, tipoFisso;
	private JLabel password;
	private JLabel generaPassword;
	private JLabel conferma, back;
	
	private JTextField nomeField, cognomeField, cfField;
	private JTextField dataNascitaField, luogoNascitaField, provinciaNascitaField;
	private JTextField regioneResidenzaField, provinciaResidenzaField, cittaResidenzaField, indirizzoField, capField;
	private JTextField emailField, cellulareField;
	private JPasswordField passwordField;
	private JButton btnGeneraPass, btnConfermaReg, indietro;
	private String[] sessoString = {"M", "F"};
	private JComboBox<String> scegliSesso;
	
	private JLabel altezza, peso, gruppoSanguigno;
	private JTextField altezzaField, pesoField;
	private String[] gruppo = {"A_POSITIVO", "A_NEGATIVO", "B_POSITIVO", "B_NEGATIVO", "AB_POSITIVO", "AB_NEGATIVO", "ZERO_POSITIVO", "ZERO_NEGATIVO"};
	private JComboBox<String> scegliGruppo;
	
	private JButton mostra;
	private JLabel mostraPw;
	
	public RegistratiPanelPaziente() {
		
		setLayout(new GridLayout(24,2));
		
		nomeField = new JTextField();
		cognomeField = new JTextField();
		cfField = new JTextField();
		dataNascitaField = new JTextField();
		luogoNascitaField = new JTextField();
		provinciaNascitaField = new JTextField();
		regioneResidenzaField = new JTextField();
		provinciaResidenzaField = new JTextField();
		cittaResidenzaField = new JTextField();
		capField = new JTextField();
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
		dataNascita = new JLabel("Data di nascita (AAAA-MM-GG)");
		luogoNascita = new JLabel("Luogo di nascita");
		provinciaNascita = new JLabel("Provincia di nascita");
		regioneResidenza = new JLabel("Regione di residenza");
		provinciaResidenza = new JLabel("Provincia di residenza");
		cittaResidenza = new JLabel("Città di residenza");
		indirizzo = new JLabel("Indirizzo");
		cap = new JLabel("Cap");
		email = new JLabel("Email");
		cellulare = new JLabel("Cellulare");
		
		tipo = new JLabel("Tipo Account");
		tipoFisso = new JLabel("PA");
		
		scegliSesso = new JComboBox<>(sessoString);
		
		password = new JLabel("Password");
		
		generaPassword = new JLabel("Genera Password Casuale");
		btnGeneraPass = new JButton("GENERA");
		
		conferma = new JLabel("Conferma Registrazione");
		btnConfermaReg = new JButton("CONFERMA");
		
		back = new JLabel("Torna Indietro");
		indietro = new JButton("INDIETRO");
		
		altezza = new JLabel("Altezza (cm)");
		peso = new JLabel("Peso (kg)");
		gruppoSanguigno = new JLabel("Gruppo Sanguigno");
		
		altezzaField = new JTextField();
		pesoField = new JTextField();
		
		scegliGruppo = new JComboBox<>(gruppo);
		
		mostraPw = new JLabel("Mostra Password");
		mostra = new JButton("MOSTRA");
		
		
		add(registrazione);
		add(nuoviDati);
		add(tipo);
		add(tipoFisso);
		add(nome);
		add(nomeField);
		add(cognome);
		add(cognomeField);
		add(cf);
		add(cfField);
		add(sesso);
		add(scegliSesso);
		add(altezza);
		add(altezzaField);
		add(peso);
		add(pesoField);
		add(gruppoSanguigno);
		add(scegliGruppo);
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
		add(cap);
		add(capField);
		add(indirizzo);
		add(indirizzoField);
		add(email);
		add(emailField);
		add(cellulare);
		add(cellulareField);
		add(password);
		add(passwordField);
		add(generaPassword);
		add(btnGeneraPass);
		add(mostraPw);
		add(mostra);
		add(conferma);
		add(btnConfermaReg);
		add(back);
		add(indietro);
		
		//PER ALDIN
//		mostra.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            // Ottenere la password temporaneamente
//	            passwordField.setEchoChar((char) 0);
//
//	            Timer timer = new Timer(1000, new ActionListener() {
//	                public void actionPerformed(ActionEvent evt) {
//	                    // Nascondere nuovamente la password dopo un secondo
//	                    passwordField.setEchoChar('*');
//	                }
//	            });
//	            timer.setRepeats(false); // Eseguire solo una volta
//	            timer.start();
//	        }
//	    });
//		
	}
	
	public JButton getBtnMostra() {
		return mostra;
	}

	public JLabel getRegistrazione() {
		return registrazione;
	}


	public void setRegistrazione(JLabel registrazione) {
		this.registrazione = registrazione;
	}


	public JLabel getNuoviDati() {
		return nuoviDati;
	}


	public void setNuoviDati(JLabel nuoviDati) {
		this.nuoviDati = nuoviDati;
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

	
	public JLabel getCap() {
		return cap;
	}


	public void setCap(JLabel cap) {
		this.cap = cap;
	}


	public JTextField getCapField() {
		return capField;
	}


	public void setCapField(JTextField capField) {
		this.capField = capField;
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


	public JLabel getTipo() {
		return tipo;
	}


	public void setTipo(JLabel tipo) {
		this.tipo = tipo;
	}


	public JLabel getTipoFisso() {
		return tipoFisso;
	}


	public void setTipoFisso(JLabel tipoFisso) {
		this.tipoFisso = tipoFisso;
	}


	public JLabel getPassword() {
		return password;
	}


	public void setPassword(JLabel password) {
		this.password = password;
	}


	public JLabel getGeneraPassword() {
		return generaPassword;
	}


	public void setGeneraPassword(JLabel generaPassword) {
		this.generaPassword = generaPassword;
	}


	public JLabel getConferma() {
		return conferma;
	}


	public void setConferma(JLabel conferma) {
		this.conferma = conferma;
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


	public JButton getBtnGeneraPass() {
		return btnGeneraPass;
	}


	public void setBtnGeneraPass(JButton btnGeneraPass) {
		this.btnGeneraPass = btnGeneraPass;
	}


	public JButton getBtnConfermaReg() {
		return btnConfermaReg;
	}


	public void setBtnConfermaReg(JButton btnConfermaReg) {
		this.btnConfermaReg = btnConfermaReg;
	}


	public String[] getSessoString() {
		return sessoString;
	}


	public void setSessoString(String[] sessoString) {
		this.sessoString = sessoString;
	}


	public JComboBox<String> getScegliSesso() {
		return scegliSesso;
	}

	public String getSessoScelto() {
		return scegliSesso.getSelectedItem().toString();
	}

	public void setScegliSesso(JComboBox<String> scegliSesso) {
		this.scegliSesso = scegliSesso;
	}
	
	public JButton getBtnBack() {
		return indietro;
	}


	public JTextField getAltezzaField() {
		return altezzaField;
	}


	public void setAltezzaField(JTextField altezzaText) {
		this.altezzaField = altezzaText;
	}


	public JTextField getPesoField() {
		return pesoField;
	}


	public void setPesoField(JTextField pesoText) {
		this.pesoField = pesoText;
	}


	public JComboBox<String> getScegliGruppo() {
		return scegliGruppo;
	}

	public String getGruppoScelto() {
		return scegliGruppo.getSelectedItem().toString();
	}
	
	public void setScegliGruppo(JComboBox<String> scegliGruppo) {
		this.scegliGruppo = scegliGruppo;
	}
	
	
}
