package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	private File serverFile;
	
	public SelectServerPanel() {
		setLayout(new BorderLayout());
		setSize(1100,699);
		instantiateComponents();
		createGUI();
	}
	
	//Reads the list of all available hosts into the combo box
	private void populateServerComboBox() throws IOException {
		serverFile= new File(Constants.SERVERS_FILE);
		BufferedReader br =  null;
		try{
			br = new BufferedReader(new FileReader(serverFile));
			int i = 0;
			String s;
			while((s = br.readLine()) != null)
			{
				serverComboBox.insertItemAt(s, i);
				//System.out.println(s);
				i++;
			}	
		} catch (FileNotFoundException fnfe) {
			System.out.println("fnfe: " + fnfe.getMessage());
		} finally {
			if(br != null)
			{
				try {
					br.close();
				} catch (IOException ioe){
					System.out.println(ioe.getMessage());
				}
			}
			
		}
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
		try {
			populateServerComboBox();
		} catch (IOException e) {
			e.getMessage();
		}
		serverComboBox.setBounds(0, 115, 310, 50);
		addActions();
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
	}
	private void addActions() {
		serverComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String selected = (String)serverComboBox.getSelectedItem();
				System.out.println(selected);
				serverComboBox.setText(selected);
				serverComboBox.revalidate();
				serverComboBox.repaint();
			}
		});
	}
	public HubButton getButton() {
		return selectServerButton;
	}
	public String getSelectedServer()
	{
		return (String)serverComboBox.getSelectedItem();
	}
}
	
