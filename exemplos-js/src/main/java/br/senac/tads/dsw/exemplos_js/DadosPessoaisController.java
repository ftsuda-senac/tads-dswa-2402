package br.senac.tads.dsw.exemplos_js;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosPessoaisController {

    @GetMapping("/dados-joao")
    public String dadosJson() {
        return """
            {
				"nome":"João Marcelino",
				"email":"joao.marcelino@email.com",
				"telefone":"(11) 98765-4321",
				"dataNascimento":"30/01/2004",
				"linkedinUrl":"https://br.linkedin.com/in/joaomarcelino",
				"githubUrl":"https://github.com/joaomarcelino"
		    }
            """;
    }

}
