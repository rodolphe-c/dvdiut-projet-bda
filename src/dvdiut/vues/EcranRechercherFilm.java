package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;

import javax.swing.JButton;

import dvdiut.controlleurs.ControlleurEcranRechercherFilm;
import dvdiut.interfaces.NavigationMenu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * EcranRechercherFilm
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranRechercherFilm extends JFrame implements ActionListener, NavigationMenu {

	private JPanel contentPane;
	private JButton btnRechercherParTitre;
	private JButton btnRechercherParRealisateur;
	private JButton btnRechercherParGenre;
	private JButton btnRechercherParAuteur;
	private JButton btnRetour;
	private Connection co;
	private ControlleurEcranRechercherFilm controlleur;

	/**
	 * Constructeur
	 * 
	 * @param co Connexion
	 */
	public EcranRechercherFilm(Connection co) 
	{
		controlleur = new ControlleurEcranRechercherFilm();
		this.co = co;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 422);
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
		label.setIcon(new ImageIcon(EcranRechercherFilm.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(label);
		
		JLabel lblRechercherUnFilm = new JLabel("Rechercher un film");
		pnlTitre.add(lblRechercherUnFilm);
		
		JPanel pnlChoix = new JPanel();
		pnlChoix.setBackground(Color.WHITE);
		contentPane.add(pnlChoix, BorderLayout.CENTER);
		pnlChoix.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnRechercherParTitre = new JButton("Rechercher par titre");
		btnRechercherParTitre.addActionListener(this);
		pnlChoix.add(btnRechercherParTitre);
		
		btnRechercherParRealisateur = new JButton("Rechercher par réalisateur");
		btnRechercherParRealisateur.addActionListener(this);
		pnlChoix.add(btnRechercherParRealisateur);
		
		btnRechercherParGenre = new JButton("Rechercher par genre");
		btnRechercherParGenre.addActionListener(this);
		pnlChoix.add(btnRechercherParGenre);
		
		btnRechercherParAuteur = new JButton("Rechercher par acteur");
		btnRechercherParAuteur.addActionListener(this);
		pnlChoix.add(btnRechercherParAuteur);
		
		JPanel pnlBouton = new JPanel();
		pnlBouton.setBackground(Color.WHITE);
		contentPane.add(pnlBouton, BorderLayout.SOUTH);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		pnlBouton.add(btnRetour);
	}
	
	/**
	 * Redirection vers l'écran de recherche de film par titre
	 */
	public void rechercherTitre()
	{
		controlleur.rechercherTitre(this, co);
	}
	
	/**
	 * Redirection vers l'écran de recherche de film par acteur
	 */
	public void rechercherActeur()
	{
		controlleur.rechercherActeur(this, co);
	}
	
	/**
	 * Redirection vers l'écran de recherche de film par genre
	 */
	public void rechercherGenre()
	{
		controlleur.rechercherGenre(this, co);
	}
	
	/**
	 * Redirection vers l'écran de recherche de film par réalisateur
	 */
	public void rechercherRealisateur()
	{
		controlleur.rechercherRealisateur(this, co);
	}
	
	@Override
	public void retournerMenu()
	{
		controlleur.retournerMenu(this, co);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnRechercherParTitre))
		{
			rechercherTitre();
		}
		else if(e.getSource().equals(btnRechercherParAuteur))
		{
			rechercherActeur();
		}
		else if(e.getSource().equals(btnRechercherParGenre))
		{
			rechercherGenre();
		}
		else if(e.getSource().equals(btnRechercherParRealisateur))
		{
			rechercherRealisateur();
		}
		else if(e.getSource().equals(btnRetour))
		{
			retournerMenu();
		}
	}

}
