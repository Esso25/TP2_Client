package controleur;

import com.chat.client.ClientChat;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeConnectes extends MouseAdapter {

    private ClientChat clientChat;
    private JList<String> jlConnectes;

    public EcouteurListeConnectes(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
    	if (evt.getClickCount() == 2) { 
            jlConnectes = (JList) evt.getSource();
            int index = jlConnectes.locationToIndex(evt.getPoint());

            if (index != -1) { 
                String alias = (String) jlConnectes.getModel().getElementAt(index);

                clientChat.envoyer("JOIN " + alias);
            }
        }
    }
}
