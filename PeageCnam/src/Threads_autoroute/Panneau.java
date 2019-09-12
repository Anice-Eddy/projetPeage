package Threads_autoroute;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
    //Vous verrez cette phrase chaque fois que la m�thode sera invoqu�e
      private int posX = -50;
      private int posY = -50;

      public void paintComponent(Graphics g){
          //On choisit une couleur de fond pour le rectangle
          g.setColor(Color.white);
          //On le dessine de sorte qu'il occupe toute la surface
          g.fillRect(0, 0, this.getWidth(), this.getHeight());
          //On red�finit une couleur pour le rond
          g.setColor(Color.red);
          //On le dessine aux coordonn�es souhait�es
          g.fillRect(posX, posY, 20, 10);
      }


    public int getPosX() {
      return posX;
    }

    public void setPosX(int posX) {
      this.posX = posX;
    }

    public int getPosY() {
      return posY;
    }

    public void setPosY(int posY) {
      this.posY = posY;
    }           
}