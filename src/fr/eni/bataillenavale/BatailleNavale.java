package fr.eni.bataillenavale;
import java.util.Random;
import java.util.Scanner;
public class BatailleNavale {
    final static int TAILLE_MAX = 4;
    final static char PLOUF='~';
    final static char WIN= '#';//victoire
    final static char MAY = '?';
    public static void main(String[] args) {
        int ligneU=0;
        int colU=0;
        int cibleCol;//pour choix bateau
        int cibleLigne;
        boolean ok = false;
        Random rand =new Random();
        char[][] plateau = new char[TAILLE_MAX][TAILLE_MAX ] ;
        for (int j =0;j<TAILLE_MAX;j++){//ligne
            for (int i =0; i<TAILLE_MAX;i++) {//colonne
                plateau[j][i]=MAY;
            }
        }
        cibleCol=rand.nextInt(TAILLE_MAX-1);
        cibleLigne=rand.nextInt(TAILLE_MAX-1);
        plateau[cibleLigne][cibleCol]=WIN;
        Scanner sc = new Scanner(System.in);
            do {
                for (int j =0;j<TAILLE_MAX;j++){//ligne
                    for (int i =0; i<TAILLE_MAX;i++) {//colonne
                        if (plateau[j][i]==MAY||plateau[j][i]==WIN) {
                            System.out.print(MAY);
                        }
                        else{
                            System.out.print(PLOUF);
                        }
                    }
                    System.out.println();
                }
                //choix utilisateur
                boolean tire=false;
                do {
                    System.out.println("Quelle Colonne ?");
                        colU=(sc.nextInt()-1);
                        if(colU>=0 ||colU<TAILLE_MAX) {//-1 pris encompte
                            tire =true;
                            do {                        
                                System.out.println("Quelle Ligne ?");
                                ligneU=(sc.nextInt()-1);
                                if(ligneU<0||ligneU>TAILLE_MAX) {//si en dehors du plateau 
                                    tire =false;
                                    System.out.println("veuillez saisir un chiffre entre 1  et "+ TAILLE_MAX);
                                }
                            }while(tire==false);
                        }
                        else {
                            System.out.println("veuillez saisir un chiffre entre 1  et "+ TAILLE_MAX);
                        }
                }while(tire==false);
                //comparaison
                if (plateau[ligneU][colU]==PLOUF) {
                    System.out.println("vous avez déjà tiré ici. dommage!!!! ");
                    ok=false;
                } else if (plateau[ligneU][colU]==MAY) {
                System.out.println("PLOUF! A l'eau!");
                    plateau[ligneU][colU]=PLOUF;
                    ok = false;
                }
                else {//WIN
                    ok =true;
                    System.out.println("Touché Coulé vous avez gagné!!!!!!!!!!!!!");
                }
            }while(ok==false);
        sc.close();
    }
}