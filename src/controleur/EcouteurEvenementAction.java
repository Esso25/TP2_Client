package controleur;


import com.chat.client.ClientChat;
import vue.PanneauInvitations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcouteurEvenementAction implements ActionListener{
	 private ClientChat clientChat;
	 private PanneauInvitations panneauInvitation;
	 
	public EcouteurEvenementAction(ClientChat clientChat, PanneauInvitations panneauInvitation) {
		this.clientChat = clientChat;
		this.panneauInvitation = panneauInvitation;
	}
	 @Override
	public void actionPerformed(ActionEvent evt) {
	JButton btn = (JButton) evt.getSource();

        List<String> invitationsSelectionnees = panneauInvitation.getElementsSelectionnes();
        //SI BOUTON CLIQUE EST UNE ACCEPTATION
        if (btn.getText().equals("+")) { // 
            for (String invitation : invitationsSelectionnees) {
                clientChat.envoyer("JOIN " + invitation); 
                panneauInvitation.retirerInvitationRecue(invitation); 
            }
        } 
        //SI BOUTON CLIQUE EST UN REFUS
        else if (btn.getText().equals("x")) { 
            for (String invitation : invitationsSelectionnees) {
                clientChat.envoyer("DECLINE " + invitation); 
                panneauInvitation.retirerInvitationRecue(invitation); 
            }
        }
    }

}
