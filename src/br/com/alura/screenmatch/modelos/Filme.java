package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {

    public Filme(String nome, int anoDeLancamento, String link) {
        super(nome, anoDeLancamento, link);
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    public static class Filmes extends Titulo implements Classificavel {
        private String diretor;

        public Filmes(String nome, int anoDeLancamento, String link) {
            super(nome, anoDeLancamento, link);
        }

        public void setDiretor(String diretor) {
            this.diretor = diretor;
        }

        public String getDiretor() {
            return diretor;
        }

        @Override
        public String toString() {
            return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
        }

        @Override
        public int getClassificacao() {
            return (int) pegaMedia() / 2;
        }
    }

}