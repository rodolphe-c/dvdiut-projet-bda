package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dvdiut.controlleurs.ControlleurEcranMenu;
import dvdiut.controlleurs.OutilsJDBC;

import java.awt.Color;
import java.sql.Connection;

/**
 * EcranMenu
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAjouterFilm;
	private JButton btnRechercherFilm;
	private JButton btnStatistique;
	private JButton btnQuitter;
	private ControlleurEcranMenu controlleur;
	private Connection co;
	
	/**
	 * Constructeur
	 * 
	 * @param co
	 */
	public EcranMenu(Connection co) 
	{
		this.co = co;
		controlleur = new ControlleurEcranMenu();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel pnlTitre = new JPanel();
		pnlTitre.setBackground(Color.WHITE);
		contentPane.add(pnlTitre, BorderLayout.NORTH);
		pnlTitre.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EcranMenu.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(label);
		
		JLabel lblBienvenueSurDvdiut = new JLabel("Bienvenue sur DVDIUT");
		pnlTitre.add(lblBienvenueSurDvdiut);
		
		JPanel pnlChoix = new JPanel();
		pnlChoix.setBackground(Color.WHITE);
		contentPane.add(pnlChoix, BorderLayout.CENTER);
		pnlChoix.setLayout(new GridLayout(3, 1, 0, 0));
		
		btnAjouterFilm = new JButton("Ajouter un film");
		btnAjouterFilm.addActionListener(this);
		pnlChoix.add(btnAjouterFilm);
		
		btnRechercherFilm = new JButton("Rechercher un film");
		btnRechercherFilm.addActionListener(this);
		pnlChoix.add(btnRechercherFilm);
		
		btnStatistique = new JButton("Afiicher les statistiques");
		btnStatistique.addActionListener(this);
		pnlChoix.add(btnStatistique);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		panel.add(btnQuitter);
	}
	
	/**
	 * Quitter l'application
	 */
	public void quitter()
	{
		int rep=JOptionPane.showConfirmDialog(this,"Voulez-vous quitter l'application ?","Quitter",JOptionPane.YES_NO_OPTION);	
		if(rep == 0)
		{
			OutilsJDBC.closeConnection(co);
			System.exit(0);
		}
	}
	
	/**
	 * Naviguer vers l'écran d'ajout de film
	 */
	public void ajoutFilm()
	{
		controlleur.ajoutFilm(this, co);
	}
	
	/**
	 * Naviguer vers l'écran d'affichage des statistiques
	 */
	public void statistiques()
	{
		controlleur.statistiques(this, co);
	}
	
	/**
	 * Naviguer vers l'écran de recherche de films
	 */
	public void rechercherFilm()
	{
		controlleur.rechercherFilm(this, co);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnQuitter))
		{
			quitter();
		}
		else if(e.getSource().equals(btnAjouterFilm))
		{
			ajoutFilm();
		}
		else if(e.getSource().equals(btnStatistique))
		{
			statistiques();
		}
		else if(e.getSource().equals(btnRechercherFilm))
		{
			rechercherFilm();
		}		
	}

}
