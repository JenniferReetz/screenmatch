package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    public static class Filmes extends Titulo implements Classificavel {
        private String diretor;

        public void setDiretor(String diretor) {
            this.diretor = diretor;
        }
        public String getDiretor() {
            return diretor;
        }

        @Override
        public int getClassificacao() {
            return (int) pegaMedia() / 2;
        }
    }
}