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