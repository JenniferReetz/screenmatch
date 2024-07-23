package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroDeconversaoDeMinutosException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        while (!busca.equalsIgnoreCase("sair")) {


            System.out.println("Digite o nome do filme para a busca: ");
            busca = leitura.nextLine();
            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            String chave = "a1bf499a";
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + chave;
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //try {

                Titulo meuTitulo = new Titulo(meuTituloOmdb);

                System.out.println("Tútilo já convertido:");
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);


               FileWriter escrita = new FileWriter("filmes.txt");
               escrita.write("g");
               escrita.close();
                escrita.write("s");
                escrita.close();

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço.");
            } catch (ErroDeconversaoDeMinutosException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("titulos.gson");
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }
}