// =============================
// EXPORTAÇÃO PARA DOCX E ODT
// Utiliza a biblioteca html-docx.js para DOCX e Blob para ODT
// =============================

// Função para exibir mensagens de sucesso ou erro
window.displayMessage = function(message, type) {
    const messageElement = document.createElement('div');
    messageElement.classList.add(type);  // "success" ou "error"
    messageElement.textContent = message;
    document.body.appendChild(messageElement);
    setTimeout(() => {
        messageElement.remove();  // Remove a mensagem após 2 segundos
    }, 2000);  // 2 segundos
};

// EVENTO: Exportar para DOCX
document.getElementById('exportDocxBtn').addEventListener('click', function() {
    // Obtém o conteúdo do documento gerado
    var content = document.getElementById('documentPreview').innerHTML;
    
    // Verifica se há conteúdo para exportação
    if (!content || content.trim() === "") {
        window.displayMessage("Nenhum documento gerado para exportação.", "error");
        return;
    }
    
    // Converte o conteúdo HTML em um Blob do tipo DOCX usando a biblioteca html-docx.js
    var converted = htmlDocx.asBlob(content);
    
    // Cria um URL temporário para o Blob
    var url = URL.createObjectURL(converted);
    
    // Cria um elemento de link e simula um clique para download
    var a = document.createElement('a');
    a.href = url;
    a.download = 'documento.docx';  // Nome do arquivo DOCX
    a.click();
    
    // Libera o URL criado
    URL.revokeObjectURL(url);
    
    // Exibe uma mensagem de sucesso após a exportação
    window.displayMessage("Documento exportado para DOCX com sucesso!", "success");
});

// EVENTO: Exportar para ODT
document.getElementById('exportOdtBtn').addEventListener('click', function() {
    // Obtém o conteúdo do documento gerado
    var content = document.getElementById('documentPreview').innerHTML;

    // Verifica se há conteúdo para exportação
    if (!content || content.trim() === "") {
        window.displayMessage("Nenhum documento gerado para exportação.", "error");
        return;
    }

    // Cria um Blob com o conteúdo HTML usando o MIME type para ODT
    var blob = new Blob([content], { type: 'application/vnd.oasis.opendocument.text' });

    // Cria um URL temporário para o Blob
    var url = URL.createObjectURL(blob);

    // Cria um elemento de link e simula um clique para download
    var a = document.createElement('a');
    a.href = url;
    a.download = 'documento.odt';   // Nome do arquivo ODT
    a.click();

    // Libera o URL criado
    URL.revokeObjectURL(url);
    
    // Exibe uma mensagem de sucesso após a exportação
    window.displayMessage("Documento exportado para ODT com sucesso!", "success");
});