import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    @Test
    void getChar() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        assertEquals(Labyrinthe.PJ, l.getChar(2,3));
    }

    @Test
    void getSuivant() throws FichierIncorrectException {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        //res doit avoir les coordonnées de sortie
        int[] res = Labyrinthe.getSuivant(1,0,Labyrinthe.DROITE);
        assertEquals(Labyrinthe.SORTIE, l.getChar(res[0],res[1]));
    }

    @Test
    void deplacerPerso() throws ActionInconnueException, FichierIncorrectException {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        assertEquals(Labyrinthe.PJ, l.getChar(2,3));
        l.deplacerPerso(Labyrinthe.HAUT);
        assertEquals(Labyrinthe.PJ, l.getChar(1,3));
    }

    @Test
    void testToString() {
    }

    @Test
    void etreFini() {
    }

    @Test
    void chargerLabyrinthe() {
    }
}