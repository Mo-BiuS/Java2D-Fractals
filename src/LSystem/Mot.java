package LSystem;

public class Mot {
	public final Symbole mot[];
	
	public Mot(Symbole mot[]) {
		this.mot = mot;
	}
	public Mot(char mot[]) {
		this.mot = new Symbole[mot.length];
		for(int i = 0; i < mot.length; i++) this.mot[i] = new Symbole(mot[i]);
	}
	public String toString() {
		String s = "";
		for(Symbole symbole : mot) {
			s = s.concat(symbole.toString());
		}
		return s;
	}
}
