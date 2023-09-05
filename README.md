# ENTERPRISE-3-CHALLENGE
# Plataforma de Feedback Inteligente da Plusoft

A Plataforma de Feedback Inteligente da Plusoft tem como objetivo principal promover a colaboração e o crescimento dentro da empresa por meio da inteligência proporcionada pelo ChatGPT. A plataforma visa oficializar e aprofundar a troca de feedbacks entre colegas de equipe, permitindo o desenvolvimento do potencial individual e a geração de insights valiosos. Além disso, oferece relatórios detalhados para acompanhar a evolução e o desempenho profissional dos funcionários, contribuindo para a cultura de melhoria contínua da empresa. Ao facilitar a comunicação e os feedbacks construtivos entre diferentes áreas, a plataforma também ajuda a identificar pontos fracos e a definir estratégias para fortalecer os pontos fortes. Juntos, podemos elevar o sucesso da empresa!

-----------------------------------------------------------------------------------------
## Arquitetura Hexagonal

A arquitetura hexagonal, também conhecida como Arquitetura de Ports and Adapters ou Arquitetura Limpa, é um padrão de design que visa separar as preocupações em uma aplicação de software. Ela é caracterizada por uma estrutura em camadas, onde as funcionalidades centrais da aplicação estão no centro (núcleo) e as interfaces externas, como interfaces de usuário e serviços externos, estão nas bordas. Aqui estão algumas vantagens da arquitetura hexagonal:

- **Separação de Responsabilidades:** A arquitetura hexagonal promove uma clara separação de responsabilidades entre as diferentes partes da aplicação. O núcleo da aplicação contém a lógica de negócios, enquanto as interfaces externas estão isoladas.

- **Facilita Testabilidade:** A separação das interfaces externas facilita os testes unitários, pois você pode isolar o núcleo da aplicação e testá-lo independentemente das interfaces externas.

- **Flexibilidade:** A arquitetura hexagonal torna a aplicação mais flexível, permitindo a substituição de implementações de interfaces externas sem afetar o núcleo da aplicação. Isso facilita a evolução da aplicação ao longo do tempo.

- **Legibilidade e Manutenção:** A estrutura clara da arquitetura torna o código mais legível e facilita a manutenção, tornando mais fácil entender e atualizar partes específicas da aplicação.

------------------------------------------------------------------------------------------
## Métodos de Login e CRUDs

### Métodos de Login

Os métodos de login da Plataforma de Feedback Inteligente são responsáveis por autenticar os usuários no sistema. O método `login` recebe as credenciais do usuário (nome de usuário e senha) e verifica se elas correspondem a um usuário válido no banco de dados. Se as credenciais forem válidas, o usuário é autenticado e pode acessar as funcionalidades da plataforma. Caso contrário, o login falha e uma mensagem apropriada é retornada.

### CRUDs (Create, Read, Update, Delete)

Os CRUDs (Create, Read, Update, Delete) são operações básicas de gerenciamento de dados que permitem criar, ler, atualizar e excluir informações no sistema. Na Plataforma de Feedback Inteligente, os CRUDs são utilizados para:

- **Criação de Usuários:** O método de registro (`register`) permite criar novos usuários na plataforma, incluindo nome de usuário e senha. Os dados do usuário são armazenados no banco de dados.

- **Leitura de Usuários:** Os dados dos usuários podem ser lidos por meio de consultas no banco de dados, permitindo que a plataforma recupere informações sobre os usuários cadastrados.

- **Atualização de Dados:** Caso seja necessário atualizar informações de um usuário (por exemplo, nome de usuário), os métodos de atualização (`update`) permitem fazer essas alterações no banco de dados.

- **Exclusão de Usuários:** Os métodos de exclusão (`delete`) permitem remover um usuário do sistema, excluindo seus dados do banco de dados.

Essas operações são fundamentais para o funcionamento da plataforma, permitindo o gerenciamento dos usuários e a interação com o sistema.
