package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        var meuFilme = new Filme.Filmes("Minha mãe é uma peça", 2019);
        meuFilme.avalia(10);
        Serie lost = new Serie("Lost", 2000);
        lost.avalia(9);
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(lost);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme.Filmes filme && filme.getClassificacao() > 2) {
                System.out.println("Classifição: " + filme.getClassificacao());
            }

        }
    }
}
