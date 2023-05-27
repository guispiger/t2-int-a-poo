package intapo.t2.atletas.competicao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import intapo.t2.atletas.Atleta;
import intapo.t2.atletas.exceptions.ExcessoLesoesException;
import intapo.t2.atletas.exceptions.IdadeException;

public class Competicao {
	private ArrayList<Atleta> atletasInscritos = new ArrayList<Atleta>();

	public ArrayList<Atleta> getAtletasInscritos() {
		return atletasInscritos;
	}

	public void setAtletasInscritos(ArrayList<Atleta> atletasInscritos) {
		this.atletasInscritos = atletasInscritos;
	}

	public void registrarAtleta(Atleta atleta) {
		this.atletasInscritos.add(atleta);
	}

	public void verificarRequisitos(Atleta atleta) {
		LocalDate hoje = LocalDate.now();
		Period anos = Period.between(atleta.getDataNascimento(), hoje);

		if (atleta.getNumeroLesoes() > 10) {
			throw new ExcessoLesoesException("Atleta com excesso de lesões");
		} else if (anos.getYears() < 18) {
			throw new IdadeException("Atleta menor de idade");
		} else if (anos.getYears() > 45) {
			throw new IdadeException("Atleta acima da idade permitida");
		}
	}

}
