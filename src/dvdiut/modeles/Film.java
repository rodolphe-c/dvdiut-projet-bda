package dvdiut.modeles;

public class Film 
{
	private String titre;
	private Individu realisateur;
	private int numFilm;
	private String genre;
	
	public Film(int numFilm, String titre, String nom, String prenom, String genre)
	{
		this.numFilm = numFilm;
		this.titre = titre;
		this.realisateur = new Individu(nom, prenom);
		this.genre = genre;
	}

	@Override
	public String toString() 
	{
		return titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Individu getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Individu realisateur) {
		this.realisateur = realisateur;
	}

	public int getNumFilm() {
		return numFilm;
	}

	public void setNumFilm(int numFilm) {
		this.numFilm = numFilm;
	}
	
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
