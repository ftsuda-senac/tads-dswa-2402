package br.senac.tads.dsw.dadospessoais;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    /**
     * Define uma URL para acessar um diretório contendo as imagens<br>
     * Criar o diretório configurado no sistema.<br>
     * Referência: https://www.baeldung.com/spring-mvc-static-resources
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/arquivos-upload/**")
                .addResourceLocations("file:///C:/tads/dsw/servidor-destino/");
    }
    
}
