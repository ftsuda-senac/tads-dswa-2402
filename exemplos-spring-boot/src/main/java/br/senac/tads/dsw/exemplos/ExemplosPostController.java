package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplos-post")
public class ExemplosPostController {
    
    @PostMapping
    public DadosPessoaisDto receberDados(@RequestBody DadosPessoaisDto dadosRecebidos) {
        DadosPessoaisDto resposta  = new DadosPessoaisDto(dadosRecebidos.getNome(),
                dadosRecebidos.getEmail(), dadosRecebidos.getTelefone(), 
                dadosRecebidos.getDataNascimento(),
                "https://br.linkedin.com/in/padrao", "https://github.com/padrao",
                "padrao.jpg", 123);
        return resposta;
    }
    
}
