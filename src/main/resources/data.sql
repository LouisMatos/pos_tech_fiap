--Clientes
INSERT INTO CLIENTES (NOME, EMAIL, CPF) SELECT * FROM (SELECT 'Daniel Teste', 'daniel@teste.com', '59766143021')   AS tmp WHERE NOT EXISTS (SELECT id_cliente FROM clientes WHERE id_cliente = 1) LIMIT 1;
INSERT INTO CLIENTES (NOME, EMAIL, CPF) SELECT * FROM (SELECT 'Luis Teste', 'luis@teste.com', '60904915000')       AS tmp WHERE NOT EXISTS (SELECT id_cliente FROM clientes WHERE id_cliente = 2) LIMIT 1;
INSERT INTO CLIENTES (NOME, EMAIL, CPF) SELECT * FROM (SELECT 'Lucas Teste', 'lucas@teste.com', '42030321052')     AS tmp WHERE NOT EXISTS (SELECT id_cliente FROM clientes WHERE id_cliente = 3) LIMIT 1;
INSERT INTO CLIENTES (NOME, EMAIL, CPF) SELECT * FROM (SELECT 'Ana Teste', 'ana@teste.com', '02304335020')         AS tmp WHERE NOT EXISTS (SELECT id_cliente FROM clientes WHERE id_cliente = 4) LIMIT 1;
INSERT INTO CLIENTES (NOME, EMAIL, CPF) SELECT * FROM (SELECT 'Jessica Teste', 'jessica@teste.com', '66226725044') AS tmp WHERE NOT EXISTS (SELECT id_cliente FROM clientes WHERE id_cliente = 5) LIMIT 1;

--Categorias
INSERT INTO CATEGORIAS(NOME, DESCRICAO) SELECT * FROM (SELECT 'LANCHE', 'Conjunto de ingredientes que forma um lanche') AS tmp WHERE NOT EXISTS (SELECT id_categoria FROM categorias WHERE id_categoria = 1) LIMIT 1;
INSERT INTO CATEGORIAS(NOME, DESCRICAO) SELECT * FROM (SELECT 'ACOMPANHAMENTO', 'Produtos que acompanham o lanche')     AS tmp WHERE NOT EXISTS (SELECT id_categoria FROM categorias WHERE id_categoria = 2) LIMIT 1;
INSERT INTO CATEGORIAS(NOME, DESCRICAO) SELECT * FROM (SELECT 'BEBIDA', 'Liquido gelado para beber')                    AS tmp WHERE NOT EXISTS (SELECT id_categoria FROM categorias WHERE id_categoria = 3) LIMIT 1;
INSERT INTO CATEGORIAS(NOME, DESCRICAO) SELECT * FROM (SELECT 'SOBREMESA', 'Alimento doce para comer após a refeição')  AS tmp WHERE NOT EXISTS (SELECT id_categoria FROM categorias WHERE id_categoria = 4) LIMIT 1;

--Lanches
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Tião Matador', 'Hamburguer pao brioche, com alface cebola e blend de costela', 33.29, 1, string_to_array('teste001.jpg,teste002.jpg', ','))  AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 1) LIMIT 1;
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Maria Bonita', 'Hamburguer pao normal, com alface cebola e blend de picanha', 37.88, 1, string_to_array('teste001.jpg,teste002.jpg', ','))   AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 2) LIMIT 1;

--Acompanhamentos
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Batata Frita', 'Batata frita tipo palito congelada', 15.82, 2, string_to_array('teste001.jpg,teste002.jpg', ','))                      AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 3) LIMIT 1;
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Batata com Cheddar e Bacon', 'Batata frita rustica com cheddar e bacon', 23.57, 2, string_to_array('teste001.jpg,teste002.jpg', ','))  AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 4) LIMIT 1;

