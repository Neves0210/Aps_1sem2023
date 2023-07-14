package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import Dados.dados_junto;
import entities.Alunos;
import entities.Curso;

public class Dao_curso {
	
	private String filePath;
	private dados_junto dados;
	
	public Dao_curso(String aFilePath, dados_junto dados) {
		this.dados = dados;
		this.filePath = aFilePath;
	}

	public void loadCurso(){
        try (   InputStream is = new java.io.FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String nome = palavras[0];
                String nivel = palavras[1];
                String ano = palavras[2];
                
                Curso curso= new Curso(nome, nivel, ano);
                dados.addCurso(curso);
            }
        }
           catch(IOException e) {
        	   e.printStackTrace();
            	
        }
	}
	 
	 public void saveCurso(){

	        try(    OutputStream os = new FileOutputStream(filePath, true);
	                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
	                PrintWriter wr = new PrintWriter(osw, true);
	                ){
	            for(Curso c: dados.getCurso()){
	               wr.println(c.getNome()+","+c.getNivel()+","+c.getAno());
	            }

	        }catch(IOException e){
	            e.printStackTrace();
	        }
	    }
}