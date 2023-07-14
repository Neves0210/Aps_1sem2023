package dao;

import java.io.BufferedReader;
import java.io.FileOutputStream;
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

public class Dao {
	
	private String filePath;
	private dados_junto dados;
	
	public Dao(String aFilePath, dados_junto dados) {
		this.dados = dados;
		this.filePath = aFilePath;
	}
	
	public void loadAlunos(){
        try (   InputStream is = new java.io.FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String id = palavras[0];
                String nome = palavras[1];
                
                Alunos alunos = new Alunos(id,nome);
                dados.addAluno(alunos);
            }
        }
           catch(IOException e) {
        	   e.printStackTrace();
            	
        }
	}

	public void saveAlunos(){

	        try(    OutputStream os = new FileOutputStream(filePath, true);
	                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
	                PrintWriter wr = new PrintWriter(osw, true);
	                ){
	            for(Alunos a: dados.getAlunos()){
	               wr.println(a.getId()+","+a.getNome());
	            }

	        }catch(IOException e){
	            e.printStackTrace();
	        }
	    }
}