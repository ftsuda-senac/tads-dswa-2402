package br.senac.tads.dsw.exemplos;

import jakarta.validation.Valid;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplos-post")
public class ExemplosPostController {
    
    @PostMapping
    public DadosPessoaisDto exemplo01(@RequestBody DadosPessoaisDto dadosRecebidos) {
        DadosPessoaisDto resposta  = new DadosPessoaisDto(dadosRecebidos.getNome(),
                dadosRecebidos.getEmail(), dadosRecebidos.getTelefone(), 
                dadosRecebidos.getDataNascimento(),
                "https://br.linkedin.com/in/padrao", "https://github.com/padrao",
                "padrao.jpg", 123);
        return resposta;
    }

    @PostMapping("/ex02")
    public DadosPessoaisDto receberDados(@RequestBody DadosInputDto input) {
        DadosPessoaisDto resposta  = new DadosPessoaisDto(input.getNome(),
                input.getEmail(), input.getTelefone(), 
                input.getDataNascimento(),
                "https://br.linkedin.com/in/padrao", "https://github.com/padrao",
                "padrao.jpg", 123);
        return resposta;
    }
    
    @PostMapping("/ex03")
    public DadosPessoaisDto receberDadosComValidacao(@RequestBody @Valid DadosInputDto input) {
        DadosPessoaisDto resposta  = new DadosPessoaisDto(input.getNome(),
                input.getEmail(), input.getTelefone(), 
                input.getDataNascimento(),
                "https://br.linkedin.com/in/padrao", "https://github.com/padrao",
                "padrao.jpg", 333);
        return resposta;
    }
    
}
