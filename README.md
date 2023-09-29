# Password Validator
## Descrição do projeto
Uma API que tem como objetivo verificar se uma senha é valida de acordo com algumas definições.

A senha precisa possuir: 
- Nove ou mais caracteres;
- Ao menos 1 dígito;
- Ao menos 1 letra minúscula;
- Ao menos 1 letra maiúscula;
- Ao menos 1 caractere especial;
- Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto;

## Como executar o projeto

- Link para teste: http://localhost:8080/swagger-ui/index.html#/validator-controller/validatePassword

## Detalhes da solução

### Premissas assumidas

- Existe uma aplicação front-end responsável por enviar e receber o resultado da API e 
apresentar ao usuário pensando em usabilidade e design.

### Próximos passos

- Adicionar uma camada de autenticação para maior segurança.
