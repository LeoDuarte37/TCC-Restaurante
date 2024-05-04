package com.restaurante.grupo07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Grupo07Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo07Application.class, args);

		// Transformar a tabela item em embedable

		// Videos e blog: Padrão Dto e Mapper
		// https://www.youtube.com/watch?v=2GTgDLkDWPQ&list=PLGxZ4Rq3BOBpwaVgAPxTxhdX_TfSVlTcY&index=43
		// https://www.youtube.com/watch?v=qeM3PHD4qoQ
		// https://www.youtube.com/watch?v=lmzpyCNyziI
		// https://marioalvial.medium.com/blindando-sua-api-spring-boot-com-o-padr%C3%A3o-dto-44f97020d1a0


		// Atualização parcial:
		// https://www.youtube.com/watch?v=wVMKnPM9F4E
		// https://www.youtube.com/watch?v=6AJh4cJNOn0

		// http://localhost:8080/h2-console

		// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html


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




			INSERT INTO tb_endereco(id, rua, bairro, cidade, uf)
			VALUES (1, 'General Asdrubal', 'Jardim Arpoador', 'São Paulo', 'SP');

			INSERT INTO tb_contato(id, email, telefone)
			VALUES (1, 'restaurante@gmail.com', '121123132');

			INSERT INTO tb_restaurante(id, nome, cnpj, endereco_id, contato_id)
			VALUES (1, 'Restaurante', '12345678901234', 1, 1);

			INSERT INTO tb_categoria(id, nome, foto, disponivel)
			VALUES (1, 'Comida', 'comida.png', true);

			INSERT INTO tb_produto(id, nome, descricao, foto, valor, disponivel, categoria_id)
			VALUES (1, 'arroz', 'comida tradicional', 'arroz.png', 12, true, 1);
		 */
	}

}
