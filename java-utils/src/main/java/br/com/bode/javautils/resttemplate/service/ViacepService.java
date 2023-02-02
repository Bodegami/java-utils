package br.com.bode.javautils.resttemplate.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ViacepService {

    // Obs: É interessante que a principio eu utilizei o tipo Long para variavel cep, porém ao efetuar a chamada
    // no endpoint, retornava erro e debugando foi possivel confirmar que o primeiro digito que era '0', era
    // jogado para o final do codigo do cep. Quando mudei a variavel para o tipo String , o problema parou de ocorrer

    private final String VIACEP_URI = "http://www.viacep.com.br/ws/";
    private final String typeJson = "json";
    private final String typeXml = "xml";


    public ResponseEntity<String> getAddress(String cep, String format) {

        int status = 0;
        String response = "";
        RestTemplate restTemplate = new RestTemplate();

        try {

            String validCep = cepFormater(cep);
            String validFormat = typeFormatValidator(format);

            String url = buildUrl(validCep, validFormat);

            String endereco = restTemplate.getForObject(url, String.class);

            status = 200;
            response = endereco;

        } catch(Exception e) {
            status = 500;
            response = "falha ao consumir API..";
        }

        return ResponseEntity.status(status).body(response);
    }

    private boolean cepIsValid(String cep) {
        return cep.length() == 8;
    }

    private String typeFormatValidator(String format) {
        if (format.equals(typeJson)) {
            return typeJson;
        } else if (format.equals(typeXml)) {
            return typeXml;
        } else {
            throw new IllegalArgumentException("Invalid format..");
        }
    }

    private String cepFormater(String cep) {
        if (cepIsValid(cep)) {
            return cep.replace("-", "");
        } else {
            throw new IllegalArgumentException("Invalid cep format...");
        }
    }

    private String buildUrl(String cep, String format) {
        return VIACEP_URI.concat(cep).concat("/").concat(format);
    }

}
