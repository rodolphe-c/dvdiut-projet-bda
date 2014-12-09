package dvdiut.controlleurs;

import java.sql.Connection;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import dvdiut.modeles.Dvdiut;
import dvdiut.modeles.Film;
import dvdiut.vues.EcranRechercherRealisateur;

/**
 * ControlleurEcranRechercherRealisateur
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranRechercherRealisateur {

	/**
	 * Afficher l'écran de recherche par réalisateurs
	 * 
	 * @param co Connexion
	 */
	public void afficherRechercherRealisateur(Connection co) 
	{
		EcranRechercherRealisateur e = new EcranRechercherRealisateur(co);
		e.setVisible(true);
	}
	
	/**
	 * Redirection vers l'écran de recherche de films
	 * 
	 * @param j
	 * @param co
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
	 * Retourne une liste de films
	 * 
	 * @param co Connexion
	 * @param nom Nom du réalisateur
	 * @param prenom Prénom du réalisateur
	 * @return Retourne une liste de films
	 */
	public DefaultListModel<Film> initFilmRealisateur(Connection co, String nom, String prenom) 
	{
		Dvdiut d = new Dvdiut();
		return d.initFilmRealisateur(co, nom, prenom);
	}

}
