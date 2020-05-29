# SensoresRemotos

## Motivação

Estou começando a trabalhar mais seriamente com git e github.

Se você for o único desenvolvedor do projeto, quer acessar o fonte de qualquer lugar e quando edita o fonte em computadores diferentes tem dificuldade ou aborrecimentos em unificar as versões dos computadores, git, github e esta página podem ajudar.

A dinâmica baseia-se em manter o fonte atualizado num repositório. Claro que uma pessoa disciplinada consegue fazer isso com um *pendrive* MAS mesmo os mais disciplinados às vezes esquecem ou não conseguem atualizar. Ferramentas de controle de versão, como git, ajudam a diminuir o trabalho caso isso aconteça. Com esta ferramenta, é possível trabalhar em outra funcionalidade do código, ou em outra seção do capítulo que está escrevendo e depois fundir (*merge*) todas as versões, na maioria dos casos, automaticamente.

Vou chamar *"na maioria dos casos, automaticamente"* de *quase automaticamente*.

Grandes vantagens tornam-se evidentes quando há várias pessoas trabalhando no mesmo arquivo. Neste caso cada uma pode ter sua cópia, dar sua contribuição e depois as contribuições podem ser fundidas *quase automaticamente*.

Se você está num projeto com uma equipe usando git para sincronizar os arquivos do projeto e precisou ficou fora por um mês, com três comandos você atualiza a sua versão e está pronto para voltar, pelo menos no que concerne aos arquivos.

Se você está trabalhando na próxima versão do seu projeto e surge um erro que precisa ser corrigido na versão de produção, com três comandos você entra na versão de produção, leva seu tempo para fazer a correção e com outros três comandos, volta para a próxima versão.

Se há diferentes versões, por exemplo para Android e para iOS, com alguns arquivos em comum e outros diferentes, com vários colaboradores em cada versão, manter os arquivos coerentes pode ser facilitado através do uso de controladores de versão, como git.

Em vista das vantagens, aprender a usar git ser um investimento: gasta-se esforço aprendendo, ganha-se capacidade de acrescentar colaboradores (escalabilidade) e agilidade em gerenciar o projeto.

## Etapas iniciais

Comecei este repositório primeiro criando o repositório no github e depois clonando no computador local. Fiz isso porque não achei no github como criar subdiretórios e quero isso para organizar os arquivos que pretendo criar e manter aqui.

Criar o repositório no github foram alguns apertar de botões. Preferi criar com o *README.md* para criar o repositório com algo dentro - recomendo fazer isso. Chamarei o repositório de *RepoTeste*. Já criar no computador local deu mais trabalho pois fiz umas besteiras no caminho.

Antes de começar a história, instale o [git](https://git-scm.com/). :)

Ok, antes de antes de começar: 

- git é uma ferramenta de versionamento e desenvolvimento paralelo (colaborativo) em que cada colaborador pode ter um ou mais ramos de trabalho (*branch*) e pode mantê-los todos em paralelo. Quando um ramo de trabalho estiver concluido, ele pode fundir (*merge*) com o ramo de trabalho que quiser, por exemplo o ramo mestre, ou o ramo de produção. Existe para Linux, Mac e Windows.

- github é um site de desenvolvimento colaborativo e compartilhamento de repositórios. Ele é baseado em um servidor de arquivos executando git e permitindo que desenvolvedores editem, armazenem, compartilhem, comuniquem, divulguem repositórios e socializem em torno deles. No github um repositório é uma área de armazenamento de arquivos e um projeto permite usar, além do repositório, ferramentas de gerenciamento, como quadros e mensagens - semelhante ao Trello. 

Entendida a diferença, *instale o git* passa a ser uma frase que faz sentido... :)

Depois de instalar o git:

- crie uma pasta no computador local para clonar o *RepoTeste*. (Sugestão para este momento:criar a pasta com o mesmo nome);
- copie o <nome do repositório> (algo como https://github.com/.../...) no botão *clone ou download* que aparece na janela do github do lado direito do nome do seu repositório.
- com o terminal (sim, uso linux), entre na pasta;
- execute **git clone <nome do repositório>  .   ** (o ponto no final é importante!)

Deve ter aparecido algumas mensagens e se tudo deu certo, o *README.md* deve estar lá também.

Talvez explicar a mesma coisa por outra fonte ajude a entender melhor. Pode tentar [a documentação do github sobre clonar repositórios](https://help.github.com/pt/github/creating-cloning-and-archiving-repositories/cloning-a-repository)

Depois de clonar o repositório, coloquei as instruções no *README.md* usando o editor online. Isto deixou o meu arquivo local atrasado em relação à versão no servidor. Para re-sincronizar:

- git fetch
- git merge (acabei de ver que git checkout dá um aviso que o ramo local está atrasado e recomenda usar git pull. Usei git pull e re-sincronizou)

Talvez explicar a mesma coisa por outra fonte ajude a entender melhor. Pode tentar [a documentação do github sobre sincronizar arquivos locais](https://help.github.com/pt/github/using-git/getting-changes-from-a-remote-repository)

Editor online pode gerar perda de dados (trabalho). Comecei a editar o arquivo local e sincronizar o repositório remoto.

- git add <arquivo(s) que mudou)
- git commit -m "mensagem"
- git push

Talvez explicar a mesma coisa por outra fonte ajude a entender melhor. Pode tentar [a documentação do github sobre sincronizar arquivos remotos](https://help.github.com/pt/github/using-git/pushing-commits-to-a-remote-repository)

Existe uma espécie de inconsistência lógica em torndo dos usos de *push*, *pull* e *merge*. Talvez fique mais claro para mim quando colocar em prática a possibilidade de usar vários repositórios remotos, várias versões e vários ambientes (o computador em que estou digitando os comandos é um servidor git ou é um cliente git), ... Por enquanto parece tudo mais ou menos igual, embora eu saiba que quando estou dando os comandos no cliente, *push* significa enviar do cliente para o servidor e que o servidor é o repositório remoto e *pull* significa trazer do servidor para o cliente.  

(comentário: este editor de markdown é bem legal - pelo menos o bold e o itálico ele formata WYSIWYG).

(comentário 2: a palavra *é* pode ser usada para dar a definição de dicionário de algo ou para dar a percepção de quem escreve sobre aquilo que ele está descrevendo, além de outros usos. Fique atento!)

(comentário 3: minha internet passou o dia instável. Usar o editor online do github nessa condição pode levar a perda de dados pois se não houver conexão, o botão *commit changes* falha e o que foi digitado no editor é perdido.)

(comentário 4: quando tentei clonar da primeira vez, criei o diretório e dei um **git init**. Se ficar só por isso, cria-se um novo repositório. Vendo [esta postagem](https://stackoverflow.com/questions/651038/how-do-you-clone-a-git-repository-into-a-specific-folder) entendi que eu poderia "corrigir" fazendo: 
git remote add origin PATH/TO/REPO; git fetch; git checkout -t origin/master. Não tentei, mas fica a dica - uma hora eu tento).

(comentário 5: apagando o .git e seu conteúdo, removo o diretório do git. [link](https://stackoverflow.com/questions/1514054/how-do-i-delete-a-local-repository-in-git))

Modifico aqui para simular o commit de um outro colaborador.

Fazendo de conta que não sei que outro colaborador fez um commit durante a minha edição, vou tentar um push...
