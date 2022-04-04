import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {
    public Labyrinthe l;


    @Test
    void chargerLabyrinthe_FichierIncorrect() {
        //A chaque assert on verifie si une exception est levee
        //on teste le cas ou le fichier n'existe pas
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe(" "));
        //on teste le cas ou le fichier contient deux sorties
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_deuxSorties.txt"));
        //on teste le cas ou le fichier ne contient pas de sortie
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_pasSorties.txt"));
        //on teste le cas ou le fichier ne contient pas de personnage
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_pasPerso.txt"));
        //on teste le cas ou le fichier contient 2 personnages
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_deuxPerso.txt"));
        //on teste le cas ou il y a un caractere inconnu
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_charInconnu.txt"));
    }

    //on utilisera le fichier laby0.txt pour nos tests
    @BeforeEach
    void preparerTests() throws Exception {
        // utilise laby0.txt fourni
        this.l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
    }

    @Test
    void getChar() throws Exception {
        //le personnage commence sur la case (2,3) dans laby0.txt
        assertEquals(Labyrinthe.PJ, this.l.getChar(2,3));
        //on deplace le perso vers la gauche
        this.l.deplacerPerso(Labyrinthe.GAUCHE);
        //le perso est maintenant sur la case (2,1)
        assertEquals(Labyrinthe.PJ, this.l.getChar(2,1));
    }

    @Test
    void getSuivant() throws FichierIncorrectException {
        //res doit avoir les coordonnées de sortie
        int[] res = Labyrinthe.getSuivant(1,0,Labyrinthe.DROITE);
        assertEquals(Labyrinthe.SORTIE, this.l.getChar(res[0],res[1]));
    }

    @Test
    void deplacerPerso() throws ActionInconnueException{
        assertEquals(Labyrinthe.PJ, l.getChar(2,3));
        l.deplacerPerso(Labyrinthe.HAUT);
        //le perso s'est bien déplacé vers le haut jusqu'au mur
        assertEquals(Labyrinthe.PJ, l.getChar(1,3));
        //on recupere les coordonnees de la case suivante vers le haut
        int[] res = Labyrinthe.getSuivant(1,3,Labyrinthe.HAUT);
        //on verifie que la case suivante est bien le mur
        assertEquals(Labyrinthe.MUR, l.getChar(res[0], res[1]));

    }

    @Test
    void testToString() {
        assertEquals(   "XXXXXXX\n" +
                                "XS....X\n" +
                                "X..P..X\n" +
                                "X.....X\n" +
                                "XXXXXXX\n", l.toString());
    }

    @Test
    void etreFini_true() throws ActionInconnueException {
        //on teste le cas ou le perso est sur la sortie
        l.deplacerPerso(Labyrinthe.HAUT);
        l.deplacerPerso(Labyrinthe.GAUCHE);
        assertTrue(l.etreFini());
    }

    @Test
    void etreFini_false() throws ActionInconnueException {
        //on teste le cas ou le perso n'est pas sur la sortie
        l.deplacerPerso(Labyrinthe.HAUT);
        l.deplacerPerso(Labyrinthe.BAS);
        assertFalse(l.etreFini());
    }

}