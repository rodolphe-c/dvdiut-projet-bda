package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dvdiut.controlleurs.ControlleurEcranAjoutFilm;
import dvdiut.interfaces.NavigationMenu;
import dvdiut.modeles.Individu;

import java.awt.SystemColor;

/**
 * EcranAjoutFilm
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranAjoutFilm extends JFrame implements ActionListener, ListSelectionListener, NavigationMenu {

	private Connection co;
	private JPanel contentPane;
	private JTextField tfdTitre;
	private JTextField tfdPrenomRealisateur;
	private JTextField tfdNom;
	private JButton btnAjouter;
	private JButton btnRetour;
	private JButton btnValider;
	private JButton btnSupprimer;
	private DefaultListModel<Individu> listModel;
	private JList<Individu> listActeur;
	private JTextField tfdPrenom;
	private JTextField tfdNomRealisateur;
	private JComboBox<String> cmbGenre;
	
	private ControlleurEcranAjoutFilm controlleur;

	/**
	 * Constructeur
	 * @param co Connexion
	 */
	public EcranAjoutFilm(Connection co) 
	{
		this.co = co;
		controlleur = new ControlleurEcranAjoutFilm();
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel pnlTitre = new JPanel();
		pnlTitre.setBackground(Color.WHITE);
		contentPane.add(pnlTitre, BorderLayout.NORTH);
		pnlTitre.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EcranAjoutFilm.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(lblNewLabel);
		
		JLabel lblAjoutDeFilms = new JLabel("Ajout de films ");
		pnlTitre.add(lblAjoutDeFilms);
		
		JPanel pnlBoutons = new JPanel();
		pnlBoutons.setBackground(Color.WHITE);
		contentPane.add(pnlBoutons, BorderLayout.SOUTH);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		pnlBoutons.add(btnRetour);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		pnlBoutons.add(btnValider);
		
		JPanel pnlAjoutFilm = new JPanel();
		contentPane.add(pnlAjoutFilm, BorderLayout.CENTER);
		pnlAjoutFilm.setBackground(SystemColor.window);
		pnlAjoutFilm.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel pnlTitreFilm = new JPanel();
		
		JLabel lblTitre = new JLabel("Titre :");
		pnlTitreFilm.add(lblTitre);
		
		tfdTitre = new JTextField();
		pnlTitreFilm.add(tfdTitre);
		tfdTitre.setColumns(10);
		
		JPanel pnlRealisateur = new JPanel();
		pnlRealisateur.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlRealisateur.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		pnlRealisateur.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		
		JLabel lblPrenomRealisateur = new JLabel("Prénom :");
		panel_1.add(lblPrenomRealisateur);
		
		tfdPrenomRealisateur = new JTextField();
		panel_1.add(tfdPrenomRealisateur);
		tfdPrenomRealisateur.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblNom_1 = new JLabel("Nom :");
		panel_4.add(lblNom_1);
		
		tfdNomRealisateur = new JTextField();
		panel_4.add(tfdNomRealisateur);
		tfdNomRealisateur.setColumns(10);
		
		JPanel pnlAjoutActeur = new JPanel();
		pnlAjoutActeur.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		listModel = new DefaultListModel<Individu>();
		pnlAjoutFilm.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlAjoutFilm.add(pnlTitreFilm);
		
		JPanel pnlGenre = new JPanel();
		FlowLayout fl_pnlGenre = (FlowLayout) pnlGenre.getLayout();
		fl_pnlGenre.setAlignment(FlowLayout.LEFT);
		
		JLabel lblGenre = new JLabel("Genre :");
		pnlGenre.add(lblGenre);
		
		ArrayList<String> listeGenre = new ArrayList<String>();
		listeGenre = controlleur.recupererGenre(co);
		
		DefaultComboBoxModel<String> listGenre = new DefaultComboBoxModel<String>();
		for(String a : listeGenre)
		{
			listGenre.addElement(a);
		}
		
		cmbGenre = new JComboBox<String>(listGenre);
		pnlGenre.add(cmbGenre);
		pnlAjoutFilm.add(pnlGenre);
		
		JPanel panel = new JPanel();
		pnlAjoutFilm.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		pnlAjoutFilm.add(pnlRealisateur);
		
		JLabel lblRealisateur = new JLabel("Réalisateur :");
		pnlRealisateur.add(lblRealisateur, BorderLayout.NORTH);
		pnlAjoutFilm.add(pnlAjoutActeur);
		pnlAjoutActeur.setLayout(new BorderLayout(0, 0));
		
		btnSupprimer = new JButton("Supprimer");
		pnlAjoutActeur.add(btnSupprimer, BorderLayout.SOUTH);
		btnSupprimer.setEnabled(false);
		
		listActeur = new JList<Individu>();
		listActeur.addListSelectionListener(this);
		listActeur.setForeground(new Color(51, 204, 0));
		listActeur.setBackground(UIManager.getColor("info"));
		listActeur.setVisibleRowCount(4);
		JScrollPane lspListeActeurs = new JScrollPane(listActeur);
		pnlAjoutActeur.add(lspListeActeurs, BorderLayout.CENTER);
		
		JPanel pnlActeur = new JPanel();
		lspListeActeurs.setColumnHeaderView(pnlActeur);
		pnlActeur.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		pnlActeur.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlSaisieActeur = new JPanel();
		panel_3.add(pnlSaisieActeur);
		pnlSaisieActeur.setLayout(new BorderLayout(0, 0));
		
		btnAjouter = new JButton("Ajouter");
		pnlSaisieActeur.add(btnAjouter, BorderLayout.SOUTH);
		
		JPanel pnlTitreActeur = new JPanel();
		pnlSaisieActeur.add(pnlTitreActeur, BorderLayout.NORTH);
		
		JLabel lblActeur = new JLabel("Acteur :");
		pnlTitreActeur.add(lblActeur);
		
		JPanel pnlInfoActeur = new JPanel();
		pnlSaisieActeur.add(pnlInfoActeur, BorderLayout.CENTER);
		pnlInfoActeur.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlPrenomActeur = new JPanel();
		pnlInfoActeur.add(pnlPrenomActeur);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		pnlPrenomActeur.add(lblPrenom);
		
		tfdPrenom = new JTextField();
		pnlPrenomActeur.add(tfdPrenom);
		tfdPrenom.setColumns(10);
		
		JPanel pnlNomActeur = new JPanel();
		pnlInfoActeur.add(pnlNomActeur);
		
		JLabel lblNom = new JLabel("Nom :");
		pnlNomActeur.add(lblNom);
		
		tfdNom = new JTextField();
		pnlNomActeur.add(tfdNom);
		tfdNom.setColumns(10);
		btnAjouter.addActionListener(this);
		btnSupprimer.addActionListener(this);
	}

	/**
	 * Ajouter un film
	 * 
	 * @return Retourne vrai si le film est ajouté, faux sinon
	 */
	public boolean ajouterFilm()
	{
		return controlleur.ajouterSaisie(co, tfdTitre.getText().toUpperCase(), cmbGenre.getSelectedItem().toString().toUpperCase(), tfdNomRealisateur.getText().toUpperCase(), tfdPrenomRealisateur.getText().toUpperCase(), listModel);
	}
	
	/**
	 * Ajouter un acteur dans la liste
	 */
	public void ajouterActeur()
	{
		if (tfdNom.getText().length() == 0 || tfdPrenom.getText().length()==0)
		{
			JOptionPane.showMessageDialog(this, "Le champs de texte est vide. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			Individu acteur = new Individu(tfdNom.getText().toUpperCase(), tfdPrenom.getText().toUpperCase());
			listModel.addElement(acteur);
			listActeur.setModel(listModel);
			tfdNom.setText("");
			tfdPrenom.setText("");
		}
	}
	
	/**
	 * Supprimer un acteur de la liste
	 */
	public void supprimerActeur()
	{
		if(listActeur.getSelectedIndex()!=-1)
		{
			int index = listActeur.getSelectedIndex();
            listModel.remove(index);
 
            int size = listModel.getSize();
 
            if (size == 0) 
            { //Nobody's left, disable firing.
                btnSupprimer.setEnabled(false);
            } 
            else 
            { //Select an index.
                if (index == listModel.getSize()) 
                {
                    //removed item in last position
                    index--;
                }
                
                listActeur.setSelectedIndex(index);
                listActeur.ensureIndexIsVisible(index);
            }
		}
		else
		{
			btnSupprimer.setEnabled(false);
		}
	}
	
	/**
	 * Valider la saisie du film
	 */
	public void validerSaisie()
	{
		if(tfdTitre.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Le titre est vide. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
		}
		else if (tfdPrenomRealisateur.getText().isEmpty() || tfdNomRealisateur.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Le Réalisateur est mal identifié. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
		}
		else if(listActeur.getModel().getSize() == 0)
		{
			int option= JOptionPane.showConfirmDialog(this, "Il n'y a pas d'acteur. Voulez-vous continuer ?.","Attention", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION)
			{
				if (ajouterFilm())
				{
					JOptionPane.showMessageDialog(this, "Le film à été ajouté avec succès !.");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Le film n'a pas été ajouté !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				listModel.clear();
				listActeur.setModel(listModel);
				tfdTitre.setText("");
				tfdNom.setText("");
				tfdPrenom.setText("");
				tfdNomRealisateur.setText("");
				tfdPrenomRealisateur.setText("");
			}
		}
		else
		{
			ajouterFilm();
			listModel.clear();
			listActeur.setModel(listModel);
			tfdTitre.setText("");
			tfdNom.setText("");
			tfdPrenom.setText("");
			tfdNomRealisateur.setText("");
			tfdPrenomRealisateur.setText("");
			JOptionPane.showMessageDialog(this, "Le film à été ajouté avec succès !.");
		}
	}
	
	@Override
	public void retournerMenu()
	{
		controlleur.retournerMenu(this, co);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnAjouter))
		{
			ajouterActeur();
		}
		else if (e.getSource().equals(btnSupprimer))
		{
			supprimerActeur();
		}
		else if(e.getSource().equals(btnValider))
		{
			validerSaisie();
		}
		else if(e.getSource().equals(btnRetour))
		{
			retournerMenu();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			 
            if (listActeur.getSelectedIndex() == -1) 
            {
            	//No selection, disable fire button.
                btnSupprimer.setEnabled(false);
            } 
            else 
            {
            	//Selection, enable the fire button.
                btnSupprimer.setEnabled(true);
            }
        }
		
	}
}
