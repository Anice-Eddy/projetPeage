package Threads_autoroute;
import java.awt.*;
import javax.swing.*;

/**
 * @author eanice
 *
 */
public class Fenetre extends JFrame {
  private Panneau p = new Panneau();

  public Fenetre(){
	    //Définit un titre pour notre fenêtre
	    this.setTitle("Ma première fenêtre Java");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(400, 300);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    this.setContentPane(p);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
	    this.setVisible(true);
  }
  public void setPanneau(Panneau p) {
      this.p = p;
    }    
	/*
	 * private void go(){ for(int i = -50; i < pan.getWidth(); i++){ int x =
	 * pan.getPosX(), y = pan.getPosY(); x++; y++; pan.setPosX(x); pan.setPosY(y);
	 * pan.repaint(); try { Thread.sleep(10); } catch (InterruptedException e) {
	 * e.printStackTrace(); } } }
	 */     
}
