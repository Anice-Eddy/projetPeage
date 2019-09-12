package Threads_autoroute;
import javax.swing.*;
import java.awt.*;
//import fr.ipst.io.Clavier;

import java.text.NumberFormat;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class VueSaisie{

    private JPanel container = new JPanel();
    private JPanel top = new JPanel(); 
    private JTextField jtf1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtf2 = new JFormattedTextField(NumberFormat.getPercentInstance());
    private JTextField jtf3 = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtf4 = new JFormattedTextField(NumberFormat.getPercentInstance());
    private JTextField jtf5 = new JFormattedTextField(NumberFormat.getIntegerInstance());

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    
    private JButton b = new JButton ("Valider");
    
	public FormAutoroute lire() {
		
		JFrame fenetre = new JFrame ( "Formulaire" ) ;
		Container contenu = fenetre.getContentPane();
		contenu . setLayout (new BorderLayout ( ) ) ;
		
	    
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());       
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    top.setBackground(Color.white);
	    top.setLayout(new FlowLayout());       
	    
	    
	    jtf1.setFont(police);
	    jtf1.setPreferredSize(new Dimension(150, 30));
	    //jtf1.setHorizontalAlignment(JLabel.CENTER);
	    jtf1.setForeground(Color.BLUE);
	    
	    jtf2.setFont(police);
	    jtf2.setPreferredSize(new Dimension(150, 30));
	    jtf2.setForeground(Color.BLUE);
	     
	    jtf3.setFont(police);
	    jtf3.setPreferredSize(new Dimension(150, 30));
	    jtf3.setForeground(Color.BLUE);
	    
	    jtf4.setFont(police);
	    jtf4.setPreferredSize(new Dimension(150, 30));
	    jtf4.setForeground(Color.BLUE);
	    
	    jtf5.setFont(police);
	    jtf5.setPreferredSize(new Dimension(150, 30));
	    jtf5.setForeground(Color.BLUE);
		
	    
        this.label1 = new JLabel("Nombre de voitures : ");
        this.label1.setHorizontalAlignment(JLabel.CENTER);
        contenu.add(label1, BorderLayout .CENTER);
        String nb_v = this.jtf1.getText();
        contenu.add(this.jtf1);
        
        this.label2 =  new JLabel("Nombre de caisses : ");
        this.label2.setHorizontalAlignment(JLabel.CENTER);
        contenu.add(label2, BorderLayout .CENTER);
        String nb_c = this.jtf2.getText();
        contenu.add(this.jtf2);
        
        this.label3 =  new JLabel("Kilométrage min : ");
        this.label3.setHorizontalAlignment(JLabel.CENTER);
        contenu.add(label3, BorderLayout .CENTER);
        String min = this.jtf3.getText();
        contenu.add(this.jtf3);
        
        this.label4 =  new JLabel("Kilométrage max : ");
        this.label4.setHorizontalAlignment(JLabel.CENTER);
        contenu.add(label4, BorderLayout .CENTER);
        String max = this.jtf4.getText();
        contenu.add(this.jtf4);
        
        this.label5 =  new JLabel("Vitesse moyenne des véhicules : ");
        this.label5.setHorizontalAlignment(JLabel.CENTER);
        contenu.add(label5, BorderLayout .CENTER);
        String vitesse = this.jtf5.getText();
        contenu.add(this.jtf5);
        
        //Définir les boutons au SUD
        JPanel boutons = new JPanel (new FlowLayout ( ) ) ;
        contenu .add(boutons , BorderLayout .SOUTH);
        boutons.add(b);
	
        //this.setContentPane(top);
        fenetre.getContentPane().add(b);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack(); //dimmensionner la fenêtre
        fenetre.setVisible(true);  
        
		b.addActionListener(bt -> {
		        	
		});
		FormAutoroute f = new FormAutoroute(Integer.parseInt(nb_v), Integer.parseInt(nb_c), Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(vitesse));
        return f;
    }
}
