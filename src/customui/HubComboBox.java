	package customui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import library.ImageLibrary;

public class HubComboBox<T> extends JComboBox<T> {
	private static final long serialVersionUID = -7835999902645001564L;
	Image mBackgroundImage;
	String text;
	{	
		mBackgroundImage = ImageLibrary.getImage("img/ui/text.png");
		setOpaque(false);
		setBorder(new EmptyBorder(0,0,0,0));
		this.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		this.setUI(new HubComboBoxUI());
		text = "No set text";
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
	protected void paintComponent(Graphics g) {
		g.drawImage(mBackgroundImage, 0, 0, getWidth(), getHeight(), null);
		if (this.getSelectedIndex() == -1) {
			int width = this.getWidth();
			int height = this.getHeight();
			Font prev = g.getFont();
			Font italic = prev.deriveFont(Font.ITALIC);
			Color prevColor = g.getColor();
			g.setFont(italic);
			g.setColor(ThemeColors.INACTIVE_TEXT);
			int h = g.getFontMetrics().getHeight();
			int textBottom = (height - h) / 2 + h - 4;
			int x = this.getInsets().left;
			Graphics2D g2d = (Graphics2D) g;
			RenderingHints hints = g2d.getRenderingHints();
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.drawString(text, 10, textBottom);
			g2d.setRenderingHints(hints);
			g.setFont(prev);
			g.setColor(prevColor);
		} 
	}
}
