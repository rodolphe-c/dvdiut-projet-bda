package dvdiut.controlleurs;

import java.sql.Connection;

import javax.swing.JFrame;

import dvdiut.vues.EcranRechercherFilm;

/**
 * ControlleurEcranRechercherFilm
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranRechercherFilm 
{

	/**
	 * Afficher l'écran de recherche de films
	 * 
	 * @param co Connexion
	 */
	public void afficherRechercherFilm(Connection co) 
	{
		EcranRechercherFilm e = new EcranRechercherFilm(co);
		e.setVisible(true);
	}
	
	/**
	 * Redirection vers l'écran de recherche par acteurs
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void rechercherActeur(JFrame f,Connection co) 
	{
		f.dispose();
		ControlleurEcranRechercherActeur c = new ControlleurEcranRechercherActeur();
		c.afficherRechercherActeur(co);
	}

	/**
	 * Redirection vers l'écran de recherche par réalisateurs
	 *  
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void rechercherRealisateur(JFrame f,Connection co) 
	{
		f.dispose();
		ControlleurEcranRechercherRealisateur c = new ControlleurEcranRechercherRealisateur();
		c.afficherRechercherRealisateur(co);
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

	/**
	 * Redirection vers l'écran de recherche par titres
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void rechercherTitre(JFrame f, Connection co) 
	{
		f.dispose();
		ControlleurEcranRechercherTitre c = new ControlleurEcranRechercherTitre();
		c.afficherRechercherTitre(co);
	}

	/**
	 * Redirection vers l'écran de recherche par genres
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void rechercherGenre(JFrame f, Connection co) 
	{
		f.dispose();
		ControlleurEcranRechercherGenre c = new ControlleurEcranRechercherGenre();
		c.afficherRechercherGenre(co);
	}

}
