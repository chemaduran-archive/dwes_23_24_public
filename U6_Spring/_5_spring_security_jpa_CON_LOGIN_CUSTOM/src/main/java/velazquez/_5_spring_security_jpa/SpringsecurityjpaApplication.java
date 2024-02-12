package velazquez._5_spring_security_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringsecurityjpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringsecurityjpaApplication.class, args);
  }

  // BEAN PARA HABILITAR i18n
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("locale/messages");
    return messageSource;
  }
}
