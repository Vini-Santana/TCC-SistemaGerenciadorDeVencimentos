# TCC - Projeto de Gerenciamento de Produtos

## ⚙️ Pré-requisitos

### 1. Instalar Java 17
- Acesse: [Oracle JDK 17 Archive](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Baixe o arquivo: **Windows x64 Compressed Archive**
- Extraia para um local de fácil acesso

### 2. Instalar Maven 3.8.8
- Acesse: [Apache Maven Download](https://maven.apache.org/download.cgi)
- Baixe o arquivo: **Binary apache-maven-3.8.8-bin.zip**
- Extraia para um local de fácil acesso

---

## 🧩 Configuração das Variáveis de Ambiente (Windows)

1. **Criar variáveis de usuário**:
   - `JAVA_HOME` → caminho da pasta onde o Java foi extraído
   - `MAVEN_HOME` → caminho da pasta onde o Maven foi extraído

2. **Editar a variável `Path`** e adicionar:
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

## 🧪 Compilar o Projeto

Dentro da pasta `backend`, execute via PowerShell:

```bash
mvn clean install
```

---

## 🚀 Executar o Projeto

Na pasta `backend`, execute:

```bash
mvn spring-boot:run
```

--- 
## Commitando alterações 

Para subir no repositório remoto suas alterações, dentro do diretório TCC, execute no terminal:

**Certifique-se de estar na branch certa:**

```
git branch
```
A branch atual estará destacada:
```
* frontend
  main
```
Continuando ...
```
git add .
```
```
git commit -m "mensagem do commit"
```
```
git push origin Branch_Desejada
```