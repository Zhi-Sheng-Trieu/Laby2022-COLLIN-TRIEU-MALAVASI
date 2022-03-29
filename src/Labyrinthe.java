import java.io.*;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {

    public boolean[][] murs;
    public Personnage personnage;
    public Sortie sortie;

    /*constantes*/
    public final static char MUR = 'X';
    public final static char PJ = 'P';
    public final static char SORTIE = 'S';
    public final static char VIDE = '.';
    public final static String HAUT = "haut";
    public final static String BAS = "bas";
    public final static String GAUCHE = "gauche";
    public final static String DROITE = "droite";


    public char getChar(int x, int y) {
        char res;
        if ((y == this.personnage.getY()) && (x == this.personnage.getX())) {
            res = PJ;
        } else if (this.murs[x][y]) {
            res = MUR;
        } else if ((x == this.sortie.getX()) && (y == this.sortie.getY())) {
            res = SORTIE;
        } else {
            res = VIDE;
        }
        return res;
    }

    public static int[] getSuivant(int x, int y, String direction) {
        int[] val = new int[2];
        if (direction.equals(DROITE)) {
            val[0] = x;
            val[1] = y + 1;
        } else if (direction.equals(GAUCHE)) {
            val[0] = x;
            val[1] = y-1;
        } else if (direction.equals(HAUT)) {
            val[0] = x - 1;
            val[1] = y;
        } else if (direction.equals(BAS)) {
            val[0] = x + 1;
            val[1] = y;
        } else {
            val = null;
        }

        return val;
    }


    public void deplacerPerso(String action) {

        int y = this.personnage.getY();
        int x = this.personnage.getX();
        int[] val = getSuivant(x, y, action);

        while (getChar(val[0], val[1]) != MUR) {
            x = val[0];
            y = val[1];
            this.personnage.setX(x);
            this.personnage.setY(y);
            val = getSuivant(x, y, action);
        }
    }


    public String toString() {

        String tableau = "";

        for (int i = 0; i < this.murs.length; i++) {
            for (int j = 0; j < this.murs[i].length; j++) {
                tableau += getChar(i, j);
            }
            tableau += "\n";
        }

        return (tableau);
    }


    public boolean etreFini() {
        return (this.personnage.getY() == this.sortie.getY() && this.personnage.getX() == this.sortie.getX());
    }


    public Labyrinthe(String nom) throws IOException {

        BufferedReader fichier = new BufferedReader(new FileReader(nom));
        String ligne = fichier.readLine();
        int x = Integer.parseInt(ligne);
        ligne = fichier.readLine();
        int y = Integer.parseInt(ligne);
        this.murs = new boolean[x][y];

        char caractere;
        String ln;
        for (int i = 0; i < x; i++) {
            ln = fichier.readLine();
            for (int j = 0; j < y; j++) {
                if (ln != null) {
                    caractere = ln.charAt(j);
                    if (caractere == SORTIE) {
                        this.sortie = new Sortie(i, j);
                    } else if (caractere == MUR) {
                        this.murs[i][j] = true;
                    } else if (caractere == PJ) {
                        this.personnage = new Personnage(i, j);
                    }
                }
            }

        }

    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException {
        Labyrinthe lab = new Labyrinthe(nom);
        return (lab);
    }


}
