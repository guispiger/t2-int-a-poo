package intapo.t2.atletas.competicao;

import java.math.BigDecimal;
import java.util.ArrayList;

import intapo.t2.atletas.Atleta;

public class SimuladorCompeticao {
	public Resultado simular(Competicao c) {
		Resultado resultado = new Resultado();

		int contagemAtletas = 0;

		for (Atleta atleta : c.getAtletasInscritos()) {
			DesempenhoAtleta desempenho = new DesempenhoAtleta();
			desempenho.setNomeAtleta(atleta.getNome());
			desempenho.setDesempenho(atleta.competir());
			resultado.getDesempenhos().add(desempenho);
			contagemAtletas++;
			resultado.setNumeroParticipantes(contagemAtletas);
		}

		resultado.setNomeAtletaCampeao(verificaCampeao(resultado.getDesempenhos()));

		return resultado;
	}

	private String verificaCampeao(ArrayList<DesempenhoAtleta> desempenhos) {
		String nomeCampeao = null;
		BigDecimal desempenho = new BigDecimal("0");

		for (DesempenhoAtleta desempenhoAtleta : desempenhos) {
			if (desempenhoAtleta.getDesempenho().compareTo(desempenho) >= 0) {
				desempenho = desempenhoAtleta.getDesempenho();
				nomeCampeao = desempenhoAtleta.getNomeAtleta();
			}
		}
		return nomeCampeao;
	}
}
