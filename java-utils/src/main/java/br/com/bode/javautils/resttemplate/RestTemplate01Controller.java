package br.com.bode.javautils.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/busca")
public class RestTemplate01Controller {

    private final String VIACEP_URI = "http://www.viacep.com.br/ws/";
    private final String JSON_FORMAT = "/json";
    private final String XML_FORMAT = "/xml";


    @GetMapping("/{cep}")
    public ResponseEntity<String> buscaCep(@PathVariable String cep) {

        // Obs: É interessante que a principio eu utilizei o tipo Long para variavel cep, porém ao efetuar a chamada
        //no endpoint, retornava erro e debugando foi possivel confirmar que o primeiro digito que era '0', era
        //jogado para o final do codigo do cep. Quando mudei a variavel para o tipo String , o problema parou de ocorrer

        RestTemplate restTemplate = new RestTemplate();

        String url = VIACEP_URI + cep + JSON_FORMAT;
        System.out.println(url);
        int status = 0;
        String response = "";

        try {

            String endereco = restTemplate.getForObject(url, String.class);
            response = endereco.toString();

            status = 200;

        } catch(Exception e) {
            status = 404;
            response = "falha ao consumir API..";
        }

        return ResponseEntity.status(status).body(response);

    }

}
