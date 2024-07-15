package br.com.alura.screenmatch.modelos;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var meuFilme = new Filme.Filmes();
        meuFilme.setNome("Minha mãe é uma peça");
        meuFilme.setAnoDeLancamento(2019);
        meuFilme.setDuracaoEmMinutos(160);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.setIncluidoNoPlano(true);
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(5);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        // meuFilme.somaDasAvaliacoes() = 1;
        //System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodios(50);
        System.out.println("Duração para maratonar lost: " + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        Espisodio episodio = new Espisodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);



                //codigo anterior omitido

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);


        System.out.println("Tamanho da lista: " +listaDeFilmes.size());
        System.out.println("Primeiro Filme: " +listaDeFilmes.get(0));
        System.out.println(listaDeFilmes);



    }

    static class Teste {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Filme.Filmes seuFilme = new Filme.Filmes();
            seuFilme.setNome("Meu Malvado favorto 4");
            seuFilme.setAnoDeLancamento(2024);
            System.out.println("Digite o nome do filme: ");
            String nomeDoFilme = scanner.nextLine();
            seuFilme.setNome(nomeDoFilme);
            System.out.println("Digite a quantidade em minutos: ");
            int minutos = (int) scanner.nextInt();
            seuFilme.setDuracaoEmMinutos(minutos);
            System.out.println("\nDigite três notas entre 0 e 100: ");
            for (int i = 0; i < 3; i++) {
                double nota;
                do {
                    nota = scanner.nextDouble();
                    if (nota < 0 || nota > 100) {
                        System.out.println("Nota inválida! Tente novamente.");
                    }
                } while (nota < 0 || nota > 100);

                seuFilme.avalia(nota);
            }
            //System.out.println("Total de notas: " + seuFilme.somaDasAvaliacoes);
            System.out.println(seuFilme.getTotalDeAvaliacoes() + " Pessoas Avaliaram este filme.");
            String numeroFormatadoDaMedia = String.format("%.2f", seuFilme.pegaMedia());
            System.out.println(numeroFormatadoDaMedia  + "% Avaliação.") ;
        }
    }
}
