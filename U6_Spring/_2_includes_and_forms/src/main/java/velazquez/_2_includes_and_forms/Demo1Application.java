package velazquez._2_includes_and_forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Demo1Application implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(Demo1Application.class, args);
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("locale/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
