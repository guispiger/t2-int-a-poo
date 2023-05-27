package intapo.t2.atletas.competicao;

import java.util.ArrayList;

import intapo.t2.atletas.Atleta;

public class ListaInscricoesNegadas {
	private int numeroInscricoesNegadas;
	private ArrayList<InscricaoNegada> inscricoesNegadas = new ArrayList<InscricaoNegada>();

	public void atualizarNumeroInscricoesNegadas() {
		this.numeroInscricoesNegadas = inscricoesNegadas.size();
	}
	
	public void cadastrarInscricaoNegada(Atleta atleta, Exception e) {
		InscricaoNegada inscricaoNegada = new InscricaoNegada();
		inscricaoNegada.setNomeAtleta(atleta.getNome());
		inscricaoNegada.setMotivo(e.getMessage());
		this.inscricoesNegadas.add(inscricaoNegada);
		atualizarNumeroInscricoesNegadas();
	}

	public int getNumeroInscricoesNegadas() {
		return numeroInscricoesNegadas;
	}

	public void setNumeroInscricoesNegadas(int numeroInscricoesNegadas) {
		this.numeroInscricoesNegadas = numeroInscricoesNegadas;
	}

	public ArrayList<InscricaoNegada> getInscricoesNegadas() {
		return inscricoesNegadas;
	}

	public void setInscricoesNegadas(ArrayList<InscricaoNegada> inscricoesNegadas) {
		this.inscricoesNegadas = inscricoesNegadas;
	}

}
