package intapo.t2.atletas;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Atleta {
	private String nome;
	private LocalDate dataNascimento;
	private BigDecimal peso;
	private BigDecimal flexibilidade;
	private BigDecimal resistencia;
	private BigDecimal folego;
	private BigDecimal forca;
	private int numeroLesoes;

	public abstract BigDecimal competir();

	@Override
	public String toString() {
		return "Atleta [nome=" + nome + ", nascimento=" + dataNascimento + "]\n";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getFlexibilidade() {
		return flexibilidade;
	}

	public void setFlexibilidade(BigDecimal flexibilidade) {
		this.flexibilidade = flexibilidade;
	}

	public BigDecimal getResistencia() {
		return resistencia;
	}

	public void setResistencia(BigDecimal resistencia) {
		this.resistencia = resistencia;
	}

	public BigDecimal getFolego() {
		return folego;
	}

	public void setFolego(BigDecimal folego) {
		this.folego = folego;
	}

	public BigDecimal getForca() {
		return forca;
	}

	public void setForca(BigDecimal forca) {
		this.forca = forca;
	}

	public int getNumeroLesoes() {
		return numeroLesoes;
	}

	public void setNumeroLesoes(int numeroLesoes) {
		this.numeroLesoes = numeroLesoes;
	}

}
