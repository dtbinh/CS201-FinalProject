/* DESIGNED AND CREATED BY JEREMY AFTEM
 * This JFrame is a window frame for the LoginPanel and SelectServerPanel
 */

package client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import customui.HubButton;

public class LoginGUI extends JFrame {
	private static final long serialVersionUID = -6157734000544090104L;
	LoginPanel login;
	SelectServerPanel selectServer;
	HubButton selectServerButton, signUpButton, loginButton;
	LoginGUI() {
		setTitle("Club Hub Login");
		setSize(1100,699);
		setMinimumSize(new Dimension(1100,699));
		setMaximumSize(new Dimension(1100,699));
		setPreferredSize(new Dimension(1100,699));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		instantiateComponents();
		createGUI();
		addActionListeners();
	}
	
	private void instantiateComponents() {
		login = new LoginPanel();
		selectServer = new SelectServerPanel();
		selectServerButton = selectServer.getButton();
		signUpButton = login.getButtonSignUp();
		loginButton = login.getButtonLogin();
	}
	
	private void createGUI() {
		add(selectServer);
	}
	
	private void addActionListeners() {
		selectServerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(login);
				getContentPane().revalidate();
				setVisible(true);
			}
		});
	}
	
	public static void main(String args[]) {
		LoginGUI loginGUI = new LoginGUI();
		loginGUI.setVisible(true);
	}	
}
