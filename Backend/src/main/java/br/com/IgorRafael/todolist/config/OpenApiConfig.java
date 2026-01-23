package br.com.IgorRafael.todolist.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
		
		info = @Info(
				title = "Todo List API",
				description = "API para gerenciamento de tarefas.",
				version = "V1",
				contact = @Contact(
						name = "Igor Coelho"	
						)
				)
		)



public class OpenApiConfig {

}
