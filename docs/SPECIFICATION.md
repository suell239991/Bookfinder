# BookFinder — Especificação do Projeto

## 1. Visão geral

O BookFinder é uma aplicação Android desenvolvida para permitir que usuários pesquisem livros, consultem informações e mantenham uma coleção de livros favoritos.

A aplicação utilizará a Open Library API para obter informações sobre livros e permitirá o armazenamento local dos dados para consultas mesmo sem conexão com a internet.

## 2. Objetivo

Desenvolver uma aplicação Android aplicando conceitos de arquitetura de software, programação assíncrona, persistência de dados, consumo de APIs REST, testes automatizados e interfaces modernas.

## 3. Problema que pretende resolver

Facilitar a descoberta e organização de livros, permitindo que o usuário encontre obras de seu interesse e mantenha seus livros favoritos disponíveis localmente.

## 4. Requisitos funcionais

- RF01: Permitir pesquisar livros pelo título ou nome do autor.
- RF02: Consultar informações dos livros retornados pela API.
- RF03: Exibir título, autor e capa quando disponíveis.
- RF04: Permitir adicionar e remover livros dos favoritos.
- RF05: Salvar informações dos livros no banco de dados local.
- RF06: Permitir consultar os livros favoritos sem conexão com a internet.
- RF07: Exibir estados de carregamento, sucesso, ausência de resultados e erro.
- RF08: Atualizar os dados locais quando houver conexão com a internet.

## 5. Requisitos não funcionais

- RNF01: Utilizar Kotlin como linguagem principal.
- RNF02: Implementar Clean Architecture.
- RNF03: Desenvolver a interface utilizando Jetpack Compose.
- RNF04: Utilizar Retrofit para consumo da API REST.
- RNF05: Utilizar Room para persistência local.
- RNF06: Utilizar Kotlin Coroutines e StateFlow.
- RNF07: Implementar injeção de dependências com Hilt.
- RNF08: Implementar testes unitários.
- RNF09: Evitar operações bloqueantes na thread principal.
- RNF10: Garantir acesso aos favoritos mesmo sem internet.

## 6. API escolhida

Open Library API.

Documentação: https://openlibrary.org/developers/api

A API foi escolhida por disponibilizar informações públicas sobre livros, autores e capas, permitindo implementar funcionalidades de pesquisa sem necessidade de autenticação.

## 7. Público-alvo

Pessoas interessadas em pesquisar, descobrir e organizar livros.

## 8. Critérios de aceitação

- O usuário consegue pesquisar livros pela aplicação.
- Os resultados são apresentados em uma interface organizada.
- O usuário consegue favoritar livros.
- Os favoritos permanecem disponíveis após fechar e abrir o aplicativo.
- Os favoritos podem ser consultados sem internet.
- Os erros de conexão são tratados sem encerrar inesperadamente a aplicação.
- As principais regras de negócio possuem testes unitários.