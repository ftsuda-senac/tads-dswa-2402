/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplos;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    
    public String gerarJson(String nome, String userAgent, String enderecoIp) {
        return "{" + System.lineSeparator()
                + "\t\"texto\" : \"Exemplo JSON gerado no Servlet\"," + System.lineSeparator()
                + "\t\"dataHora\" : \"" + LocalDateTime.now() + "\"," + System.lineSeparator()
                + "\t\"nome\" : \"" + nome + "\"," + System.lineSeparator()
                + "\t\"userAgent\" : \"" + userAgent + "\"," + System.lineSeparator()
                + "\t\"enderecoIp\" : \"" + enderecoIp + "\"" + System.lineSeparator()
                + "}";
    }
    
    @GetMapping("/exemplo-spring-boot")
    public String obterDados(HttpServletRequest request) {
        
        String userAgent = request.getHeader("user-agent");
        String enderecoIp = request.getRemoteAddr();
        String nome = request.getParameter("nome");
        if (nome == null || nome.trim().length() == 0) {
            nome = "Anônimo";
        }
        String resposta = gerarJson(nome, userAgent, enderecoIp);
        return resposta;

    }
    
}
