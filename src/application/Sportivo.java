package application;

public class Sportivo {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String disciplina;
	public Sportivo(String nome, String cognome, String codiceFiscale, String disciplina) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.disciplina = disciplina;
	}
	@Override
	public String toString() {
		return "Sportivo [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", disciplina="
				+ disciplina + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
}
