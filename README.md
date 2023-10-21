
<h1 align="center"> Sistema de Controle de Pedidos de Lanchonete </h1>

> Status do Projeto: em desenvolvimento :warning:


### Tópicos 

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Domain-driven design](#domain-driven-design)

:small_blue_diamond: [Diagramas de Fluxo](#diagramas-de-fluxo)

:small_blue_diamond: [Pré-requisitos](#pré-requisitos)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)

# 

## Descrição do Projeto

<p align="justify"> Projeto desenvolvido durante o curso de Pós-Graduação em software architecture na instituição FIAP, visando aplicar todos os conceitos aprendidos durante o curso! </p>

Contexto do Domínio:

Com o crescimento de uma lanchonete local, surge a necessidade de otimizar e organizar o processo de pedidos e entregas. Para garantir a eficiência e a satisfação dos clientes, desenvolvemos um sistema de controle de pedidos que aborda desde a escolha do produto até a retirada do pedido.


## Domain-driven design

1. Entidades e Agregações:

    Entidades:

    * Cliente
    * Produto
    * Pedido
    * Fatura

    Agregações:

    * Itens do Pedido (agrupa produtos específicos sob um Pedido)
    * Cozinha (conjunto de profissionais e equipamentos dedicados à preparação dos produtos)

3. Objetos de Valor:
    
    * Categoria de Produto
    * Status do Pedido
    * Status de Pagamento

4. Eventos de Domínio:

    * PedidoRealizado: Ocorre quando um Cliente faz um Pedido.
    * PedidoPreparado: Ocorre quando a Cozinha finaliza os Itens do Pedido.
    * PagamentoConfirmado: Ocorre quando o pagamento é efetivamente registrado.
    * PagamentoRecusado: Ocorre quando há um problema com a transação de pagamento.

5. Restrições e Regras de Negócio:

    * Cada Pedido deve conter pelo menos um Produto.
    * A transição do Status do Pedido deve ocorrer em uma sequência definida, como: PedidoRealizado -> PedidoEmPreparo -> PedidoPronto -> PedidoEntregue.
    * A confirmação da Fatura precede a entrega do Pedido ao Cliente.


6. Relacionamentos:

    * Um Cliente pode fazer vários Pedidos, mas cada Pedido pertence a apenas um Cliente.
    * Um Pedido pode conter vários Produtos, mas cada Produto pode ser parte de diversos Pedidos.


7. Consistência e Transações:

    * A disponibilidade de um Produto é verificada ao realizar o Pedido.
    * Todos os pagamentos são registrados em uma Fatura e têm um Status de Pagamento associado para rastreabilidade.


8. Glossário:

    * Cliente: Indivíduo que realiza a solicitação de produtos na lanchonete.   
    * Produto: Alimento ou bebida que é oferecido pela lanchonete.
    * Categoria: Classificação de um Produto conforme suas características (por exemplo, bebidas, lanches etc)

##  Diagramas de fluxo


Foram utilizadas técnicas de Domain Driven Design para definição dos fluxos utilizando a ferramenta mirror

1. Realização do pedido e pagamento

![image](https://github.com/Jeffe-git/First-Project/assets/40615923/13a08458-d713-4738-886f-426ad2e3c720)


2. Preparação e Entrega do Pedido

![Preparacao_EntregaPedido](https://github.com/Jeffe-git/First-Project/assets/40615923/fb7c901d-e6c9-4f90-8c6e-f508ba67557e)

## Pré-requisitos

1. Para rodar a aplicação via ambiente docker:

    :warning: [Docker](https://docs.docker.com/engine/install/)

    :warning: [Docker compose](https://docs.docker.com/compose/install/)

2. Para rodar  a aplicação em localhost:

    :warning: [Docker](https://docs.docker.com/engine/install/)

    :warning: [Docker compose](https://docs.docker.com/compose/install/)

    :warning: [Eclipse](https://www.eclipse.org/downloads/) ou [IntelliJ](https://www.jetbrains.com/idea/download/)

    :warning: [JDK Development Kit 21](https://www.oracle.com/br/java/technologies/downloads/) 


## Como rodar a aplicação :arrow_forward:

1. No terminal, clone o projeto: 

    ```
    git clone https://github.com/LouisMatos/pos_tech_fiap.git
    ```

2. Entre na pasta do projeto: 

    ```
    cd pos_tech_fiap
    ```
3. Execute no terminal o comando: 

    ```
    docker-compose build --no-cache && docker-compose up -d
    ```
4. Acesse o swagger pela url: 

    ```
    http://localhost:8070/swagger-ui/index.html
    ```