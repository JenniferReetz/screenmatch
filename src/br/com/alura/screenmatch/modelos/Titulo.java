package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.exception.ErroDeconversaoDeMinutosException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private String link;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;


    public Titulo(String nome, int anoDeLancamento, String link) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.link = link;

    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        this.link = meuTituloOmdb.poster();
        if (meuTituloOmdb.runtime().length() > 7 ){
            throw new ErroDeconversaoDeMinutosException("Não consegui converter a duração" +
                    "em minutos, pois tem mais de 6 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year().substring(0,4));
  if (meuTituloOmdb.runtime().length() == 6) {
      this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
  }
  if (meuTituloOmdb.runtime().length() == 7) {
      this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
  }
    }


    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    //get obter valor
    //set atribuir valor
    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;

    }


    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "\nAno de lancamento: " + anoDeLancamento +
                "; Nome: " + nome + "; Duração em minutos: " + duracaoEmMinutos + "; Link do Poster: " + link + ".";
    }
}

