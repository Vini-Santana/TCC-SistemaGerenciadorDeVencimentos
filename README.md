
# 📦 TCC - Projeto de Gerenciamento de Produtos

## ⚙️ Pré-requisitos

### 1. Instalar Java 17
- Acesse: [Oracle JDK 17 Archive](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Baixe o arquivo: **Windows x64 Compressed Archive**
- Extraia para um local de fácil acesso

### 2. Instalar Maven 3.8.8
Você pode usar a versão 3.8.9, por exemplo, mas **não altere o segundo número da versão (3.8.x)**.
- Acesse: [Apache Maven Download](https://maven.apache.org/download.cgi)
- Baixe o arquivo: **Binary apache-maven-3.8.8-bin.zip**
- Extraia para um local de fácil acesso

---

## 🧩 Configuração das Variáveis de Ambiente (Windows)

1. No Windows, busque por **"variáveis de ambiente"** e abra a opção **"Editar variáveis de ambiente do sistema"**
2. Na janela que abrir, clique em **"Variáveis de Ambiente..."**

### Variáveis de usuário

#### `JAVA_HOME`
1. Procure a variável `JAVA_HOME` (crie caso não exista)
2. Edite-a e adicione o caminho onde o Java foi extraído (exemplo: `C:\Program Files\Java\jdk-17.0.x`)
3. Certifique-se de que a variável `Path` contém `%JAVA_HOME%\bin`. Se não, adicione.

#### `MAVEN_HOME`
1. Crie a variável `MAVEN_HOME` (ou edite se já existir)
2. Defina o caminho onde o Maven foi extraído (exemplo: `C:\apache-maven-3.8.8`)
3. Vá até a variável `Path` (em **Variáveis do sistema**) e clique em **Editar**
4. Adicione: `%MAVEN_HOME%\bin`
5. Clique em **OK** para salvar

### Editar a variável `Path` (caso ainda não tenha feito)

Adicione os caminhos abaixo:
```
%JAVA_HOME%\bin
%MAVEN_HOME%\bin
```

---

## 📥 Clonar o Repositório

1. Crie uma pasta chamada `TCC`
2. Dentro dela, execute o comando:

```bash
git clone https://github.com/Vini-Santana/TCC.git
```

---

## 🧪 Compilar e subir o Backend

No IntelliJ, acessar o arquivo TCCSistemaGerenciadorDeVencimentos, em:

```bash
TCC\backend\src\main\java\br\com\vinicius\TCCSistemaGerenciadorDeVencimentos.java
```
Clique no botão verde de execução (play) para compilar e subir o backend.

---

## 🚀 Subir o Frontend

No terminal dentro da pasta frontend, execute o seguinte comando:

```bash
npm start
```
O frontend será iniciado e você poderá acessá-lo em `http://localhost:3000`, e já está apontando para o backend em `http://localhost:8080`.

---

## 💾 Commitar Alterações

Para subir alterações para o repositório remoto, dentro do diretório `TCC`, execute os comandos:

### Verifique a branch atual:

```bash
git branch
```

A branch atual estará com `*`:
```bash
* frontend
  main
```

### Continuando...

```bash
git add .
git commit -m "mensagem do commit"
git push origin Nome_Da_Branch
```
