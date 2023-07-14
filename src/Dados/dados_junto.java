package Dados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entities.Alunos;
import entities.Curso;

public class dados_junto {
	
	private Map<String, Alunos> alunos = new TreeMap<>();
	private Map<String, Curso> curso = new TreeMap<>();
	private List<Curso> cursoByName;
	
	public Map<String, Alunos> getAlunosbyId(){
		return this.alunos;
	}
	
	public boolean addAluno(Alunos a) {
		if(alunos.containsKey(a.getId())) {
			return false;
		}
		
		this.alunos.put(a.getId(), a);
		return true;
	}
	
	public boolean addCurso(Curso c) {
		if(curso.containsKey(c.getNome())) {
			return false;
		}
		
		this.curso.put(c.getNome(), c);
		return true;
	}
	
	public Collection<Alunos> getAlunos(){
		return this.alunos.values();
	}
	
	public Collection<Curso> getCurso(){
		return this.curso.values();
	}

	public Alunos getAlunobyId(String id) {
		return alunos.get(id);
	}
		
	public List<Curso> getCursoByNome(String keyName_C){
		cursoByName = new ArrayList<>();
		
		for(Curso c: curso.values()) {
			if(c.getNome().toLowerCase().contains(keyName_C.toLowerCase())) {
				cursoByName.add(c);
			}
		}
		return cursoByName;
	}
}