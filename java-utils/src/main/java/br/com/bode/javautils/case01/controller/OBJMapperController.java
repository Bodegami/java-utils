package br.com.bode.javautils.case01.controller;

import br.com.bode.javautils.case01.dto.PessoaDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;


@RestController
@RequestMapping("/case01")
public class OBJMapperController {

    private final ObjectMapper objectMapper;

    private static Integer count = 0;

    public OBJMapperController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("/1")
    public ResponseEntity<String> transformaEmJson(@RequestBody PessoaDTO dto) {

        int status;
        String response;

        try {

            objectMapper.writeValue(new File("target/pessoa_" + count), dto);
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
