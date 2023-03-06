package mx.babel.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTiempoTranscurridoFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("Entrando a post");

        Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
        
        log.info(String.format("Tiempo transcurrido en segundos %s", tiempoTranscurrido.doubleValue() / 1000.00));
        log.info(String.format("Tiempo transcurrido en miliseg %s", tiempoTranscurrido.doubleValue()));
        return null;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
    
}
