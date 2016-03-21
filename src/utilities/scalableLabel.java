package utilities;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class scalableLabel extends JLabel {
	private static final long serialVersionUID = -7242831876811376204L;
	private ImageIcon img;
	public scalableLabel(ImageIcon img) {
		this.img = img;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

	}
}