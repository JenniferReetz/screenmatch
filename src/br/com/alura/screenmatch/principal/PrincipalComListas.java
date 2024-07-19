package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sendler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");
        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação ");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano ");
        System.out.println(lista);
    }
}
