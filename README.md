# ImageCV
Desenvolvimento de extensão para visão computacional no ambiente de programação por blocos App Inventor

Esta documentação faz parte dos entregáveis do projeto de Iniciação Científica XXX/2019.

Fique nesta página se quiser criar no app inventor um app de celular que usa a extensão. Caso seja a primeira vez que usará App Inventor, sugerimos ler, ou seguir nosso [tutorial para criar seu primeiro app usando App Inventor](Documentos/primeiroApp/primeiroApp.md)

Navegue para [Como criar extensões do app Inventor](Documentos/ComoCriarExtensao.md) para ver o que foi feito para criar a extensão (setup de IDE, inclusão de bibliotecas, ...).

Navegue para [Como a extensão foi codificada](Documentos/ExtensaoImageCV.md) para ver como chegou-se à esta versão do código (escolha de tipos de dados, escolhas de funcionamento dos blocos, ...).

Navegue para [Como github foi usado neste projeto](Documentos/sobreGit/README.md) para ver que recursos de github foram usados neste projeto. Pode ser um bom guia para começar a usar **git** e **github**.

## Apresentação (contexto)

[App Inventor](https://appinventor.mit.edu/) é uma ferramenta de programação baseada em blocos ([*block-based programming*](https://en.wikipedia.org/wiki/Visual_programming_language)) para criar *apps* para [Android](https://www.android.com/intl/pt-BR_br/). Numa generalização grosseira, esses *apps* podem ser executados em telefones celulares, tablets e outros dispositivos que usam Android como sistema operacional.

Ferramentas como esta tornaram-se conhecidas por seu sucesso no uso em ensino de programação para crianças. O que também criou o estigma de *ser coisa para criança*.

A técnica de programação baseada em blocos favorece a criação modular de componentes, acelera o desenvolvimento de *apps*, seja na fase de protótipo, seja na fase de produto, permite que profissionais com formação diversas das formações relacionadas à computação possam testar idéias facilmente e, mesmo para programadores, permite que se ocupem menos com detalhes da linguagem.

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

(**nota**: a interface web tem suporte para Português do Brasil)

(**A falta de um tutorial em português pode ser barreira para seu uso com crianças brasileiras.**)

(https://cacm.acm.org/magazines/2019/8/238340-block-based-programming-in-computer-science-education/fulltext
https://en.scratch-wiki.info/wiki/Block-Based_Coding

)

(**nota**: para cortar as imagens e diminuir seu tamanho usei imageMagic, segundo https://itectec.com/ubuntu/ubuntu-cropping-images-using-command-line-tools-only/

```
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/screenshots-primeiroApp$ identify Captura\ de\ tela\ de\ 2020-06-14\ 08-47-54.png 
Captura de tela de 2020-06-14 08-47-54.png PNG 1080x1920 1080x1920+0+0 8-bit sRGB 1.974MB 0.000u 0:00.000
```
```
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/screenshots-primeiroApp$ convert Captura\ de\ tela\ de\ 2020-06-14\ 10-45-03.png -quality 50 -crop 1080x1000+50+0 17.jpg
```

)

## Como instalar a extensão

Baixe a extensão ImageCV [aqui](appcv.ImageCV.aix), guarde onde ela foi armazenada.

No seu projeto do App Inventor, no quadro da esquerda na aba extension clique no link *Import extension*

Uma caixa de mensagem se apresenta, clique em Browse, selecione o arquivo *appcv.ImagCV.aix* baixado no passo X.

![](screenshots/1.jpg)

Deve aparecer na aba a extensão ImageCV.

![](screenshots/2.jpg)



## Como usar a extensão em um app simples

