# BookFinder

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose, que permite pesquisar livros utilizando a API Open Library e gerenciar uma lista de livros favoritos.

## Objetivo

O BookFinder foi desenvolvido como projeto acadêmico, aplicando conceitos de desenvolvimento Android, arquitetura de software, persistência local de dados, consumo de APIs e testes unitários.

## Funcionalidades

- Pesquisa de livros através da API Open Library.
- Exibição dos resultados da pesquisa.
- Adição e remoção de livros dos favoritos.
- Armazenamento local dos favoritos utilizando Room.
- Consulta dos favoritos mesmo sem conexão com a internet.
- Navegação entre a tela inicial e a tela de favoritos.

## Tecnologias utilizadas

- **Kotlin:** linguagem de programação.
- **Jetpack Compose:** construção das interfaces.
- **Navigation Compose:** navegação entre telas.
- **Retrofit:** consumo da API Open Library.
- **Room:** persistência local dos dados.
- **Hilt:** injeção de dependências.
- **Coroutines e Flow:** operações assíncronas e observação de dados.
- **JUnit:** testes unitários.
- **Gradle:** gerenciamento e construção do projeto.

## Arquitetura

O projeto utiliza os princípios da Clean Architecture, organizando o código em camadas:

- **Data:** comunicação com a API, banco de dados local e implementação dos repositórios.
- **Domain:** entidades, contratos de repositórios e casos de uso.
- **Presentation:** telas, ViewModels e gerenciamento dos estados da interface.

## API utilizada

O aplicativo utiliza a API pública Open Library para pesquisar informações sobre livros.

Documentação: https://openlibrary.org/developers/api

## Como executar o projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/suell239991/Bookfinder.git
   ```

2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Execute o aplicativo em um emulador ou dispositivo Android.

## Testes

Foram implementados testes unitários para os casos de uso:

- Consulta de livros favoritos.
- Pesquisa de livros.

Os resultados dos testes e os testes funcionais realizados estão documentados em `TEST_RESULTS.md`.

## Estrutura da documentação

```text
BookFinder/
├── app/
├── docs/
│   ├── SPECIFICATION.md
│   ├── PLANNING.md
│   └── TASKS.md
├── screenshots/
├── apk/
├── TEST_RESULTS.md
└── README.md
```

## Capturas de tela

As imagens das principais funcionalidades estão disponíveis na pasta `screenshots`.

## APK

O APK de depuração está disponível na pasta `apk`, permitindo instalar e testar o aplicativo em um dispositivo Android.

## Projeto acadêmico

Desenvolvido como atividade acadêmica para aplicar conhecimentos de desenvolvimento de aplicativos Android, arquitetura de software, consumo de APIs, persistência de dados e testes de software.
