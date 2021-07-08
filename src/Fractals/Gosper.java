package Fractals;

import LSystem.Lsysteme;
import LSystem.Mot;
import LSystem.Regles;
import LSystem.Symbole;

public class Gosper {
	public static Mot getMot(int n){
		Symbole A = new Symbole('A');
		Symbole B = new Symbole('B');
		Symbole plus = new Symbole('+');
		Symbole minus = new Symbole('-');
		
		Mot axiome = new Mot(new Symbole[]{A});
		
		Mot motRegle1 = new Mot(new char[]{'A','-','B','-','-','B','+','A','+','+','A','A','+','B','-'});
		Regles regle1 = new Regles(A, motRegle1);
		
		Mot motRegle2 = new Mot(new char[]{'+','A','-','B','B','-','-','B','-','A','+','+','A','+','B'});
		Regles regle2 = new Regles(B, motRegle2);
		
		while(n > 0) {
			axiome = Lsysteme.motSuivant(new Regles[] {regle1,regle2}, axiome);
			n--;
		}
		
		return axiome;
		
	}
}
