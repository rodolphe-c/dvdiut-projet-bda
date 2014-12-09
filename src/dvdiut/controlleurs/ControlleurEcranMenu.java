package dvdiut.controlleurs;

import java.sql.Connection;

import javax.swing.JFrame;

import dvdiut.vues.EcranMenu;

/**
 * ControlleurEcranMenu
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranMenu 
{	
	/**
	 * Afficher le menu
	 * 
	 * @param co Connexion
	 */
	public void afficherMenu(Connection co) 
	{
		EcranMenu e = new EcranMenu(co);
		e.setVisible(true);
	}

	/**
	 * Redirection vers l'écran d'ajout de films
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void ajoutFilm(JFrame f, Connection co) 
	{
		f.dispose();
		ControlleurEcranAjoutFilm c = new ControlleurEcranAjoutFilm();
		c.afficherAjoutFilm(co);
	}

	/**
	 * Redirection vers l'écran des statistiques
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void statistiques(JFrame f, Connection co) 
	{
		f.dispose();
		ControlleurEcranStatistiques c = new ControlleurEcranStatistiques();
		c.afficherStatistiques(co);
	}

	/**
	 * Redirection vers l'écran de recherche de films
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void rechercherFilm(JFrame f, Connection co) 
	{
		f.dispose();
		ControlleurEcranRechercherFilm c = new ControlleurEcranRechercherFilm();
		c.afficherRechercherFilm(co);
	}
}
