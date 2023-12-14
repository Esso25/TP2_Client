package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;
    private JPanel panel;
    

    public PanneauConfigServeur(String adr, int port) {
    	
    	txtAdrServeur = new JTextField(adr);
        txtAdrServeur.setColumns(10);
    	txtNumPort = new JTextField(String.valueOf(port));
        txtNumPort.setColumns(10);
        
    	panel=new JPanel();
		panel.setLayout(new BorderLayout() );

		JPanel adressePanel = new JPanel(new BorderLayout());
	    adressePanel.add(new JLabel("Adresse IP:"), BorderLayout.WEST);
	    adressePanel.add(txtAdrServeur, BorderLayout.EAST);

	    JPanel portPanel = new JPanel(new BorderLayout());
	    portPanel.add(new JLabel("          	 Port:"), BorderLayout.WEST);
	    portPanel.add(txtNumPort, BorderLayout.EAST);

	    panel.add(adressePanel, BorderLayout.NORTH);
	    panel.add(portPanel, BorderLayout.SOUTH);
		
    }
    public JPanel getPanel() {
		return panel;
	}
	
	public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
