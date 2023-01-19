package br.com.bode.javautils.objectmapper.controller;

import br.com.bode.javautils.objectmapper.dto.PessoaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/mapper/case02")
public class Case02Controller {


    private final ObjectMapper objectMapper;

    private static Integer count = 0;

    public Case02Controller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/1")
    public ResponseEntity<String> transformaEmObjeto() {

        int status;
        String response;
        PessoaDTO pessoaDTO = null;

        try {

            File file = new File("target/pessoa_" + count + ".json");
            pessoaDTO = objectMapper.readValue(file, PessoaDTO.class);
            response = pessoaDTO.toString();
            status = 200;
            count++;

        } catch(Exception e) {

            response = e.getMessage();
            status = 404;
            count--;

        }

        return ResponseEntity.status(status).body(response);

    }

}
