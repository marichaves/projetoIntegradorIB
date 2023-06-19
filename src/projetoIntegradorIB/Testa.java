package projetoIntegradorIB;

import java.util.Scanner;

public class Testa {

	public static void main(String[] args) {
		Conexao conexao = new Conexao();
		conexao.conectar();

//		conexao.adicionarDadosConsole();
//		conexao.exibirTabela();
//		conexao.exibirRelacaoVacinaSexo();
//		System.out.println();
//		conexao.exibirRelacaoIdadeVacina();
//		
//		
//		System.out.println("Digite o pacienteId da linha que deseja editar:");
		Scanner scanner = new Scanner(System.in);
//		String pacienteId = scanner.nextLine();
//		pacienteId = pacienteId.substring(0, Math.min(pacienteId.length(), 65));
//
//		// Verifica se o pacienteId está correto
//		System.out.println("Paciente ID digitado: " + pacienteId);
//		
//		// Executa a edição apenas se o pacienteId estiver correto
//		if (pacienteId.length() > 0) {
//		    conexao.editarLinha(pacienteId);
//		    conexao.exibirTabela();
//		} else {
//		    System.out.println("Paciente ID inválido. A edição não foi realizada.");
//		}
//		
		conexao.exibirTabela();
		
//		System.out.println("Digite o documentId da linha que deseja excluir:");
//	    String documentId = scanner.nextLine();
//	    documentId = documentId.substring(0, Math.min(documentId.length(), 65));
//	    conexao.exibirLinha(documentId);
//	    conexao.confirmarExclusao(documentId);
	    
	    
		conexao.fecharConexao();
	}

}
