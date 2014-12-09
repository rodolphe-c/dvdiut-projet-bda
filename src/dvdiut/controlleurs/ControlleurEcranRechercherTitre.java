package dvdiut.controlleurs;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import dvdiut.modeles.Dvdiut;
import dvdiut.modeles.Film;
import dvdiut.vues.EcranRechercherTitre;

/**
 * ControlleurEcranRechercherTitre
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranRechercherTitre 
{
	/**
	 * Afficher l'écran de recherche par titres
	 * 
	 * @param co Connexion
	 */
	public void afficherRechercherTitre(Connection co) 
	{
		EcranRechercherTitre e = new EcranRechercherTitre(co);
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
	 * Récupérer un réalisateur
	 * 
	 * @param co Connexion
	 * @param f Film
	 * @return Retourne le nom et le prénom du réalisateur
	 */
	public HashMap<String, String> getRealisateur(Connection co, int f)
	{
		Dvdiut d = new Dvdiut();
		return d.getRealisateur(co, f);
	}
	
	/**
	 * Récupérer le numéro d'un film
	 * 
	 * @param co Connexion
	 * @param titre Titre
	 * @return Retourne le numéro du film
	 */
	public int getNumFilm(Connection co, String titre)
	{
		Dvdiut d = new Dvdiut();
		return d.getNumFilm(co, titre);
	}
	
	/**
	 * Rcupérer le genre
	 * 
	 * @param co Connexion
	 * @param numFilm Numéro du film
	 * @return Retourne le genre du film
	 */
	public String getGenre(Connection co, int numFilm)
	{
		Dvdiut d = new Dvdiut();
		return d.getGenre(co, numFilm);
	}
}
