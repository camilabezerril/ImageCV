# Desenvolvimento de Componentes de Visão Computacional para Programação por Blocos
# ImageCV - Componente de Visão Computacional para o App Inventor

## Introdução

Visão computacional está se tornando uma área cada vez mais utilizada na
sociedade atual. Aplica-se a reconhecimento de sorriso em câmeras fotográficas,
reconhecimento facial em sistemas de vigilância, reconhecimento de culturas de
plantas em fotografias aéreas e outras.

Trabalhar nessa área requer conhecimento em computação, Inteligência
Artificial, processamento de imagens e na área de aplicação. A conjunção das
habilidades para o trabalho geralmente é conseguida formando equipes
multidisciplinares e, mais recentemente, dando formação interdisciplinar aos
profissionais.

Uma alternativa que poderia ser mais explorada é o uso de ferramentas
visuais, como programação por blocos, para reduzir a exigência nas habilidades
ligadas à tecnologia da informação e comunicação, consequentemente permitindoque profissionais da área de aplicação possam usar ferramentas de visão
computacional.

Programação por blocos é uma forma de criar programas que já mostrou que
facilita/acelera o desenvolvimento de aplicativos. É fácil de usar, razoavelmente
intuitivo, pode inclusive ser usado para ensinar crianças a programar - talvez o uso
mais popular da programação por blocos. Esta forma de programar tem suas
limitações: à medida que a quantidade de blocos aumenta a ferramenta perde a
comodidade pela poluição visual e quantidade e amplitude de movimentos físicos
(arrastar objetos na tela) necessários para construir os programas. Ainda assim,
com as escolhas adequadas, pode ser uma ferramenta útil para o desenvolvimento
de aplicações.

App Inventor (POKRESS, VEIGA, 2013) é um dos mais conhecidos
ambientes de programação em blocos. Desenvolvido pelo MIT, busca facilitar o
desenvolvimento de aplicativos que têm como base a linguagem Java. Esta
plataforma faz uso do Blockly, uma biblioteca que adiciona um código representado
por blocos que formam expressões lógicas quando anexados uns aos outros.
OpenCV (Bradski, 2000) significa ​ Open Source Computer Vision Library ​ , é
uma biblioteca de software aberto para visão computacional e aprendizado de
máquina (openCV, 2019). Originalmente desenvolvida na linguagem C/C++, por ser
Open Source e ser constantemente otimizada, fez com que outras formas de
aplicações com diferentes linguagens pudessem utilizá-la, tendo inclusive suporte
ao Android. Dessa forma, possibilitou diversos avanços na pesquisa em visão
computacional. Embora esteja disponível para serincorporada às aplicações feitas
no Android Studio, IDE oficial e profissional de aplicações Android, a biblioteca OpenCV não oferece suporte para o App Inventor e nem para o appybuilder. Há
projetos que tentaram implementar funcionalidades semelhantes, mas de forma
limitada e desatualizada.


## Objetivos

1. Criar uma ou mais extensões de alguma ferramenta de programação por
blocos que permitam a pessoas pouco experientes em linguagens de
programação utilizar técnicas de Visão Computacional.
2. Divulgar e documentar o desenvolvimento de extensões e os dados
coletados com o intuito de atrair desenvolvedores e interessados da área de
computação e de áreas de aplicação.
3. Introduzir o aluno de graduação da USP em uma linha de pesquisa nas Áreas
de Visão Computacional, Inteligência Artificial e Construção de Aplicativos.

## Métodos

Trata-se do desenvolvimento de componentes de software utilizando metodologia ágil. Nas primeiras semanas o estudante conhecerá colegas em diferentes estágios do seu trabalho de Iniciação Científica, que podem ser fontes de informação ou facilitadores para seu projeto. Nas semanas subsequentes, o estudante desenvolverá suas atividades recebendo metas semanalmente à medida que cumpre as metas anteriores, em um ciclo de desenvolvimento. Ao final espera-se entregar todos os resultados.

## Resultados

### Substituição de OpenCV por BoofCV.
### Compilação de ImageCV.
[Conteúdo detalhado](documentos/ExtensaoImageCV.md)

### Uso da extensão - Construção de app para celular usando ImageCV e App Inventor.
[Conteúdo detalhado](README.md)

## Sumário de resultados - Indicadores de avaliação

1. [Site documentando o projeto](https://github.com/camilabezerril/ImageCV/tree/master)
2. [Entrega do primeiro protótipo no fim de Janeiro](appcv.ImageCV.aix);
3. Submissão de resumo ao WICSI no fim de Fevereiro;
4. [Entrega de relatório intermediário no fim de Março](DocumentacaoProjeto.pdf);
5. [Entrega da última versão da extensão em Agosto](appcv.ImageCV.aix);
6. [Entrega do relatório final em Agosto](relatorio.md);
7. Submissão do resumo ao SIICUSP em Outubro.

## Discussão e conclusão

A versão do BoofCV utilizada em ImageCV é 0.27, por questão de compatibilidade entre ambientes de desenvolvimento. A versão atual de BoofCV é 0.36. A documentação da versão 0.27 não foi encontrada, o que dificultou o uso das funções de reconhecimento de polígonos.

A quantidade de aplicativos de teste criados só foi possível pela adoção da programação baseada em blocos, que permitiu que esses aplicativos fossem construídos em até menos de uma hora.

O bloco que converte códigos RGB para HSV é particularmente conveniente para encontrar a faixa de H e S que se deseja detectar

Os testes produzidos permitem levantar algumas características dos algoritmos. Estas podem gerar hipóteses para teste e aperfeiçoamento que podem motivar desenvolvimentos futuros.

1. Transformações de escala e resolução, caso sejam feitas e não revertidas, podem acarretar erros nas coordenadas das elipses e dos vértices dos polígonos. Algumas imagens de teste, após processamento, ficam muito pixeladas, o que indica o uso dessas transformações;
2. Cada tratamento da imagem parece degradar um pouco a imagem;
3. O algoritmo de reconhecimento de elipses parece aceitar erros maiores para reconhecer elipses menores, comparado a elipses maiores.

Seriam sugestões para projetos futuros:

1. Checar a preservação do sistema de coordenadas ao longo de sucessivos tratamentos;
2. Checar possibilidade e conveniência de diminuir a degradação da imagem para permitir mais tratamentos em sequência;
3. Checar o funcionamento interno dos algoritmos de localização de formas para verificar se há alguma transformação que afete desnecessariamente a resolução da imagem;
4. Testar uma estratégia de, baseado na imagem antes do tratamento, recuperar a qualidade da imagem depois do tratamento.

A  disponibilização de um processo para criar extensões para App Inventor permite embarcar no celular uma grande variedade de aplicativos, em especial os contidos em bibliotecas Java (.jar), que, além de BoofCV, é também o caso de Weka. Consequentemente facilitando a criação e teste de aplicativos que fazem uso de Inteligência Artificial.

## Referências

BRADSKI, G. (2000) - The OpenCV Library. ​ Dr. Dobb’s Journal of Software Tools ​ .
OpenCV (2019) - About OpenCV - <​ https://opencv.org/about/​ > Acessado em 26 de
maio de 2019.
POKRESS, Shaileen Crawford; VEIGA, José Juan Dominguez (2013) - MIT App
Inventor: Enabling Personal Mobile Computing - PRoMoTo 2013 Proceedings
(arXiv:1309.5509) October 2013.

