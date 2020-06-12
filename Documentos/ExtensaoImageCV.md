# Como a extensão foi codificada
---

A extensão ImageCV está sendo desenvolvida com base na biblioteca de visão computacional [BoofCV](https://boofcv.org/index.php?title=Main_Page), escolhida por não utilizar bibliotecas “nativas” codificadas em linguagem diferente de Java,
ser Open Source, estar em constante atualização, e ainda por ter suporte ao Android.

As seções deste documento são:
1. [Pacotes do BoofCV](#pacotes-do-boofcv)
2. [Funcionamento da extensão](#funcionamento-da-extensão)
    1. [Funcionalidade básica](#funcionalidade-básica)
    2. [Funções relacionadas à visão computacional](#funções-relacionadas-à-visão-computacional)

## Pacotes do BoofCV

A biblioteca BoofCV (Atualmente na versão 0.36) é disponibilizada de duas formas: uma delas apresenta as dependências colocadas de forma a serem
facilmente adicionadas pelas IDE’s por meio de comandos. Já a outra é através de arquivos jar, que devido à plataforma para o qual a extensão é
desenvolvida (App Inventor), é a forma utilizada para aplicação da biblioteca na extensão.

A versão da biblioteca selecionada é a 0.27 ([Baixe aqui](https://sourceforge.net/projects/boofcv/files/v0.27/boofcv-v0.27libs.zip/download)),
podendo ainda ser modificada para a 0.28. As versões mais recentes não são utilizadas devido à incompatibilidade do App Inventor com a biblioteca,
o primeiro tendo suporte para o Java 7, já a segunda desenvolvida para o Java 8-11 a partir da versão 0.29.

As [demais versões](https://boofcv.org/index.php?title=Download) estão disponíveis no site da própria biblioteca.

Os pacotes utilizados pela extensão atualmente são:

- boofcv-android.jar
- boofcv-ip.jar
- ddogleg.jar
- georegression.jar
- boofcv-feature.jar
- ejml-core.jar
- ejml-ddense.jar
- ejml-fdense.jar
- ejml-simple.jar

### Configuração dos pacotes

Após serem baixados, os pacotes que serão utilizados devem ser colocados na pasta `appinventor\lib`.
Estes podem ser colocados em uma subpasta com nome a ser escolhido.

Para que seja compilado devidamente, o arquivo [build.xml](../build.xml), localizado dentro da pasta `appinventor\components`, deve ser modificado.

A seguinte formatação deve ser colocada na seção CopyComponentLibraries target
(Há um comentário com uma indicação: \<!-- Add extension libraries here \-->) para cada pacote adicionado à pasta lib que será utilizado:

~~~
<copy toFile=”${public.deps.dir}/nomeSimplificadoDoArquivoJar.jar”
file=”${lib.dir}/SubpastaDaBibliotecaNoLib/nomeDoArquivoJar.jar” />
~~~

Se estiver correto, após a compilação os pacotes serão copiados da pasta lib para a pasta `appinventor\build\components\deps`.

Por último, é necessário alterar o arquivo da classe da extensão de forma a informar quais bibliotecas serão utilizadas
durante a extensão, etapa na qual já está feita para os arquivos jar que são atualmente utilizados.
Debaixo dos detalhes da extensão, a seguinte formatação deve estar colocada:

~~~
@UsesLibraries(libraries = "library1.jar," +  “library2.jar,” + … + “libraryN.jar”)
~~~

## Funcionamento da extensão

### Funcionalidade básica

#### Métodos acessores

Logo ao início está a parte do código que disponibiliza para o usuário as informações geradas pela extensão,
possibilitando também que o mesmo possa modificar algumas delas.

Por exemplo:

~~~java
    /**
     * Retorna imagem alterada pela extensao
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String getAltImagePath() {
        return altImagePath;
    }
~~~

#### Imagem após ser fotografada

O método converteDrawableToBitmap trata a imagem assim que a foto é tirada pelo componente da câmera do App Inventor e seu
caminho se torna disponível para uso.

O caminho da imagem é recebido e um drawable é gerado a partir disto, utilizando uma classe do próprio App Inventor
(MediaUtil) que trata as variantes de uma imagem. Em seguida um bitmap em escala é criado, evitando possíveis problemas
gerados pelas imagens rotacionadas etc. e retornado.

A conversão de drawable para bitmap ocorre para que os processos envolvendo visão computacional sejam aplicados.

#### Salvando imagem alterada pela extensão

No método salvaAltImage o bitmap que passou por algum processo e foi alterado é comprimido, convertido para uma jpeg e
salvo na galeria do celular por meio de um objeto file.

Por fim, nesse mesmo método, o caminho da imagem alterada é salvo para posterior uso, como exibição desta no aplicativo,
entre outros.

Todas as imagens que passam por processos da extensão são salvas no mesmo caminho: pictures/ImageCV

### Funções relacionadas à visão computacional

Note que muitas classes da biblioteca BoofCV utilizam o tipo BufferedImage para processar as imagens, porém esta classe não
é suportada pelo Android. Alternativamente, a biblioteca apresenta classes que possibilitam a conversão de bitmap para
tipos de imagens em que a mesma trabalha. Estas classes estão presentes no pacote jar boofcv-android-0.27.
