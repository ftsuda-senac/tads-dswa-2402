package br.senac.tads.dsw.dadospessoais.pessoas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByApelido(String apelido);

    List<Pessoa> findByNomeLike(String nome);

    List<Pessoa> findByApelidoAndNomeLike(String apelido, String nome);
    
    @Query(value = """
                   SELECT p.*, pi.interesse_nome 
                     FROM pessoa p
                     INNER JOIN pessoa_interesse pi
                        on p.id = pi.pessoa_id
                     WHERE p.apelido = :apelido
                   """,
            nativeQuery = true)
    Optional<Pessoa> buscarPorApelido(String apelido);

}
