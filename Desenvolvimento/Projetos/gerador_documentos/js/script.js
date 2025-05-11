// =============================
// LÓGICA PRINCIPAL DA APLICAÇÃO
// =============================
document.addEventListener('DOMContentLoaded', function() {
    // --- Obtenção de referências aos elementos do DOM ---
    const docTypeSelect = document.getElementById('docType');         // Seletor de tipo de documento
    const formFieldsContainer = document.getElementById('formFields');  // Container onde os campos do formulário serão gerados
    const generateBtn = document.getElementById('generateBtn');         // Botão para gerar o documento
    const printBtn = document.getElementById('printBtn');               // Botão para imprimir o documento
    const clearBtn = document.getElementById('clearBtn');               // Botão para limpar o formulário e o documento gerado
    const documentPreview = document.getElementById('documentPreview'); // Área onde o documento final será exibido
    const darkModeToggle = document.getElementById('darkModeToggle');   // Botão para alternar o modo escuro
    const messageBox = document.getElementById('message');              // Área para exibir mensagens de ação

    // Variável para controlar o estado do modo escuro (inicialmente desativado)
    let darkMode = false;

    // =============================
    // FUNÇÃO: displayMessage
    // Exibe uma mensagem com efeito fade-out (2 segundos) e depois oculta a mensagem
    // =============================
    function displayMessage(text, type) {
        messageBox.textContent = text;                  // Define o texto da mensagem
        messageBox.className = "message " + type;         // Adiciona a classe conforme o tipo (ex: success ou error)
        messageBox.style.display = "block";               // Torna a mensagem visível
        messageBox.style.opacity = 1;                     // Garante opacidade total
        // Após 2 segundos, inicia o efeito de fade-out
        setTimeout(function() {
            messageBox.style.opacity = 0;               // Inicia a transição de opacidade para 0
            // Após a transição, esconde a mensagem e limpa o texto
            setTimeout(function() {
                messageBox.style.display = "none";
                messageBox.textContent = "";
            }, 2000);
        }, 2000);
    }
    // Torna a função displayMessage global para que possa ser chamada por outros scripts (como export.js)
    window.displayMessage = displayMessage;

    // =============================
    // EVENTO: Alternar Modo Escuro
    // Alterna entre o modo claro e o modo escuro quando o botão é clicado
    // =============================
    darkModeToggle.addEventListener('click', function() {
        darkMode = !darkMode;                           // Inverte o estado do modo escuro
        if (darkMode) {
            document.body.classList.add('dark-mode');   // Adiciona a classe para modo escuro
            darkModeToggle.textContent = "Desativar Modo Escuro";  // Atualiza o texto do botão
            displayMessage("Modo escuro ativado.", "success");     // Exibe mensagem de sucesso
        } else {
            document.body.classList.remove('dark-mode'); // Remove a classe do modo escuro
            darkModeToggle.textContent = "Ativar Modo Escuro";     // Atualiza o texto do botão
            displayMessage("Modo escuro desativado.", "success");    // Exibe mensagem de sucesso
        }
    });

    // =============================
    // EVENTO: Alteração do Tipo de Documento
    // Quando o usuário seleciona um tipo, renderiza os campos do formulário conforme o template
    // =============================
    docTypeSelect.addEventListener('change', function() {
        const selectedType = this.value;                // Obtém o tipo de documento selecionado
        if (templates[selectedType]) {
            renderFormFields(templates[selectedType].fields);  // Renderiza os campos do template selecionado
        } else {
            formFieldsContainer.innerHTML = "";         // Se nenhum tipo for selecionado, limpa os campos
        }
    });

    // =============================
    // EVENTO: Gerar Documento
    // Coleta os dados inseridos, valida os campos e gera o layout final do documento
    // =============================
    generateBtn.addEventListener('click', function() {
        const selectedType = docTypeSelect.value;         // Obtém o tipo de documento selecionado
        if (!selectedType || !templates[selectedType]) {
            displayMessage("Por favor, selecione um tipo de documento.", "error");
            return;
        }

        const data = {};                                  // Objeto para armazenar os dados do formulário
        let valid = true;                                 // Variável de controle para validação dos campos

        // Itera sobre cada campo definido no template e coleta seu valor
        templates[selectedType].fields.forEach(field => {
            const input = document.getElementById(field.id); // Obtém o elemento do campo
            if (input) {
                data[field.id] = input.value.trim();      // Armazena o valor, removendo espaços
                if (field.required && !data[field.id]) {    // Se o campo obrigatório estiver vazio...
                    valid = false;                          // ...a validação falha
                }
            }
        });

        if (!valid) {
            displayMessage("Preencha todos os campos obrigatórios.", "error");
            return;
        }

        // Gera o layout final do documento utilizando a função do template
        documentPreview.innerHTML = templates[selectedType].layout(data);
        // Adiciona a classe de fonte específica conforme o tipo de documento
        documentPreview.className = "document-preview font-" + selectedType;
        documentPreview.style.display = 'block';          // Torna o documento visível

        displayMessage("Documento gerado com sucesso!", "success");
    });

    // =============================
    // FUNÇÃO: renderFormFields
    // Renderiza dinamicamente os campos do formulário com base nos dados do template
    // =============================
    function renderFormFields(fields) {
        formFieldsContainer.innerHTML = "";             // Limpa quaisquer campos existentes
        fields.forEach(field => {                         // Para cada campo definido
            // Cria o HTML do rótulo e do campo (input ou textarea)
            let fieldHtml = `<label for="${field.id}">${field.label}${field.required ? ' *' : ''}</label>`;
            if (field.type === 'textarea') {
                fieldHtml += `<textarea id="${field.id}" ${field.required ? 'required' : ''}></textarea>`;
            } else {
                fieldHtml += `<input type="${field.type}" id="${field.id}" ${field.required ? 'required' : ''} />`;
            }
            // Adiciona o campo gerado ao container de campos
            formFieldsContainer.innerHTML += fieldHtml;
        });
    }

    // =============================
    // EVENTO: Imprimir Documento
    // Abre uma nova janela com apenas o documento gerado e aciona a impressão
    // =============================
    printBtn.addEventListener('click', function() {
        // Verifica se existe um documento gerado
        if (documentPreview.style.display === 'none' || documentPreview.innerHTML === "") {
            displayMessage("Nenhum documento gerado para imprimir.", "error");
            return;
        }
        // Abre uma nova janela para impressão
        var printWindow = window.open('', '', 'width=800,height=600');
        // Escreve o HTML com o conteúdo do documento e link para o CSS (para manter a formatação)
        printWindow.document.write('<html><head><title>Documento para Impressão</title>');
        printWindow.document.write('<link rel="stylesheet" href="css/styles.css" type="text/css" />');
        printWindow.document.write('</head><body>');
        printWindow.document.write(documentPreview.innerHTML);
        printWindow.document.write('</body></html>');
        printWindow.document.close();
        printWindow.focus();
        // Aciona a impressão e fecha a janela
        printWindow.print();
        printWindow.close();
        displayMessage("Documento enviado para impressão.", "success");
    });

    // =============================
    // EVENTO: Limpar Documento
    // Limpa os campos do formulário, reseta o seletor e oculta o documento gerado
    // =============================
    clearBtn.addEventListener('click', function() {
        formFieldsContainer.innerHTML = "";             // Limpa os campos do formulário
        docTypeSelect.value = "";                         // Reseta o seletor de tipo de documento
        documentPreview.innerHTML = "";                   // Limpa o documento gerado
        documentPreview.style.display = "none";           // Oculta a área de visualização
        displayMessage("Documento e campos limpos.", "success");
    });
});
