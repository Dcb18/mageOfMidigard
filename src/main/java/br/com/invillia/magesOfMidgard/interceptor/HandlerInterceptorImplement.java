package br.com.invillia.magesOfMidgard.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Classe que implementa o HandlerInterceptor, sobrescrevendo os médotos para adicionar codigos personalizados **/
public class HandlerInterceptorImplement implements HandlerInterceptor {

    /**Cria uma instancia de logger, para ser usado para imprimir logs no console**/
    private static Logger log = LoggerFactory.getLogger(HandlerInterceptorImplement.class);
    /** Primeiro método a ser executado do handler, sendo chamado antes do handler atual ser executado e a view não foi gerada**/
    @Override /** Notação usada para indicar que o metodo esta sobrescrevendo um metodo de uma classe implementada/extendida**/
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
                + "]" + request.getRequestURI());

        return true;
    }
    /** Método que será chamado depois do handdler for executado **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[postHandle][" + request.getMethod() + "]");

    }
    /** Método que será chamdo depois que a requisição for completada e a view for gerada  **/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) {
        if (ex != null) {
            ex.printStackTrace();
        }
        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
    }

}
