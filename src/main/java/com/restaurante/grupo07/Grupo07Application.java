package com.restaurante.grupo07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Grupo07Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo07Application.class, args);

		// CONTINUAR EM MESA SERVICE E DTO

		// http://localhost:8080/h2-console


		// https://www.youtube.com/watch?v=nG2KTQnES1s


		// Filtro de requisição/consulta
		// https://dzone.com/articles/spring-web-service-response-filtering
		// https://jfilter.sframework.org/projects/jfilter/1.0.18/

		// Inner join com JPA
		// https://pt.stackoverflow.com/questions/476236/como-fazer-inner-join-no-jpa-springboot
		/*
			Exemplo:

			select m.id, m.nome, m.crm, e.descricao
			from Medico m
			inner join m.especialidade e
		 */



		/*
			Comandos data.sql para testes

			INSERT INTO tb_produto (nome, descricao, foto, valor, disponivel, categoria_id) VALUES
			('Arroz', 'sei la', 'https://img.freepik.com/fotos-gratis/composicao-de-comida-brasileira-deliciosa-de-alto-angulo_23-2148739223.jpg', 10, true, 1),
			('Suco', 'sei la', 'https://img.freepik.com/fotos-gratis/composicao-de-comida-brasileira-deliciosa-de-alto-angulo_23-2148739223.jpg', 10, true, 2);

			INSERT INTO tb_categoria (nome, foto, disponivel) VALUES
			('Comida', 'https://img.freepik.com/fotos-gratis/composicao-de-comida-brasileira-deliciosa-de-alto-angulo_23-2148739223.jpg', true),
			('Bebida', 'https://img.freepik.com/fotos-gratis/composicao-de-comida-brasileira-deliciosa-de-alto-angulo_23-2148739223.jpg', true);

			SELECT P.id, P.nome, P.valor, C.nome AS categoria
			FROM tb_produto P
			INNER JOIN tb_categoria C
			ON P.categoria_id = C.id;
		 */
	}

}
