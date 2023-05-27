package intapo.t2.atletas.manipuladorjson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import intapo.t2.atletas.Ginasta;
import intapo.t2.atletas.Halterofilista;
import intapo.t2.atletas.Nadador;
import intapo.t2.atletas.competicao.ListaInscricoesNegadas;
import intapo.t2.atletas.competicao.Resultado;
import intapo.t2.atletas.exceptions.GravacaoArquivoException;
import intapo.t2.atletas.exceptions.LeituraArquivoException;

public class ManipuladorJson {

	Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.create();

	public ArrayList<Ginasta> lerArquivoGinastas() {
		ArrayList<Ginasta> ginastas = new ArrayList<>();
		try {
			FileReader leitor = new FileReader("ginastas.json");
			ginastas = gson.fromJson(leitor, new TypeToken<ArrayList<Ginasta>>() {
			}.getType());
		} catch (IOException e) {
			throw new LeituraArquivoException("Erro ao ler o arquivo!");
		}

		return ginastas;
	}

	public ArrayList<Halterofilista> lerArquivoHalterofilistas() {
		ArrayList<Halterofilista> halterofilistas = new ArrayList<Halterofilista>();
		try {
			FileReader leitor = new FileReader("halterofilistas.json");
			halterofilistas = gson.fromJson(leitor, new TypeToken<ArrayList<Halterofilista>>() {
			}.getType());
		} catch (IOException e) {
			throw new LeituraArquivoException("Erro ao ler o arquivo!");
		}

		return halterofilistas;
	}

	public ArrayList<Nadador> lerArquivoNadadores() {
		ArrayList<Nadador> nadadores = new ArrayList<Nadador>();
		try {
			FileReader leitor = new FileReader("nadadores.json");
			nadadores = gson.fromJson(leitor, new TypeToken<ArrayList<Nadador>>() {
			}.getType());
		} catch (IOException e) {
			throw new LeituraArquivoException("Erro ao ler o arquivo!");
		}

		return nadadores;
	}
	
	public void escreverResultado(Resultado resultado, String modalidade) {
				
		try {
			FileWriter writer = new FileWriter("resultado-" + modalidade + ".json");
			gson.toJson(resultado, writer);
			writer.close();
		} catch (JsonIOException | IOException e) {
			throw new GravacaoArquivoException("Erro ao gravar arquivo!");
		}
	}
	
	public void escreverListaInscricoesNegadas(ListaInscricoesNegadas inscricoesNegadas, String modalidade) {
		
		try {
			FileWriter writer = new FileWriter("inscricoes-negadas-" + modalidade + ".json");
			gson.toJson(inscricoesNegadas, writer);
			writer.close();
		} catch (JsonIOException | IOException e) {
			throw new GravacaoArquivoException("Erro ao gravar arquivo!");
		}
	}
	
}
