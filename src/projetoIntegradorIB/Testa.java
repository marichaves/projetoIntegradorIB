package projetoIntegradorIB;

public class Testa {

	public static void main(String[] args) {
		Conexao conexao = new Conexao();
	    conexao.conectar();

	    
	  //  conexao.adicionarDadosConsole();
	    conexao.exibirTabela();
	    conexao.exibirRelacaoVacinaSexo();
	    conexao.fecharConexao();
	}

}