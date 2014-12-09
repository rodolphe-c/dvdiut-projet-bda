package dvdiut.modeles;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

import dvdiut.controlleurs.OutilsJDBC;

/**
 * DVDIUT
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class Dvdiut 
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
		String existe = new String();
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call IndividuExiste (?, ?)}");
			cst.setString (2, nomRealisateur);
			cst.setString (3, prenomRealisateur);
			cst.registerOutParameter (1,java.sql.Types.VARCHAR);
			
			cst.execute();
			existe = cst.getString (1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème individuExiste()");
		}
		if(existe.equals("oui"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Teste si l'individu existe dans NVINDIVIDU
	 * 
	 * @param co Connexion
	 * @param nomRealisateur Nom
	 * @param prenomRealisateur Prénom
	 * @return Retourne vrai si l'individu existe dans la table NVINDIVIDU, faux sinon
	 */
	public boolean nvIndividuExiste(Connection co, String nom, String prenom)
	{
		String existe = new String();
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call nvIndividuExiste (?, ?)}");
			cst.setString (2, nom);
			cst.setString (3, prenom);
			cst.registerOutParameter (1,java.sql.Types.VARCHAR);
			
			cst.execute();
			existe = cst.getString (1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème nvIndividuExiste()");
		}
		if(existe.equals("oui"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Calcule le numéro de l'individu à ajouter
	 * 
	 * @param co Connexion
	 * @return Retourne un numéro d'individu
	 */
	public int calculNumIndividu(Connection co)
	{
		int nbIndividu = 0;
		int nbNVIndividu = 0;
		try 
		{
			CallableStatement cst = co.prepareCall ("{ ? = call nbreIndividu}");
			cst.registerOutParameter (1,java.sql.Types.NUMERIC);
			cst.execute();
			nbIndividu = cst.getInt(1);
			cst.close();
		} 
		catch(Exception e)
		{
			System.out.println("Problème calculNumIndividu()");
		}
		try 
		{
			CallableStatement cst = co.prepareCall ("{ ? = call nbreNVIndividu}");
			cst.registerOutParameter (1,java.sql.Types.NUMERIC);
			cst.execute();
			nbNVIndividu = cst.getInt(1);
			cst.close();
		} 
		catch(Exception e)
		{
			System.out.println("Problème calculNumIndividu()");
		}	
		
		return nbIndividu + nbNVIndividu;
	}
	
	/**
	 * Teste si le film existe dans la table ENS2004.FILM
	 * 
	 * @param co Connexion
	 * @param titre Titre
	 * @return Retourne vrai si le film existe dans ENS2004.FILM, faux sinon
	 */
	public boolean filmExiste(Connection co, String titre)
	{	
		String existe = new String();
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call FilmExiste (?)}");
			cst.setString (2, titre);
			cst.registerOutParameter (1,java.sql.Types.VARCHAR);
			cst.execute();
			existe = cst.getString (1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème filmExiste");
		}
		if(existe.equals("oui"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Teste si le film existe dans la table NVFILM
	 * 
	 * @param co Connexion
	 * @param titre Titre
	 * @return Retourne vrai si le film existe dans NVFILM, faux sinon
	 */
	public boolean nvFilmExiste(Connection co, String titre)
	{	
		String existe = new String();
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call NvFilmExiste (?)}");
			cst.setString (2, titre);
			cst.registerOutParameter (1,java.sql.Types.VARCHAR);
			cst.execute();
			existe = cst.getString (1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème nvFilmExiste");
		}
		if(existe.equals("oui"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Calcule le numéro du film à ajouter
	 * 
	 * @param co Connexion 
	 * @return Retourne un numéro de film 
	 */
	public int calculNumFilm(Connection co)
	{
		int nbFilm = 0;
		int nbNVFilm = 0;
		try 
		{
			CallableStatement cst = co.prepareCall ("{ ? = call nbreFilms}");
			cst.registerOutParameter (1,java.sql.Types.NUMERIC);
			cst.execute();
			nbFilm = cst.getInt(1);
			cst.close();
		} 
		catch(Exception e)
		{
			System.out.println("Problème calculNumFilm()");
		}
		try 
		{
			CallableStatement cst = co.prepareCall ("{ ? = call nbreNVFilms}");
			cst.registerOutParameter (1,java.sql.Types.NUMERIC);
			cst.execute();
			nbNVFilm = cst.getInt(1);
			cst.close();
		} 
		catch(Exception e)
		{
			System.out.println("Problème calculNumFilm()");
		}	
		
		return nbFilm + nbNVFilm;
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
		try
		{
			CallableStatement cst = co.prepareCall ("{call ajouterRealisateur (?, ?, ?, ?)}");
			cst.setInt (1, num);
			cst.setString (2, nom);
			cst.setString (3, prenom);
			cst.setString(4, existe);
			cst.execute();
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème ajouterIndividu()");
		}
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
		int numIndividu = 0;
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call getNumIndividu (?, ?)}");
			cst.setString (2, nom);
			cst.setString (3, prenom);
			cst.registerOutParameter (1,java.sql.Types.NUMERIC);
			cst.execute();
			numIndividu = cst.getInt(1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème getNumIndividu()");
		}
		return numIndividu;
	}
	
	/**
	 * Indique le numéro de l'individu dans la nouvelle table
	 * 
	 * @param co Connexion
	 * @param nom Nom de l'individu
	 * @param prenom Prénom de l'individu
	 * @return Retourne le numéro de l'individu
	 */
	public int getNumNVIndividu(Connection co, String nomIndividu, String prenomIndividu)
	{
		int numIndividu = 0;
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call getNumNVIndividu (?, ?)}");
			cst.setString (2, nomIndividu);
			cst.setString (3, prenomIndividu);
			cst.registerOutParameter (1,java.sql.Types.NUMERIC);
			cst.execute();
			numIndividu = cst.getInt(1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème getNumNVIndividu()");
		}
		return numIndividu;
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
		String code = new String();
		try
		{
			CallableStatement cst = co.prepareCall ("{ ? = call getCodeGenre (?)}");
			cst.setString (2, libelle);
			cst.registerOutParameter (1,java.sql.Types.VARCHAR);
			cst.execute();
			code = cst.getString(1);
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème getCodeGenre()");
		}
		return code;
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
		try
		{
			CallableStatement cst = co.prepareCall ("{ call ajouterFilm (?, ?, ?)}");
			cst.setInt (1, numFilm);
			cst.setString (2, titre);
			cst.setInt (3, numRealisateur);
			cst.execute();
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème ajouterFilm()");
		}
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
		try
		{
			CallableStatement cst = co.prepareCall ("{ call ajouterNVGenreFilm (?, ?)}");
			cst.setInt (1, numFilm);
			cst.setString (2, code);
			cst.execute();
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème ajouterGenreFilm()");
		}
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
		
		for(int i = 0; i<listeActeur.getSize(); i++)
		{
			int numActeur = 0;
			if(individuExiste(co, ((Individu)listeActeur.getElementAt(i)).getNom(), ((Individu)listeActeur.getElementAt(i)).getPrenom()))
			{
				if(!nvIndividuExiste(co, ((Individu)listeActeur.getElementAt(i)).getNom(), ((Individu)listeActeur.getElementAt(i)).getPrenom()))
				{
					numActeur =getNumIndividu(co, ((Individu)listeActeur.getElementAt(i)).getNom(), ((Individu)listeActeur.getElementAt(i)).getPrenom());
					ajouterIndividu(co, numActeur, ((Individu)listeActeur.getElementAt(i)).getNom(), ((Individu)listeActeur.getElementAt(i)).getPrenom(), "oui");
					ajouterActeurNvActeur(co, numFilm, numActeur);
				}
			}
			else
			{
				if(!nvIndividuExiste(co, ((Individu)listeActeur.getElementAt(i)).getNom(), ((Individu)listeActeur.getElementAt(i)).getPrenom()))
				{
					numActeur =calculNumIndividu(co)+1;
					ajouterIndividu(co, numActeur, ((Individu)listeActeur.getElementAt(i)).getNom(), ((Individu)listeActeur.getElementAt(i)).getPrenom(), "non");
					ajouterActeurNvActeur(co, numFilm, numActeur);
				}
			}
		}
	}
	
	/**
	 * Ajouter un acteur dans la table NVACTEUR
	 * 
	 * @param co Connexion
	 * @param numFilm Numéro du film
	 * @param numActeur Numéro de l'acteur
	 */
	public void ajouterActeurNvActeur(Connection co, int numFilm, int numActeur)
	{
		try
		{
			CallableStatement cst = co.prepareCall ("{ call ajouterNVActeur (?, ?)}");
			cst.setInt (1, numFilm);
			cst.setInt (2, numActeur);
			cst.execute();
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Problème ajouterActeursNvActeur()");
		}
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
		try
		{
			int numRealisateur = 0;
			int numFilm = 0;
			
			/// AJOUT DU FILM
			if(filmExiste(co,titre))
			{
				if(nvFilmExiste(co,titre))
				{
					return false;
				}
				else
				{
					/// AJOUT DU REALISATEUR
					if(individuExiste(co, nomRealisateur, prenomRealisateur))
					{
						if(!nvIndividuExiste(co, nomRealisateur, prenomRealisateur))
						{
							numRealisateur = getNumIndividu(co, nomRealisateur, prenomRealisateur);
							ajouterIndividu(co, numRealisateur, nomRealisateur, prenomRealisateur, "oui");
						}
						else
						{
							numRealisateur = getNumNVIndividu(co, nomRealisateur, prenomRealisateur);
						}
					}
					else
					{
						if(!nvIndividuExiste(co, nomRealisateur, prenomRealisateur))
						{
							numRealisateur = calculNumIndividu(co)+1;
							ajouterIndividu(co, numRealisateur, nomRealisateur, prenomRealisateur, "non");
						}
						else
						{
							numRealisateur = getNumNVIndividu(co, nomRealisateur, prenomRealisateur);
						}
					}
					numFilm = calculNumFilm(co)+1;
					ajouterFilm(co, numFilm, titre, numRealisateur);
				}
			}
			else
			{
				if(nvFilmExiste(co,titre))
				{
					return false;
				}
				else
				{
					/// AJOUT DU REALISATEUR
					if(individuExiste(co, nomRealisateur, prenomRealisateur))
					{
						if(!nvIndividuExiste(co, nomRealisateur, prenomRealisateur))
						{
							numRealisateur = getNumIndividu(co, nomRealisateur, prenomRealisateur);
							ajouterIndividu(co, numRealisateur, nomRealisateur, prenomRealisateur, "oui");
						}
						else
						{
							numRealisateur = getNumNVIndividu(co, nomRealisateur, prenomRealisateur);
						}
					}
					else
					{
						if(!nvIndividuExiste(co, nomRealisateur, prenomRealisateur))
						{
							numRealisateur = calculNumIndividu(co)+1;
							ajouterIndividu(co, numRealisateur, nomRealisateur, prenomRealisateur, "non");
						}
						else
						{
							numRealisateur = getNumNVIndividu(co, nomRealisateur, prenomRealisateur);
						}
					}
					numFilm = calculNumFilm(co)+1;
					ajouterFilm(co, numFilm, titre, numRealisateur);
				}
				
			}
			
			/// AJOUT DES ACTEURS
			ajouterActeursNvIndividu(co, listeActeur, numFilm);
		
			/// AJOUT GENRE FILM
			ajouterGenreFilm(co, numFilm, getCodeGenre(co, genre));
		}
		catch(Exception e)
		{
			
		}
		return true;
	}
	
	/**
	 * Recupérer les genres enregistés dans ENS2004.GENRE
	 * 
	 * @param co Connexion
	 * @return Retourne une liste de genres
	 */
	public ArrayList<String> recupererGenre(Connection co)
	{
		ArrayList<String> genres = new ArrayList<String>();
		String requete = new String("SELECT DISTINCT libelleGenre FROM ENS2004.GENRE ORDER BY libelleGenre");
		ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
		try 
		{
			while(resultat1.next())
			{ 
				genres.add(resultat1.getString("libelleGenre"));
			}
		} 
		catch(Exception e)
		{
				
		}
			return genres;
	}
	
	/**
	 * Récupérer une liste de films
	 * 
	 * @param co Connexion
	 * @param nom Nom de l'acteur
	 * @param prenom Prénom de l'acteur
	 * @return Retourne une liste de films
	 */
	public DefaultListModel<Film> initFilm(Connection co, String nom, String prenom) 
	{
		DefaultListModel<Film> liste = new DefaultListModel<Film>();
		try
		{
			String requete = new String("SELECT F.numFilm, F.titre, G.LIBELLEGENRE FROM ENS2004.FILM F, ENS2004.INDIVIDU I, ENS2004.ACTEUR A, ENS2004.GENRE G, ENS2004.GENREFILM GF WHERE A.NUMFILM = F.NUMFILM  AND F.NUMFILM = GF.NUMFILM AND GF.CODEGENRE = G.CODEGENRE AND A.NUMINDIVIDU = I.NUMINDIVIDU AND I.NomIndividu = '"+nom.toUpperCase()+"' AND I.PrenomIndividu = '"+prenom.toUpperCase()+"' UNION SELECT F.numFilm, F.titre, G.LIBELLEGENRE FROM NVFILM F, NVINDIVIDU I, NVACTEUR A, ENS2004.GENRE G, NVGENREFILM GF WHERE A.NUMFILM = F.NUMFILM AND F.NUMFILM = GF.NUMFILM AND GF.CODEGENRE = G.CODEGENRE AND A.NUMINDIVIDU = I.NUMINDIVIDU  AND I.NomIndividu = '"+nom.toUpperCase()+"' AND I.PrenomIndividu = '"+prenom.toUpperCase()+"'");
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				Film a = new Film(resultat1.getInt("numFilm"), resultat1.getString("Titre"), nom, prenom,resultat1.getString("LIBELLEGENRE"));
				System.out.println(a);
				liste.addElement(a);
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur");
		}
		return liste;
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
		ArrayList<String> liste = new ArrayList<String>();
		try
		{
			String requete = new String("SELECT I.NomIndividu, I.PrenomIndividu FROM ENS2004.FILM F, ENS2004.ACTEUR A, ENS2004.INDIVIDU I WHERE A.numFilm = F.numFilm AND A.NumIndividu = I.numIndividu AND A.NumFilm ="+f.getNumFilm()+" UNION SELECT I.NomIndividu, I.PrenomIndividu FROM NVFILM F, NVACTEUR A, NVINDIVIDU I WHERE A.numFilm = F.numFilm AND A.NumIndividu = I.numIndividu AND A.NumFilm = "+f.getNumFilm()+"");
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				liste.add(resultat1.getString("nomIndividu")+" "+resultat1.getString("prenomIndividu")+"\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur");
		}
		
		return liste;
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
		DefaultListModel<Film> liste = new DefaultListModel<Film>();
		try
		{
			String requete = new String("SELECT F.numFilm, F.titre, I.numIndividu, I.NOMINDIVIDU, I.PRENOMINDIVIDU FROM ENS2004.FILM F, ENS2004.GENRE G, ENS2004.GENREFILM GF, ENS2004.INDIVIDU I WHERE GF.NUMFILM = F.NUMFILM AND GF.CODEGENRE = G.CODEGENRE AND F.REALISATEUR = I.NUMINDIVIDU AND G.LIBELLEGENRE = '"+genre.toUpperCase()+"' UNION SELECT F.numFilm, F.titre, I.numIndividu, I.NOMINDIVIDU, I.PRENOMINDIVIDU FROM NVFILM F, ENS2004.GENRE G, NVGENREFILM GF, NVINDIVIDU I WHERE GF.NUMFILM = F.NUMFILM AND GF.CODEGENRE = G.CODEGENRE AND F.REALISATEUR = I.NUMINDIVIDU AND G.LIBELLEGENRE = '"+genre.toUpperCase()+"'");
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				Film a = new Film(resultat1.getInt("numFilm"), resultat1.getString("Titre"), resultat1.getString("nomindividu"), resultat1.getString("nomindividu"), genre);
				System.out.println(a);
				liste.addElement(a);
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur");
		}
		return liste;
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
		HashMap<String,String> realisateur = new HashMap<String,String>();
		try
		{
			String requete = new String("SELECT F.NUMFILM, I.NUMINDIVIDU, I.NOMINDIVIDU, I.PRENOMINDIVIDU FROM ENS2004.FILM F, ENS2004.INDIVIDU I  WHERE I.numIndividu = F.realisateur AND F.NUMFILM = "+f+ " Union SELECT F.NUMFILM, I.NUMINDIVIDU, I.NOMINDIVIDU, I.PRENOMINDIVIDU FROM NVFILM F, NVINDIVIDU I  WHERE I.numIndividu = F.realisateur AND F.NUMFILM = "+f+ "" );
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				realisateur.put("nom", resultat1.getString("nomIndividu"));
				realisateur.put("prenom", resultat1.getString("prenomIndividu"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur");
		}
		
		return realisateur;
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
		int numFilm = 0;
		try
		{
			String requete = new String("SELECT NUMFILM FROM ENS2004.FILM WHERE TITRE = '"+titre.toUpperCase()+"' UNION SELECT NUMFILM FROM NVFILM WHERE TITRE = '"+titre.toUpperCase()+"'" );
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				numFilm = resultat1.getInt("NUMFILM");
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur num");
		}
		
		return numFilm;
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
		String genre = new String();
		try
		{
			String requete = new String("SELECT G.LIBELLEGENRE FROM ENS2004.GENRE G, ENS2004.GENREFILM GF WHERE GF.CODEGENRE = G.CODEGENRE AND GF.NUMFILM = "+numFilm+" UNION SELECT G.LIBELLEGENRE FROM ENS2004.GENRE G, NVGENREFILM GF WHERE GF.CODEGENRE = G.CODEGENRE AND GF.NUMFILM = "+numFilm+"" );
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				genre = resultat1.getString("LIBELLEGENRE");
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur num");
		}
		
		return genre;
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
		DefaultListModel<Film> liste = new DefaultListModel<Film>();
		try
		{
			String requete = new String("SELECT F.NUMFILM, F.titre, G.LIBELLEGENRE FROM ENS2004.FILM F, ENS2004.INDIVIDU I, ENS2004.GENRE G, ENS2004.GENREFILM GF WHERE I.numIndividu = F.realisateur  AND F.NUMFILM = GF.NUMFILM AND GF.CODEGENRE = G.CODEGENRE AND I.NomIndividu = '"+nom.toUpperCase()+"'  AND I.PrenomIndividu = '"+prenom.toUpperCase()+"' UNION SELECT F.NUMFILM, F.TITRE, G.LIBELLEGENRE FROM NVFILM F, NVINDIVIDU I, ENS2004.GENRE G, NVGENREFILM GF WHERE I.numIndividu = F.realisateur  AND F.NUMFILM = GF.NUMFILM AND GF.CODEGENRE = G.CODEGENRE AND I.NomIndividu = '"+nom.toUpperCase()+"' AND I.PrenomIndividu = '"+prenom.toUpperCase()+"'");
			ResultSet resultat1 = OutilsJDBC.exec1Requete(requete,co,1);
			while(resultat1.next())
			{ 
				Film a = new Film(resultat1.getInt("numFilm"), resultat1.getString("Titre"), nom, prenom, resultat1.getString("LIBELLEGENRE"));
				System.out.println(a);
				liste.addElement(a);
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur");
		}
		return liste;
	}

	
}
