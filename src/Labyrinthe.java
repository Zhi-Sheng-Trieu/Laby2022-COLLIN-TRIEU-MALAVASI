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
            val[1] = y - 1;
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


    public void deplacerPerso(String action) throws ActionInconnueException {
        int y = this.personnage.getY();
        int x = this.personnage.getX();
        int[] val = getSuivant(x, y, action);

        try {
            while (getChar(val[0], val[1]) != MUR) {
                x = val[0];
                y = val[1];
                this.personnage.setX(x);
                this.personnage.setY(y);
                val = getSuivant(x, y, action);
            }
        } catch (NullPointerException e) {
            throw new ActionInconnueException("Action " + action + " inconnue");
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

        return tableau;
    }


    public boolean etreFini() {
        return (this.personnage.getY() == this.sortie.getY() && this.personnage.getX() == this.sortie.getX());
    }


    public Labyrinthe(String nom) throws FichierIncorrectException {
        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nom));
            String ligne = fichier.readLine();
            int x = Integer.parseInt(ligne);
            ligne = fichier.readLine();
            int y = Integer.parseInt(ligne);
            this.murs = new boolean[x][y];

            char caractere;
            String ln = fichier.readLine();
            int i = 1, j = 1;
            try {
                while (ln != null) {
                    caractere = ln.charAt(0);
                    while (caractere != '\n') {
                        if (caractere == SORTIE) {
                            if (this.sortie != null) {
                                throw new FichierIncorrectException("Plusieurs sorties");
                            } else {
                                this.sortie = new Sortie(i, j);
                            }
                        } else if (caractere == MUR) {
                            this.murs[i][j] = true;
                        } else if (caractere == PJ) {
                            if (this.personnage != null) {
                                throw new FichierIncorrectException("Plusieurs personnages");
                            } else {
                                this.personnage = new Personnage(i, j);
                            }
                        } else if (caractere != VIDE) {
                            throw new FichierIncorrectException("caractere inconnu : " + caractere);
                        }
                        caractere = ln.charAt(j);
                        j++;
                    }
                    ln = fichier.readLine();
                    i++;
                }
                if (this.personnage == null) {
                    throw new FichierIncorrectException("personnage inconnu");
                }
                if (this.sortie == null) {
                    throw new FichierIncorrectException("sortie inconnue");
                }
            } catch (IndexOutOfBoundsException f) {
                if (i > x) {
                    throw new FichierIncorrectException("nbLignes ne correspond pas");
                } else if (j > y) {
                    throw new FichierIncorrectException("nbColonnes ne correspond pas");
                }
            }

        } catch (IOException e) {
            throw new FichierIncorrectException("Fichier " + nom + " inconnu");
        } catch (NumberFormatException e) {
            throw new FichierIncorrectException("pb num ligne ou colonne");
        }

    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws FichierIncorrectException {
        return new Labyrinthe(nom);
    }


}
