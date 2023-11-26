package it.unipv.sfw.view;

import java.awt.*;  
import javax.swing.*; 

import it.unipv.sfw.view.account.MedicoPanel;
import it.unipv.sfw.view.account.OperatoreSanitarioPanel;
import it.unipv.sfw.view.account.OperatoreUfficioPanel;
import it.unipv.sfw.view.account.PazientePanel;
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

	
	public ViewController() {
		frame = new JFrame();
		panel = new JPanel();

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("HOSPITAL MANAGER");
		
		frame.getContentPane().add(panel);
		
		//Login
		loginP = new LoginPanel();
		panel.add(loginP);
		
		//Paziente
		pazienteP = new PazientePanel();
		//panel.add(pazienteP);
		
		//Registrati
		registratiP = new RegistratiPanel();
		//panel.add(registratiP);
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		ViewController main = new ViewController();
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
}
