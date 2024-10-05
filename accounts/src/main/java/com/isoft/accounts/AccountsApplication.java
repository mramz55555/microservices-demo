package com.isoft.accounts;

import com.isoft.accounts.dto.DataBaseConfigDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.isoft.accounts.controller") })
@EnableJpaRepositories("com.isoft.accounts.repository")
@EntityScan("com.isoft.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {DataBaseConfigDTO.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "isoftBank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Madan Reddy",
						email = "tutor@isoft.com",
						url = "https://www.isoft.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.isoft.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "isoftBank Accounts microservice REST API Documentation",
				url = "https://www.isoft.com/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
