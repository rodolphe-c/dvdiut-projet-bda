package dvdiut.controlleurs;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import dvdiut.modeles.Dvdiut;
import dvdiut.modeles.Film;
import dvdiut.vues.EcranRechercherActeur;

/**
 * ControlleurEcranRechercherActeur
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranRechercherActeur 
{
	/**
	 * Afficher l'écran de recherche par acteur
	 * 
	 * @param co Connexion
	 */
	public void afficherRechercherActeur(Connection co) 
	{
		EcranRechercherActeur e = new EcranRechercherActeur(co);
		e.setVisible(true);
	}
	
	/**
	 * Redirection vers l'écran de recherche de films
	 * 
	 * @param j JFrame
	 * @param co Connexion
	 */
	public void retourRechercherFilm(JFrame j, Connection co)
	{
		j.dispose();
		ControlleurEcranRechercherFilm c = new ControlleurEcranRechercherFilm();
		c.afficherRechercherFilm(co);
	}
	
	/**
	 * Récupérer une liste d'acteurs
	 * 
	 * @param co Connexion
	 * @param f Film
	 * @return Retourne une liste d'acteurs
	 */
	public ArrayList<String> getActeurs(Connection co, Film f)
	{
		Dvdiut d = new Dvdiut();
		return d.getActeurs(co, f);
	}
	
	/**
	 * Récuperer une liste de films
	 * 
	 * @param co Connexion
	 * @param genre Genre
	 * @return Retourne une liste de films
	 */
	public DefaultListModel<Film> initFilm(Connection co, String nom, String prenom) 
	{
		Dvdiut d = new Dvdiut();
		return d.initFilm(co, nom, prenom);
	}
}
