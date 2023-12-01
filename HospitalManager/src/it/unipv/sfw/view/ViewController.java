package it.unipv.sfw.view;

import java.awt.*;  
import javax.swing.*; 

import it.unipv.sfw.view.account.MedicoPanel;
import it.unipv.sfw.view.account.OperatoreSanitarioPanel;
import it.unipv.sfw.view.account.OperatoreUfficioPanel;
import it.unipv.sfw.view.account.PazientePanel;
import it.unipv.sfw.view.cartellaclinica.AggiornaCartellaClinicaPanel;
import it.unipv.sfw.view.login.CambiaPwPanel;
import it.unipv.sfw.view.login.LoginPanel;
import it.unipv.sfw.view.login.RegistratiPanel;
import it.unipv.sfw.view.login.RegistratiPanelPaziente;
import it.unipv.sfw.view.prenotazione.CancellaPanelPaziente;
import it.unipv.sfw.view.prenotazione.CancellaPanelUfficio;
import it.unipv.sfw.view.prenotazione.PrenotaPanelPaziente;
import it.unipv.sfw.view.prenotazione.PrenotaPanelUfficio;

public class ViewController extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private LoginPanel loginP;
	private PazientePanel pazienteP;
	private MedicoPanel medicoP;
	private OperatoreSanitarioPanel operatoreSanitarioP;
	private OperatoreUfficioPanel operatoreUfficioP;
	private RegistratiPanel registratiP;
	private RegistratiPanelPaziente registratiPP;
	private PrenotaPanelPaziente prenotatiP;
	private CancellaPanelPaziente cancellaPP;
	private CancellaPanelUfficio cancellaPU;
	private PrenotaPanelUfficio prenotatiPU;
	private CambiaPwPanel cambiaPwPanel;
	private AggiornaCartellaClinicaPanel aggiornaCartClin;

	
	public ViewController() {
		frame = new JFrame();
		panel = new JPanel();

		Image icon = Toolkit.getDefaultToolkit().getImage("img\\icona.png");  
		frame.setIconImage(icon);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("HOSPITAL MANAGER");
		
		
		frame.getContentPane().add(panel);
		
		loginP = new LoginPanel();
		panel.add(loginP);
		
		pazienteP = new PazientePanel();
		panel.add(pazienteP);
		pazienteP.setVisible(false);
		
		registratiP = new RegistratiPanel();
		panel.add(registratiP);
		registratiP.setVisible(false);
		
		medicoP = new MedicoPanel();
		panel.add(medicoP);
		medicoP.setVisible(false);
		
		operatoreSanitarioP = new OperatoreSanitarioPanel();
		panel.add(operatoreSanitarioP);
		operatoreSanitarioP.setVisible(false);
		
		operatoreUfficioP = new OperatoreUfficioPanel();
		panel.add(operatoreUfficioP);
		operatoreUfficioP.setVisible(false);
		
		registratiPP = new RegistratiPanelPaziente();
		panel.add(registratiPP);
		registratiPP.setVisible(false);
		
		cambiaPwPanel = new CambiaPwPanel();
		panel.add(cambiaPwPanel);
		cambiaPwPanel.setVisible(false);
		
		prenotatiP = new PrenotaPanelPaziente();
		panel.add(prenotatiP);
		prenotatiP.setVisible(false);
		
		cancellaPP = new CancellaPanelPaziente();
		panel.add(cancellaPP);
		cancellaPP.setVisible(false);
		
		cancellaPU = new CancellaPanelUfficio();
		panel.add(cancellaPU);
		cancellaPU.setVisible(false);
		
		prenotatiPU = new PrenotaPanelUfficio();
		panel.add(prenotatiPU);
		prenotatiPU.setVisible(false);
		
		aggiornaCartClin = new AggiornaCartellaClinicaPanel();
		panel.add(aggiornaCartClin);
		aggiornaCartClin.setVisible(false);
		
		frame.setVisible(true);
		
	}
	
	public LoginPanel getLoginPanel() {
		return loginP;
	}

	public MedicoPanel getMedicoPanel() {
		return medicoP;
	}

	public PazientePanel getPazientePanel() {
		return pazienteP;
	}

	public OperatoreSanitarioPanel getOperatoreSanitarioPanel() {
		return operatoreSanitarioP;
	}

	public OperatoreUfficioPanel getOperatoreUfficioPanel() {
		return operatoreUfficioP;
	}

	public RegistratiPanel getRegistratiPanel() {
		return registratiP;
	}

	public RegistratiPanelPaziente getRegistratiPanelPaziente() {
		return registratiPP;
	}
	
	public PrenotaPanelPaziente getPrenotatiPanelPaziente() {
		return prenotatiP;
	}

	public CancellaPanelPaziente getCancellaPanelPaziente() {
		return cancellaPP;
	}

	public CancellaPanelUfficio getCancellaPanelUfficio() {
		return cancellaPU;
	}

	public PrenotaPanelUfficio getPrenotatiPanelUfficio() {
		return prenotatiPU;
	}

	public CambiaPwPanel getCambiaPwPanel() {
		return cambiaPwPanel;
	}
	
	public AggiornaCartellaClinicaPanel getAggiornaCartellaClinicaPanel() {
		return aggiornaCartClin;
	}
}
