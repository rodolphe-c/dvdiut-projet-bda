package dvdiut.controlleurs;

import java.sql.Connection;

import javax.swing.JFrame;

/**
 * ControlleurEcranConnexion
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
public class ControlleurEcranConnexion 
{	
	/**
	 * Redirection vers l'écran de menu
	 * 
	 * @param f JFrame
	 * @param co Connexion
	 */
	public void menu(JFrame f, Connection co) 
	{
		f.dispose();
		ControlleurEcranMenu c = new ControlleurEcranMenu();
		c.afficherMenu(co);
	}
}
