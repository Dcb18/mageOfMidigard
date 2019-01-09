package br.com.invillia.magesOfMidgard.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.logging.LogRecord;

@Component /** Notação de stereotype, dizendo que essa classe é um componente **/
@Order(2) /** Notação que indica qual a ordem de execução das implementações de uma mesma classe **/
public class RequestResponseLoggingFilter implements Filter {
    /**Cria uma instancia de logger, para ser usado para imprimir logs no console**/
    private static Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    /** Médoto que iria monitorar e capturar as requisições de trafego de pagina no cliente **/
    @Override/** Notação usada para indicar que o metodo esta sobrescrevendo um metodo de uma classe implementada/extendida**/

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());
        chain.doFilter(request, response);
        logger.info(
                "Logging Response :{}",
                res.getContentType());
    }



}
