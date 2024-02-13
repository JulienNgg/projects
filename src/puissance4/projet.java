package puissance4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class projet {
	//valeur globale Grille.
	public static int [][] Grille = new int [6][7];
	
	//initialiser Grille.
	public static void initialiseGrille() {
		System.out.println("le tableau est: ");
		for(int i=0; i < Grille.length; i++ ) {
			for(int j=0; j<Grille[0].length; j++) {
				System.out.print( Grille[i][j] + " ");
			}
			System.out.println(" ");
		}
		return;
	
	}
	//fonction jouer qui prend des paramettres de joueur.
	public static void jouer(int joueur, int colonne) {
		for(int i =0; i<6; i++) {
			if (Grille[i][colonne]==0) {
				Grille[i][colonne]= joueur;
				return;
			}
			
		}
		return;
	}
	
	//fonction qui affiche le tableau.
	public static void visualisation() {
		for(int i = 5; i>=0; i--) {
			for(int j=0; j<Grille[0].length;j++) {
				if(Grille[i][j]==0) {
					System.out.print("| ");
					System.out.print("");
				}
				if(Grille[i][j]==1) {
					System.out.print("|X"); 
				}
				if(Grille[i][j]==2) {
					System.out.print("|O");
				}
				if(j==6) {
					System.out.print("|");
				
				
			}
			
				
			}
			
			System.out.println();
			
		}
		System.out.print(" 0 1 2 3 4 5 6");
		System.out.println();
		return;
		
		
	}
	//fonction qui fait gagné si le joueur a 4 pions à l'horizontale.
	public static boolean aGagneHor(int joueur, int ligne, int colonne) {
		boolean win= false;
		int n=0;
		if(colonne <4) {
		for (int i=0; i<4; i++) {
			if(Grille[ligne][i]==joueur) {
				n=n+1;
			
				}
				if(n==4) {
					win= true;
					
				}
			}
		}
		return win;
	}
	
		
	//fonction qui fait gagné si le joueur a 4 pions à la verticale.
	public static boolean aGagneVer(int joueur, int ligne, int colonne) {
		boolean win= false;
		int n=0;
		if(ligne <3) {
		for (int i=0; i<4; i++) {
			if(Grille[i][colonne]==joueur) {
				n=n+1;
				if(n==4) {
					win= true;
					
				}
			}
		}
	}
		return win;
	}
	
	//fonction qui fait gagné si le joueur a 4 pions alignés sur la diagonale montante
	public static boolean aGagneDiagMont(int joueur, int ligne, int colonne) {
		boolean win = false;
		int n= 0;
		if(ligne < 3 && colonne < 4) {
			for(int i=0; i<4; i++) {
				if (Grille[ligne][colonne]==joueur) {
					n=n+1;
					if (n==4) {
						win=true;
					}
					ligne=ligne +1;
					colonne= colonne +1;
					
					
				}
			}
		}
		return win;
	}
	
	//fonction qui fait gagné si le joueur a 4 pions alignés sur la diagonale descendante
	public static boolean aGagneDiagDesc(int joueur, int ligne, int colonne) {
		boolean win = false;
		int n=0;
		if(ligne>2 && colonne< 4) {
			for(int i=0; i<4; i++) {
				if(Grille[ligne][colonne]==joueur) {
					n=n+1;
					if(n==4) {
						win= true;
					}
					ligne=ligne-1;
					colonne= colonne +1;
						
				}
			}
		}
		return win;
	}
	
	//fonction qui fait gagné si 1 de 4 cases est vrai
	public static boolean aGagne(int joueur) {
		boolean win= false;
		for(int i=0; i<5; i++) {
			for(int j=0; j<6; j++) {
				if (aGagneHor(joueur,i,j) || aGagneVer(joueur,i,j) || aGagneDiagMont(joueur,i,j) || aGagneDiagDesc(joueur,i,j)){
					win = true;
				}
			}
		}
		return win;
	}
	//fonction qui fait match nul si le tableau est rempli est personne gagne.
	public static boolean matchNul() {
		boolean nul= false;
		int n=0; 
		for(int i = 0; i<5; i++ ) {
			for (int j = 0; j<6;j++) {
				if(Grille[i][j]!=0) {
					n=n+1;
					if(n==42) {
					nul= true;
					}
				}
			}
		}
		return nul;
	}
	
	//fonction qui exécute le jeu.
	public static void jeu() {
		visualisation();
		Scanner sc = new Scanner(System.in);
		int x =0;
		
		int joueur = 1;
		while(!matchNul() || !aGagne(joueur)) {
			for(int i=0; i<=42; i++) {
				x=x+1;
				if(x%2 == 0) {
					joueur = 2;
				}
				else joueur = 1;
					
			}
			System.out.println("c'est tour de joueur "+ joueur+ " taper le numéro de colonne entre 0 et 6 !");
				int n= sc.nextInt();
				if(n<0||n>9) {
					System.out.println("valeur en dehors du tableau, ressayez!!! ");
					n= sc.nextInt();
				}
				
				jouer(joueur, n);
				visualisation();
				if(aGagne(joueur)){
					System.out.println("Joueur "+ joueur+ " a gangé!!! ");
					break;
					
					}
				if(matchNul()) {
					break;
				}
				
				
			
		}
		
		
		
		
		
	}
	
	//fonction de joueur 2 qui va déclarer les valeurs aleatoires.
	public static void entierAleatoire(){
		int joueur=2;
		for(int i =0; i<1;i++) {
			int num= ThreadLocalRandom.current().nextInt(0 ,6);
			jouer(joueur,num);
			visualisation();
			
			
			
		}
	
		
		return;	
	}
	
	//fonction jeu qui permet joueur 1 joueur avec IA
	public static void joueCoupRandom() {
		Scanner sc = new Scanner(System.in);
		int x =0;
		
		int joueur = 1;
		while(!matchNul() || !aGagne(joueur)) {
			for(int i=0; i<=42; i++) {
				x=x+1;
				if(x%2 == 0) {
					joueur = 2;
				}
				else joueur = 1;
					
			}
			if(joueur==1) {
			System.out.println("c'est tour de joueur "+ joueur+ " taper le numéro de colonne entre 0 et 6 !");
				int n= sc.nextInt();
				
				jouer(joueur, n);
				visualisation();
	}
			if(joueur==2) {
				entierAleatoire();
			}
				if(aGagne(joueur)){
					System.out.println("Joueur "+ joueur+ " a gangé!!! ");
					break;
					
					}
				if(matchNul()) {
				
					break;
				
				}
		}
		}
	/*public static void block(int joueur,int colonne) {
		for(int i =0; i<6; i++) {
			if (Grille[i][colonne]!=0) {
				Grille[i][colonne]= 2;
				return;
			}
			
		}
		return;
	}*/
	//brouillon, je fais une fontion qui bloque joueur quand il est presque de gagner
	
	
	//fonction qui empêche le joueur 1 de gagner quand il a 3 pions en horizontale.
	// le problème ici c'est que l'IA joue 2 fois lorsque qu'il doit bloquer.
	public static boolean aGagneHorblock(int joueur, int ligne, int colonne) {
		boolean block= false;
		int n=0;
		if(colonne <4) {
		for (int i=0; i<3; i++) {
			if(Grille[ligne][i]==joueur) {
				n=n+1;
			}
				if(n==3) {
					Grille[ligne][i+1]=2;
					block = true;
				}
				if(n==4) {
					block= true;
					
				}
			}
		}
		return block;
	}
			
		
		
		
	
	

	public static void main(String[] args) {
		jeu();	
		//joueCoupRandom();
	}
}
