# WeatherApp - Aplicativo de Clima por Cidade
<!-- INSERÇÃO DA IMAGEM DA TELA PRINCIPAL AQUI -->
<img width="387" height="868" alt="{E7A7708C-7F84-40E3-9C61-262D1E81871C}" src="https://github.com/user-attachments/assets/e953dbfb-1b87-42fb-878e-8cd0539370c4" />
<img width="386" height="863" alt="{3C56FFCC-FB97-425B-A679-C7523FCBDD0B}" src="https://github.com/user-attachments/assets/38ed418f-f556-48f2-88c7-5d24c4a3a881" />

</br></br>
🌟Bem-vindo ao repositório do WeatherApp, um aplicativo Android nativo (Java) projetado para buscar e exibir dados climáticos em tempo real de qualquer cidade do mundo.</br>
Este projeto é um aplicativo Android nativo desenvolvido em Java. Ele demonstra a integração com a API OpenWeatherMap para buscar e exibir informações climáticas de qualquer cidade, focando na arquitetura de consumo de API (Retrofit + GSON) e na manipulação de listas eficientes 

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

### Widgets usados
* TextView
* Button
* ImageView
* RecyclerView
* EditText
* Toast

## ⚙️ Como Configurar e Executar
Obter Chave da API: Crie uma conta no OpenWeatherMap e obtenha sua chave de API (API_KEY).

Configurar a Chave: Abra o arquivo MainActivity.java e substitua o valor da constante API_KEY pela sua chave obtida.

Executar: Sincronize o Gradle e execute o aplicativo em um dispositivo Android ou emulador.
