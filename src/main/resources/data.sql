--Clientes
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Daniel Teste', 'daniel@teste.com', '12345678901');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Luis Teste', 'luis@teste.com', '12345678902');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Lucas Teste', 'lucas@teste.com', '12345678903');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Ana Teste', 'ana@teste.com', '12345678904');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Jessica Teste', 'jessica@teste.com', '12345678905');


--Categorias
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('LANCHE', 'Conjunto de ingredientes que forma um lanche');
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('ACOMPANHAMENTO', 'Produtos que acompanham o lanche');
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('BEBIDA', 'Liquido gelado para beber');
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('SOBREMESA', 'Docinho');


--Lanches
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Tião Matador', 'Hamburguer pao brioche, com alface cebola e blend de costela', 33.29, 1, '[teste001.jpg, teste002.jpg]');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Maria Bonita', 'Hamburguer pao normal, com alface cebola e blend de picanha', 37.88, 1, '[teste004.jpg, teste005.jpg]');

--Acompanhamentos
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Batata Frita', 'Batata frita tipo palito congelada', 15.82, 2, '[teste006.jpg, teste007.jpg]');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Batata com Cheddar e Bacon', 'Batata frita rustica com cheddar e bacon', 23.57, 2, '[teste008.jpg, teste009.jpg]');

--Bebidas
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Refrigerante 350ml', 'Refrigerante 350ml', 5.61, 3, '[teste010.jpg, teste011.jpg]');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Suco Natural 500ml', 'Suco Natural 500ml', 8.17, 3, '[teste012.jpg, teste013.jpg]');

--Sobremesas
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Sorvete', 'Sorvete de massa', 13.45, 4, '[teste014.jpg, teste015.jpg]');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Cokie', 'Biscoito de chocolate', 3.77, 4, '[teste016.jpg, teste017.jpg]');
