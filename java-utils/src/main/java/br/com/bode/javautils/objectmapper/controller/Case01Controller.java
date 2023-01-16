package br.com.bode.javautils.objectmapper.controller;

import br.com.bode.javautils.objectmapper.dto.PessoaDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;


@RestController
@RequestMapping("/case01")
public class Case01Controller {

    private final ObjectMapper objectMapper;

    private static Integer count = 0;

    public Case01Controller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("/1")
    public ResponseEntity<String> transformaEmJson(@RequestBody PessoaDTO dto) {

        int status;
        String response;

        try {

            objectMapper.writeValue(new File("target/pessoa_" + count + ".json"), dto);
            response = "works!!!";
            status = 201;

        } catch(Exception e) {

            response = e.getMessage();
            status = 404;

        }

        count++;
        return ResponseEntity.status(status).body(response);

    }

}
