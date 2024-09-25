package br.senac.tads.dsw.exemplos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
            @RequestParam(defaultValue = "default@teste.com") String email,
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
    
    // NÃO USAR - EXEMPLO SOMENTE PARA MOSTRAR O USO DO OBJECTMAPPER DO JACKSON2
    // INTERNAMENTE O SPRING BOOT USA OBJECTMAPPER PARA CONVERTER O OBJETO DTO
    // RETORNADO PELA FUNCAO
    // @GetMapping("/ex06")
    @GetMapping(path = "/ex06", produces = MediaType.APPLICATION_JSON_VALUE)
    public String exemplo06() {
        DadosPessoaisDto dto = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano", "https://github.com/fulano",
                "fulano.jpg", 1234);
        
        ObjectMapper jackson2Mapper = new ObjectMapper();
        jackson2Mapper.registerModule(new JavaTimeModule());
        jackson2Mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            return jackson2Mapper.writeValueAsString(dto);
        } catch(JsonProcessingException ex) {
            return ex.getMessage();
        }
    }
    
    @GetMapping("/ex06b")
    public DadosPessoaisDto exemplo06b() {
        DadosPessoaisDto dto = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano", "https://github.com/fulano",
                "fulano.jpg", 1234);
        return dto;
    }
    
    @GetMapping("/ex06c")
    public List<DadosPessoaisDto> exemplo06c() {
        DadosPessoaisDto dto1 = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano", "https://github.com/fulano",
                "fulano.jpg", 1234);
        DadosPessoaisDto dto2 = new DadosPessoaisDto("Ciclano de Souza",
                "ciclano@teste.com.br", "(11) 99999-4455",
                LocalDate.parse("1999-05-15"),
                "https://br.linkedin.com/in/ciclano", "https://github.com/ciclano",
                "ciclano.jpg", 333);
        DadosPessoaisDto dto3 = new DadosPessoaisDto("Beltrana dos Santos",
                "beltrana@teste.com.br", "(11) 98765-0099",
                LocalDate.parse("2001-06-09"),
                "https://br.linkedin.com/in/beltrana", "https://github.com/beltrana",
                "beltrana.jpg", 42);
        List<DadosPessoaisDto> resultado = new ArrayList<>();
        resultado.add(dto1);
        resultado.add(dto2);
        resultado.add(dto3);
        return resultado;

        // OU return Arrays.asList(dto1, dto2, dto3);
        // OU return List.of(dto3, dto2, dto1);
    }

    @GetMapping("/ex07")
    public DadosRequisicaoDto exemplo07(HttpServletRequest servletRequest) {
        String userAgent = servletRequest.getHeader("user-agent");
        String ipAddress = servletRequest.getRemoteAddr();
        return new DadosRequisicaoDto(userAgent, ipAddress);
    }
    
    @GetMapping("/ex08")
    public DadosRequisicaoDto exemplo08(
            @RequestHeader("user-agent") String userAgent,
            HttpServletRequest servletRequest) {
        String ipAddress = servletRequest.getRemoteAddr();
        return new DadosRequisicaoDto(userAgent, ipAddress);
    }

}
