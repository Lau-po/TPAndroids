package fr.univlille1.iutinfo.jmp.vacances;

import java.util.ArrayList;
/**
 * 
 * Modele de l'application 'Vacances'
 * @author jean-Marie.place@univ-lille1.fr
 *
 */
public class Modele {
	/**
	 * 
	 * @author jean-marie.place@univ-lille1.fr
	 * Classe interne qui centralise la gestion du compte d'un participant.
	 * Le mod�le lui-m�me est simplement mod�lis� comme un ArrayList<Compte>.
	 * Un compte est rep�r� soit par son indice dans  l'ArrayList, soit par
	 * le nom du participant.
	 */
	private class Compte {
		/**
		 * Le nom du participant.
		 */
		String nom ;
		/**
		 * Le solde du participant (n�gatif pour un d�bit, positif pour un cr�dit).
		 */
		double solde ;
		/**
		 * Constructeur.
		 * @param nom Le nom du participant concern�.
		 */
		public Compte(String nom) {
			this.nom = nom ;
			this.solde = 0 ;
		}
		/**
		 * Permet de v�rifier si le compte cibl� est bien celui du participant de nom {@leNom}.
		 * @param leNom Nom du participant.
		 * 
		 * @return true si le compte correspond.
		 */
		public boolean match(String leNom) {
			return leNom.equals(nom) ;
		}
		/**
		 * Modifie le solde de ce compte.
		 * @param delta Montant additionn� (soustrait si négatif) au solde.
		 */
		public void update(double delta) {
			solde += delta ;
		}
		/**
		 * Affiche le solde de ce compte.
		 * @return
		 */
		public double getSolde() {
			return solde ;
		}
	}
	/**
	 * Liste des comptes consid�r�s.
	 */
	protected ArrayList<Compte> comptes = new ArrayList<Compte>() ; 
	/**
	 * Constructeur. Cr�e un compte par �l�ment de tableau. Le nom du compte est initialis� par la valeur de l'�l�ment.
	 * On suppose que les noms sont tous différents.
	 * @param noms
	 */
	public Modele(String[] noms) {
		for (int i = 0 ; i < noms.length ; i++) {
			comptes.add(new Compte(noms[i])) ;
		}
	}
	public double getSolde(String nom) {
		double resultat = 0 ;
		for (Compte cpt : comptes) {
			if (cpt.match(nom)) {
				resultat = cpt.getSolde();
			}
		}
		return resultat ;
	}
	public double getSolde(int num) {
		return comptes.get(num).getSolde() ;
	}
	public void update(String nom, double valeur) {
		int diviseur = comptes.size() ;
		for (Compte cpt: comptes) {
			if (cpt.match(nom)) {
				cpt.update(valeur * (diviseur-1) / diviseur) ;
			} else {
				cpt.update(-valeur / diviseur) ;
			}
		}
	}
	public void update(int num, double valeur) {
		int diviseur = comptes.size() ;
		for (int i = 0 ; i < comptes.size(); i++) {
			Compte cpt = comptes.get(i) ;
			if (i == num) {
				cpt.update(valeur * (diviseur-1) / diviseur) ;
			} else {
				cpt.update(-valeur / diviseur) ;
			}
		}
	}
	public void update(double[] valeurs) {
		if (valeurs.length == comptes.size()) {
			for (int i = 0 ; i < valeurs.length; i++) {
				comptes.get(i).update(valeurs[i]) ;
			}
		}
	}
}
