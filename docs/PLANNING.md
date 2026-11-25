# BookFinder — Planejamento Técnico

## 1. Arquitetura

O projeto utilizará Clean Architecture, organizado em três camadas principais:

### Presentation
Responsável pela interface gráfica, navegação e gerenciamento de estados.

Tecnologias:
- Jetpack Compose
- Navigation Compose
- ViewModel
- StateFlow

### Domain
Responsável pelas regras de negócio da aplicação.

Componentes:
- Entidades
- Interfaces de repositórios
- Casos de uso

### Data
Responsável pela comunicação com fontes externas e armazenamento local.

Tecnologias:
- Retrofit
- Room
- Kotlin Coroutines

## 2. Injeção de dependências

Será utilizado Hilt para gerenciar as dependências e facilitar a organização dos componentes da aplicação.

## 3. Estratégia Offline First

O Room será utilizado como fonte de dados local.

Os resultados obtidos pela API serão armazenados no banco de dados. As consultas locais serão utilizadas para disponibilizar informações salvas mesmo sem conexão com a internet.

Os favoritos serão persistidos localmente e permanecerão disponíveis após o encerramento da aplicação.

Quando houver conexão, novas pesquisas poderão atualizar os dados armazenados.

## 4. Tecnologias

- Kotlin
- Android Studio
- Jetpack Compose
- Clean Architecture
- Hilt
- Retrofit
- Room
- Kotlin Coroutines
- StateFlow
- Navigation Compose
- JUnit

## 5. Organização prevista

O código será organizado por funcionalidades e responsabilidades, mantendo a separação entre Presentation, Domain e Data.

## 6. Estratégia de testes

Serão implementados testes unitários para validar as principais regras de negócio, especialmente os casos de uso relacionados aos favoritos e à pesquisa de livros.

## 7. Estratégia de implementação

1. Criar a estrutura inicial.
2. Configurar as dependências.
3. Implementar as entidades e regras de negócio.
4. Configurar o Room.
5. Configurar o Retrofit.
6. Implementar os repositórios.
7. Desenvolver as interfaces.
8. Implementar a navegação.
9. Implementar o funcionamento offline.
10. Criar e executar os testes.
11. Finalizar a documentação e gerar o APK.