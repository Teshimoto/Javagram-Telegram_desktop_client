package View.Forms;

import View.Resources;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.image.BufferedImage;


public class SignUpForm {
    private JTextField lastNameText;
    private JTextField firstNameText;
    private JButton nextButton;
    private JPanel rootPanel;
    private JTextPane titleTextPane;
    private JPanel logoPanel;
    private BufferedImage logo;

    public SignUpForm() {
        this.logo = Resources.getImage(Resources.LOGO_MINI);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getLastNameText() {
        return lastNameText;
    }

    public JTextField getFirstNameText() {
        return firstNameText;
    }

    private void createUIComponents() {
        firstNameText = new JTextField();
        lastNameText = new JTextField();

        Border outerBorder, innerBorder;
        outerBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
        innerBorder = BorderFactory.createEmptyBorder(2, 10, 2, 0);
        firstNameText.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        lastNameText.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 0, 0, null);
            }
        };

        StyleContext sc = new StyleContext();
        DefaultStyledDocument doc = new DefaultStyledDocument(sc);
        titleTextPane = new JTextPane(doc);
        Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
        Style mainStyle = sc.addStyle("My Style", defaultStyle);
        StyleConstants.setAlignment(mainStyle,StyleConstants.ALIGN_CENTER);
        doc.setLogicalStyle(0, mainStyle);
    }
}