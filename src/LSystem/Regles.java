package LSystem;

public class Regles {
	public final Symbole symbole;
	public final Mot mot;
	
	public Regles(Symbole symbole, Mot mot){
		this.symbole = symbole;
		this.mot = mot;
	}
	public String toString() {
		return symbole.toString() + " -> " + mot.toString();
	}
}
