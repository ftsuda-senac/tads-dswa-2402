package br.senac.tads.dsw.dadospessoais.pessoas;

import br.senac.tads.dsw.dadospessoais.pessoas.repository.Interesse;
import br.senac.tads.dsw.dadospessoais.pessoas.repository.Pessoa;
import br.senac.tads.dsw.dadospessoais.pessoas.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PessoaServiceJpaImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaDto converterEntidadeParaDto(Pessoa p) {
        PessoaDto dto = new PessoaDto();
        dto.setNome(p.getNome());
        dto.setApelido(p.getApelido());
        dto.setDataNascimento(p.getDataNascimento());
        dto.setEmail(p.getEmail());
        dto.setTelefone(p.getTelefone());

        if (p.getInteresses() != null && !p.getInteresses().isEmpty()) {
            List<String> interessesDto = new ArrayList<>();
            for (Interesse interesse : p.getInteresses()) {
                interessesDto.add(interesse.getNome());
            }
            dto.setInteresses(interessesDto);
        }
        return dto;
    }

    @Override
    public List<PessoaDto> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDto> resultado = new ArrayList<>();
        for (Pessoa p : pessoas) {
            PessoaDto dto = converterEntidadeParaDto(p);
            resultado.add(dto);
        }
        return resultado;
    }

    @Override
    public Optional<PessoaDto> findByApelido(String apelido) {
        Optional<Pessoa> pessoa = pessoaRepository.buscarPorApelido(apelido);
        if (pessoa.isEmpty()) {
            return Optional.empty();
        }
        PessoaDto dto = converterEntidadeParaDto(pessoa.get());
        return Optional.of(dto);
    }

    @Override
    public void incluir(PessoaDto dto) {
        Pessoa p = new Pessoa();
        p.setNome(dto.getNome());
        p.setApelido(dto.getApelido());
        p.setDataNascimento(dto.getDataNascimento());
        p.setEmail(dto.getEmail());
        p.setTelefone(dto.getTelefone());
        p.setSenha(dto.getSenha());
        if (dto.getInteresses() != null && !dto.getInteresses().isEmpty()) {
            Set<Interesse> interesses = new LinkedHashSet<>();
            for (String interesseDto : dto.getInteresses()) {
                Interesse i = new Interesse();
                i.setNome(interesseDto);
                interesses.add(i);
            }
            p.setInteresses(interesses);
        }

        pessoaRepository.save(p);
    }

    @Override
    public Optional<PessoaDto> alterar(String apelido, PessoaDto pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<String> excluir(String apelido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
