package org.example;

import org.example.http.IHttpViacepClient;
import org.example.http.ViacepClientImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o cep sem o hífen: ");
        String cep = sc.next();

        System.out.println("Digite o formato de retorno desejado (json/xml): ");
        String format = sc.next();

        try {
            IHttpViacepClient client = new ViacepClientImpl();
            String response = client.getResponseHttp(cep, format);
            System.out.println(response);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
        }


    }
}