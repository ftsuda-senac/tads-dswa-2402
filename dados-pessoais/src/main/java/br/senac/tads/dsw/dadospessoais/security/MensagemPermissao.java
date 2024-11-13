/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.security;

public class MensagemPermissao {
    
    private String nome;
    
    private String mensagem;
    
    public MensagemPermissao() {
        
    }

    public MensagemPermissao(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
