import java.io.IOException;
import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du fichier :");
        String txt = sc.nextLine();
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe(txt);
            System.out.println(laby);
            boolean run = true;
            String act;
            while (run) {
                System.out.println("Quelle est la prochaine action ?");
                act = sc.nextLine();
                //si la prochaine action n'est ni une action si un exit on redemande
                while (! (act.equals(Labyrinthe.DROITE) || act.equals(Labyrinthe.GAUCHE) || act.equals(Labyrinthe.HAUT) || act.equals(Labyrinthe.BAS)|| act.equals("exit"))){
                    System.out.println("Action non valide. Entrez une nouvelle action :");
                    act = sc.nextLine();
                }
                if (act.equals(Labyrinthe.DROITE) || act.equals(Labyrinthe.GAUCHE) || act.equals(Labyrinthe.HAUT) || act.equals(Labyrinthe.BAS)) {
                    laby.deplacerPerso(act);
                } else if (act.equals("exit")) {
                    run = false;
                }
                System.out.println(laby);
                if (laby.etreFini()){
                    run=false;
                    System.out.println("Felicitation. Vous avez fini le jeu !");
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur le fichier n'existe pas");
        }
    }
}
