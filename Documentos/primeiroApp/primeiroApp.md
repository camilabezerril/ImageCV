# Construir o primeiro App para celular

Nesta página você vai aprender a criar um app/programa que pode ser executado em telefones e tablets que usam Android como sistema operacional. 

Você vai desenvolver o app através da Internet, em um computador, usando o navegador. Nenhum programa adicional será necessário no computador. 

No celular será necessário um leitor de QR-Code. Através dele, acessa-se o link para baixar seu app no celular quando você for testá-lo. Os passos são:

1. [Criar uma conta no App Inventor Web](Criar-uma-conta-no-App-Inventor-Web);
2. [Criar um projeto](Criar-um-projeto);
3. [Colocar os componentes na tela](Colocar-os-componentes-na-tela);
4. [Definir as ações](Definir-as-ações);
5. [Enviar o app para o celular](Enviar-o-app-para-o-celular) e
6. [Testar o app](Testar-o-app).

## Criar uma conta no App Inventor Web.

A página de início é (http://appinventor.mit.edu). Logo no topo, clique em Create Apps!.

![](screenshots/1.jpg)

Faça seu cadastro e entre na página para criar seus projetos.

## Criar um projeto.

Em cima, ao lado do logo do App Inventor, há uma barra de menu. Com os menus é possível mudar de idioma, criar um novo projeto, trocar de projeto, criar o app e gerar um QR-Code para baixar e instalar o app no celular. Escolha criar um novo projeto e digite o nome do projeto na caixa de diálogo. Recomendamos o nome *Ola*... aparece o desenho de uma tela de celular.

![](screenshots/1a.jpg)

Se quiser, troque o idioma para Português do Brasil

![](screenshots/2.jpg)

## Colocar os componentes na tela.

Usando como referência o desenho da tela do celular, o quadro do lado direito apresenta as propriedades do componente selecionado - no caso a tela. Seu nome é Screen1, o nome do App é Ola.

No App Inventor, componentes são partes do app. Por exemplo, a tela, botões, caixas de texto, caixas de figuras, listas, etc.

Entre o desenho da tela e o quadro de propriedades fica a lista de componentes. No momento só há a Screen1. Nesta lista há botões para renomear e apagar o componentes.

No quadro do lado esquerdo ficam os componentes que podem ser usados no app.

O quadro à esquerda abre na aba *Interface de Usuário*. Ela contém os componentes básicos dos aplicatiovos de celular.

Vamos fazer um app em que digitamos nosso nome numa CaixaDeTexto, clicamos em um Botão  e ele muda o texto em uma Legenda.

Começamos clicando e arrastando os componentes da lista da esquerda para a tela do celular...

Um Botão quando clicado, executa alguma ação.

![](screenshots/3.jpg)
![](screenshots/4.jpg)

Uma Legenda é usada para mostrar texto.

![](screenshots/5.jpg)

Uma CaixaDeTexto, quando clicada, abre o teclado e permite digitar texto dentro da caixa.

![](screenshots/6.jpg)
![](screenshots/7.jpg)

Terminamos o trabalho no modo designer. Neste modo nós escolhemos que componentes aparecem onde na tela do celular. As formas de dispor componentes na tela estão na aba Organização.

## Definir as ações.

As ações do app são resultado do uso ordenado das ações dos componentes. Damos essa ordem dispondo blocos que representam as ações dos componentes. Para entrar no modo Blocos, no canto superior esquerdo da janela, clique no botão Blocos.

O modo blocos inicia com um plano vazio. À esquerda há um quadro com a aba Blocos aberta. Nesta aba são apresentados os componentes que podem ser usados. Há componentes internos, que estão disponíveis mesmo que não haja nada na tela do aplicativo e há os componentes que nós colocamos na tela no modo *design*. No caso, Screen1, Botão1, Legenda1 e CaixaDeTexto1.

![](screenshots/8.jpg)

Clicando no componente abre-se a escolha de qual bloco do componente usar. O que é possível fazer com um componente no App Inventor está representado pelos blocos.

![](screenshots/9.jpg)

Em um aplicativo, a execução dos blocos é iniciada por eventos determinados. Por exemplo, no Botão1, o bloco Clique (Botão1.Clique) é executado quando Botão1 for clicado durante a execução do app. Vamos arrastar o bloco Botão1.Clique para o plano.

![](screenshots/10.jpg)

Queremos que o texto que digitarmos na CaixaDeTexto1 seja copiado para o texto da Legenda1. Para isso, vamos ajustar Legenda1.texto para CaixaDeTexto1.texto.

Clique em Legenda1 e arraste o bloco ajustar Legenda1.texto e encaixe dentro do Botão1.Clique.

![](screenshots/11.jpg)
![](screenshots/12.jpg)
![](screenshots/13.jpg)

Clique em CaixaDeTexto1, arraste o bloco CaixaDeTexto1.Texto e encaixe em ajustar Legenda1.Texto.

![](screenshots/14.jpg)
![](screenshots/15.jpg)

Vamos reler os blocos para checar o conjunto:

Quando Botão1.Clique fazer
Ajustar Legenda1.Texto para CaixaDeTexto1.Texto

Nesta forma de programar, isto é suficiente para quando o botão for clicado, copiar o texto da caixa de texto para a legenda.

## Enviar o app para o celular.

Para gerar o app de celular, na barra de menu do alto da janela selecione Compilar -> App (fornecer o QR code para o .apk).

![](screenshots/15.jpg)

Compilação é o nome dado em computação para o processo de traduzir de uma linguagem para outra. No caso, compila-se da linguagem de programação em blocos para a linguagem dos aplicativos de celular. O resultado da compilação, neste caso, é um aplicativo de celular.

![](screenshots/16.jpg)

Além de gerar o aplicativo, o App Inventor fornece um link para baixar o aplicativo. Este é passado para nós por um QR-Code.

![](screenshots/17.jpg)

## Testar o app

Abra o leitor de QR-Code, leia o código e clique no link. Um programa pode transmitir os dados do celular para alguém, ou, usar o celular para enviar mensagens para os contatos armazenados nele, ou até mesmo danificar o celular. Por isso quem está baixando o programa precisa ter certeza do que está fazendo. Para certificar, aparecerá uma tela para confirmar que você deseja baixar o arquivo que contém seu programa.

Como é o programa que você fez, usando sites e instruções confiáveis, deve ser seguro baixá-lo. Se você concorda, responda OK.

[T|20%](screenshots/Screenshot_20200614-104534.png)

<img src="screenshots/Screenshot_20200614-104534.png" height="960" width="540">

![|20%](s

Depois abra o programa (clique em abrir). Se a notificação sair da tela, entre no navegador em downloads, encontre Ola.apk e dê um duplo-clique sobre ele (isto equivale a clicar em abrir).

![](screenshots/Screenshot_20200614-104551.png)

Em seu celular, na tela a seguir, clique em Instalar

![](screenshots/Screenshot_20200614-104604.png)

Aguarde o processo de instalação terminar

![](screenshots/Screenshot_20200614-104610.png)

Terminada a instalação clique em abrir

![](screenshots/Screenshot_20200614-104621.png)

Você verá a tela que você criou

![](screenshots/Screenshot_20200614-104631.png)

Clique na caixa de texto - o teclado aparecerá, digite o texto que quiser e clique no botão, 

![Teclado|1080x1920,20%](screenshots/Screenshot_20200614-104651.png)

o texto que você digitou aparecerá na Legenda1.

![](screenshots/Screenshot_20200614-104713.png)

Parabéns, você completou todos os passos para construir um app Android.

