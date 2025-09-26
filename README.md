# WeatherApp - Aplicativo de Clima por Cidade
<!-- INSERÇÃO DA IMAGEM DA TELA PRINCIPAL AQUI -->

Bem-vindo ao repositório do WeatherApp, um aplicativo Android nativo (Java) projetado para buscar e exibir dados climáticos em tempo real de qualquer cidade do mundo.

O projeto demonstra conceitos cruciais do desenvolvimento Android e integração com APIs externas.

## 🚀 Funcionalidades
O aplicativo possui duas telas principais e as seguintes funcionalidades:

Busca de Cidade: Permite que o usuário digite o nome de qualquer cidade.

Lista Histórica de Climas: Exibe uma lista rolável e persistente (utilizando RecyclerView) com as informações básicas do clima (Cidade, Temperatura, Descrição) de cada busca realizada.

Visualização de Detalhes: Ao clicar em qualquer item da lista, o usuário é levado a uma segunda tela (DetalhesActivity) com informações mais específicas.

## 🛠️ Tecnologias e Arquitetura

* Linguagem: Java

* Plataforma: Android Nativo

* API de Dados: OpenWeatherMap API (requer uma chave de API válida para funcionar).

* Consumo da API: Retrofit 2 (Biblioteca HTTP Type-Safe para Java)

* Mapeamento de Dados: GSON (Biblioteca para converter JSON em objetos Java).

* Navegação e Dados: Intents e a interface Serializable para passar objetos complexos (City) entre telas.

* Visualização de Lista: RecyclerView para gerenciamento eficiente da lista de histórico.

## 🗺️ Estrutura do Projeto (Modelo de Dados)
O projeto segue um modelo de classes bem definido para mapear a estrutura da resposta JSON da API e a estrutura interna do aplicativo:

* City.java

* WeatherService.java

* Retrofit
  
* WeatherResponse.java

* MainApi.java

* Wind.java

* Weather.java
* MainActivity.java
* DetalhesActivity


## ⚙️ Como Configurar e Executar
Obter Chave da API: Crie uma conta no OpenWeatherMap e obtenha sua chave de API (API_KEY).

Configurar a Chave: Abra o arquivo MainActivity.java e substitua o valor da constante API_KEY pela sua chave obtida.

Executar: Sincronize o Gradle e execute o aplicativo em um dispositivo Android ou emulador.
