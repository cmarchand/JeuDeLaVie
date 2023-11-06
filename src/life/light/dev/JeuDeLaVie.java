package life.light.dev;

import javax.swing.*;

public class JeuDeLaVie {

    public static void main (String arg[]){
        int taille = 90;
        World world = new World();
        world.initWorld(taille*8, taille);

        //Affichage
        JFrame fenetre = new JFrame();
        fenetre.setContentPane(new Panneau());

        //Définit un titre de la fenêtre
        fenetre.setTitle("Le jeu de la vie");
        //Définit sa taille
        fenetre.setSize(taille*10+20, taille*10+40);
        //Positionne la fenêtre au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        fenetre.setVisible(true);
        Panneau pan = new Panneau();
        fenetre.setContentPane(pan);

        for( int nbGeneration = 0; nbGeneration < 10000; nbGeneration ++){
            pan.setWorld(world);
            pan.revalidate();
            pan.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            world = world.newGeneration(taille);
        }
    }

}
