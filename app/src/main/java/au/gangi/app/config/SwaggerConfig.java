package au.gangi.app.config;


// import java.util.List;

// import org.springdoc.core.models.GroupedOpenApi;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.info.License;
// import io.swagger.v3.oas.models.servers.Server;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
// @Configuration
// public class SwaggerConfig {
//     @Bean
//     public GroupedOpenApi publicApi(@Value("${openapi.service.api-docs}") String apiDocs) {
//         return GroupedOpenApi.builder()
//                 .group(apiDocs) // /v3/api-docs/api-service
//                 .packagesToScan("com.example.demo.controller")
//                 .build();
//     }

//     @Bean
//     public OpenAPI openAPI(
//             @Value("${openapi.service.title}") String title,
//             @Value("${openapi.service.version}") String version,
//             @Value("${openapi.service.server}") String serverUrl) {
//         return new OpenAPI()
//                 .servers(List.of(new Server().url(serverUrl)))
//                 .info(new Info().title(title)
//                         .description("API documents")
//                         .version(version)
//                         .license(new License().name("Apache 2.0").url("https://springdoc.org")));
//     }
// }

@OpenAPIDefinition(
		info = @Info(
				title = "Demo API",
				version = "1.0",
				description = "Demo API",
				contact = @Contact(
					name = "Demo",
					email = "contact@demo.com",
					url = "http://demo.com"
					),
				license = @License(
					name = "License of API",
					url = "http://demo.com/license"
					),
				termsOfService = "Terms of service"
		),
		servers = {
			@Server(
				description = "Local Environment",
				url = "http://localhost:8080"
			),
			
		}
)

public class SwaggerConfig {
}