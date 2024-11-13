/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.security;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "bearer-jwt")
public class DadosController {
   
    @Autowired
    private UsuarioSistemaService usuarioSistemaService;
    
    @GetMapping("/me")
    public UsuarioSistema obterDados(Authentication authn) {
        Jwt jwt = (Jwt) authn.getPrincipal();
        UsuarioSistema usuario = (UsuarioSistema) 
                usuarioSistemaService.loadUserByUsername(jwt.getSubject());
        return usuario;
    }

    @GetMapping("/peao")
    @PreAuthorize("hasAuthority('SCOPE_PEAO')")
    public MensagemPermissao obterDadosPeao(Authentication authn) {
        Jwt jwt = (Jwt) authn.getPrincipal();
        String nome = jwt.getClaimAsString("nome");
        return new MensagemPermissao(nome, "Usuário com Permissão \"PEAO\"");
    }
    
    @GetMapping("/gerente")
    @PreAuthorize("hasAuthority('SCOPE_GERENTE')")
    public MensagemPermissao obterDadosGerente(Authentication authn) {
        Jwt jwt = (Jwt) authn.getPrincipal();
        String nome = jwt.getClaimAsString("nome");
        return new MensagemPermissao(nome, "Usuário com Permissão \"GERENTE\"");
    }
    
    @GetMapping("/diretor")
    @PreAuthorize("hasAuthority('SCOPE_DIRETOR')")
    public MensagemPermissao obterDadosDiretor(Authentication authn) {
        Jwt jwt = (Jwt) authn.getPrincipal();
        String nome = jwt.getClaimAsString("nome");
        return new MensagemPermissao(nome, "Usuário com Permissão \"DIRETOR\"");
    }
    
}
