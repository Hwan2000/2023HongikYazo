package hongik.yazo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOriginPatterns(
                        "https://www.2023hogikyajo.com",
                        "http://localhost:3000",
                        "https://2023yajo.github.io",
                        "https://2023hongikyajo.com"
                )
                .allowedHeaders("Origin", "Content-Type", "Accept")
                .allowedMethods("GET", "POST");
    }
}
