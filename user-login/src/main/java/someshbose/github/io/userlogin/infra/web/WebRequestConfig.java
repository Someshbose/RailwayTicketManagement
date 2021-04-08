package someshbose.github.io.userlogin.infra.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebRequestConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("Request Context received{}.", this.getClass().getSimpleName());
        registry.addInterceptor(new LogRequestInterceptor()).addPathPatterns("/**");
        log.info("Resgistered{}.", this.getClass().getSimpleName());
    }
}
