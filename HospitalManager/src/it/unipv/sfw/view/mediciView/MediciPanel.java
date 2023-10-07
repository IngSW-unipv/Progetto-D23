package it.unipv.sfw.view.mediciView;

import java.sql.Date;

import javax.accessibility.AccessibleContext;
import javax.swing.Icon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import it.unipv.sfw.persona.Medico;
import it.unipv.sfw.view.PopupError;


public class MediciPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JComboBox mediciBox;
	private JTextField nomeText;
	private JTextField cognomeText;
	private JTextField CFText;
	private JTextField sessoText;
	private JTextField emailText;
	private JTextField cellulareText;
	private JTextField luogoNascitaText;
	private JTextField indirizzoText;
	private JTextField capText;
	private JTextField paeseText;
	private JTextField dataNascitaText;
	private JTextField codiceRegionaleText;
	private JTextField specializzazioneText;
	private JTextField dataAssunzioneText;
	
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblCF;
	private JLabel lblSesso;
	private JLabel lblEmail;
	private JLabel lblCellulare;
	private JLabel lblLuogoNascita;
	private JLabel lblIndirizzo;
	private JLabel lblCap;
	private JLabel lblPaese;
	private JLabel lblDataNascita;
	private JLabel lblCodiceRegionale;
	private JLabel lblSpecializzazione;
	private JLabel lblDataAssunzione;
	
	private TabellaMediciPanel tab;
	private JButton btnModifica;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private JButton btnAggiorna;
	private JButton btnHome;
	
	public MediciPanel() {
		
		setBounds(0, 0, 2700, 2200);
		
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		nomeText = new JTextField();
		nomeText.setBounds(1096, 12, 100, 25);
		add(nomeText);
		nomeText.setColumns(10);

		cognomeText = new JTextField();
		cognomeText.setColumns(10);
		cognomeText.setBounds(1096, 52, 100, 25);
		add(cognomeText);

		CFText = new JTextField();
		CFText.setColumns(10);
		CFText.setBounds(1096, 92, 100, 25);
		add(CFText);

		sessoText = new JTextField();
		sessoText.setColumns(10);
		sessoText.setBounds(1096, 132, 100, 25);
		add(sessoText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(1096, 172, 100, 25);
		add(emailText);

		cellulareText = new JTextField();
		cellulareText.setColumns(10);
		cellulareText.setBounds(1096, 212, 100, 25);
		add(cellulareText);

		luogoNascitaText = new JTextField();
		luogoNascitaText.setColumns(10);
		luogoNascitaText.setBounds(1096, 252, 100, 25);
		add(luogoNascitaText);
		
		indirizzoText = new JTextField();
		indirizzoText.setColumns(10);
		indirizzoText.setBounds(1096, 292, 100, 25);
		add(indirizzoText);

		capText = new JTextField();
		capText.setColumns(10);
		capText.setBounds(1096, 332, 100, 25);
		add(capText);

		paeseText = new JTextField();
		paeseText.setColumns(10);
		paeseText.setBounds(1096, 372, 100, 25);
		add(paeseText);

		dataNascitaText = new JTextField();
		dataNascitaText.setColumns(10);
		dataNascitaText.setBounds(1096, 412, 100, 25);
		add(dataNascitaText);

		codiceRegionaleText = new JTextField();
		codiceRegionaleText.setColumns(10);
		codiceRegionaleText.setBounds(1096, 452, 100, 25);
		add(codiceRegionaleText);
		
		specializzazioneText = new JTextField();
		specializzazioneText.setColumns(10);
		specializzazioneText.setBounds(1096, 492, 100, 25);
		add(specializzazioneText);
		
		dataAssunzioneText = new JTextField();
		dataAssunzioneText.setColumns(10);
		dataAssunzioneText.setBounds(1096, 532, 100, 25);
		add(dataAssunzioneText);
		
		// LABEL	

		lblNome = new JLabel("Nome");
		lblNome.setBounds(970, 12, 70, 15);
		add(lblNome);

		lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(970, 52, 70, 15);
		add(lblCognome);

		lblCF = new JLabel("CF");
		lblCF.setBounds(970, 92, 70, 15);
		add(lblCF);

		lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(970, 132, 70, 15);
		add(lblSesso);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(970, 172, 70, 15);
		add(lblEmail);

		lblCellulare = new JLabel("Cellulare'");
		lblCellulare.setBounds(970, 212, 70, 15);
		add(lblCellulare);

		lblLuogoNascita = new JLabel("LuogoNascita");
		lblLuogoNascita.setBounds(970, 252, 70, 15);
		add(lblLuogoNascita);
		
		lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(970, 292, 70, 15);
		add(lblIndirizzo);

		lblCap = new JLabel("Cap");
		lblCap.setBounds(970, 332, 70, 15);
		add(lblCap);

		lblPaese = new JLabel("Paese");
		lblPaese.setBounds(970, 372, 70, 15);
		add(lblPaese);

		lblDataNascita = new JLabel("DataNascita");
		lblDataNascita.setBounds(970, 412, 70, 15);
		add(lblDataNascita);

		lblCodiceRegionale = new JLabel("CodiceRegionale");
		lblCodiceRegionale.setBounds(970, 452, 70, 15);
		add(lblCodiceRegionale);

		lblSpecializzazione = new JLabel("Specializzazione");
		lblSpecializzazione.setBounds(970, 492, 70, 15);
		add(lblSpecializzazione);
		
		lblDataAssunzione = new JLabel("DataAssunzione");
		lblDataAssunzione.setBounds(970, 532, 70, 15);
		add(lblDataAssunzione);
		
		tab = new TabellaMediciPanel(scrollPane);
		
		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 494, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 494, 100, 25);
		add(btnElimina);

		// bottone per modificare quel med: riempie le textField con gli attributi
		// di quel med
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(964, 543, 100, 25);
		add(btnModifica);

		// bottone per aggiornare le caratteristiche del medico selezionato
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(1096, 543, 100, 25);
		add(btnAggiorna);

		btnHome = new JButton("HOME");
		btnHome.setBounds(1058, 590, 52, 43);
		add(btnHome);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JComboBox getMediciBox() {
		return mediciBox;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

	public JTextField getCognomeText() {
		return cognomeText;
	}

	public JTextField getCFText() {
		return CFText;
	}

	public JTextField getSessoText() {
		return sessoText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public JTextField getCellulareText() {
		return cellulareText;
	}

	public JTextField getLuogoNascitaText() {
		return luogoNascitaText;
	}

	public JTextField getIndirizzoText() {
		return indirizzoText;
	}

	public JTextField getCapText() {
		return capText;
	}

	public JTextField getPaeseText() {
		return paeseText;
	}

	public JTextField getDataNascitaText() {
		return dataNascitaText;
	}

	public JTextField getCodiceRegionaleText() {
		return codiceRegionaleText;
	}

	public JTextField getSpecializzazioneText() {
		return specializzazioneText;
	}

	public JTextField getDataAssunzioneText() {
		return dataAssunzioneText;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblCognome() {
		return lblCognome;
	}

	public JLabel getLblCF() {
		return lblCF;
	}

	public JLabel getLblSesso() {
		return lblSesso;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblCellulare() {
		return lblCellulare;
	}

	public JLabel getLblLuogoNascita() {
		return lblLuogoNascita;
	}

	public JLabel getLblIndirizzo() {
		return lblIndirizzo;
	}

	public JLabel getLblCap() {
		return lblCap;
	}

	public JLabel getLblPaese() {
		return lblPaese;
	}

	public JLabel getLblDataNascita() {
		return lblDataNascita;
	}

	public JLabel getLblCodiceRegionale() {
		return lblCodiceRegionale;
	}

	public JLabel getLblSpecializzazione() {
		return lblSpecializzazione;
	}

	public JLabel getLblDataAssunzione() {
		return lblDataAssunzione;
	}

	public TabellaMediciPanel getTab() {
		return tab;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JButton getBtnAggiungi() {
		return btnAggiungi;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}

	public JButton getBtnHome() {
		return btnHome;
	}
	
/* public Medico getNuovoMedicoTextField() {	
		
		Medico med = new Medico(nomeText.getText(), cognomeText.getText(), CFText.getText(), sessoText.getText(),
				emailText.getText(), cellulareText.getText(), luogoNascitaText.getText(), indirizzoText.getText(),
				capText.getText(), paeseText.getText(), dataNascita, codiceRegionaleText.getText(),
				specializzazioneText.getText(), dataAssunzioneText.getText());
		return med;
	} */
}
	
	
	
	
	
	
