# Projeto - Conhecendo Spring Data JPA na Prática com Java

## Feramentas Usadas

* Spring Initializer
* Maven como regerenciador de dependências
* Java JDK 17
* Spring Data JPA
* Banco de dados H2 no modo test
* Banco de dados Postgress no modo dev
* Ide Eclispe STS4
* OpenAPI (Swagger)

## Sobre o projeto
  O projeto consiste de uma API que recebe as entradas via Json e armazena em banco de dados, para tal foi utilizado
  o conceito de camadas, sendo criado os pacotes resources, services, entities, dto.
       As classes do pacote resource são encarregadas de fazer a comunicação com a aplicação cliente, recebendo ou retornando
  dados, através de uma classe que pertencente ao pacote dto, as classes DTO(Data Transfer Object) são encarregadas de trafegar
  os dados copiados da classe correspondente no pacote entities que é monitorada pelo JPA, a classes responsáveis por interagir 
  com o banco de dados estão no pacote de services e implementam a interface JpaRepository do JPA, conforme figura abaixo:

  <img src="https://raw.githubusercontent.com/devsuperior/sds2/master/assets/camadas.png">
 referência: (Github DevSuperior)   https://github.com/devsuperior/sds2/blob/master/aula1/README.md
