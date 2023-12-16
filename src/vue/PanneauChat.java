package vue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel {
    protected JTextArea zoneChat;
    protected JTextField champDeSaisie;
    
    public PanneauChat() {
    	JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout() );
		zoneChat = new JTextArea(38,28);
		zoneChat.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2));
		champDeSaisie = new JTextField();	
		panel.add(champDeSaisie,BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(zoneChat);
		zoneChat.setEditable(false);
		panel.add(scroll,BorderLayout.CENTER);
		this.add(panel,BorderLayout.CENTER);
		
    }
    
    
    

    public void ajouter(String msg) {
        zoneChat.append("\n"+msg);
    }
    public void setEcouteur(ActionListener ecouteur) {
        champDeSaisie.addActionListener(ecouteur); 
    }

    public void vider() {
        this.zoneChat.setText("");
    }




	public JTextArea getZoneChat() {
		return zoneChat;
	}




	public void setZoneChat(JTextArea zoneChat) {
		this.zoneChat = zoneChat;
	}




	public JTextField getChampDeSaisie() {
		return champDeSaisie;
	}




	public void setChampDeSaisie(JTextField champDeSaisie) {
		this.champDeSaisie = champDeSaisie;
	}




}