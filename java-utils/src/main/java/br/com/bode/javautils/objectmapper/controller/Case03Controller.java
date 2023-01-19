package br.com.bode.javautils.objectmapper.controller;

import br.com.bode.javautils.objectmapper.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/mapper/case03")
public class Case03Controller {

    private final ObjectMapper mapper;
    private static Integer COUNT = 0;

    public Case03Controller(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(value = "/1")
    public ResponseEntity<String> createObject(Map<String, Object> request) {

        int status;
        String response;
        Cliente cliente = null;


        try {

            status = 200;
            COUNT++;

            cliente = mapper.readValue(new File("jsonfiles/cliente_0.json"), Cliente.class);
            System.out.println(cliente.toString());

            response = cliente.toString();

        }
        catch (Exception e) {
            cliente = null;
            response = "cliente nulo...";
            status = 503;
        }
        return ResponseEntity.status(status).body(response);
    }

}
