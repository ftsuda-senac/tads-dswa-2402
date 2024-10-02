package br.senac.tads.dsw.dadospessoais.validation;

import br.senac.tads.dsw.dadospessoais.pessoas.PessoaDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class SenhasIguaisValidator implements
        ConstraintValidator<SenhasIguais, PessoaDto> {

    @Override
    public boolean isValid(PessoaDto pessoa, ConstraintValidatorContext context) {
        return pessoa.getSenha().equals(pessoa.getSenhaRepetida());
    }
    
}
