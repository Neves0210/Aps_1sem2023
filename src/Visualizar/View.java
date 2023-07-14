package Visualizar;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import Dados.dados_junto;
import dao.Dao;
import dao.Dao_curso;
import entities.Alunos;
import entities.Curso;


public class View {
	
	Dao dao;
	Dao_curso dao_c;
	dados_junto dados;

	
	public View() {
	    dados = new dados_junto();
	    dao = new Dao("file\\Alunos.csv", dados);
	    dao_c = new Dao_curso("file\\Cursos.csv", dados);
	    dao.loadAlunos();
	    dao_c.loadCurso();
	}
	
	public void init() {
		controller();
	}

	public Object controller() {
		int opcao = 0;
		do {
			opcao = getOpcaoMenu();
			switch(opcao) {
				case 1: int opcao_A = 0;
				do {
					opcao_A = getOpcaoAluno();
					switch(opcao_A) {
					case 1: adicionaAluno(); break;
					case 2: listaTodosAlunos(); break;
					case 3: encontraAlunoById(); break;
					case 4: voltar(); break;
					case 0: sairAluno(); break;
					}
				}while(opcao_A !=0);
					System.exit(0);
					
			case 2: int opcao_C = 0;
				do {
					opcao_C = getOpcaoCurso();
					switch(opcao_C) {
					case 1: adicionaCurso(); break;
					case 2: listaTodosCursos(); break;
					case 3: encontraCursoByNome(); break;
					case 4: voltar(); break;
					case 0: sairCurso(); break;
					}
				}while(opcao_C != 0);
					System.exit(0);
			}
		}while(opcao != 0);
		 System.exit(0);
		return opcao;
	}
	
	public int getOpcaoMenu() {
		
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Escolha a opcao:");
		System.out.println("1 - ALUNOS ");
		System.out.println("2 - CURSOS");
		System.out.println("0 - FINALIZAR PROGRAMA");
		System.out.println("--------------------------------");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		String linha = in.nextLine();
		
		try {
			return Integer.parseInt(linha);
		}catch( NumberFormatException e) {
			System.out.println("O valor entrado: "+ linha+ "nao é valido");
			System.out.println("   a opcao deve ser um numero inteiro\n");
			return getOpcaoMenu();
		}
	}	
	public int getOpcaoAluno() {
		
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Escolha a opcao:");
		System.out.println("1 - para adicionar ALUNO");
		System.out.println("2 - listar todos os ALUNOS");
		System.out.println("3 - encontrar o ALUNO pelo ID");
		System.out.println("4 - VOLTAR");
		System.out.println("0 - FINALIZAR PROGRAMA");
		System.out.println("--------------------------------");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		String linha = in.nextLine();
		
		try {
			return Integer.parseInt(linha);
			
		}catch (NumberFormatException e){
			System.out.println("O valor entrado : " + linha + " nao eh valido");
			System.out.println("   a opcao deve ser um numero inteiro\n");
			return getOpcaoAluno();
		}
		
	}
	
	public int getOpcaoCurso() {
		
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Escolha a opcao:");
		System.out.println("1 - para adicionar CURSO");
		System.out.println("2 - listar todos os Cursos");
		System.out.println("3 - encontrar o CURSO pelo NOME");
		System.out.println("4 - VOLTAR");
		System.out.println("0 - FINALIZAR PROGRAMA");
		System.out.println("--------------------------------");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		String linha = in.nextLine();
		
		try {
			return Integer.parseInt(linha);
			
		}catch (NumberFormatException e){
			System.out.println("O valor entrado : " + linha + " nao eh valido");
			System.out.println("   a opcao deve ser um numero inteiro\n");
			return getOpcaoAluno();
		}
		
	}
	
	public Object voltar() {
		return controller();
	}
	
	public void sairAluno() {
	    System.out.println("saindo do programa");
	    System.out.println("salvando Alunos");
	    dao.saveAlunos();

	}
	
	public void adicionaAluno() {
		Alunos aluno = entraAluno();
		if(aluno==null) {
			return ;
		}
		if(dados.addAluno(aluno)) {
			System.out.println("Adicionando Aluno "+ aluno);
		}
		else  {
			System.out.println("Falha ao adicionar o Aluno"+ aluno);
		}
	}
	
	public void listaTodosAlunos() {
		System.out.println("Lista de todos os ALunos");
		for(Alunos a: dados.getAlunos()) {
			System.out.println(a);
		}
	}

	public String VerificarAluno() {
	    String aluno = entraNome_A();
	    boolean temNumeros = false;

	    for (int i = 0; i < aluno.length(); i++) {
	        if (Character.isDigit(aluno.charAt(i))) {
	            temNumeros = true;
	            break;
	        }
	    }

	    if (temNumeros) {
	        System.out.println("O nome contém números.");
	        adicionaAluno();
	        return null; 
	    }
	    
	    return aluno;
	}

