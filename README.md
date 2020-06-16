# ImageCV
Desenvolvimento de extensão para visão computacional no ambiente de programação por blocos App Inventor

Esta documentação faz parte dos entregáveis do projeto de Iniciação Científica XXX/2019.

Fique nesta página se quiser criar no app inventor um app de celular que usa a extensão. Caso seja a primeira vez que usará App Inventor, sugerimos ler, ou seguir nosso [tutorial para criar seu primeiro app usando App Inventor](Documentos/primeiroApp/primeiroApp.md)

Navegue para [Como criar extensões do app Inventor](Documentos/ComoCriarExtensao.md) para ver o que foi feito para criar a extensão (setup de IDE, inclusão de bibliotecas, ...).

Navegue para [Como a extensão foi codificada](Documentos/ExtensaoImageCV.md) para ver como chegou-se à esta versão do código (escolha de tipos de dados, escolhas de funcionamento dos blocos, ...).

Navegue para [Apps de teste](testes/README.md) para baixar os executáveis (apk) e os fontes (aia) dos apps de teste.

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




## Referência dos blocos de ImageCV

### Por que HSV ao invés de RGB.

Em Visão Computacional, um componente que identifica uma determinada cor, recebe a informação sobre a cor a analisar e aplica uma fórmula. O resultado da aplicação da fórmula indica se a cor analisada é a determinada cor ou se a cor analisada não é a determinada cor.

Para manter o ImageCV simples para o programador que usa App Inventor e simples para desenvolvedores que forem aperfeiçoá-lo, os parâmetros passados para os blocos são números e não fórmulas. Acredite, construir boas fórmulas pode não ser fácil e o programador que usa App Inventor ficaria encarregado disso.

RGB e HSV são duas formas de codificar cores. No RGB, as cores são decompostas em componentes de cor, sendo estas as intensidades de vermelho (R), verde (G) e azul (B). No ImageCV, as intensidades de R, G e B vão de 0 a 255. Por exemplo:

**R** | **G** | **B** | Nome da cor
------|-------|-------|------------
0 | 0 | 0 | preto
255 | 255 | 255 | branco
255 | 0 | 0 | vermelho intenso
120 | 0 | 0 | vermelho médio
255 | 83 | 0 | laranja-avermelhado (ou vermelho-alaranjado?)
255 | 203 | 203 | um tom claro de rosa
255 | 0 | 255 | magenta
255 | 255 | 0 | amarelo
0 |200| 0 | um tom claro de verde

Seguindo a idéia de manter o ImageCV simples, na mais complexa das alternativas, permitiríamos valores mínimos e máximos de R, G e B. Desta forma, se o programador quisesse um vermelho, poderia usar algo como min={200,0,0} max={255, 20, 20}. Esta escolha deixaria de fora tanto os vermelhos mais escuros quanto os rosas mais claros, os vermelhos alaranjados, os vermelhos azulados,...

> O ponto é que usar RGB e colocar mínimo e máximo para definir cores leva a resultados corretos (dada a codificação), mas difíceis para pessoas entenderem, considerando a forma como percebem e categorizam cores.

Na codificação HSV, H coresponde à tonalidade, S à saturação e V a "claridade". H codifica tons: vermelhos, amarelos, verdes,... S codifica quão pigmentada é. Valores altos correspondem a cores intensas, vivas. V codifica se há pouca luz ou luz suficiente. Desta forma, o vermelho tem uma faixa de H, vermelhos pouco saturados (rosa) têm S baixos, vermelhos muito saturados (talvez como o nariz de um palhaço) têm S altos. V tem pouca influência na discriminação de cor.

A biblioteca usada em ImageCV para processamento de cores e formas é BoofCV. A explicação sobre HSV em BoofCV está em (http://boofcv.org/javadoc/boofcv/alg/color/ColorHsv.html)

(**nota** A [Wikipedia](https://en.wikipedia.org/wiki/HSL_and_HSV) explica com mais detalhes.)

(**nota**: os sensores das câmeras, em situações com muita luz, tendem a levar as cores para o branco. Diz-se que o sensor saturou, ou que as cores estão "estouradas". A codificação HSL parece lidar melhor com essa situação que a codificação HSV.)

### stepHSV

picturePath: localização do arquivo de imagem.
HSMin: valores mínimos de H e S.
HSMax: valores máximos de H e S.

Retorna em altImagePath a localização do arquivo de imagem segmentado por cor.

baseado em (https://boofcv.org/index.php?title=Example_Color_Segmentation)

### reconhecePoligonos

picturePath: localização do arquivo de imagem.
minLados: quantidade mínima de lados dos polígonos a identificar (mínimo=3, máximo=20)
maxLados: quantidade máxima de lados dos polígonos a identificar (mínimo=3, máximo=20)

O desempenho ótimo é conseguido quando os polígonos são pretos e planos em fundo branco, com iluminação uniforme, sem sombras.

Retorna em altImagePath a localização do arquivo de imagem com os polígonos identificados contornados em vermelho.

Retorna em nPoligonos a quantidade de polígonos encontrada.

Retorna em listaDePoligonos uma lista contendo nPoligonos sub-listas. Cada sub-lista contém a coordenadas dos vértices dos polígonos em ordem: [x1, y1, x2, y2, x3, y3, ..., xn, yn].

### reconheceElipses

picturePath: localização do arquivo de imagem.

O desempenho ótimo é conseguido quando os polígonos são pretos e planos em fundo branco, com iluminação uniforme, sem sombras.

Retorna em altImagePath a localização do arquivo de imagem segmentado por cor.

Retorna em nElipses a quantidade de elipses encontrada.

Retorna em listaDeElipses uma lista contendo nElipses sub-listas. Uma sub-lista contém: [xcentro, ycentro, "Não Especificado", diâmetro_médio].

### converteRGBtoHSV

RGB

### getAltImagePath

### getCaractElipses

### getCaractPoligonos

### getHfromRGBtoHSV
### getSfromRGBtoHSV
### getVfromRGBtoHSV

### getListaDeElipses

### getnElipses
### getnPoligonos


### setCaractElipses
### setCaractPoligonos
### setnElipses
### setnPoligonos




Imagem para recortar os blocos e ilustrar.

![](screenshots/3.jpg)


```
@DesignerComponent(version = 1,
        category = ComponentCategory.EXTENSION,
        description = "Componente para Visao Computacional no App Inventor",
        nonVisible = true,
        iconName = "images/extension.png")

    @SimpleFunction(description = "Substitui os tons de uma cor por preto por meio do sistema HSV [FORMATO: 0-6.28, 0-1.0]")
    public void stepHSV(String picturePath, String HSmin, String HSmax){

    @SimpleFunction(description = "Converte RGB em HSV [FORMATO:x,x,x]")
    public void converteRGBtoHSV(String RGB) {

    @SimpleFunction(description = "Reconhece elipses em uma imagem")
    public void reconheceElipses(String picturePath){

    @SimpleFunction(description = "Reconhece polígonos em uma imagem, minLados >= 3 e maxLados <= 20")
    public void reconhecePoligonos(String picturePath, int minLados, int maxLados) {
```


