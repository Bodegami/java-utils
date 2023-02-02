package br.com.bode.javautils.resttemplate;

import br.com.bode.javautils.resttemplate.service.ViacepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/busca")
public class RestTemplate01Controller {

    private final ViacepService service = new ViacepService();

    @GetMapping("/{cep}/{format}")
    public ResponseEntity<String> buscaCep(@PathVariable String cep, @PathVariable String format) {
        return service.getAddress(cep, format);
    }

}
