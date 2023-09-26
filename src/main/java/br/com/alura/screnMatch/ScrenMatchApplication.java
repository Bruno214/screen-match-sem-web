package br.com.alura.screnMatch;

import br.com.alura.screnMatch.model.Serie;
import br.com.alura.screnMatch.service.ConsumoApi;
import br.com.alura.screnMatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Consumindo a api de series
		System.out.println("Consumindo a API de series");
		String endereco = "https://www.omdbapi.com/?t=gilmore+girls&apikey=29c902fc";
		ConsumoApi consumoApi = new ConsumoApi();
		var dados = consumoApi.obterDados(endereco);

		// converter os dados em uma serie
		ConverteDados dadosJson = new ConverteDados();
		Serie minhaSerie = dadosJson.obterDados(dados, Serie.class);
		System.out.println(minhaSerie);
	}
}
