package intapo.t2.atletas.competicao;

import java.util.ArrayList;

public class Resultado {
	private String nomeAtletaCampeao;
	private int numeroParticipantes;
	private ArrayList<DesempenhoAtleta> desempenhos = new ArrayList<DesempenhoAtleta>();

	public String getNomeAtletaCampeao() {
		return nomeAtletaCampeao;
	}

	public void setNomeAtletaCampeao(String nomeAtletaCampeao) {
		this.nomeAtletaCampeao = nomeAtletaCampeao;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	public ArrayList<DesempenhoAtleta> getDesempenhos() {
		return desempenhos;
	}

	public void setDesempenhos(ArrayList<DesempenhoAtleta> desempenhos) {
		this.desempenhos = desempenhos;
	}

}
