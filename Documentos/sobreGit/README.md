# SensoresRemotos

## Contexto e setup

Estou começando a trabalhar mais seriamente com git e github.

Comecei este repositório primeiro criando o repositório no github e depois clonando no computador local. Fiz isso porque não achei no github como criar subdiretórios e quero isso para organizar os arquivos que pretendo criar e manter aqui.

Criar o repositório no github foram alguns apertar de botões. Preferi criar com o *README.md* para criar o repositório com algo dentro - recomendo fazer isso. Chamarei o repositório de *RepoTeste*. Já criar no computador local deu mais trabalho pois fiz umas besteiras no caminho.

Antes de começar a história, instale o [git](https://git-scm.com/). :)

Ok, antes de antes de começar: 

- git é uma ferramenta de versionamento e desenvolvimento paralelo (colaborativo) em que cada colaborador pode ter uma ou mais linhas de trabalho (*branch*) e pode mantê-las todas em paralelo. Quando uma linha de trabalho estiver concluída, ele pode fundir (*merge*) com a linha de trabalho que quiser, por exemplo a linha mestra, ou a linha de produção.

- github é um site de desenvolvimento colaborativo e compartilhamento de projetos. Ele é baseado em um servidor de arquivos executando git e permitindo que desenvolvedores armazenem, compartilhem, comuniquem, divulguem projetos e socializem em torno dos projetos. 

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

(comentário: este editor de markdown é bem legal - pelo menos o bold e o itálico ele formata WYSIWYG).

(comentário 2: a palavra *é* pode ser usada para dar a definição de dicionário de algo ou para dar a percepção de quem escreve sobre aquilo que ele está descrevendo, além de outros usos. Fique atento!)

(comentário 3: minha internet passou o dia instável. Usar o editor online do github nessa condição pode levar a perda de dados pois se não houver conexão, o botão *commit changes* falha e o que foi digitado no editor é perdido.)

(comentário 4: quando tentei clonar da primeira vez, criei o diretório e dei um **git init**. Se ficar só por isso, cria-se um novo repositório. Vendo [esta postagem](https://stackoverflow.com/questions/651038/how-do-you-clone-a-git-repository-into-a-specific-folder) entendi que eu poderia "corrigir" fazendo: 
git remote add origin PATH/TO/REPO; git fetch; git checkout -t origin/master. Não tentei, mas fica a dica - uma hora eu tento).

(comentário 5: apagando o .git e seu conteúdo, removo o diretório do git. [link](https://stackoverflow.com/questions/1514054/how-do-i-delete-a-local-repository-in-git))

Modifico aqui para simular o commit de um outro colaborador.
