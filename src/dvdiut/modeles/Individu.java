package dvdiut.modeles;

public class Individu 
{
	private String nom;
	private String prenom;
	
	public Individu(String nom, String prenom)
	{
		this.nom = new String(nom);
		this.prenom = new String(prenom);
	}

	@Override
	public String toString() 
	{
		return nom + " " + prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
