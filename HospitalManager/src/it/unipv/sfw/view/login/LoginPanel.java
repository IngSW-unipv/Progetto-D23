package it.unipv.sfw.view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginPanel extends JPanel{
	
	private JPasswordField passwordField;
	private JTextField idAccountText;
	private JLabel lblIdAccount,lblPassword;
	private JLabel lblDomanda1, lblDomanda2;
	private JButton btnLogin, btnRegistraPaziente;
	
	
	public LoginPanel() {
		setVisible(true);
		setLayout(new GridLayout(5,2));
		
		passwordField = new JPasswordField();
		idAccountText = new JTextField();
		lblIdAccount = new JLabel("Codice Fiscale\n");
		lblPassword = new JLabel("Password\n");
		lblDomanda1 = new JLabel("Hai già un account?");
		btnLogin = new JButton("ACCEDI");
		lblDomanda2 = new JLabel("Sei un paziente?");
		btnRegistraPaziente = new JButton("REGISTRAZIONE PAZIENTE");
		
		add(lblIdAccount);
		add(idAccountText);
		add(lblPassword);
		add(passwordField);
		add(lblDomanda1);
		add(btnLogin);
		add(lblDomanda2);
		add(btnRegistraPaziente);
		
	}
	
	public void changeLabelColor() {
		lblIdAccount.setBackground(Color.red);
		lblPassword.setBackground(Color.red);
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getIdAccountText() {
		return idAccountText;
	}

	public void setIdAccountText(JTextField idAccountText) {
		this.idAccountText = idAccountText;
	}

	public JLabel getLblIdAccount() {
		return lblIdAccount;
	}

	public void setLblIdAccount(JLabel lblIdAccount) {
		this.lblIdAccount = lblIdAccount;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JLabel getLblDomanda1() {
		return lblDomanda1;
	}

	public void setLblDomanda1(JLabel lblDomanda1) {
		this.lblDomanda1 = lblDomanda1;
	}

	public JLabel getLblDomanda2() {
		return lblDomanda2;
	}

	public void setLblDomanda2(JLabel lblDomanda2) {
		this.lblDomanda2 = lblDomanda2;
	}

	
	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnRegistraPaziente() {
		return btnRegistraPaziente;
	}

	public void setBtnRegistraPaziente(JButton btnRegistraPaziente) {
		this.btnRegistraPaziente = btnRegistraPaziente;
	}
	
	
}

