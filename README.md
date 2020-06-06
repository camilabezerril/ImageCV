# ImageCV
Desenvolvimento de extensão para visão computacional no ambiente de programação por blocos App Inventor

Esta documentação faz parte dos entregáveis do projeto de Iniciação Científica XXX/2019.

Fique nesta página se quiser criar no app inventor um app de celular que usa a extensão.

Navegue para [Como criar extensões do app Inventor](Documentos/ComoCriarExtensao.md) para ver o que foi feito para criar a extensão (setup de IDE, inclusão de bibliotecas, ...).

Navegue para [Como a extensão foi codificada](Documentos/AImplementar.md) para ver como chegou-se à esta versão do código (escolha de tipos de dados, escolhas de funcionamento dos blocos, ...).

Navegue para [Como github foi usado neste projeto](Documentos/sobreGit/README.md) para ver que recursos de github foram usados neste projeto. Pode ser um bom guia para começar a usar **git** e **github**.

## Apresentação (contexto)

[App Inventor](https://appinventor.mit.edu/) é uma ferramenta de programação baseada em blocos ([*block-based programming*](https://en.wikipedia.org/wiki/Visual_programming_language)) para criar *apps* para [Android](https://www.android.com/intl/pt-BR_br/). Numa generalização grosseira, esses *apps* podem ser executados em telefones celulares, tablets e outros dispositivos que usam Android como sistema operacional.

Ferramentas como esta são conhecidas por seu uso em ensino de programação para crianças. **Porém** o desenvolvimento de *apps* pode ser substancialmente acelerado através dessas ferramentas, por exemplo acelerando o trabalho de programadores que desejam não se ocupar com detalhes de linguagens tradicionais e de pessoas com pouca experiência em programação.

A [versão web do App Inventor](ai2.appinventor.mit.edu/) não requer instalação de programa no computador local. O acesso é gratuito mediante cadastro.

Tutoriais sobre App Inventor, no site oficial em inglês, podem ser assistido [aqui](https://appinventor.mit.edu/explore/ai2/beginner-videos).

Há alguns tutoriais em português:

[androidpro (usa a versão desktop - instalada no computador)](https://www.androidpro.com.br/blog/desenvolvimento-android/app-inventor/)
[appinventorbrasil (**parece ser** acesso gratuito, mediante cadastro)](https://appinventorbrasil.tech/cursos/app-inventor-2-iniciantes)

Criar um app no App Inventor consiste em [entrar no app inventor web](ai2.appinventor.mit.edu/), criar um projeto (para isso é necessário cadastrar-se), no modo *design* arrastar os componentes que se deseja usar para dentro do dispositivo (celular/tablet), entrar no modo *blocks* escolher, dos componentes, que bloco usar, arrastá-los para dentro do canvas e encaixá-los uns nos outros para que o conjunto se comporte como desejado. Ao final, ou quando uma versão testável puder ser criada, escolher no menu *compile*, uma das opções (a mais simples é compilar, gerar um QR-code e ler com um leitor previamente instalado no dispositivo), baixar o instalador do *app* (geralmente um arquivo com extensão `.apk`), instalar e usar/testar.

Uma **extensão** do App Inventor é um componente criado por um desenvolvedor independente.

**ImageCV** é um componente do App Inventor que, dada uma imagem, por exemplo uma foto, permite:

1. Marcar determinadas cores;
2. Localizar elipses;
3. Localizar polígonos, definindo a quantidade de vértices desejada;
4. Combinar a marcação de cores com a localização de formas.

### Imagens que exemplificam usos simples



(**nota**: [um pesquisador da UNICAMP propõe criar uma versão do App Inventor traduzida para português](https://appinventor.mit.edu/explore/blogs/josh/2016/01/mit-0)

**A falta de um tutorial em português pode ser barreira para seu uso com crianças brasileiras.**

https://cacm.acm.org/magazines/2019/8/238340-block-based-programming-in-computer-science-education/fulltext
https://en.scratch-wiki.info/wiki/Block-Based_Coding

)

## Como instalar a extensão

## Como usar a extensão em um app simples




