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
public class PanneauChatPrive extends PanneauChat {
    private JButton bAccepterOuInviter, bRefuser;
    private FenetreEchecs fenetreEchecs;

    public PanneauChatPrive() {
    	super();
    	 setLayout(new BorderLayout());
         JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         
        bAccepterOuInviter = new JButton("Inviter échec");
        bRefuser = new JButton("Refuser");
        bAccepterOuInviter.setActionCommand("ACCEPTER");
        bRefuser.setActionCommand("REFUSER");
        
        btnPanel.add(bAccepterOuInviter); 
        btnPanel.add(bRefuser);
        
        this.add(btnPanel,BorderLayout.NORTH);
        this.add(zoneChat,BorderLayout.CENTER);        
        this.add(champDeSaisie,BorderLayout.SOUTH);        

        bAccepterOuInviter.setVisible(true);
        bRefuser.setVisible(false);
        
		
        
    }
    @Override
    public void setEcouteur(ActionListener ecouteur) {
        super.setEcouteur(ecouteur);
        bAccepterOuInviter.addActionListener(ecouteur);
        bRefuser.addActionListener(ecouteur);
    }
    public void invitationEchecRecue() {
        bAccepterOuInviter.setText("Accepter");
        bRefuser.setVisible(true);

    }
    public void invitationEchecAnnulee() {
        bAccepterOuInviter.setText("Inviter échec");
        bRefuser.setVisible(false);

    }
    

    public void setFenetreEchecs(FenetreEchecs fenetreEchecs) {
        if (this.fenetreEchecs!=null){
            this.fenetreEchecs.setVisible(false);
            this.fenetreEchecs.dispose();
        }
        this.fenetreEchecs = fenetreEchecs;
    }
    public FenetreEchecs getFenetreEchecs() {
        return this.fenetreEchecs;
    }
}