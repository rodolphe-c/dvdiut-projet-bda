package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dvdiut.controlleurs.ControlleurEcranRechercherGenre;
import dvdiut.interfaces.ActionChoixFilm;
import dvdiut.interfaces.ActionRecherche;
import dvdiut.interfaces.NavigationMenu;
import dvdiut.modeles.Film;

import javax.swing.JComboBox;

/**
 * EcranRechercherGenre
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranRechercherGenre extends JFrame implements ActionListener, ListSelectionListener, NavigationMenu, ActionChoixFilm, ActionRecherche{

	private JPanel contentPane;
	private JButton btnRetour;
	private JButton btnValider;
	private JButton btnChoisir;
	private JComboBox<String> cmbGenre;
	private JList<Film> listFilms;
	private JTextPane txpInfoFilm;
	private ControlleurEcranRechercherGenre controlleur;
	private Connection co;

	/**
	 * Constructeur
	 * 
	 * @param co Connexion
	 */
	public EcranRechercherGenre(Connection co) 
	{
		this.co = co;
		controlleur = new ControlleurEcranRechercherGenre();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 527);
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
		label.setIcon(new ImageIcon(EcranRechercherRealisateur.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(label);
		
		JLabel lblRechercherUnFilm = new JLabel("Rechercher un film par réalisateur");
		pnlTitre.add(lblRechercherUnFilm);
		
		JPanel pnlBouton = new JPanel();
		pnlBouton.setBackground(Color.WHITE);
		contentPane.add(pnlBouton, BorderLayout.SOUTH);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		pnlBouton.add(btnRetour);
		
		JPanel pnlLeft = new JPanel();
		contentPane.add(pnlLeft, BorderLayout.CENTER);
		pnlLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlRecherche = new JPanel();
		pnlRecherche.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlRecherche.setBackground(Color.WHITE);
		pnlLeft.add(pnlRecherche, BorderLayout.WEST);
		pnlRecherche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnlSaisie = new JPanel();
		pnlRecherche.add(pnlSaisie);
		pnlSaisie.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlNom = new JPanel();
		pnlSaisie.add(pnlNom);
		
		ArrayList<String> listeGenre = new ArrayList<String>();
		listeGenre = controlleur.recupererGenre(co);
		
		DefaultComboBoxModel<String> listGenre = new DefaultComboBoxModel<String>();
		for(String a : listeGenre)
		{
			listGenre.addElement(a);
		}
		
		cmbGenre = new JComboBox<String>(listGenre);
		pnlNom.add(cmbGenre);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		pnlSaisie.add(btnValider);
		
		JPanel pnlRealisateur = new JPanel();
		pnlRecherche.add(pnlRealisateur);
		pnlRealisateur.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlResultat = new JPanel();
		pnlLeft.add(pnlResultat, BorderLayout.CENTER);
		pnlResultat.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlListeFilm = new JPanel();
		pnlResultat.add(pnlListeFilm);
		pnlListeFilm.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlListeFilm.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeFilms = new JLabel("Liste Films :");
		panel_9.add(lblListeFilms, BorderLayout.NORTH);
		
		listFilms = new JList<Film>();
		listFilms.addListSelectionListener(this);
		listFilms.setForeground(new Color(51, 204, 0));
		listFilms.setBackground(UIManager.getColor("info"));
		listFilms.setVisibleRowCount(4);
		JScrollPane lspListeFilm = new JScrollPane(listFilms);
		panel_9.add(lspListeFilm, BorderLayout.CENTER);
		
		JPanel pnlBoutonChoisir = new JPanel();
		panel_9.add(pnlBoutonChoisir, BorderLayout.SOUTH);
		
		btnChoisir = new JButton("Choisir");
		btnChoisir.addActionListener(this);
		btnChoisir.setEnabled(false);
		pnlBoutonChoisir.add(btnChoisir);
		
		JPanel pnlInfoFilm = new JPanel();
		pnlInfoFilm.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlResultat.add(pnlInfoFilm);
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
		DefaultListModel<Film> listModel = initFilm(co, cmbGenre.getSelectedItem().toString());
		listFilms.setModel(listModel);
	}
	
	@Override
	public void choisirFilm()
	{
		if(listFilms.getSelectedIndex()!=-1)
		{
			String a = new String("Titre : "+((Film)listFilms.getSelectedValue()).getTitre().toUpperCase() + "\n");
			String g = new String ("Genre : "+((Film)listFilms.getSelectedValue()).getGenre().toUpperCase() + "\n");
			String b = new String("Réalisateur : "+((Film)listFilms.getSelectedValue()).getRealisateur().getNom()+" " + ((Film)listFilms.getSelectedValue()).getRealisateur().getPrenom() +"\n");
			String c = new String ("Acteurs :\n");
			String d = a+g+b+c;
			ArrayList<String> liste = getActeurs(co, (Film)listFilms.getSelectedValue());
			for(String acteur : liste)
			{
				d +=acteur;
			}
			
			txpInfoFilm.setText(d);
        }
		else
		{
				btnChoisir.setEnabled(false);
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
		else if(e.getSource().equals(btnChoisir))
		{
			choisirFilm();
		}
		else if(e.getSource().equals(btnRetour))
		{
			retournerMenu();
		}
	}
		
	/**
	 * Retourne une liste d'acteurs jouant dans le film saisie
	 * 
	 * @param co Connexion
	 * @param f Film
	 * @return Liste d'acteurs
	 */
	public ArrayList<String> getActeurs(Connection co, Film f)
	{
		return controlleur.getActeurs(co, f);
	}
	
	/**
	 * Retourne une liste de film
	 * 
	 * @param co Connexion
	 * @param genre Genre
	 * @return Liste de films
	 */
	private DefaultListModel<Film> initFilm(Connection co, String genre) 
	{
		return controlleur.initFilm(co, genre);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if (e.getValueIsAdjusting() == false) 
		{
			 
            if (listFilms.getSelectedIndex() == -1) 
            {
            	//No selection, disable fire button.
                btnChoisir.setEnabled(false);
            } 
            else 
            {
            	//Selection, enable the fire button.
            	btnChoisir.setEnabled(true);
            }
        }
		
	}
}
