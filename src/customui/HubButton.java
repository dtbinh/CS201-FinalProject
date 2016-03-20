package customui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HubButton extends JButton {
	private static final long serialVersionUID = -1285510119716449816L;
	Color buttonColor;
	String text;
	public HubButton(String text, Color buttonColor, Color highlightColor) {
		super(text);
		this.text = text;
		this.setOpaque(true);
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.buttonColor = buttonColor;
		
		this.setFont(new Font("Trebuchet", Font.PLAIN, 18));
		this.setBackground(buttonColor);
		this.setForeground(Color.WHITE);
		
		this.setVerticalTextPosition(SwingConstants.CENTER);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(highlightColor);
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(buttonColor);
			}
		});
	}
}
