# Conversor de Moedas

Um aplicativo de linha de comando (CLI) em Java para conversão entre diferentes moedas, incluindo Real (BRL), Dólar (USD), Euro (EUR), Libra Esterlina (GBP), Iene Japonês (JPY), Dólar Australiano (AUD) e Dólar Canadense (CAD).

## 🚀 Funcionalidades

- Conversão entre múltiplas moedas
- Interface de linha de comando interativa
- Atualização em tempo real das taxas de câmbio
- Suporte às seguintes moedas:
  - Real Brasileiro (BRL)
  - Dólar Americano (USD)
  - Euro (EUR)
  - Libra Esterlina (GBP)
  - Iene Japonês (JPY)
  - Dólar Australiano (AUD)
  - Dólar Canadense (CAD)

## 🛠️ Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior
- Conexão com a internet para obter as taxas de câmbio atuais
- Chave de API do ExchangeRate-API (gratuita)

## ⚙️ Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/conversordemoedas.git
   cd conversordemoedas
   ```

2. Configure sua chave de API:
   - Obtenha uma chave de API gratuita em [ExchangeRate-API](https://www.exchangerate-api.com/)
   - Substitua `YOUR_API_KEY` no arquivo `CurrencyConverter.java` pela sua chave

3. Instale as dependências e compile o projeto com Maven:
   ```bash
   mvn clean install
   ```

4. Execute o aplicativo:
   ```bash
   mvn exec:java -Dexec.mainClass="com.currencyconverter.CurrencyConverter"
   ```
   
   Ou, após a compilação:
   ```bash
   java -cp target/classes;target/dependency/* com.currencyconverter.CurrencyConverter
   ```

## 🎯 Como usar

1. Execute o programa conforme as instruções acima
2. Escolha uma das opções do menu:
   - 1. Converter USD para BRL
   - 2. Converter EUR para BRL
   - 3. Converter GBP para BRL
   - 4. Converter JPY para BRL
   - 5. Converter AUD para BRL
   - 6. Converter CAD para BRL
   - 0. Sair

3. Siga as instruções na tela para inserir o valor a ser convertido
4. O resultado da conversão será exibido

## 📦 Estrutura do Projeto

```
conversordemoedas/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── currencyconverter/
│                   ├── CurrencyConverter.java         # Lógica principal do conversor
│                   ├── CurrencyConverterApp.java      # Ponto de entrada alternativo
│                   └── model/
│                       ├── ExchangeRateResponse.java  # Modelo de resposta da API
│                       └── Rates.java                 # Modelo de taxas de câmbio
├── pom.xml                                          # Configuração do Maven
└── README.md
```

## 📚 Dependências

- **Jackson Databind** (v2.15.2) - Para processamento de JSON
- **Apache HttpClient** (v4.5.14) - Para requisições HTTP
- **Google Gson** - Para manipulação de JSON

## 🔄 Atualizando as taxas de câmbio

O aplicativo utiliza a API ExchangeRate-API para obter as taxas de câmbio em tempo real. A API é acessada através do endpoint `https://api.exchangerate-api.com/v4/latest/USD`.

## 🐛 Solução de Problemas

- **Erro de conexão**: Verifique sua conexão com a internet
- **Chave de API inválida**: Certifique-se de que a chave de API está correta e ativa
- **Erro de compilação**: Verifique se todas as dependências estão corretamente instaladas

## 📝 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## 📧 Contato

Se tiver alguma dúvida ou sugestão, entre em contato através do email: grasielifigueredo2@gmail.com
