package projetoIntegradorIB;

import java.sql.*;
import java.util.Scanner;

public class Conexao {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/teste_projetoint";
		String usuario = "root";
		String senha = "senhaMySQL";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void adicionarDadosConsole() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o ID do documento:");
		String documentId = scanner.nextLine();

		System.out.println("Digite o ID do paciente:");
		String pacienteId = scanner.nextLine();

		System.out.println("Digite a idade do paciente:");
		int pacienteIdade = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.println(
				"Digite o sexo biológico do paciente ('M' para masculino; 'F' para feminino; 'N' para não binário :");
		String pacienteSexo = scanner.nextLine();

		System.out.println("Digite o nome do município do paciente:");
		String pacienteMunicipio = scanner.nextLine();

		System.out.println("Digite o CEP do paciente:");
		int pacienteCep = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.println("Digite a descrição da dose da vacina (1º dose; 2º dose; Dose de Reforço):");
		String vacinaDose = scanner.nextLine();

		System.out.println("Digite o nome da vacina (CoronaVac, AstraZeneca, Pfizer):");
		String vacinaNome = scanner.nextLine();

		try {
			String query = "INSERT INTO tbl_test (document_id, paciente_id, paciente_idade, paciente_enumSexoBiologico, paciente_endereco_nmMunicipio, paciente_endereco_cep, vacina_descricao_dose, vacina_nome) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, documentId);
			preparedStatement.setString(2, pacienteId);
			preparedStatement.setInt(3, pacienteIdade);
			preparedStatement.setString(4, pacienteSexo);
			preparedStatement.setString(5, pacienteMunicipio);
			preparedStatement.setInt(6, pacienteCep);
			preparedStatement.setString(7, vacinaDose);
			preparedStatement.setString(8, vacinaNome);

			preparedStatement.executeUpdate();
			System.out.println("Dados adicionados com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar dados: " + e.getMessage());
		}
	}

	public void exibirTabela() {
		try {
			String query = "SELECT * FROM tbl_test";
			resultSet = statement.executeQuery(query);

			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();

			// Print column names
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(metaData.getColumnName(i) + "\t");
			}
			System.out.println();

			// Print table data
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao exibir tabela: " + e.getMessage());
		}
	}

	public void exibirRelacaoVacinaSexo() {
		try {
			String query = "SELECT vacina_nome, paciente_enumSexoBiologico, COUNT(*) as quantidade FROM tbl_test GROUP BY vacina_nome, paciente_enumSexoBiologico";
			resultSet = statement.executeQuery(query);

			System.out.println("=== Relação entre Nome da Vacina e Sexo Biológico (Quantidade) ===");
			System.out.println("Vacina Nome\tSexo Biológico\tQuantidade");
			System.out.println("---------------------------------------------");

			while (resultSet.next()) {
				String vacinaNome = resultSet.getString("vacina_nome");
				String pacienteSexo = resultSet.getString("paciente_enumSexoBiologico");
				int quantidade = resultSet.getInt("quantidade");
				System.out.println(vacinaNome + "\t\t" + pacienteSexo + "\t\t" + quantidade);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao exibir relação: " + e.getMessage());
		}
	}

	public void fecharConexao() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
			System.out.println("Conexão fechada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexão: " + e.getMessage());
		}
	}

}
