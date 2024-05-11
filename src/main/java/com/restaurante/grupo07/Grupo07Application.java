package com.restaurante.grupo07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Grupo07Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo07Application.class, args);

		// http://localhost:8080/h2-console

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

			-- Buscar usuarios por nivel de perfil:
			SELECT usuario_id, U.nome, U.email, perfil_nivel
			FROM TB_LOGIN L
			INNER JOIN TB_USUARIO U
			WHERE perfil_nivel = 3;



			INSERT INTO tb_endereco(id, rua, bairro, cidade, uf)
			VALUES (1, 'General Asdrubal', 'Jardim Arpoador', 'São Paulo', 'SP');

			INSERT INTO tb_contato(id, email, telefone)
			VALUES (1, 'restaurante@gmail.com', '121123132');

			INSERT INTO tb_restaurante(id, nome, cnpj, endereco_id, contato_id)
			VALUES (1, 'Restaurante', '12345678901234', 1, 1);

			INSERT INTO tb_categoria(id, nome, foto, disponivel)
			VALUES (1, 'Comida', 'comida.png', true);

			INSERT INTO tb_produto(id, nome, descricao, foto, valor, disponivel, categoria_id) VALUES
			(1, 'arroz', 'comida tradicional', 'arroz.png', 12, true, 1),
			(2, 'feijao', 'comida tradicional', 'feijao.png', 12, true, 1);
		 */
	}

}
