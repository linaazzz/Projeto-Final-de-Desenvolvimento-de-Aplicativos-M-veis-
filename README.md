Sobre o Projeto

Este aplicativo foi desenvolvido para gerenciar um estoque de Pokémons de cada usuário.
Cada usuário faz login (Firebase Auth) e gerencia seus próprios Pokémons, sem interferir no estoque de outros usuários.

É possível adicionar, listar, editar, excluir e buscar Pokémons online pela PokéAPI.
Os dados ficam salvos localmente no Room, permitindo uso offline.

Funcionalidades Principais: criar conta e login com Firebase Authentication, fazer logout e manter um estoque separado para cada usuário; adicionar Pokémons manualmente, editar Pokémons existentes, excluir Pokémons, listar todos os Pokémons cadastrados, filtrar por 
tipo (fogo, água, grama etc.), buscar Pokémons pelo nome ou ID via PokéAPI, exibir nome, tipo e imagem, salvar Pokémons buscados no banco local, armazenar tudo no SQLite (Room), associar cada Pokémon ao userId do Firebase para garantir que cada usuário veja apenas
seus próprios dados; navegação feita com Navigation Compose usando rotas organizadas, com telas de Login, Home, Lista de Pokémons, Adicionar/Editar Pokémon, Busca Online e Filtro por tipo.

Arquitetura e Tecnologias:

Kotlin, Jetpack Compose, Room Database, Retrofit (PokéAPI), Firebase Authentication, MVVM (Model–View–ViewModel), Coroutines + Flow, Navigation Compose

Como Executar o Projeto e Requisitos:

Android Studio (versão recente), JDK 11+, Conta Firebase, Emulador ou dispositivo Android real

Passo 1 — Clonar Repositório

No terminal do Android Studio ou do Windows:

git clone https://github.com/seuusuario/seu-repo.git

Passo 2 — Configurar Firebase

Acesse: https://console.firebase.google.com

Crie um projeto

Adicione um app Android com o mesmo ApplicationId:

com.example.pokemon


Baixe o arquivo

google-services.json


Coloque em:

app/google-services.json


No Firebase, habilite:

Authentication → Email/Password
