package intapo.t2.atletas.main;

import java.util.ArrayList;

import intapo.t2.atletas.Atleta;
import intapo.t2.atletas.Ginasta;
import intapo.t2.atletas.Halterofilista;
import intapo.t2.atletas.Nadador;
import intapo.t2.atletas.competicao.Competicao;
import intapo.t2.atletas.competicao.ListaInscricoesNegadas;
import intapo.t2.atletas.competicao.Resultado;
import intapo.t2.atletas.competicao.SimuladorCompeticao;
import intapo.t2.atletas.manipuladorjson.ManipuladorJson;

public class Main {
	public static void main(String[] args) {
		// Importar dados dos atletas de arquivos .json
		ManipuladorJson json = new ManipuladorJson();

		ArrayList<Ginasta> ginastas = new ArrayList<Ginasta>();
		ArrayList<Halterofilista> halterofilistas = new ArrayList<Halterofilista>();
		ArrayList<Nadador> nadadores = new ArrayList<Nadador>();

		try {
			ginastas = json.lerArquivoGinastas();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			halterofilistas = json.lerArquivoHalterofilistas();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			nadadores = json.lerArquivoNadadores();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Competicoes
		//ginastas
		SimuladorCompeticao simulador = new SimuladorCompeticao();
		Competicao competicaoGinastas = new Competicao();
		ListaInscricoesNegadas ginastasNegados = new ListaInscricoesNegadas();

		for (Atleta atleta : ginastas) {
			try {
				competicaoGinastas.verificarRequisitos(atleta);
				competicaoGinastas.registrarAtleta(atleta);
			} catch (Exception e) {
				ginastasNegados.cadastrarInscricaoNegada(atleta, e);
			}
		}
		
		Resultado resultadoGinastas = simulador.simular(competicaoGinastas);
		
		//halterofilistas
		Competicao competicaoHaterofilistas = new Competicao();
		ListaInscricoesNegadas halterofilistasNegados = new ListaInscricoesNegadas();

		for (Atleta atleta : halterofilistas) {
			try {
				competicaoHaterofilistas.verificarRequisitos(atleta);
				competicaoHaterofilistas.registrarAtleta(atleta);
			} catch (Exception e) {
				halterofilistasNegados.cadastrarInscricaoNegada(atleta, e);
			}
		}

		Resultado resultadoHalterofilistas = simulador.simular(competicaoHaterofilistas);
		
		//nadadores
		Competicao competicaoNadadores = new Competicao();
		ListaInscricoesNegadas nadadoresNegados = new ListaInscricoesNegadas();

		for (Atleta atleta : nadadores) {
			try {
				competicaoNadadores.verificarRequisitos(atleta);
				competicaoNadadores.registrarAtleta(atleta);
			} catch (Exception e) {
				nadadoresNegados.cadastrarInscricaoNegada(atleta, e);
			}
		}

		Resultado resultadoNadadores = simulador.simular(competicaoNadadores);

		// Gravacao dos arquvivos .json de resultados e inscricoes negadas
		//ginastas
		try {
			json.escreverResultado(resultadoGinastas, "ginastica");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			json.escreverListaInscricoesNegadas(ginastasNegados, "ginastica");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//halterofilistas	
		try {
			json.escreverResultado(resultadoHalterofilistas, "halterofilismo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			json.escreverListaInscricoesNegadas(halterofilistasNegados, "halterofilismo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//nadadores
		try {
			json.escreverResultado(resultadoNadadores, "natacao");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			json.escreverListaInscricoesNegadas(nadadoresNegados, "natacao");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
