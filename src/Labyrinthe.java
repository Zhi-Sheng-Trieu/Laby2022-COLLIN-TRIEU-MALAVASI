import java.io.*;
/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {
    

      public boolean[][] murs;
      public Personnage personnage;
      public Sortie sortie;
      
      

      public char getChar(int x, int y) {
        
          if ( (y == this.personnage.getY()) && (x == this.personnage.getX()) ) {
              return ('P');
          } 
          
          else if (this.murs[x][y]) {
              return ('X');
          } 
          
          else if ((x == this.sortie.getX()) && (y == this.sortie.getY())) {
              return ('S');
          } 
          
          else {
              return ('.');
          }
    
      }


      public static int[] getSuivant(int x, int y, String direction) {
        
          if ( direction == "DROITE" ) {
            int[] val = new int[2];
              val[0] = x;
              val[1] = y+1;
              return (val);
          }
          
          else if ( direction == "GAUCHE" ) {
            int[] val = new int[2];
              val[0] = x-1;
              val[1] = y;
              return (val);
          }
      
          else if ( direction == "HAUT" ) {
            int[] val = new int[2];
              val[0] = x-1;
              val[1] = y;
              return (val);
          }

          else if ( direction == "BAS" ) {
            int[] val = new int[2];
              val[0] = x+1;
              val[1] = y;
              return (val);
          }

          else {
            return(null);
          }

      }


      void deplacerPerso(String action) throws ActionInconnueException {
        
        int y = this.personnage.getY();
        int x = this.personnage.getX();
        
        while (getChar(x,y) == 'P' || getChar(x,y) == '.') {
          
          int[] val = new int[1];
            val = getSuivant(x,y,action);
            
            if (getChar(x,y) == '.') {
              x = val[0];
              y = val[1];
            }

        }

        this.personnage.setY(y);
        this.personnage.setX(x);

      }


      public String toString() {
      
        String tableau = "";
      
        for(int i = 0 ; i < this.murs.length ; i++) {
          
            for(int i2 = 0 ; i2 < this.murs[i].length ; i2++) {
              tableau += getChar(i,i2);
            }

        tableau += "\n";
      
        }
      
        return(tableau);
    
      }


      public boolean etreFini() {
          return(this.personnage.getY() == this.sortie.getY() && this.personnage.getX() == this.sortie.getX());
      }



      public Labyrinthe(String nom){
        
        BufferedReader fichier = new BufferedReader(new FileReader(nom));
        String ligne = fichier.readLine();
        int x = Integer.parseInt(ligne);
        ligne = fichier.readLine();
        int y = Integer.parseInt(ligne);
        
        String caractere;
        
        for (int i = 0; i < x; i++) {
          
          for (int i2 = 0; i2 < y; i2++) {
              caractere = fichier.read();
            
            if (caractere == 'S') {
                sortie.setY(i);
                sortie.setX(i2);
            }
              
            else if (caractere == 'X') {
              this.murs[i2][i] = true;
            }

            else if (caractere == 'P') {
                personnage.setY(i);
                personnage.setX(i2);
            }
              
          }

        }

      }



      public static Labyrinthe chargerLabyrinthe(String nom) {
          Labyrinthe lab = new Labyrinthe(nom);
            return(lab);
      }



}
