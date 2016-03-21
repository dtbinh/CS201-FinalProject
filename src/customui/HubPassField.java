package customui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import library.ImageLibrary;

public class HubPassField extends JPasswordField{
	private static final long serialVersionUID = 3964529762960557244L;
	
	private String hint;
	private static Image mBackgroundImage;
	private Insets dummyInsets;
	private ImageIcon icon;

	{
		setOpaque(false);
		mBackgroundImage = ImageLibrary.getImage("img/ui/text.png");
		icon = new ImageIcon(ImageLibrary.getScaledImage(ImageLibrary.getImage("img/ui/password.png"), 25, 25));
		setBorder(new EmptyBorder(2, 40, 2, 2));
		JTextField dummy = new JTextField();
	    Border border = UIManager.getBorder("TextField.border");
	    this.dummyInsets = border.getBorderInsets(dummy);
	}
	
	public HubPassField(String string) {
		//super(string);
		hint = string;
		this.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));

	}
	public HubPassField() {
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(mBackgroundImage, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		int textX = 2;

        if(this.icon!=null){
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int x = dummyInsets.left + 5;
            textX = x+iconWidth+2;
            int y = (this.getHeight() - iconHeight)/2;
            icon.paintIcon(this, g, x, y);
        }

        setMargin(new Insets(5, 2, 2, 2));

        if (this.getText().equals("")) {
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
            g2d.drawString(hint, 43, textBottom);
            g2d.setRenderingHints(hints);
            g.setFont(prev);
            g.setColor(prevColor);
        }
	}
	
}
