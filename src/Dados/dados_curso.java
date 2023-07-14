package Dados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entities.Curso;

public class dados_curso {
	private Map<String, Curso> curso = new TreeMap<>();
		
	public Map<String, Curso> getCursoByNome(){
		return this.curso;
	}
	public boolean addCurso(Curso c) {
		if(curso.containsKey(c.getNome())) {
			return false;
		}
		this.curso.put(c.getNome(), c);
		return true;
	}
	public Collection<Curso> getCurso(){
		return this.curso.values();
	}
	/*
	public Curso getCursoByNome(String nome_C) {
		return curso.get(nome_C);
	}
	*/
	public List<Curso> getCursoByNome(String keyName_C){
		List<Curso> cursoByName = new ArrayList<>();
		for(Curso c: curso.values()) {
			if(c.getNome().toLowerCase().contains(keyName_C.toLowerCase())) {
				cursoByName.add(c);
			}
		}
		return cursoByName;
	}
	
}