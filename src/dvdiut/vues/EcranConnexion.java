package dvdiut.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JPasswordField;

import dvdiut.controlleurs.ControlleurEcranConnexion;
import dvdiut.controlleurs.OutilsJDBC;

/**
 * EcranConnexion
 * 
 * @author rodolphe-c
 * @author k-vinchon
 *
 */
@SuppressWarnings("serial")
public class EcranConnexion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField tfdLogin;
	private JPasswordField tfdMDP;
	private JButton btnValider;
	private ControlleurEcranConnexion controlleur;

	/**
	 * Constructeur
	 */
	public EcranConnexion() {
		controlleur = new ControlleurEcranConnexion();
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 348);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel pnlValider = new JPanel();
		pnlValider.setBorder(UIManager.getBorder("OptionPane.border"));
		pnlValider.setBackground(Color.WHITE);
		contentPane.add(pnlValider, BorderLayout.SOUTH);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		pnlValider.add(btnValider);
		
		JPanel pnlTitre = new JPanel();
		pnlTitre.setBorder(null);
		pnlTitre.setBackground(Color.WHITE);
		contentPane.add(pnlTitre, BorderLayout.NORTH);
		pnlTitre.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(EcranConnexion.class.getResource("/dvdiut/img/logo.png")));
		pnlTitre.add(lblLogo);
		
		JLabel lblConnexion = new JLabel("Connexion à la base de donnée Oracle");
		pnlTitre.add(lblConnexion);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		
		JLabel lblLogin_1 = new JLabel("Login :");
		panel_2.add(lblLogin_1);
		
		tfdLogin = new JTextField();
		panel_2.add(tfdLogin);
		tfdLogin.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de Passe :");
		panel_3.add(lblMotDePasse_1);
		
		tfdMDP = new JPasswordField();
		tfdMDP.setColumns(10);
		panel_3.add(tfdMDP);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		JLabel lblLogin = new JLabel("login :");
		panel_1.add(lblLogin);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("mot de passe :");
		panel_1.add(lblMotDePasse);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		
		textField = new JTextField();
		textField.setColumns(10);
	}
	
	/**
	 * Valider le formulaire de connexion à la base de données Oracle
	 */
	@SuppressWarnings("deprecation")
	public void validerConnexion()
	{
		if(tfdLogin.getText().isEmpty() || tfdMDP.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Un des champs n'est pas remplis. Veuillez recommencer.", "Attention",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			Connection co = OutilsJDBC.openConnection("jdbc:oracle:thin:"+tfdLogin.getText()+"/"+tfdMDP.getText()+"@r2d2.iut-orsay.fr:1521:etudom");
			if(co == null)
			{
				tfdLogin.setText("");
				tfdMDP.setText("");
			}
			else
			{
				controlleur.menu(this, co);	
			}
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnValider))
		{
			validerConnexion();
		}
	}
}
