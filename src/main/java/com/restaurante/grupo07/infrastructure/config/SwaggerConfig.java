package com.restaurante.grupo07.infrastructure.config;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springTccRestauranteOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TCC Grupo O7 - Restaurante API")
                        .description("Sistema desenvolvido para o trabalho de conclusão de curso na Etec Uirapuru, " +
                                "no curso de Desenvolvimento de Sistemas")
                        .version("v0.0.1")
                        .license(new License().name("Centro Paula Souza - Etec Uirapuru")
                                .url("https://www.cps.sp.gov.br/etecs/etec-uirapuru-uirapuru/"))
                        .contact(new Contact().name("Projeto Restaurante API")
                                .url("https://github.com/LeoDuarte37/TCC-Restaurante")
                                .email("leonardo.r.s.duarte@gmail.com")))

                .externalDocs(new ExternalDocumentation().description("Github")
                        .url("https://github.com/LeoDuarte37/TCC-Restaurante"));
    }

    @Bean
    OpenApiCustomizer customizerGlobalHeaderOpenAPI() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto excluído!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso não autorizado!"));
                apiResponses.addApiResponse("403", createApiResponse("Acesso proibido!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto não encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação!"));
            }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}
