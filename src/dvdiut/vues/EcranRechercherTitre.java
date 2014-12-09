package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dvdiut.controlleurs.ControlleurEcranRechercherTitre;
import dvdiut.interfaces.ActionRecherche;
import dvdiut.interfaces.NavigationMenu;
import dvdiut.modeles.Film;

/**
 * EcranRechercherTitre
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranRechercherTitre extends JFrame implements ActionListener, NavigationMenu, ActionRecherche {

	private JPanel contentPane;
	private JTextField tfdTitre;
	private JTextPane txpInfoFilm;
	private JButton btnRetour;
	private JButton btnValider;
	private ControlleurEcranRechercherTitre controlleur;
	private Connection co;

	/**
	 * Constructeur
	 * 
	 * @param co Connexion
	 */
	public EcranRechercherTitre(Connection co) 
	{
		this.co = co;
		controlleur = new ControlleurEcranRechercherTitre();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel pnlTitre = new JPanel();
		pnlTitre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTitre.setBackground(Color.WHITE);
		contentPane.add(pnlTitre, BorderLayout.NORTH);
		pnlTitre.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EcranRechercherTitre.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(label);
		
		JLabel lblRechercherUnFilm = new JLabel("Rechercher un film par titre");
		pnlTitre.add(lblRechercherUnFilm);
		
		JPanel pnlSaisie = new JPanel();
		pnlSaisie.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(pnlSaisie, BorderLayout.WEST);
		pnlSaisie.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlTitreFilme = new JPanel();
		pnlSaisie.add(pnlTitreFilme);
		
		JLabel lblTitre = new JLabel("Titre :");
		pnlTitreFilme.add(lblTitre);
		
		tfdTitre = new JTextField();
		pnlTitreFilme.add(tfdTitre);
		tfdTitre.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		pnlSaisie.add(btnValider);
		
		JPanel pnlBouton = new JPanel();
		pnlBouton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(pnlBouton, BorderLayout.SOUTH);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		pnlBouton.add(btnRetour);
		
		JPanel pnlInfoFilm = new JPanel();
		pnlInfoFilm.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlInfoFilm, BorderLayout.CENTER);
		pnlInfoFilm.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInformationFilm = new JLabel("Information film :");
		pnlInfoFilm.add(lblInformationFilm, BorderLayout.NORTH);
		
		txpInfoFilm = new JTextPane();
		txpInfoFilm.setEditable(false);
		JScrollPane lspInfoFilm = new JScrollPane(txpInfoFilm);
		pnlInfoFilm.add(lspInfoFilm, BorderLayout.CENTER);
	}

	@Override
	public void validerSaisie()
	{
		if(tfdTitre.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Le titre est vide. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			int numFilm = controlleur.getNumFilm(co, tfdTitre.getText().toUpperCase());
			
			if(numFilm !=0)
			{	
				String a =new String("Titre : "+ tfdTitre.getText().toUpperCase() + "\n");
				String g = new String ("Genre : "+controlleur.getGenre(co, numFilm) + "\n");
				String b =new String("Réalisateur : " + (String)controlleur.getRealisateur(co, numFilm).get("nom") + " " +(String)controlleur.getRealisateur(co, numFilm).get("prenom") + "\n");
				String c = new String ("Acteurs :\n");
				String d = a+g+b+c;
				Film f = new Film(numFilm, tfdTitre.getText(), (String)controlleur.getRealisateur(co, numFilm).get("nom"), (String)controlleur.getRealisateur(co, numFilm).get("prenom"), controlleur.getGenre(co, numFilm));
				ArrayList<String> liste = controlleur.getActeurs(co, f);
				for(String acteur : liste)
				{
					d +=acteur;
				}
				txpInfoFilm.setText(d);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Le film saisi n'existe pas. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
			}	
		}
	}
	
	@Override
	public void retournerMenu()
	{
		controlleur.retourRechercherFilm(this, co);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(btnValider))
		{	
			validerSaisie();
		}
		else if(e.getSource().equals(btnRetour))
		{
			retournerMenu();
		}
		
	}

}
