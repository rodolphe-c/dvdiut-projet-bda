package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import dvdiut.controlleurs.ControlleurEcranStatistiques;
import dvdiut.interfaces.NavigationMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * EcranStatistique
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranStatistiques extends JFrame implements ActionListener, NavigationMenu {

	private JPanel contentPane;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JButton btnRetour;
	private ControlleurEcranStatistiques controlleur;
	private Connection co;


	/**
	 * Constructeur
	 * 
	 * @param co Connexion
	 */
	public EcranStatistiques(Connection co) 
	{
		this.co = co;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		JPanel pnlBouton = new JPanel();
		pnlBouton.add(btnRetour);
		contentPane.add(pnlBouton, BorderLayout.SOUTH);
		
		controlleur = new ControlleurEcranStatistiques();
		
		JPanel pnlTitre = new JPanel();
		contentPane.add(pnlTitre, BorderLayout.NORTH);
		pnlTitre.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(EcranStatistiques.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(lblLogo, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		pnlTitre.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblStatisiques = new JLabel("Statisiques");
		panel_1.add(lblStatisiques);
		
		JPanel pnlStatistiques = new JPanel();
		contentPane.add(pnlStatistiques, BorderLayout.CENTER);
		pnlStatistiques.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlRealisateur = new JPanel();
		JPanel pnlActeur = new JPanel();
		JPanel pnlGenre = new JPanel();
		
		
		JTabbedPane tbpStatistiques = new JTabbedPane(JTabbedPane.TOP);
		
		Object[][] data1 = initTableauRealisateur();
		String title1[] = {"Nom", "Prénom", "Nb Films"};
		table1 = new JTable(data1, title1);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(table1);
		pnlRealisateur.setLayout(new BorderLayout(0, 0));
		pnlRealisateur.add(scrollpane);
		tbpStatistiques.add("Top 10 Réalisateurs", pnlRealisateur);
		
		Object[][] data2 = initTableauActeur();
		String title2[] = {"Nom", "Prénom", "Nb Films"};
		table2 = new JTable(data2, title2);
		JScrollPane scrollpane2 = new JScrollPane();
		scrollpane2.setViewportView(table2);
		pnlActeur.setLayout(new BorderLayout(0, 0));
		pnlActeur.add(scrollpane2);
		tbpStatistiques.add("Top 10 Acteurs", pnlActeur);
		
		Object[][] data3 = initTableauGenre();
		String title3[] = {"Libellé", "Code", "Nb Films"};
		table3 = new JTable(data3, title3);
		JScrollPane scrollpane3 = new JScrollPane();
		scrollpane3.setViewportView(table3);
		pnlGenre.setLayout(new BorderLayout(0, 0));
		pnlGenre.add(scrollpane3);
		tbpStatistiques.add("Top 10 Genres", pnlGenre);
		
		pnlStatistiques.add(tbpStatistiques, BorderLayout.CENTER);
	}
	
	/**
	 * Initialiser le tableau des acteurs
	 * 
	 * @return Tableau de statistiques d'acteurs
	 */
	public Object[][] initTableauActeur()
	{
		return controlleur.initTableauActeur(co);
	}
	
	/**
	 * Initialiser le tableau des réalisateurs
	 * 
	 * @return Tableau de statistiques de réalisateurs
	 */
	public Object[][] initTableauRealisateur()
	{
		return controlleur.initTableauRealisateur(co);
	}
	
	/**
	 * Initialiser le tableau des genres
	 * 
	 * @return Tableau de statistiques de genres
	 */
	public Object[][] initTableauGenre()
	{
		return controlleur.initTableauGenre(co);
	}

	@Override
	public void retournerMenu()
	{
		controlleur.retournerMenu(this, co);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnRetour))
		{
			retournerMenu();
		}
		
	}

}
