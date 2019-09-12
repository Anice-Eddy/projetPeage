package Threads_autoroute;
import javax.swing.*;
import java.awt.Dimension; 
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class Voiture extends Thread {

    private int num;
    private Gare gare;
    private Observateur obs;
    private int parcours;
    private int vitesse;
    private int km_min;
    private int km_max;
    private CountDownLatch barriere;
    private Controleur controleur;
    private Panneau pan = new Panneau();

    public Voiture(int num, int v, Gare gare, Observateur obs, int min, int max, CountDownLatch b, Controleur ctrl) {
        super();
        this.num = num;
        this.gare = gare;
        this.obs = obs;
        vitesse = v;
        km_min = min;
        km_max = max;
        barriere = b;
        controleur = ctrl;
    }

    @Override
    public void run() {
        try {
            barriere.countDown();//d�cr�menter le verrou  
            barriere.await();// attendre que toutes les autres voitures soient � ce m�me point
            entrer();
            rouler();
            sortir();
            controleur.decrement();//signaler au controleur qu'on est sortie pour d�cr�menter le nombre de voitures restantes dans l'autoroute
        } catch (InterruptedException ex) {
        }
    }

    private void entrer() {
        Random r = new Random();
        parcours = km_min + r.nextInt(km_max - km_min);//g�n�rer al�atoirement la longueur du parcours de cette voiture

    }

    private void rouler() {
    	Fenetre f = new Fenetre();
    	f.setPanneau(pan);
        while (parcours > 0) {//tant que le parcours n'est pas fini
            int x = this.pan.getPosX(), y = this.pan.getPosY();
            // Le bool�en pour savoir si l'on recule ou non sur l'axe x
            boolean backX = false;
            // Le bool�en pour savoir si l'on recule ou non sur l'axe y
            boolean backY = false;
            
            // Si la coordonn�e x est inf�rieure � 1, on avance
            if (x < 1)
              backX = false;
            // Si la coordonn�e x est sup�rieure � la taille du Panneau moins la taille du rond, on recule
            if (x > this.pan.getWidth() - 50)
              backX = true;
            // Idem pour l'axe y
            if (y < 1)
              backY = false;
            if (y > this.pan.getHeight() - 50)
              backY = true;

            // Si on avance, on incr�mente la coordonn�e
            // backX est un bool�en, donc !backX revient � �crire
            // if (backX == false)
            if (!backX)
              this.pan.setPosX(++x);
            // Sinon, on d�cr�mente
            else
              this.pan.setPosX(--x);
            // Idem pour l'axe Y
            if (!backY)
              this.pan.setPosY(++y);
            else
              this.pan.setPosY(--y);
            
            this.pan.repaint();  
            try {
                parcours--;//avancer d'un cran
                Thread.sleep(vitesse);//à la vitesse choisie
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public Panneau getPanneauVoiture() {
    	return this.pan;
    }
   
    private void sortir() {
        try {
            obs.increment(); //signaler � l'observateur qu'on attend une caisse
            Caisse c = gare.take();//demander une caisse, d�s qu'une caisse est libre elle sera affecter � cette voiture et elle sortira du pool de caisses libres
            c.payer();//payer
            System.out.println("Voiture " + num + " : sortie");
            gare.put(c);//lib�rer la caisse en la remettant dans le pool de caisses libres
            obs.decrement();//signaler à l'observateur qu'on est sorti de la file d'attente d'une caisse
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
    }
}
