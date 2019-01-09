package br.com.invillia.magesOfMidgard.configuration;

import br.com.invillia.magesOfMidgard.interceptor.HandlerInterceptorImplement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Implementa a classe WebMvcConfigurer, para adicionar o interceptor HandlerInterceptorImplement
 * como um interceptor registrado **/

@EnableWebMvc /** Importa algumas configura��es do Spring MVC, para que se possa fazer configura��es para ele**/
@Configuration /** Define que o contexto da classe � de uma classe de configura��o **/
@ComponentScan /** faz com que a classe seja encontrada pelo ComponenetScan**/
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorImplement());
    }

}
