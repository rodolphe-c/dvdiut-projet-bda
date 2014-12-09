package dvdiut.controlleurs;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import dvdiut.modeles.Dvdiut;
import dvdiut.vues.EcranAjoutFilm;

/**
 * ControlleurEcranAjoutFilm
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranAjoutFilm 
{
	/**
	 * Teste si l'individu existe dans NVINDIVIDU
	 * 
	 * @param co Connexion
	 * @param nomRealisateur Nom
	 * @param prenomRealisateur Prénom
	 * @return Retourne vrai si l'individu existe dans la table ENS2004.INDIVIDU, faux sinon
	 */
	public boolean individuExiste(Connection co, String nomRealisateur, String prenomRealisateur)
	{	
		Dvdiut d = new Dvdiut();
		return d.individuExiste(co, nomRealisateur, prenomRealisateur);
	}
	
	/**
	 * Teste si l'individu existe dans NVINDIVIDU
	 * 
	 * @param co Connexion
	 * @param nom Nom
	 * @param prenom Prénom
	 * @return Retourne vrai si l'individu existe dans la table NVINDIVIDU, faux sinon
	 */
	public boolean nvIndividuExiste(Connection co, String nom, String prenom)
	{
		Dvdiut d = new Dvdiut();
		return d.nvIndividuExiste(co, nom, prenom);
	}
	
	/**
	 * Calcule le numéro de l'individu à ajouter
	 * 
	 * @param co Connexion
	 * @return Retourne un numéro d'individu
	 */
	public int calculNumIndividu(Connection co)
	{
		Dvdiut d = new Dvdiut();
		return d.calculNumIndividu(co);
	}
	
	/**
	 * Calcule le numéro du film à ajouter
	 * 
	 * @param co Connexion 
	 * @return Retourne un numéro de film 
	 */
	public int calculNumFilm(Connection co)
	{
		Dvdiut d = new Dvdiut();
		return d.calculNumFilm(co);
	}
	
	/**
	 * Ajouter un individu dans la base de données
	 * 
	 * @param co Connexion
	 * @param num Numéro de l'individu
	 * @param nom Nom de l'individu
	 * @param prenom Prénom de l'individu
	 * @param existe Existance de l'individu dans l'ancienne table
	 */
	public void ajouterIndividu(Connection co, int num, String nom, String prenom, String existe)
	{
		Dvdiut d = new Dvdiut();
		d.ajouterIndividu(co, num, nom, prenom, existe);
	}
	
	/**
	 * Indique le numéro de l'individu dans l'ancienne table
	 * 
	 * @param co Connexion
	 * @param nom Nom de l'individu
	 * @param prenom Prénom de l'individu
	 * @return Retourne le numéro de l'individu
	 */
	public int getNumIndividu(Connection co, String nom, String prenom)
	{
		Dvdiut d = new Dvdiut();
		return d.getNumIndividu(co, nom, prenom);
	}
	
	/**
	 * Indique le numéro de l'individu dans la nouvelle table
	 * 
	 * @param co Connexion
	 * @param nom Nom de l'individu
	 * @param prenom Prénom de l'individu
	 * @return Retourne le numéro de l'individu
	 */
	public int getNumNVIndividu(Connection co, String nom, String prenom)
	{
		Dvdiut d = new Dvdiut();
		return d.getNumNVIndividu(co, nom, prenom);
	}
	
	 /**
	 * Indique le code du genre sélectionné
	 * 
	 * @param co Connexion
	 * @param libelle Libellé du genre
	 * @return Retourne le code du genre
	 */
	public String getCodeGenre(Connection co, String libelle)
	{
		Dvdiut d = new Dvdiut();
		return d.getCodeGenre(co, libelle);
	}
	
	/**
	 * Ajoute un film dans la base de données
	 * 
	 * @param co Connexion
	 * @param numFilm Numéro du film
	 * @param titre Titre du film
	 * @param numRealisateur Numéro du réalisateur
	 */
	public void ajouterFilm(Connection co, int numFilm, String titre, int numRealisateur)
	{
		Dvdiut d = new Dvdiut();
		d.ajouterFilm(co, numFilm, titre, numRealisateur);
	}
	
	/**
	 * Ajouter un genre associé à un film
	 * 
	 * @param co Connexion
	 * @param numFilm Numéro du film
	 * @param code Code du genre
	 */
	public void ajouterGenreFilm(Connection co, int numFilm, String code)
	{
		Dvdiut d = new Dvdiut();
		d.ajouterGenreFilm(co, numFilm, code);
	}
	
	/**
	 * Ajouter une liste d'acteurs dans la base de données
	 * 
	 * @param co Connexion
	 * @param listeActeur Liste d'acteurs
	 * @param numFilm Numéro du film
	 */
	public void ajouterActeursNvIndividu(Connection co, DefaultListModel<?> listeActeur, int numFilm)
	{
		Dvdiut d = new Dvdiut();
		d.ajouterActeursNvIndividu(co, listeActeur, numFilm);
	}
	
	/**
	 * Ajouter un acteur dans la table NVACTEUR
	 * 
	 * @param co Connexion
	 * @param numFilm Numéro du film
	 * @param numActeur Numéro de l'acteur
	 */
	public void ajouterActeursNvActeur(Connection co, int numFilm, int numActeur)
	{
		Dvdiut d = new Dvdiut();
		d.ajouterActeurNvActeur(co, numFilm, numActeur);
	}	
	
	/**
	 * Ajouter la saisie des informations concernant un film
	 * 
	 * @param co Connexion
	 * @param titre Titre
	 * @param genre Genre
	 * @param nomRealisateur Nom du réalisateur
	 * @param prenomRealisateur Prénom du réalisateur
	 * @param listeActeur Liste d'acteurs
	 * @return Retourne vrai si l'ajout à bien été effectué, faux sinon
	 */
	public boolean ajouterSaisie(Connection co, String titre, String genre, String nomRealisateur, String prenomRealisateur, DefaultListModel<?> listeActeur)
	{
		Dvdiut d = new Dvdiut();
		return d.ajouterSaisie(co, titre, genre, nomRealisateur, prenomRealisateur, listeActeur);
	}
	
	/**
	 * Recupérer les genres enregistés dans ENS2004.GENRE
	 * 
	 * @param co Connexion
	 * @return Retourne une liste de genres
	 */
	public ArrayList<String> recupererGenre(Connection co)
	{
		Dvdiut d = new Dvdiut();
		return d.recupererGenre(co);
	}

	/**
	 * Redirection vers l'écran d'ajout de films
	 * 
	 * @param co Connexion
	 */
	public void afficherAjoutFilm(Connection co) 
	{
		EcranAjoutFilm e = new EcranAjoutFilm(co);
		e.setVisible(true);
	}
	
	/**
	 * Redirection vers l'écran de menu
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */ 
	public void retournerMenu(JFrame f, Connection co)
	{
		f.dispose();
		ControlleurEcranMenu c = new ControlleurEcranMenu();
		c.afficherMenu(co);
	}
}
