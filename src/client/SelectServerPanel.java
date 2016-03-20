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
import customui.HubComboBox;
import customui.ThemeColors;
import library.ImageLibrary;
import utilities.scalableLabel;

public class SelectServerPanel extends JPanel {
	private static final long serialVersionUID = -8929153530572963396L;
	
	private Image bg;
	private JLabel bgLabel;
	private HubComboBox<String> clubComboBox, serverComboBox;
	private HubButton selectServerButton;
	private JPanel centerPanel, buttonBox;
	
	public SelectServerPanel() {
		setLayout(new BorderLayout());
		setSize(1100,699);
		instantiateComponents();
		createGUI();
	}
	
	private void instantiateComponents() {	
		bg = ImageLibrary.getImage(Constants.SPLASH_IMAGE);
		/* scalableLabel is a JLabel */
		bgLabel = new scalableLabel(new ImageIcon(bg));
		clubComboBox = new HubComboBox<String>();
		serverComboBox = new HubComboBox<String>();
		selectServerButton = new HubButton(Constants.SELECT_SERVER_TEXT, ThemeColors.LOGIN_COLOR, ThemeColors.LOGIN_HIGHLIGHT_COLOR);
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
		serverComboBox.setText("Select School Server");
		serverComboBox.setBounds(0, 115, 310, 50);
		clubComboBox.setText("Select Club");
		clubComboBox.setBounds(0, 173, 310, 50);
		Image img = ImageLibrary.getScaledImage(ImageLibrary.getImage(Constants.SPLASH_LOGO), 310, 85);
		JLabel logoLabel = new JLabel(new ImageIcon(img));
		logoLabel.setBounds(0, 0, 310, 85);
		/* buttonBox: Container for buttons login and sign out */
		buttonBox.setLayout(null);
		buttonBox.setBounds(0, 240, 310, 50);
		selectServerButton.setBounds(0,0,310,50);
		buttonBox.add(selectServerButton);
		buttonBox.setOpaque(false);
		/* Add all the components to the center panel */
		centerPanel.add(logoLabel);
		centerPanel.add(serverComboBox);
		centerPanel.add(clubComboBox);
		centerPanel.add(buttonBox);
		/* Transparent panel */
		centerPanel.setOpaque(false);
		/* Add the centerPanel to the center (vertically and horizontally) of the JLabel */
		bgLabel.add(centerPanel, new GridBagConstraints());
		add(bgLabel);
		//test
	}
	
	public HubButton getButton() {
		return selectServerButton;
	}
}
	
