# Ramos (Branches)

## Situação

Vários desenvolvedores, às vezes trabalhando em arquivos separados, às vezes no mesmo arquivo, às vezes um revisando o trabalho do outro, simultaneamente ou não, com o repositório remoto em comum (github).

Desenvolvedores são pessoas e, como tal, importam-se com o resultado do seu trabalho - seja um objeto ou um documento. Em geral, ao menos enquanto estão envolvidas intensamente com o objeto em questão, se surpreendem negativamente quando outra pessoa também faz modificações no mesmo objeto **sem avisar antes**. Git e github podem ser usados para evitar surpresas.

(nota: A surpresa pode não ocorrer, ou ser boa, ou ser bem assimilada, caso as pessoas do grupo já se conheçam, ou têm um acordo prévio, ou têm temperamentos específicos)

A fim de evitar surpresas, o outro desenvolvedor pode adotar o seguinte fluxo de trabalho:

1. criar uma cópia (novo ramo) do objeto original, 
2. fazer os ajustes que achar melhor na sua cópia,
3. **avisar os colegas que tem uma nova versão do objeto**, 
4. discutir o que for necessário e 
5. ele, ou outro, fundir a versão original com a nova versão.

Uma parte das funcionalidades necessárias para isto são fornecidas pelo git, outras pelo github.

## o que é um ramo?

É uma versão do objeto. Pode ser uma cópia local, pode ter sofrido alguma modificação local. 

Num primeiro momento passa despercebido, mas a cópia no repositório remoto e a cópia local são, cada uma, um ramo (preciso confirmar isso, consultando a documentação do git).

Acredito que esses dois ramos (remoto e local), cada desenvolvedor com um ramo local somado a um grupo bem entrosado (um time), dê conta de muitos casos de desenvolvimento colaborativo. Algo como:

1. o grupo se comunica por algum app e combina o que fazer;
2. alguém cria o repositório remoto contendo algum boneco (mock-up, mocapi) do objeto;
3. todos clonam o repositório remoto em seus computadores locais;
4. a cada incremento que alguém quiser compartilhar ele avisa os outros pelo app;
5. discute-se o que for necessário e
6. o autor do incremento funde com a cópia remota, resolvendo os conflitos que ocorrerem.

Este fluxo de trabalho pode funcionar (nunca tentei), mas não permite gerenciar diferentes versões no mesmo local. Por exemplo quando, no mesmo local, alguém trabalha na versão de produção e na próxima versão e precisa trocar de uma para outra, seja para usar a versão de produção, seja para corrigir algo na versão de produção e depois voltar para a versão de desenvolvimento. Ou quando a equipe é grande e há fusões intermediárias,...

### Criar novo ramo

Partindo do pressuposto que você está no diretório local que contém o .git e que clonou o ramo master, o comando *git branch* lista ramos. No meu caso:

```
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/master
```
Vale notar que existe um ramo *master*, local e um ramo *master* remoto. O ramo em que estou é assinalado por um asterisco.

Com o requisito de partir de um ramo sincronizado (fiz *add, commit e push* ), o comando ```git branch <nome>``` cria um novo ramo de nome *<nome>*. Com este comando, ele é criado sincronizado com o ramo em que se está, mas ainda não se mudou para ele, como é possível notar abaixo. Para mudar para o ramo criado, usa-se ```git checkout <nome>```.


```
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ git branch  RevisaoFN
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ git branch
  RevisaoFN
* master
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ git checkout RevisaoFN 
Switched to branch 'RevisaoFN'
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ ls
Documentos  ImageCV.java  README.md  README.md~
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ git branch
* RevisaoFN
  master
fabio@fabio-13Z940-G-BK71P1:~/Documentos/Camila/CV$ 
```

![](screenshots/novoramo.png)

(nota: escrevi e salvei este conteúdo com *RevisaoFN* como ramo ativo. Mas este arquivo deveria ser atualizado direto no master pois só eu edito este arquivo. Isto quer dizer que salvei o arquivo num ramo diferente do que eu queria. Como não atualizei, se eu quiser mudar de ramo agora usando *git checkout ...* serei impedido. Posso comitar neste ramo, mas quando eu fizer *pull request* deste ramo, obrigarei meus colaboradores a revisar este arquivo, o que não é necessário. Jogar fora as alterações *thrashing* não é o que eu quero. A solução é *stash*: *git stash*, troca de ramo, *git stash apply*, conforme [sugestão](https://blog.cedrotech.com/git-o-minimo-que-voce-precisa-saber-para-trabalhar-em-equipe-parte-2/) )


## Fazer ajustes

## Avisar os colegas

## Discutir

## Fundir versões

## Outros fluxos de trabalho


https://blog.cedrotech.com/git-o-minimo-que-voce-precisa-saber-para-trabalhar-em-equipe-parte-2/
https://gist.github.com/blackfalcon/8428401
https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow
https://www.atlassian.com/git/tutorials/comparing-workflows#!workflow-gitflow
https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow


