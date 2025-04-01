package org.example.library2.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .components(new Components()
                        .addSchemas("User", new Schema<>()
                                .type("object")
                                .addProperties("id", new Schema<>().type("integer"))
                                .addProperties("name", new Schema<>().type("string"))
                        )
                )
                .info(new Info()
                        .title("Мой кастомный API")
                        .version("1.4")
                        .description("Это пользовательский API с Swagger и OpenAPI 3.1")
                        .termsOfService("https://example.com/terms")
                        .contact(new Contact()
                                .name("API Поддержка")
                                .email("support@example.com")
                                .url("https://example.com/contact"))
                        .license(new License()
                                .name("MIT Лицензия")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Более подробную информацию вы найдете здесь")
                        .url("https://example.com/docs"));
    }
}