--Bebidas
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Refrigerante 350ml', 'Refrigerante 350ml', 5.61, 3, string_to_array('teste001.jpg,teste002.jpg', ','))                                 AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 5) LIMIT 1;
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Suco Natural 500ml', 'Suco Natural 500ml', 8.17, 3, string_to_array('teste001.jpg,teste002.jpg', ','))                                 AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 6) LIMIT 1;

--Sobremesas
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Sorvete', 'Sorvete de massa', 13.45, 4, string_to_array('teste001.jpg,teste002.jpg', ','))                                             AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 7) LIMIT 1;
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) SELECT * FROM (SELECT 'Cokie', 'Biscoito de chocolate', 3.77, 4, string_to_array('teste001.jpg,teste002.jpg', ','))                                           AS tmp WHERE NOT EXISTS (SELECT id_produto FROM produtos WHERE id_produto = 8) LIMIT 1;

--Pedidos
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE, NUMERO_PEDIDO, STATUS_PAGAMENTO) SELECT * FROM (SELECT 0, 194.39, TO_TIMESTAMP('2023-10-11 20:31:56.557', 'YYYY-MM-DD HH24:MI:SS.MS'), 2, 'ZWDRLA' , 0) AS tmp WHERE NOT EXISTS (SELECT id_pedido FROM pedidos WHERE id_pedido = 1) LIMIT 1;
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE, NUMERO_PEDIDO, STATUS_PAGAMENTO) SELECT * FROM (SELECT 1, 190.79, TO_TIMESTAMP('2023-10-11 20:32:52.618', 'YYYY-MM-DD HH24:MI:SS.MS'), 1, 'BWDRL1' , 1) AS tmp WHERE NOT EXISTS (SELECT id_pedido FROM pedidos WHERE id_pedido = 2) LIMIT 1;
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE, NUMERO_PEDIDO, STATUS_PAGAMENTO) SELECT * FROM (SELECT 2, 81.37,  TO_TIMESTAMP('2023-10-11 20:33:21.251', 'YYYY-MM-DD HH24:MI:SS.MS'), 3, 'FWDR20' , 1)  AS tmp WHERE NOT EXISTS (SELECT id_pedido FROM pedidos WHERE id_pedido = 3) LIMIT 1;
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE, NUMERO_PEDIDO, STATUS_PAGAMENTO) SELECT * FROM (SELECT 3, 169.17, TO_TIMESTAMP('2023-10-11 20:52:51.781', 'YYYY-MM-DD HH24:MI:SS.MS'), 4, 'ZTDR3A' , 0) AS tmp WHERE NOT EXISTS (SELECT id_pedido FROM pedidos WHERE id_pedido = 4) LIMIT 1;
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE, NUMERO_PEDIDO, STATUS_PAGAMENTO) SELECT * FROM (SELECT 0, 169.17, TO_TIMESTAMP('2023-10-11 20:52:51.781', 'YYYY-MM-DD HH24:MI:SS.MS'), 4, 'ZTFR3A' , 2) AS tmp WHERE NOT EXISTS (SELECT id_pedido FROM pedidos WHERE id_pedido = 5) LIMIT 1;

--Itens dos Pedidos
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 1, 1, 1, 'tirar a salada') AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 1) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 3, 2, 1, 'COLOCA TUDO')    AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 2) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 3, 3, 1, 'Colocar bacon')  AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 3) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 3, 2, 2, 'tirar a salada') AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 4) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 1, 2, 2, 'COLOCA TUDO')    AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 5) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 7, 5, 2, 'Colocar bacon')  AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 6) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 1, 2, 3, 'tirar a salada') AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 7) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 1, 2, 3, 'COLOCA TUDO')    AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 8) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 1, 5, 3, 'Colocar bacon')  AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 9) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 2, 4, 4, 'Colocar bacon')  AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 10) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 1, 2, 4, 'Colocar bacon')  AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 11) LIMIT 1;
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) SELECT * FROM (SELECT 15, 5, 4, 'Colocar bacon') AS tmp WHERE NOT EXISTS (SELECT id_item_pedido FROM itens_pedido WHERE id_item_pedido = 12) LIMIT 1;
