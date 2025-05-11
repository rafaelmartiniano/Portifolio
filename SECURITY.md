# Política de Segurança

A segurança dos projetos e do código aqui apresentados é levada a sério. Embora muitos destes sejam projetos de estudo e portfólio, busco aplicar boas práticas de segurança sempre que possível.

## Reportando uma Vulnerabilidade

Se você descobrir uma vulnerabilidade de segurança em algum dos meus projetos, por favor, reporte-a de forma responsável.

**Como reportar:**

* Envie um e-mail para: `[SEU_EMAIL_PARA_CONTATO_DE_SEGURANCA_AQUI]`
* Por favor, inclua uma descrição detalhada da vulnerabilidade, os passos para reproduzi-la e, se possível, o impacto potencial.
* Não divulgue publicamente a vulnerabilidade até que haja uma oportunidade de análise e correção.

**O que esperar:**

* Uma confirmação do recebimento do seu relatório (geralmente em 48 horas).
* Uma avaliação da vulnerabilidade e um plano de ação, se aplicável.
* Crédito pela descoberta, se desejar, após a correção (para projetos onde isso seja relevante).

## Práticas de Segurança Adotadas (Quando Aplicável)

* **Validação de Entradas:** Em projetos que recebem dados do utilizador (especialmente APIs), procuro validar e sanitizar as entradas para prevenir ataques comuns como XSS ou SQL Injection (embora os projetos de estudo aqui possam não ter essa complexidade).
* **Gestão de Dependências:** Para projetos que utilizam bibliotecas externas, tento manter as dependências atualizadas para mitigar vulnerabilidades conhecidas.
* **Segredos e Chaves de API:** Chaves de API, senhas ou outros segredos nunca são "hardcoded" diretamente no código fonte de repositórios públicos. São geridas através de variáveis de ambiente ou ficheiros de configuração ignorados pelo Git (ex: `.env`, `application.properties` local não versionado).
* **Princípio do Menor Privilégio:** Ao configurar acessos ou permissões, aplico o princípio do menor privilégio necessário.

## Escopo

Esta política de segurança aplica-se aos projetos contidos neste repositório `Principal`. Vulnerabilidades em serviços de terceiros utilizados (como APIs externas) devem ser reportadas diretamente aos respetivos fornecedores.

Obrigado por ajudar a manter os projetos seguros!
