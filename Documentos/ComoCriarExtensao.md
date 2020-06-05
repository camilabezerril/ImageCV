# Como criar extensões do App Inventor
---

## Visão geral (acho que isto vai para outro lugar...)

Extensões do App Inventor são programas que acrescentam alguma função personalizada, em geral, não disponível nos blocos já existentes nem atingível pela composição de blocos já existentes.

Estas extensões são *invisíveis*, no sentido que não podem ser componentes da interface gráfica com o usuário (GUI).

A extensão do nome do arquivo que contém uma extensão do App Inventor é *aix*. É algo como nome.aix.

## Como desenvolver 

As extensões do App Inventor são mantidas localmente: o ambiente de desenvolvimento é instalado e executado no computador do desenvolvedor (ié localmente), o código-fonte fica armazenado localmente. Por isso é necessário fazer alguns ajustes no computador.

Um conjunto de arquivo-fonte são necessário para definir objetos para comunicação entre a nova extensão e os blocos já existentes no App Inventor. Eles são disponibilizados através do [github](github.com). A forma mais fácil de obtê-los é [clonando o repositório do App Inventor](A definir). 

Em seguida, há uma sistematização do procedimento para obter uma extensão.

### Configurando o Ambiente

Para possibilitar o desenvolvimento da extensão, as seguintes ferramentas devem ser instaladas:

- **Java JDK**
  - [Download aqui](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- **Git**
  - [Download aqui](https://git-scm.com/)
- **Apache Ant**
   - [Download aqui](https://ant.apache.org/bindownload.cgi)

Apache Ant é uma biblioteca Java e ferramenta de linha de comando essencial que assiste na compilação
dos arquivos da extensão em conjunto com os do App Inventor.

* onde entra a questão do gradle??*

Após a instalação das ferramentas anteriores, as variáveis de ambiente devem ser acertadas nas propriedades do sistema
no painel de controle do Windows:

Variável | Valor
---|---
ANT_HOME | F:\apache-ant-1.10.7 (Pasta do Apache)
JAVA_HOME | C:\Program Files\Java\jdk1.8.0_111 (Pasta do Java)
ANT_OPTS | -Xmx256M
_JAVA_OPTIONS | -Xmx1024m
CLASSPATH | %ANT_HOME%\lib;%JAVA_HOME%\lib
Path | ;%ANT_HOME%\bin;%JAVA_HOME%\bin

* tem alguma referência (link) do app inventor, ou outro que contém esta informação? seria bom referenciá-lo aqui *

Por meio do Git, os arquivos do App Inventor serão clonados:

1. Selecione o local do arquivos, *no meu caso o local é...*
2. Clique com o botão direito e em `Git bash here`
3. Na linha de comando digite: `git clone https://github.com/mit-cml/appinventor-sources.git`

### Localização da extensão

Abrindo a pasta **App Inventor** *é a pasta criada no ítem 1?*  como um projeto em um Ambiente de Desenvolvimento Integrado (IDE),
as extensões por padrão devem ser colocadas no caminho: `appinventor\components\src\com\google\appinventor\components\runtime`

*que IDE você usou?*
* na parte sobre boofcv, pode ser informativo mostrar a árvore das pastas do projeto *


### O Código-fonte da extensão

* aqui vai ser um "olá mundo"? *

#### Importação de pacotes/classes do App Inventor

Criada a classe da extensão no local adequado, os *imports* mais comuns para funcionalidade do App Inventor,
que definem a forma como os blocos são vistos e utilizados pelo usuário, mensagens de erro, uso de mídia, entre outros, são:

~~~java
import android.Manifest;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.runtime.*;
~~~

Note que há inclusão do *import* UsesLibraries, necessário quando há a necessidade de uso de bibliotecas externas
informando posteriormente as bibliotecas essenciais que serão utilizadas pela extensão.

#### Detalhes da extensão

Há uma seção que informa os detalhes do código em desenvolvimento para o App Inventor:

~~~java
@DesignerComponent(version = 1,
        category = ComponentCategory.EXTENSION,
        description = "Componente para Visao Computacional no App Inventor",
        nonVisible = true,
        iconName = "images/extension.png")
@SimpleObject(external = true)
~~~

A categoria da classe deve ser, por padrão, EXTENSION.
As extensões por padrão, não podem ser componentes visíveis (design do App Inventor) para o usuário,
atuando apenas na parte de programação por blocos

#### Algumas propriedades do App Inventor

Os métodos que poderão ser vistos pelo usuário para a programação por blocos em geral
possuem propriedades que aparecerem antes da inicialização destes e definem as formas que poderão ser utilizados. Tais como:

`@SimpleProperty` define o método seguinte como um bloco de propriedade simples de alguma outra função ou método,
portanto atua como um parâmetro, como no exemplo a seguir:

~~~java
@SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String getAltImagePath() {
        return altImagePath;
    }
~~~

![](./getAltImagePath.png)

`@SimpleFunction` define o método seguinte como um bloco de função que receberá parâmetros a serem definidos no mesmo.

~~~java
@SimpleFunction(description = "Reconhece elipses em uma imagem")
    public void reconheceElipses(String picturePath){
      //...
    }
~~~

![](./callImageCV1.png)

### Compilando a extensão

  Para compilar a extensão, é necessário clicar com o botão direito e em seguida em `Git bash here`
dentro da pasta appinventor para entrar na linha de comando do git.

Há dois comandos essenciais:

- `ant clean` limpa compilações anteriores (sempre utilizar antes de `ant extensions`)
- `ant extensions` compila arquivos e gera arquivo aix da extensão

Após a conclusão correta da compilação (sinalizada pela mensagem: `BUILD SUCCESSFUL`), um arquivo aix é gerado e está localizado na pasta
`appinventor\components\build\extensions` podendo então ser aplicado a qualquer projeto do App Inventor por meio da seção extension
no ambiente de design deste.
