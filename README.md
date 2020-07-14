# ImageCV
Desenvolvimento de extensão para visão computacional no ambiente de programação por blocos App Inventor

Esta documentação faz parte dos entregáveis do projeto de Iniciação Científica XXX/2019.

Fique nesta página se quiser criar no app inventor um app de celular que usa a extensão. Caso seja a primeira vez que usará App Inventor, sugerimos ler, ou seguir nosso [tutorial para criar seu primeiro app usando App Inventor](Documentos/primeiroApp/primeiroApp.md)

Navegue para [Como criar extensões do app Inventor](Documentos/ComoCriarExtensao.md) para ver o que foi feito para criar a extensão (setup de IDE, inclusão de bibliotecas, ...).

Navegue para [Como a extensão foi codificada](Documentos/ExtensaoImageCV.md) para ver como chegou-se à esta versão do código (escolha de tipos de dados, escolhas de funcionamento dos blocos, ...).

Navegue para [Apps de teste](testes/README.md) para baixar os executáveis (apk) e os fontes (aia) dos apps de teste.

Navegue para [Como github foi usado neste projeto](Documentos/sobreGit/README.md) para ver que recursos de github foram usados neste projeto. Pode ser um bom guia para começar a usar **git** e **github**.

## Apresentação (contexto)

