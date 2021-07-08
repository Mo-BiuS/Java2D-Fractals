package LSystem;
import java.util.ArrayList;

public class Lsysteme {
	public final static Mot motSuivant(Regles regles, Mot motActuel) {
		ArrayList<Symbole> list = new ArrayList<Symbole>();
		for(Symbole symbole : motActuel.mot) {
			if(regles.symbole.s == symbole.s) {
				for(Symbole symboleRegles : regles.mot.mot)list.add(symboleRegles);
			}
			else {
				list.add(symbole);
			}
		}
		
		Symbole[] array = new Symbole[list.size()];
		for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
		return new Mot(array);
	}
	
	public final static Mot motSuivant(Regles regles[], Mot motActuel) {
		ArrayList<Symbole> list = new ArrayList<Symbole>();
		for(Symbole symbole : motActuel.mot) {
			for(Regles regleActuelle : regles) {
				if(regleActuelle.symbole.s == symbole.s) {
					for(Symbole symboleRegles : regleActuelle.mot.mot)list.add(symboleRegles);
					break;
				}
				else {
					list.add(symbole);
				}
			}
		}
		
		Symbole[] array = new Symbole[list.size()];
		for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
		return new Mot(array);
	}
}
