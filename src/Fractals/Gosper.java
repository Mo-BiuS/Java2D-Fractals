package Fractals;

import java.awt.Graphics2D;

import LSystem.Lsysteme;
import LSystem.Mot;
import LSystem.Regles;
import LSystem.Symbole;

public class Gosper{
	private static Mot getMot(int n){
		Symbole A = new Symbole('A');
		Symbole B = new Symbole('B');
		
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
	
	public static void draw(int size, int n, Graphics2D g2d) {
		Mot mot = getMot(n);
		System.out.println(mot);
		
		for(Symbole symbole : mot.mot) {
			switch(symbole.s) {
			case 'A':
				g2d.drawLine(0, 0, 0, size);
				g2d.translate(0,size);
				break;
			case 'B':
				g2d.drawLine(0, 0, 0, size);
				g2d.translate(0,size);
				break;
			case '+':
				g2d.rotate(Math.toRadians(60));
				break;
			case '-':
				g2d.rotate(Math.toRadians(-60));
				break;
			}
		}
		
	}
}
