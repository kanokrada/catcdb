package cat.cdb;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 

@SpringBootApplication(scanBasePackages = "cat.cdb")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "cat.cdb.repository")
public class CatcdbApplication {
	 public static void main(String[] args) { 
		SpringApplication.run(CatcdbApplication.class, args);
	}

}
