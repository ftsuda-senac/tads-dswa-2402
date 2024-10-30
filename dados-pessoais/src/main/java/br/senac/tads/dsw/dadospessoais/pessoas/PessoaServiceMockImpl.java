package br.senac.tads.dsw.dadospessoais.pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceMockImpl implements PessoaService {

    private Map<String, PessoaDto> mapPessoas;

    public PessoaServiceMockImpl() {
        mapPessoas = new LinkedHashMap<>();
        mapPessoas.put("fulano", new PessoaDto("fulano", "Fulano da Silva",
                LocalDate.parse("2000-10-20"),
                "fulano@email.com.br", "(11) 99999-1234",
                List.of("Java", "Spring Boot")));
        mapPessoas.put("ciclano", new PessoaDto("ciclano", "Ciclano de Souza",
                LocalDate.parse("1999-05-15"),
                "ciclano@email.com.br", "(11) 98765-1122",
                List.of("HTML", "CSS")));
        mapPessoas.put("beltrana", new PessoaDto("beltrana", "Beltrana dos Santos",
                LocalDate.parse("2001-06-25"),
                "beltrana@email.com.br", "(11) 98877-5600",
                List.of("HTML", "Javascript")));
    }

    @Override
    public List<PessoaDto> findAll() {
        return new ArrayList<>(mapPessoas.values());
    }

    public PessoaDto findByApelido1(String apelido) {
        return mapPessoas.get(apelido);
    }
    
    @Override
    public Optional<PessoaDto> findByApelido(String apelido) {
        return Optional.ofNullable(mapPessoas.get(apelido));
    }
    
    @Override
    public void incluir(PessoaDto pessoa) {
        mapPessoas.put(pessoa.getApelido(), pessoa);
    }
    
    @Override
    public Optional<PessoaDto> alterar(String apelido, PessoaDto pessoa) {
        if (!mapPessoas.containsKey(apelido)) {
            return Optional.empty();
        }
        pessoa.setApelido(apelido);
        mapPessoas.put(apelido, pessoa);
        return Optional.of(pessoa);
    }
    
    @Override
    public Optional<String> excluir(String apelido) {
        if (!mapPessoas.containsKey(apelido)) {
            return Optional.empty();
        }
        mapPessoas.remove(apelido);
        return Optional.of(apelido);
    }

}
