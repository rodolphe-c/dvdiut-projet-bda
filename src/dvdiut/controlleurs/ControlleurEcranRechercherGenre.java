package dvdiut.controlleurs;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import dvdiut.modeles.Dvdiut;
import dvdiut.modeles.Film;
import dvdiut.vues.EcranRechercherGenre;

/**
 * ControlleurEcranRechercherGenre
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranRechercherGenre {

	/**
	 * Afficher l'écran de rechercher par genres
	 * 
	 * @param co Connexion
	 */
	public void afficherRechercherGenre(Connection co) 
	{
		EcranRechercherGenre e = new EcranRechercherGenre(co);
		e.setVisible(true);
	}
	
	/**
	 * Redirection vers l'écran de recherche de films
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void retourRechercherFilm(JFrame f, Connection co)
	{
		f.dispose();
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
	public DefaultListModel<Film> initFilm(Connection co, String genre) 
	{
		Dvdiut d = new Dvdiut();
		return d.initFilm(co, genre);
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

}
