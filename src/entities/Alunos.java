package entities;

public class Alunos  {

	private String id;
	private String nome;
	
	public Alunos(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Alunos [id=" + id + ", nome=" + nome + "]";
	}
	
}