# Ramos (Branches)

## Situação

Vários desenvolvedores, às vezes trabalhando em arquivos separados, às vezes no mesmo arquivo, às vezes um revisando o trabalho do outro, simultaneamente ou não, com o repositório remoto em comum (github).

Desenvolvedores são pessoas e, como tal, importam-se com o resultado do seu trabalho - seja um objeto ou um documento. Em geral, ao menos enquanto estão envolvidas intensamente com o objeto em questão, se surpreendem negativamente quando outra pessoa também faz modificações no mesmo objeto **sem avisar antes**. Git e github podem ser usados para evitar surpresas.

(nota: A surpresa pode não ocorrer, ou ser boa, ou ser bem assimilada, caso as pessoas do grupo já se conheçam, ou têm um acordo prévio, ou têm temperamentos específicos)

A fim de evitar surpresas, o outro desenvolvedor pode adotar o seguinte fluxo de trabalho:

1. criar uma cópia do objeto original, 
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

## Criar cópia

## Fazer ajustes

## Avisar os colegas

## Discutir

## Fundir versões


