package webService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.GoogleBookResponse;
import dto.VolumeInfo;
import mapper.LivroMapper;
import modelo.Livro;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaLivros {
        public Livro consultaLivros(String titulo) throws IOException, InterruptedException {
        String tituloFinal = titulo.replace(" ", "");
        String endereco = "https://www.googleapis.com/books/v1/volumes/?q=" + tituloFinal;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        GoogleBookResponse googleBookResponse =
                gson.fromJson(json, GoogleBookResponse.class);
        if (googleBookResponse.items() == null || googleBookResponse.items().isEmpty()) {
                throw new RuntimeException("Nenhum livro encontrado");
        }
        VolumeInfo volumeInfo = googleBookResponse.items().get(0).volumeInfo();
        Livro livro = LivroMapper.conversao(volumeInfo);
        return livro;


    }
}
