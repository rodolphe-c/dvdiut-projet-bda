package dvdiut.controlleurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * OutilsJDBC
 * 
 * @author Rodolphe Cargnello
 * @author Kevin Vinchon 
 */
public class OutilsJDBC
{
	/**
	 * Fonction qui retourne la connexion à la base de donnée Oracle
	 * 
	 * @param url Informations pour se connecter
	 * @return Connexion
	 */
	public static Connection openConnection (String url) 
	{
		Connection co=null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co= DriverManager.getConnection(url);
			JOptionPane.showMessageDialog(null, "Connexion établie !");
			return co;
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("il manque le driver oracle");
			System.exit(1);
		}
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "La connexion n'a pu être établi. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	/**
	 * Fonction qui retourne le résultat de la requête passée en parametre 
	 * 
	 * @param requete Requete
	 * @param co Connexion
	 * @param type Type de la requête
	 * @return Résultat
	 */
	public static ResultSet exec1Requete (String requete, Connection co, int type)
	{
		ResultSet res=null;
		try 
		{
			Statement st;
			if (type==0)
			{
				st=co.createStatement();
			}
			else 
			{
				st=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					       	ResultSet.CONCUR_READ_ONLY);
			};
			res= st.executeQuery(requete);
		}
		catch (SQLException e)
		{
			System.out.println("Problème lors de l'exécution de la requete : "+requete);
		};
		return res;
	}

	/**
	 * Fonction qui ferme la connexion à la base de données Oracle
	 * 
	 * @param co Connexion
	 */
	public static void closeConnection(Connection co){
		try 
		{
			co.close();
			System.out.println("Connexion fermée");
		}
		catch (SQLException e) {
			System.out.println("Impossible de fermer la connexion");
		}	
	}
}
