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
                //si la prochaine action n'est ni une action ni un exit on redemande
                boolean actInconue = true;
                while (actInconue){
                    try {
                        laby.deplacerPerso(act);
                        actInconue = false;
                    } catch (ActionInconnueException f) {
                        if (act.equals("exit")) {
                            run = false;
                            actInconue = false;
                            System.out.println("Au revoir !");
                        } else {
                            System.out.println(f.fillInStackTrace()+". \nEntrez une nouvelle action :");
                            act = sc.nextLine();
                        }
                    }
                }

                System.out.println(laby);
                if (laby.etreFini()) {
                    run = false;
                    System.out.println("Felicitation. Vous avez fini le jeu !");
                }
            }

        } catch (FichierIncorrectException e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
