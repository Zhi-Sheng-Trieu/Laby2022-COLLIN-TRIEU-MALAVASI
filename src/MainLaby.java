import java.io.IOException;
import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du fichier :");
        String txt=sc.nextLine();
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe(txt);
        } catch (IOException e) {
            System.out.println("Erreur le fichier n'existe pas");
        }
    }
}
