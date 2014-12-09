package dvdiut.controlleurs;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;

import dvdiut.vues.EcranStatistiques;

/**
 * ControlleurEcranStatistiques
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranStatistiques 
{	
	/**
	 * Initialiser le tableau des acteurs
	 * 
	 * @return Tableau de statistiques d'acteurs
	 */
	public Object[][] initTableauActeur(Connection co)
	{
		String requete = new String("SELECT I.nomIndividu, I.prenomIndividu, COUNT(*) AS nbFilms FROM ENS2004.FILM F, ENS2004.ACTEUR A, ENS2004.INDIVIDU I WHERE F.numFilm = A.numFilm AND A.numIndividu = I.numIndividu GROUP BY I.numIndividu, I.nomIndividu, I.prenomIndividu ORDER BY nbFilms DESC");
		ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
		
		Object[][] a = new Object[10][3];
		
		try 
		{
			int i = 0;
			while(resultat1.next() && i<10)
			{ 
				a[i][0]= resultat1.getString("nomIndividu");
				a[i][1]= resultat1.getString("prenomIndividu");
				a[i][2]= resultat1.getString("nbFilms");
				i++;
			}
		} 
		catch(Exception e)
		{
			System.out.println("ERREUR");
		}
		
		return a;
	}
	
	/**
	 * Initialiser le tableau des réalisateurs
	 * 
	 * @return Tableau de statistiques de réalisateurs
	 */
	public Object[][] initTableauRealisateur(Connection co)
	{
		String requete = new String("SELECT I.nomIndividu, I.prenomIndividu, COUNT(*) AS nbFilms FROM ENS2004.FILM F, ENS2004.INDIVIDU I WHERE F.realisateur = I.numIndividu GROUP BY I.numIndividu, I.nomIndividu, I.prenomIndividu ORDER BY nbFilms DESC");
		ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
		
		Object[][] a = new Object[10][3];
		
		try 
		{
			int i = 0;
			while(resultat1.next() && i<10)
			{ 
				a[i][0]= resultat1.getString("nomIndividu");
				a[i][1]= resultat1.getString("prenomIndividu");
				a[i][2]= resultat1.getString("nbFilms");
				i++;
			}
		} 
		catch(Exception e)
		{
			System.out.println("ERREUR REALISATEUR");
		}
		
		return a;
	}
	
	/**
	 * Initialiser le tableau des genres
	 * 
	 * @return Tableau de statistiques de genres
	 */
	public Object[][] initTableauGenre(Connection co)
	{
		String requete = new String("SELECT G.CODEGENRE, G.LIBELLEGENRE, COUNT(*) AS nbFilms FROM ENS2004.GENRE G, ENS2004.GENREFILM GF WHERE G.CODEGENRE = GF.CODEGENRE  GROUP BY G.CODEGENRE, G.LIBELLEGENRE ORDER BY nbFilms DESC");
		
		ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
		
		Object[][] a = new Object[10][3];
		
		try 
		{
			int i = 0;
			while(resultat1.next() && i<10)
			{ 
				a[i][0]= resultat1.getString("LIBELLEGENRE");
				a[i][1]= resultat1.getString("CODEGENRE");
				a[i][2]= resultat1.getString("nbFilms");
				i++;
			}
		} 
		catch(Exception e)
		{
			System.out.println("ERREUR");
		}
		
		return a;
	}

	/**
	 * Afficher l'écran des statistiques
	 * 
	 * @param co Connexion
	 */
	public void afficherStatistiques(Connection co) 
	{
		EcranStatistiques e = new EcranStatistiques(co);
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
