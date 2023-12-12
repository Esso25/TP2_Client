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
    	txtNumPort = new JTextField(String.valueOf(port));
        panel=new JPanel();

        panel.add(new JLabel("Adresse IP:"));
		panel.add(txtAdrServeur);
        panel.add(new JLabel("Port:"));
		panel.add(txtNumPort);

		
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
