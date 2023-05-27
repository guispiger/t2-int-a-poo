package intapo.t2.atletas;

import java.math.BigDecimal;

public class Halterofilista extends Atleta {

	@Override
	public BigDecimal competir() {
		BigDecimal desempenho = new BigDecimal("0");

		BigDecimal constForca = new BigDecimal("1.0");
		BigDecimal constResistencia = new BigDecimal("0.6");
		BigDecimal constFolego = new BigDecimal("0.4");
		BigDecimal constFlexibilidade = new BigDecimal("0.3");

		BigDecimal desempenhoForca = getForca().multiply(constForca);
		BigDecimal desempenhoResistencia = getResistencia().multiply(constResistencia);
		BigDecimal desempenhoFolego = getFolego().multiply(constFolego);
		BigDecimal desempenhoFlexibilidade = getFlexibilidade().multiply(constFlexibilidade);
		BigDecimal desempenhoPeso = getPeso().divide(new BigDecimal("100"));
		BigDecimal desempenhoLesoes = new BigDecimal(getNumeroLesoes()).divide(new BigDecimal("10"));

		desempenho = desempenhoForca.add(new BigDecimal("1")).add(desempenhoResistencia).add(desempenhoFolego)
				.add(desempenhoFlexibilidade).add(desempenhoPeso).subtract(desempenhoLesoes);

		return desempenho;
	}

}
