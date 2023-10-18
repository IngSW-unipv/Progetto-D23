package it.unipv.sfw.view;

import javax.swing.*;

import it.unipv.sfw.view.account.MedicoPanel;
import it.unipv.sfw.view.account.OperatoreSanitarioPanel;
import it.unipv.sfw.view.account.OperatoreUfficioPanel;
import it.unipv.sfw.view.account.PazientePanel;
import it.unipv.sfw.view.login.LoginPanel;

public class ViewController {
	
	private JFrame frame;
	private JPanel panel;
	private LoginPanel loginP;
	private PazientePanel pazienteP;
	private MedicoPanel medicoP;
	private OperatoreSanitarioPanel operatoreSanitarioP;
	private OperatoreUfficioPanel operatoreUfficioP;

	
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
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		ViewController main = new ViewController();
	}
}
