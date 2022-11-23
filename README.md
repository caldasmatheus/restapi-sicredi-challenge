# desafio-sicredi-api-test

### Descrição

Este projeto contém o código responsável por testar funcionalmente a API [sicredi-api](https://drive.google.com/drive/folders/1zP7CcBy8eS5FLI8rIHzC-jJB6ypWowp-?usp=share_link).

- [Extent Reports](https://www.extentreports.com/)
- [Java 11](https://openjdk.org/projects/jdk/11/)
- [Rest Assured](https://rest-assured.io/)
- [TestNG](https://testng.org/)

### Clone e Execução do projeto

Para clonar o projeto siga os seguintes passos:

No terminal:
```
git clone git@github.com:caldasmatheus/restapi-sicredi-challenge.git
```

No contexto onde o projeto foi clonado:
```
cd desafio-sicredi-api-test
```

Na raiz do projeto:
```
gradle clean build
```

### Tipos de Execução dos Testes

Para executar o projeto **desafio-sicredi-api-test** siga as etapas:

* Exemplo de execução de todos os cenários de testes:

```
gradle test
```

* Exemplo de execução de uma classe de teste específica:

```
gradle test -i --tests ConsultarSimulacaoTest
```

* Exemplo de execução de um cenário de teste específico:

```
gradle test --tests '*ConsultarSimulacaoTest.consultarSimulacoes'
```

* O relatório da execução pode ser localizado no seguinte caminho:

```
./target/extent-output/desafio-sicredi-api-test-report.html
```

### Contribuições

Para contribuir com o projeto, siga estas etapas:

1. Crie um *branch*: *`git checkout -b <branch_name>`*;
2. Faça suas alterações e confirme-as: *`git commit -m '<commit_message>'`*;
3. Envie a *branch* local para o repositório remoto: *`git push origin <branch_name>`*;
4. Crie o *pull request*.

:exclamation: **Observação**: Como alternativa, consulte a documentação do GitHub em "[Criando um Pull Request](https://docs.github.com/pt/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request)".

### Contato

Em caso de dúvidas: <raimundo.matheus@dcx.ufpb.br>. :incoming_envelope: