gerenciamento_escolar
📚 Sobre o projeto

O gerenciamento_escolar é um sistema desenvolvido como trabalho final da disciplina de Programação II. Ele permite o gerenciamento de uma escola, com funcionalidades para manipulação de turmas, alunos e professores — organizando dados e facilitando o controle das informações da instituição.

Funcionalidades principais

Cadastro, edição e remoção de alunos;

Cadastro, edição e remoção de professores;

Cadastro, edição e remoção de turmas;

Associação entre turmas, alunos e professores;

Persistência dos dados (via a lógica que seu código implementar — verificar se há banco de dados ou serialização, dependendo da sua versão).

🛠 Tecnologias / Ferramentas usadas

Linguagem: Java 
GitHub

Build / Gerenciamento de dependências: Gradle 
GitHub

Estrutura do projeto organizada com pasta src/, conforme padrão. 
GitHub
+2
DIO
+2

🚀 Como executar / compilar

⚠️ Adapte os passos abaixo conforme a estrutura/versão do seu projeto

# 1. Clone o repositório  
git clone https://github.com/JB-2499/gerenciamento_escolar.git  

# 2. Acesse a pasta do projeto  
cd gerenciamento_escolar  

# 3. Compile o projeto usando Gradle  
./gradlew build   # ou gradlew.bat build no Windows  

# 4. Execute a aplicação  
# Dependendo de como está organizado o projeto: 
# - se houver classe Main com método main(), executar via IDE ou:  
java -jar build/libs/nome-do-jar-gerado.jar  
# - ou rodar diretamente via IDE (Eclipse, IntelliJ, etc.)


Se for necessário configurar banco de dados, variáveis de ambiente, ou ajustes, adicione instruções aqui (por exemplo: criar banco, configurar credenciais, run migrations etc.).

📁 Estrutura de pastas (exemplo)
/gerenciamento_escolar  
├── src/            # Código-fonte Java  
├── build.gradle    # Configuração do Gradle  
├── gradlew         # Wrapper Gradle Linux/Mac  
├── gradlew.bat     # Wrapper Gradle Windows  
├── settings.gradle  
├── .gitignore      # Itens ignorados no versionamento  


(Este é um exemplo simples — ajuste conforme a real estrutura do seu projeto.)

🎯 Objetivo / Motivação

O sistema foi criado com objetivo de servir como exercício acadêmico da disciplina de programação, exercitando conceitos de orientação a objetos, manipulação de coleções/estruturas de dados, persistência (se implementada), lógica de negócio e organização de código — ao mesmo tempo em que simula um contexto real (gerenciamento escolar).

✅ Como contribuir

Se você quiser contribuir com melhorias, correções ou novas funcionalidades, sinta-se à vontade! Algumas ideias:

Implementar persistência em banco de dados (SQLite, MySQL, etc.);

Criar interface gráfica ou web para facilitar uso (caso ainda não exista);

Adicionar funcionalidades extras: busca de alunos/professores, relatórios, import/export de dados, etc.;

Melhorar a documentação;

Escrever testes automatizados.

Para contribuir, recomendo seguir um fluxo simples de:

Fazer um fork do repositório;

Criar uma branch com o nome da feature ou correção;

Fazer commits explicativos e claros;

Abrir um Pull Request com a sua proposta.

📝 Licença / Aviso

Descreva aqui a licença do projeto (se for o caso — MIT, GPL, etc.). Se não estiver usando uma licença formal, você pode apenas indicar “uso acadêmico / pessoal”.

✨ Agradecimentos / Referências

Se você usou bibliotecas, tutoriais ou referências externas durante o desenvolvimento, pode mencioná-las aqui. Também vale citar colegas, professores ou materiais que te ajudaram.
