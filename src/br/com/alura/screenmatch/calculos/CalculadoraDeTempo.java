package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }
//    public void inclui (Filme.Filmes f) {
//        tempoTotal += f.getDuracaoEmMinutos();
//
//    }
//    public void inclui (Serie s) {
//        tempoTotal += s.getDuracaoEmMinutos();
//
//    }
    public void inclui (Titulo titulo){
        System.out.println("Adicionado a duração de minutos de: " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}