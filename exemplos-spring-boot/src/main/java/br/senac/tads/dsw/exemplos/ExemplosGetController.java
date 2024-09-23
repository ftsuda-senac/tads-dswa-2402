package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplos")
public class ExemplosGetController {

    @GetMapping
    public String exemplo01() {
        return "Hello Spring Boot com @RestController";
    }

    @GetMapping("/ex02")
    // @RequestMapping(value = "/ex02", method = RequestMethod.GET) // Formato completo
    public String exemplo02() {
        return "Mensagem exemplo02";
    }

    // Parâmetros enviados via query string
    // http://localhost:8080/exemplos/ex03?nome=Fulano&email=fulano@teste.com.br&dataNascimento=2000-10-20
    @GetMapping("/ex03")
    public String exemplo03(
            @RequestParam("nome") String nomeArg,
            @RequestParam("email") String emailArg,
            @RequestParam("dataNascimento") String dataNascimentoArg) {
        return "Olá " + nomeArg + ". Seu e-mail é " + emailArg
                + " e data de nascimento " + dataNascimentoArg + ".";
    }

    @GetMapping("/ex03b")
    public String exemplo03b(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String dataNascimento) {
        return "Olá " + nome + ". Seu e-mail é " + email
                + " e data de nascimento " + dataNascimento
                + ". (ex: Convenção ao invés de configuração)";
    }

    @GetMapping("/ex04")
    public String exemplo04(
            @RequestParam String nome,
            @RequestParam(defaultValue = "xpto@teste.com") String email,
            @RequestParam(required = false) String dataNascimento) {

        if (dataNascimento != null) {
            long idade = ChronoUnit.YEARS.between(
                    LocalDate.parse(dataNascimento),
                    LocalDate.now());
            return "Olá " + nome + ". Seu e-mail é " + email
                    + " e data de nascimento " + dataNascimento
                    + ". Sua idade é " + idade + ".";
        } else {
            return "Olá " + nome + ". Seu e-mail é " + email + ".";
        }
    }

    @GetMapping("/ex05/{apelido}")
    public String exemplo05(@PathVariable("apelido") String apelido) {
        return "Olá " + apelido + ".";
    }

}
