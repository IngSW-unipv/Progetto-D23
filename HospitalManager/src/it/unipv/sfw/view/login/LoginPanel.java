package it.unipv.sfw.view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginPanel extends JPanel{
	
	private JPasswordField passwordField;
	private JTextField idAccountText;
	private JLabel lblIdAccount,lblPassword;
	private JButton btnLogin, btnRegistrati;
	
	
	public LoginPanel() {
		setVisible(true);
		setLayout(new GridLayout(3,2));
		
		passwordField = new JPasswordField();
		idAccountText = new JTextField();
		lblIdAccount = new JLabel("Id Account\n");
		lblPassword = new JLabel("Password\n");
		btnLogin = new JButton("LOGIN");
		btnRegistrati = new JButton("REGISTRATI");
		
		add(lblIdAccount);
		add(idAccountText);
		add(lblPassword);
		add(passwordField);
		add(btnRegistrati);
		add(btnLogin);
		
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

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnRegistrati() {
		return btnRegistrati;
	}

	public void setBtnRegistrati(JButton btnRegistrati) {
		this.btnRegistrati = btnRegistrati;
	}
	
	
	
}

