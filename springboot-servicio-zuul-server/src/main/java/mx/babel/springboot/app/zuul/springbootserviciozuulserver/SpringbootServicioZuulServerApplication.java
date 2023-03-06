package mx.babel.springboot.app.zuul.springbootserviciozuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import mx.babel.springboot.app.zuul.filters.PostTiempoTranscurridoFilter;
import mx.babel.springboot.app.zuul.filters.PreTiempoTranscurridoFilter;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SpringbootServicioZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioZuulServerApplication.class, args);
	}

	@Bean
    public PreTiempoTranscurridoFilter preFilter() {
        return new PreTiempoTranscurridoFilter();
    }
 
    @Bean
    public PostTiempoTranscurridoFilter postFilter() {
        return new PostTiempoTranscurridoFilter();
    }
     
}
