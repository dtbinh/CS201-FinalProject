/* DESIGNED AND CODED BY JEREMY AFTEM */
package client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customui.HubButton;
import customui.HubPassField;
import customui.HubTextField;
import customui.ThemeColors;
import library.ImageLibrary;
import utilities.scalableLabel;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = -6157734000544090104L;
	
	private Image bg;
	private JLabel bgLabel;
	private HubTextField usernameTextField;
	private HubPassField passwordTextField;
	private HubButton loginButton, signupButton;
	private JPanel centerPanel, buttonBox;
	public LoginPanel() {
		setLayout(new BorderLayout());
		setSize(1100,699);
		instantiateComponents();
		createGUI();
	}
	
	private void instantiateComponents() {	
		bg = ImageLibrary.getImage(Constants.SPLASH_IMAGE);
		/* scalableLabel is a JLabel */
		bgLabel = new scalableLabel(new ImageIcon(bg));
		usernameTextField = new HubTextField(Constants.USERNAME_TEXT);
		passwordTextField = new HubPassField(Constants.PASSWORD_TEXT);
		loginButton = new HubButton(Constants.LOGIN_TEXT, ThemeColors.LOGIN_COLOR, ThemeColors.LOGIN_HIGHLIGHT_COLOR);
		signupButton = new HubButton(Constants.SIGNUP_TEXT, ThemeColors.SIGNUP_COLOR, ThemeColors.SIGNUP_HIGHLIGHT_COLOR);
		centerPanel = new JPanel();		
		buttonBox = new JPanel();
	}
	
	private void createGUI() {
		bgLabel.setLayout(new GridBagLayout());
		/* Center Panel is a panel located vertically and horizontally in the center of the frame */
		centerPanel.setPreferredSize(new Dimension(310,350));
		centerPanel.setLayout(null);
		/* The components inside the center panel are placed by pixels,
		 * OK because user can't resize smaller than 1100x699 */
		usernameTextField.setBounds(0, 115, 310, 50);
		passwordTextField.setBounds(0, 173, 310, 50);
		Image img = ImageLibrary.getScaledImage(ImageLibrary.getImage(Constants.SPLASH_LOGO), 310, 85);
		JLabel logoLabel = new JLabel(new ImageIcon(img));
		logoLabel.setBounds(0, 0, 310, 85);
		/* buttonBox: Container for buttons login and sign out */
		buttonBox.setLayout(null);
		buttonBox.setBounds(0, 240, 310, 50);
		loginButton.setBounds(0,0,147,50);
		signupButton.setBounds(163,0,147,50);
		buttonBox.add(loginButton);
		buttonBox.add(signupButton);
		buttonBox.setOpaque(false);
		/* Add all the components to the center panel */
		centerPanel.add(logoLabel);
		centerPanel.add(usernameTextField);
		centerPanel.add(passwordTextField);
		centerPanel.add(buttonBox);
		/* Transparent panel */
		centerPanel.setOpaque(false);
		/* Add the centerPanel to the center (vertically and horizontally) of the JLabel */
		bgLabel.add(centerPanel, new GridBagConstraints());
		add(bgLabel);
	}
	
	public HubButton getButtonLogin() {
		return loginButton;
	}
	public HubButton getButtonSignUp() {
		return signupButton;
	}
}