package intapo.t2.atletas.competicao;

import java.math.BigDecimal;

public class DesempenhoAtleta {
	private String nomeAtleta;
	private BigDecimal desempenho;

	public String getNomeAtleta() {
		return nomeAtleta;
	}

	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}

	public BigDecimal getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(BigDecimal desempenho) {
		this.desempenho = desempenho;
	}

}
