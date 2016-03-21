package customui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.plaf.metal.MetalComboBoxUI;

import library.ImageLibrary;

public class HubComboBoxUI extends MetalComboBoxUI {
	private static final Image arrow;
	
	static {
		arrow = ImageLibrary.getImage("img/ui/arrow.png");
	}
	
	protected JButton createArrowButton() {
		return new JButton() {
			private static final long serialVersionUID = 1L;
			{
				setOpaque(false);
				setContentAreaFilled(false);
				setBorderPainted(false);
			}
			protected void paintComponent(Graphics g) {
				Image sized = arrow.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
				g.drawImage(sized,  0,  0, getWidth(), getHeight(), null);
				super.paintComponent(g);
			}
		};
	}
}
