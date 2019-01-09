package br.com.invillia.magesOfMidgard.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component /** Notação de stereotype, dizendo que essa classe é um componente **/
@Order(1) /** Notação que indica qual a ordem de execução das implementações de uma mesma classe **/
public class TransactionFilter implements Filter {
    /**Cria uma instancia de logger, para ser usado para imprimir logs no console**/
    private static Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    /** Médoto que iria monitorar e capturar as requisições de trafego de pagina no cliente **/
    @Override/** Notação usada para indicar que o metodo esta sobrescrevendo um metodo de uma classe implementada/extendida**/
    public void doFilter ( ServletRequest request, ServletResponse response,
    FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        logger.info(
                "Starting a transaction for req : {}",
                req.getRequestURI());

        chain.doFilter(request, response);
        logger.info(
                "Committing a transaction for req : {}",
                req.getRequestURI());
    }


}