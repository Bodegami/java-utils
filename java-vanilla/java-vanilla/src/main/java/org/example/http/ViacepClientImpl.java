package org.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ViacepClientImpl implements IHttpViacepClient {

    private final String url = "http://viacep.com.br/ws/";
    private final String jsonFormat = "json";
    private final String xmlFormat = "xml";

    @Override
    public String getResponseHttp(String cep, String format) {

        String endpoint = buildUri(cep, format);

        try {

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(endpoint))
                    .header("Content-Type", "application/".concat(format))
                    .timeout(Duration.ofMillis(3000))
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newBuilder()
                    .build()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return httpResponse.body();

        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException("não foi possível gerar a url...");
        } catch (InterruptedException e) {
            throw new RuntimeException("servidor apresenta lentidão...");
        } catch (IOException e) {
            throw new RuntimeException("falha na conexão...");
        }
    }

    private boolean isValidCep(String cep) {
        return cep.length() == 8 && !cep.contains("-");
    }

    private boolean isValidFormat(String format) {

        return format.equals(jsonFormat) || format.equals(xmlFormat);
    }

    private String buildUri(String cep, String format) {
        if (!isValidCep(cep)) throw new RuntimeException("cep inválido...");

        if (!isValidFormat(format)) throw new RuntimeException("formato inválido...");


        return  url.concat(cep).concat("/").concat(format);
    }
}