[App Inventor](https://appinventor.mit.edu/) é uma ferramenta de programação baseada em blocos ([*block-based programming*](https://en.wikipedia.org/wiki/Visual_programming_language)) para criar *apps* para [Android](https://www.android.com/intl/pt-BR_br/). Numa generalização grosseira, esses *apps* podem ser executados em telefones celulares, tablets e outros dispositivos que usam Android como sistema operacional. Ferramentas como esta tornaram-se conhecidas por seu sucesso no uso em ensino de programação para crianças. O que também criou o estigma de *ser coisa para criança*.

A técnica de programação baseada em blocos favorece a criação modular de componentes, acelera o desenvolvimento de *apps*, seja na fase de protótipo, seja na fase de produto, permite que profissionais com formação diversas das formações relacionadas à computação possam testar idéias facilmente e, mesmo para programadores, permite que se ocupem menos com detalhes da linguagem, como notado por Pokress e Veiga, 2013 e por Elts et. al. 2013.

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

### Imagens que exemplificam usos da extensão

Há muitas formas de usar e combinar as funcionalidades do ImageCV. Documentar e exemplificar exaustivamente geraria muita documentação de pouca utilidade. Sugere-se que processo de avaliação da utilidade de ImageCV seja:

1. Ver o que ImageCV faz: o que usa como entrada e o que apresenta como saída;
2. Verificar se há exemplos que se aproximam do uso que deseja;
2. Instalar o(s) exemplo(s);
2. Experimentar quanto tempo e conhecimento são necessários para começar a usá-lo(s);
3. Aprofundar-se nos usos e na documentação para chegar ao uso desejado;

Apresentamos abaixo as imagens usadas nos testes que fizemos e os resultados.

#### Detecção de elipses

Abra o app `Elipses` no celular e escolha uma foto. 

![Tela do app](amostras/Elipses/Screenshot_20200714-154353.png)

Na tela do celular: 

- No alto a visualização da foto escolhida, 
- em seguida a foto processada com as sete elipses localizadas realçadas, 
- a quantidade de elipses localizadas;
- lista contendo uma sub-lista por elipse. Cada sub-lista contém as coordenadas de uma elipse, a expressão "Não especificado" (para uso futuro) e o tamanho da elipse;
- por último, o caminho para o arquivo processado.

[Imagem Original (Tamanho: 2,8M)](amostras/Elipses/IMG_20200615_165551868.jpg)

[Imagem Processada (Tamanho: 600k)](amostras/Elipses/AltImage_8610.jpg)

#### Detecção de polígonos

O app foi codificado para identificar polígonos de quatro lados, por abuso de notação, usou-se retângulos para o nome do app. Abra o app `Retangulos` no celular e escolha uma foto.

![Tela do app](amostras/Retangulos/Screenshot_20200714-161840.png)

Na tela do celular: 

- No alto a visualização da foto escolhida, 
- em seguida a foto processada com os cinco retângulos localizados realçados (clicando na foto ela é aberta em tela cheia), 
- a quantidade de retângulos localizados;
- lista contendo uma sub-lista por retângulo. Cada sub-lista descreve um retângulo, iniciando pela expressão "Não especificado" (para uso futuro) e as coordenadas de cada um dos vértices;
- por último, o caminho para o arquivo processado.

[Imagem Original (Tamanho: 3M)](amostras/Retangulos/IMG_20200615_152429437.jpg)

[Imagem Processada (Tamanho: 700k)](amostras/Retangulos/AltImage_1274.jpg)

#### Identificação/Substituição de cor

Abra o app `Ola` no celular e escolha uma foto, ajuste os intervalos de H e S que deseja substituir por preto (Hmin, Hmax, Smin, Smax), clique no botão `Seleciona Cor`.

![Tela do app](amostras/Ola/Screenshot_20200714-172110.png)

Na tela do celular: 

- No alto a visualização da foto escolhida, 
- em seguida os quatro controles deslizantes através dos quais ajusta-se Hmin, Hmax, Smin e Smax.
- o botão `Seleciona Cor` - apertar depois de escolher os intervalos de H e S desejados,
- a foto processada, com as cores substituídas (clicando na foto ela é aberta em tela cheia), 
- por último, o caminho para o arquivo processado.

[Imagem Original (Tamanho: 2,7M)](amostras/Ola/IMG_20200615_132103299.jpg)

[Imagem Processada (Tamanho: 90k)](amostras/Ola/AltImage_5703.jpg)

No exemplo acima, com 0.6283 < H < 1.06811 e 0.2 < S < 1, selecionou-se muitas áreas com sombras. Para remover um pouco as sombras, pode-se aumentar um pouco a Saturação, o que pode ser interpretado como excluir áreas com pouca cor.

Resultado ajustando para  0.6283 < H < 1.06811 e **0.41** < S < 1

![Tela do app](amostras/Ola/Screenshot_20200714-172249.png)

Imagem Original (Tamanho: 2,7M) é a mesma do exemplo acima.

[Imagem Processada (Tamanho: 60k)](amostras/Elipses/Ola/AltImage_4416.jpg)

Você pode estar se questionando [por que HSV ao invés de RGB](#Por-que-HSV-ao-invés-de-RGB). HSV é um sistema de codificação de cores que, comparado ao RGB, organiza o espaço de cores de uma forma mais intuitiva para nós, humanos.

#### Substituição de cor encadeada a detecção de elipses e retângulos.

Nestes exemplos a imagem é processada realçando uma cor específica e depois, sobre a imagem processada, as formas são localizadas.

**Realça o laranja e localiza a forma**

[Imagem Original (Tamanho: 2,7M)](amostras/Combinado/IMG_20200615_192802274.jpg)

![Tela do app](amostras/Combinado/Screenshot_20200714-185223.png)

[Imagem com o laranja realçado (12k)](amostras/Combinado/AltImage_4745.jpg)

![Tela do app](amostras/Combinado/Screenshot_20200714-185257.png)

[Imagem com o retângulo localizado (9k)](amostras/Combinado/AltImage_1394.jpg)

**Realça o azul e localiza as formas**

Imagem Original (Tamanho: 2,7M) é a mesma do exemplo acima.

![Tela do app](amostras/Combinado/Screenshot_20200714-191652.png)

[Imagem com o azul realçado (12k)](amostras/Combinado/AltImage_4339.jpg)

![Tela do app](amostras/Combinado/Screenshot_20200714-191821.png)

[Imagem com as formas localizadas (10k)](amostras/Combinado/AltImage_7224.jpg)

**Realça o vermelho e localiza as formas**

Imagem Original (Tamanho: 2,7M) é a mesma do exemplo acima.

![Tela do app](amostras/Combinado/Screenshot_20200714-192558.png)

[Imagem com o azul realçado (12k)](amostras/Combinado/AltImage_7538.jpg)

![Tela do app](amostras/Combinado/Screenshot_20200714-192640.png)

[Imagem com as formas localizadas (10k)](amostras/Combinado/AltImage_9925.jpg)

## Como instalar a extensão

Baixe a extensão ImageCV [aqui](appcv.ImageCV.aix), guarde onde ela foi armazenada.

No seu projeto do App Inventor, no quadro da esquerda na aba extension clique no link *Import extension*

Uma caixa de mensagem se apresenta, clique em Browse, selecione o arquivo *appcv.ImagCV.aix* baixado no passo X.

![](screenshots/1.jpg)

Deve aparecer na aba a extensão ImageCV.

![](screenshots/2.jpg)


## Os aplicativos para teste

[Página para download de .aia e .apk](Testes/README.md)

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


![stepHSV](screenshots/image107.png)

picturePath: localização do arquivo de imagem.
HSMin: valores mínimos de H e S.
HSMax: valores máximos de H e S.

Retorna em altImagePath a localização do arquivo de imagem segmentado por cor.

baseado em (https://boofcv.org/index.php?title=Example_Color_Segmentation)

### reconhecePoligonos

![reconhecePoligonos](screenshots/image106.png)



picturePath: localização do arquivo de imagem.
minLados: quantidade mínima de lados dos polígonos a identificar (mínimo=3, máximo=20)
maxLados: quantidade máxima de lados dos polígonos a identificar (mínimo=3, máximo=20)

O desempenho ótimo é conseguido quando os polígonos são pretos e planos em fundo branco, com iluminação uniforme, sem sombras.

Retorna em altImagePath a localização do arquivo de imagem com os polígonos identificados contornados em vermelho.

Retorna em nPoligonos a quantidade de polígonos encontrada.

Retorna em listaDePoligonos uma lista contendo nPoligonos sub-listas. Cada sub-lista contém a coordenadas dos vértices dos polígonos em ordem: [x1, y1, x2, y2, x3, y3, ..., xn, yn].

### reconheceElipses

![reconheceElipses](screenshots/image105.png)


picturePath: localização do arquivo de imagem.

O desempenho ótimo é conseguido quando os polígonos são pretos e planos em fundo branco, com iluminação uniforme, sem sombras.

Retorna em altImagePath a localização do arquivo de imagem segmentado por cor.

Retorna em nElipses a quantidade de elipses encontrada.

Retorna em listaDeElipses uma lista contendo nElipses sub-listas. Uma sub-lista contém: [xcentro, ycentro, "Não Especificado", diâmetro_médio].

### converteRGBtoHSV

![converteRGBtoHSV](screenshots/image104.png)


RGB

### getAltImagePath

![getAltImagePath](screenshots/image108.png)


Contém a localização do arquivo de imagem que contém as cores segmentadas ou as elipses ou os polígonos localizados, dependendo do método que foi utilizado.

![ImageCV1](screenshots/image118.png)


### getCaractElipses

![getListaDeElipses](screenshots/image110.png)


### getCaractPoligonos

![getListaDePoligonos](screenshots/image111.png)


### getHfromRGBtoHSV

![getHfromRGBtoHSV](screenshots/image109.png)

### getSfromRGBtoHSV
![getSfromRGBtoHSV](screenshots/image112.png)


### getVfromRGBtoHSV
![getVfromRGBtoHSV](screenshots/image113.png)


### getListaDeElipses

### getnElipses

![getnElipses](screenshots/image114.png)

### getnPoligonos

![getnPoligonos](screenshots/image115.png)



### setCaractElipses
### setCaractPoligonos
### setnElipses
![setnElipses](screenshots/image116.png)

### setnPoligonos

![setnPoligonos](screenshots/image117.png)

## Bibliografia

Pokress, S.C., Veiga, J. MIT App Inventor: Enabling Personal Mobile Computing. In Proceedings of the PRoMoTo Workshop at the ACM SIGPLAN conference on Systems, Programming, Languages and Applications (SPLASH ’13). ACM, New York, NY, USA. (http://arxiv.org/abs/1310.2830). 

Elsts, Atis & Judvaitis, Jānis & Selavo, Leo. (2013). SEAL: A Domain-Specific Language for Novice Wireless Sensor Network Programmers. Proceedings - 39th Euromicro Conference Series on Software Engineering and Advanced Applications, SEAA 2013. 220-227. 10.1109/SEAA.2013.16. 

[Mapa do site](sitemap.md)

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

