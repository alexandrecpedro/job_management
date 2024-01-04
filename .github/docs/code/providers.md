<!-- markdownlint-disable MD024 -->

# `providers/`

> [voltar](../c_code-analysis.md) para a página anterior

## Sumário

- [`providers/`](#providers)
  - [Sumário](#sumário)
  - [`JWTCandidateProvider.java`](#jwtcandidateproviderjava)
    - [Função](#função)
    - [Análise do Código](#análise-do-código)
  - [`JWTProvider.java`](#jwtproviderjava)
    - [Função](#função-1)
    - [Análise do Código](#análise-do-código-1)

## `JWTCandidateProvider.java`

### Função

 Esta classe fornece um método para validar tokens JWT usando a biblioteca Auth0 JWT. Ela usa um segredo específico definido nas configurações do Spring para verificar a assinatura do token e retorna as informações do token se for válido, ou `null` se não for válido.

### Análise do Código

1. Importações:
   - O código começa com importações de várias classes de bibliotecas, incluindo o Spring Framework e a biblioteca Auth0 JWT. Essas importações são necessárias para o funcionamento do código.

2. Anotações:
   - A classe `JWTCandidateProvider` é anotada com `@Service`, o que indica que é uma classe de serviço Spring e pode ser gerenciada pelo contêiner Spring.

3. Variáveis de instância:
   - A classe possui uma variável de instância `secretKey` que é anotada com `@Value("${security.token.secret.candidate}")`. Isso significa que o valor desta variável será injetado a partir das configurações do Spring, onde `"security.token.secret.candidate"` é uma chave de configuração específica que contém o segredo usado para verificar os tokens JWT.

4. Método `validateToken`:
   - Este método é usado para validar um token JWT. Recebe um token como entrada, que normalmente deve começar com "Bearer ".
   - Primeiro, ele remove a parte "Bearer " do token, deixando apenas o token JWT real.
   - Em seguida, cria um objeto `Algorithm` usando o segredo fornecido (`secretKey`) e o algoritmo HMAC256. O algoritmo HMAC256 é usado para verificar a assinatura do token.
   - O método então tenta verificar o token usando a biblioteca Auth0 JWT. Para fazer isso, ele chama o método `JWT.require(algorithm)` para especificar o algoritmo a ser usado na verificação e, em seguida, chama `build()` para criar um verificador JWT e finalmente `verify(token)` para verificar o token.
   - Se o token for válido, o método retornará um objeto `DecodedJWT`, que contém as informações do token JWT decodificado.
   - Se ocorrer uma exceção `JWTVerificationException`, o método imprimirá a exceção e retornará `null`. Isso significa que o token não é válido ou a verificação falhou de alguma forma.

> [retornar](#providers) para o topo da página

## `JWTProvider.java`

### Função

 Esta classe fornece um método para validar tokens JWT usando a biblioteca Auth0 JWT. Ela usa um segredo específico definido nas configurações do Spring para verificar a assinatura do token e retorna as informações do token se ele for válido, ou `null` se não for válido.

### Análise do Código

1. Importações:
   - O código começa com importações de várias classes de bibliotecas, incluindo o Spring Framework e a biblioteca Auth0 JWT. Essas importações são necessárias para o funcionamento do código.

2. Anotações:
   - A classe `JWTProvider` é anotada com `@Service`, o que indica que é uma classe de serviço Spring e pode ser gerenciada pelo contêiner Spring.

3. Variáveis de instância:
   - A classe possui uma variável de instância `secretKey` que é anotada com `@Value("${security.token.secret}")`. Isso significa que o valor desta variável será injetado a partir das configurações do Spring, onde `"security.token.secret"` é uma chave de configuração que contém o segredo usado para verificar os tokens JWT.

4. Método `validateToken`:
   - Este método é usado para validar um token JWT. Ele recebe um token como entrada, que é uma string representando o token JWT, normalmente começando com "Bearer ".
   - A primeira linha do método remove a parte "Bearer " do token, deixando apenas o token JWT real.
   - Em seguida, ele cria um objeto `Algorithm` usando o segredo fornecido (`secretKey`) e o algoritmo HMAC256. O algoritmo HMAC256 é usado para verificar a assinatura do token.
   - O método então tenta verificar o token usando a biblioteca Auth0 JWT. Para fazer isso, ele chama o método `JWT.require(algorithm)` para especificar o algoritmo a ser usado na verificação. Em seguida, ele chama `.build()` para criar um verificador JWT e, finalmente, `.verify(token)` para verificar o token.
   - Se o token for válido, o método retornará um objeto `DecodedJWT`, que contém as informações do token JWT decodificado.
   - Se ocorrer uma exceção `JWTVerificationException`, o método imprimirá a exceção usando `ex.printStackTrace()` e retornará `null`. Isso significa que o token não é válido ou a verificação falhou de alguma forma.

> [retornar](#providers) para o topo da página
>
> [voltar](../c_code-analysis.md) para a página anterior
