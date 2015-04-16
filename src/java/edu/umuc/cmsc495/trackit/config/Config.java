package edu.umuc.cmsc495.trackit.config;

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.web.servlet.config.annotation.EnableWebMvc;  
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;  
import org.springframework.web.servlet.view.UrlBasedViewResolver;  
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
/**
 * Scans all classes under edu.umuc.cmsc495.trackit for controllers
 * @author Christian
 */
  
@Configuration
@ComponentScan("edu.umuc.cmsc495.trackit")
@EnableWebMvc   
public class Config extends WebMvcConfigurerAdapter {  
      
    @Bean  
    public UrlBasedViewResolver setupViewResolver() {
        
        // Sets all .jsp pages in the /views directory as something that 
        // resolves to a controller
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Sets /resources as a location
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/WEB-INF/resources/*");
    }
}  
