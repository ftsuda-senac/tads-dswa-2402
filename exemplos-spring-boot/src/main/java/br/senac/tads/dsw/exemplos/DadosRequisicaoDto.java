package br.senac.tads.dsw.exemplos;

public class DadosRequisicaoDto {
    
    private String userAgent;
    
    private boolean acessoMobile;
    
    private String ipAddress;
    
    public DadosRequisicaoDto(String userAgent, String ipAddress) {
        this.userAgent = userAgent;
        this.ipAddress = ipAddress;
        this.acessoMobile = userAgent.toLowerCase().contains("mobile");
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public boolean isAcessoMobile() {
        return acessoMobile;
    }

    public void setAcessoMobile(boolean acessoMobile) {
        this.acessoMobile = acessoMobile;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
}
