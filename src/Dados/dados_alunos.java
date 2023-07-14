package Dados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entities.Alunos;

public class dados_alunos {
	private Map<String, Alunos> alunos = new TreeMap<>();
	
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
	public Collection<Alunos> getAlunos(){
		return this.alunos.values();
	}
	public Alunos getAlunobyId(String id) {
		return alunos.get(id);
	}
	public List<Alunos> getAlunosByNome(String keyName){
		List<Alunos> alunosByName = new ArrayList<>();
		for(Alunos a: alunos.values()) {
			if(a.getNome().toLowerCase().contains(keyName.toLowerCase())) {
				alunosByName.add(a);
			}
		}
		return alunosByName;
	}
}