	public void encontraAlunoById() {
	    System.out.println("Entre com o id do aluno que deseja encontrar:");
	    Scanner in = new Scanner(System.in);
	    String id = in.nextLine();
	    Alunos aluno = dados.getAlunobyId(id);
	    if (aluno != null) {
	        System.out.println("Aluno encontrado:");
	        System.out.println(aluno);
	    } else {
	        System.out.println("Nenhum aluno encontrado com o id " + id);
	    }
	}
	
	public Alunos entraAluno() {
		String id = entraId();
		
		Alunos temAluno = dados.getAlunobyId(id);
		if(temAluno!=null) {
			System.out.println("Ja Tem um Aluno com o ID: ");
			System.out.println(temAluno);
			return null;
		}
		String nome = (String) VerificarAluno();
		return new Alunos(id, nome);	
	}
	
	public String entraId() {
		System.out.println("Entre com um ID para o ALUNO");
		Scanner in = new Scanner(System.in);
		
		String id = in.nextLine();
		
		return id.trim();
	}
	
	public String entraNome_A() {
		System.out.println("Entre com o Nome do Aluno");
		Scanner in = new Scanner(System.in);
		return in.nextLine().trim();
	}
	
//-------------------------------------------------------------------------------------------------------------------//
	
	public void sairCurso() {
	    System.out.println("saindo do programa");
	    System.out.println("salvando Cursos");
	    dao_c.saveCurso();
	}
	
	public void listaTodosCursos() {
		System.out.println("Lista de todos os Cursos");
		for(Curso c: dados.getCurso()) {
			System.out.println(c);
		}
	}
	
	public void listaCursoByNome(String keyName_C) {
		System.out.println("Listando todos os Cursos com o nome \"" + keyName_C+ "\"");
		Collection<Curso> curso = (Collection<Curso>) dados.getCursoByNome(keyName_C);
		if(curso.size()==0) {
			System.out.println("Nenhum Curso com esse Nome "+ keyName_C);
		}
		
		System.out.println("   "+ curso.size() + "Cursos Encontrados");
		for(Curso c: curso) {
			System.out.println(c);
		}
		System.out.println();
	}

	public void encontraCursoByNome() {
		String nome = entraNome_Curso();
		encontraCursoByNome(nome);
	}
	
	public void encontraCursoByNome(String keyName_C) {
		System.out.println("Procurando Curso pelo Nome \"" + keyName_C + "\"");
		List<Curso> c = dados.getCursoByNome(keyName_C);
		if(c.size()==0) {
			System.out.println("O CURSO NAO FOI ENCONTRADO");
		} else {
			System.out.println("CURSO Foi Encontrado");
			System.out.println(c);
		}
	}
	public void adicionaCurso() {
		Curso curso = entraCurso();
		if(curso==null) {
			return;
		}
		if(dados.addCurso(curso)) {
			System.out.println("Adicionando Curso"+ curso);
		}
		else {
			System.out.println("Falha ao adicionar o Curso"+ curso);
		}
	}
	
	public Curso entraCurso() {
		String nome_curso = VerificarCurso();
		String nivel = entraNivel();
		String ano = VerificarAno();
		return new Curso(nome_curso, nivel, ano);	
		}

	
	public String VerificarCurso() {
	    String curso = entraNome_Curso();
	    boolean temNumeros = false;
	    for (int i = 0; i < curso.length(); i++) {
	        if (Character.isDigit(curso.charAt(i))) {
	            temNumeros = true;
	            break;
	        }
	    }
	    if (temNumeros) {
	        System.out.println("O nome contém números.");
	        adicionaCurso();
	        return null; 
	    }
	    return curso;
	}
	
	public String VerificarAno() {
	    String ano = entraAno();
	    boolean temNumeros = false;

	    for (int i = 0; i < ano.length(); i++) {
	        if (Character.isDigit(ano.charAt(i))) {
	            temNumeros = true;
	            break;
	        }
	    }

	    if (temNumeros) {
	        return ano;
	    } else {
	        try {
	            throw new NumberFormatException("O ano é inválido.");
	        } catch (NumberFormatException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    return ano;
	}
	
	public String entraNome_Curso(){
		System.out.println("Entre com um NOME para o CURSO");
		Scanner in = new Scanner(System.in);
		return in.nextLine().trim();
	}
	
	public String entraNivel() {
		System.out.println("Entre com o Nivel do CURSO");
		Scanner in = new Scanner(System.in);
		return in.nextLine().trim();
	}
	
	public String entraAno() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entre com o Ano de Inicio do CURSO");
		String anoLine = in.nextLine();
		try {
			String ano = anoLine;
			return ano;
		}catch (NumberFormatException e) {
			System.out.println("Entrada Invalida: "+ anoLine);
			System.out.println("    Deve Ser Um ANO Valido");
			return entraAno();
		}
	}
	
}