import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) {
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("../laby/laby0.txt");
        } catch (IOException e) {
            System.out.println("Erreur");
            ;
        }
    }
}
