package entities;

public class Curso {
		
	private String nome_C;
	private String nivel;
	private String ano;
	
	public Curso(String nome, String nivel, String ano) {
		super();
		this.nome_C = nome;
		this.nivel = nivel;
		this.ano = ano;
	}
	
	public String getNome() {
		return nome_C;
	}
	
	public void setNome(String nome) {
		this.nome_C = nome;
	}
	
	public String getNivel() {
		return nivel;
	}
	
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome_C + ", nivel=" + nivel + ", ano=" + ano + "]";
	}
}