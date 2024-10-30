package br.senac.tads.dsw.dadospessoais;

import br.senac.tads.dsw.dadospessoais.pessoas.repository.Interesse;
import br.senac.tads.dsw.dadospessoais.pessoas.repository.InteresseRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interesses")
public class InteresseController {
    
    @Autowired
    private InteresseRepository repository;

    @GetMapping
    public List<String> findAll() {
        // return List.of("Java", "Spring Boot", "HTML", "CSS", "Javascript", "Python");
        List<Interesse> interesses = repository.findAll();
        List<String> resultado = new ArrayList<>();
        for (Interesse interesse : interesses) {
            resultado.add(interesse.getNome());
        }
        return resultado;
        
    }

}
