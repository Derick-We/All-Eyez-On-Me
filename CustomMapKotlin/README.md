# Custom Map Kotlin

Este é um projeto Android que demonstra como criar e personalizar mapas do Google Maps usando Kotlin. O aplicativo inclui três estilos diferentes de mapas que podem ser alternados com um botão flutuante.

## Funcionalidades

- Mapa do Google Maps integrado
- Três estilos diferentes de mapa (Retrô, Noturno e Natureza)
- Botão flutuante para alternar entre os estilos
- Controles de zoom e bússola habilitados
- Localização inicial centralizada em São Paulo

## Configuração

1. Clone este repositório
2. Obtenha uma chave de API do Google Maps:
   - Acesse o [Google Cloud Console](https://console.cloud.google.com)
   - Crie um novo projeto ou selecione um existente
   - Habilite a API do Maps SDK for Android
   - Crie uma chave de API
3. Adicione sua chave de API no arquivo `AndroidManifest.xml`:
   ```xml
   <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="SUA_CHAVE_API_AQUI" />
   ```
4. Build e execute o projeto

## Requisitos

- Android Studio Arctic Fox ou superior
- Android SDK 21 ou superior
- Google Play Services

## Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.