# Como começar

Nesse arquivo você pode checar o passo a passo de como baixar, modificar e atualizar o repositório do projeto.

Estes passos são importante para que consiga enviar o código que escreveu

---

## > Baixando Git

- Clique [aqui](https://git-scm.com/downloads) para baixar o Git

Após instalar e configurar o git, é necessário adicionar duas configurações:

    git config --global user.name <nome de usuario>
    git config --global user.email <email>

É através destas configurações que o github vai te identificar ao realizar alterações.

---

## > Baixando o repositório do projeto

Se o git já foi instalado, o próximo passo é baixar o repositório: 

    git clone <link>

No caso deste projeto, seria:

    git clone https://github.com/maximoace/Projeto-Sudoku.git

Com esse comando o git irá criar uma cópia do projeto na sua máquina, relacionada com o remoto.

---

## > Criando sua própria branch

Depois que a pasta terminou de baixar, entre com o Git Bash (ou uma IDE de sua preferência que tenha integração com git, ex: Vs Code) e crie uma nova branch com o seguinte comando:

    git checkout -b <nome da branch>

Esse comando cria uma nova branch e a seleciona para utilizar imediatamente, é a versão resumida de:

    git branch <nome da branch>
    git checkout <nome da branch>

Por motivos de organização, sugiro que o nome da branch seja dev-seunome

### **O que é uma branch?**

Branch é um galho, uma parte do código que não segue o fluxo principal, você cria uma "cópia" do ramo principal para fazer alterações.\
Quando se termina de adicionar alterações se funde o galho de volta no ramo principal e o git vai solucionar as diferenças entre os arquivos.

![branches](https://www.nobledesktop.com/image/blog/git-branches-merge.png)

### **Branches Locais e Remotas:**

Quando você baixa o projeto para sua máquina, seja com git clone ou git pull, o que ele faz é criar um clone (chamado de local) no seu pc com todas as branchs do projeto do github (chamado de remoto).\
Então toda vez que você seleciona uma branch com git checkout, o que ele faz é baixar a branch e criar uma versão local.

É possível atualizar somente o local ou o remoto, mas normalmente este não é o objetivo.

O --set-upstream, ou -u, cria uma correlação na sua máquina entre ambas as branchs local e remoto,

ou seja,

se você criar uma branch chamada branch-1:

    git checkout -b branch-1

e depois utilizar o --set-upstream:

    git push --set-upstream origin* branch-1

**É importante realizar este comando assim que criar a nova branch, para que as mudanças reflitam no local remoto.**


Ele vai relacionar as duas e definir como a relação padrão, então quando uma recebe um push, a outra também recebe o mesmo.

##### \* O origin no comando é uma apelido para o endereço do local remoto criado na config automaticamente pelo git.

---

## > Enviando as alterações para o projeto

3 passos:

1º :

    git add <caminho do arquivo com nome>
    ex: git add pasta/arquivo.exe

Vai adicionar o arquivo para a lista de prontos para commit.\
Para  adicionar todos os arquivos modificados de uma vez, use

    git add .

2º :

    git commit <motivo>
    
Esse comando adiciona o motivo de estar enviando essa atualização, tente escrever algo que seja descritivo sobre as mudanças.\
Para textos com mais de 50 caracteres, use

    git commit -m <motivo>

3º :

    git push <endereço remoto> <branch>

Manda as alterações para o branch do repositório se for especificado,

**Se não for especificado o endereço e a branch, o git vai enviar as atualizações para a branch atual local**

**Se o branch local estiver relacionado com o upstream de um branch remoto, vai realizar a  atualização no remoto.**

---

E com isso você agora sabe o básico para utilizar o sistema de versionamento do Git