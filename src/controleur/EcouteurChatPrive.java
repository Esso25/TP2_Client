package controleur;

import com.chat.client.Client;
import com.chat.client.ClientChat;
import vue.PanneauChat;
import vue.PanneauChatPrive;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic implements ActionListener{
    private String alias;
    private PanneauChatPrive panneauChatPrive;

    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat,PanneauChatPrive panneauChatPrive) {
        super(clientChat, panneauChat);
        this.alias = alias;
        this.panneauChatPrive= panneauChatPrive;
    }
    
	
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source instanceof JButton) {
            JButton btnChoix = (JButton) source;
            String text = btnChoix.getText();

            switch (text) {
            	case "Inviter échec":
		            panneauChatPrive.invitationEchecRecue();
            		break;
                case "Accepter":
                    clientChat.envoyer("CHESS");
                    panneauChatPrive.invitationEchecAnnulee();

                    break;
                case "Refuser":
                    clientChat.envoyer("DECLINE");
                    panneauChatPrive.invitationEchecAnnulee();

                    break;
                default:
                    break;
            }
        } 
        else if (source instanceof JTextField) {
        	
            JTextField textField = (JTextField) source;
            String msgText = textField.getText();

            switch (msgText) {
                case "QUIT":
                    clientChat.envoyer("QUIT");
                    textField.setText("");
                    break;
                case "ABANDON":
                    clientChat.envoyer("ABANDON");
                    textField.setText("");

                    break;
                default:
                     	clientChat.envoyer("PRV " +alias+" "+ msgText); 
                        textField.setText("");
            
                    break;
            }
        }
    }
    
    		
}