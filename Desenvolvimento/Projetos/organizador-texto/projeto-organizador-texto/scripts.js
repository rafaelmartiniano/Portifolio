// Função para organizar o texto
function organizarTexto() {
    // Obtém o texto digitado na área de texto
    const inputText = document.getElementById('inputText').value;

    // Verifica se o texto foi obtido corretamente
    console.log("Texto original:", inputText);

    // Organiza o texto adicionando novas linhas após pontuação seguida de letra maiúscula,
    // removendo linhas em branco extras e adicionando nova linha entre palavras que começam com letra maiúscula
    let organizedText = inputText
        .replace(/([.!?])\s*(?=[A-Z])/g, '$1\n') // Adiciona nova linha após pontuação seguida de letra maiúscula
        .replace(/(\r\n|\r|\n){2,}/g, '\n\n') // Remove linhas em branco extras
        .replace(/([a-z])([A-Z])/g, '$1\n$2'); // Adiciona nova linha entre palavras que começam com letra maiúscula

    // Verifica se o texto foi organizado corretamente
    console.log("Texto organizado:", organizedText);

    // Verifica se o texto após o ponto final inicia com letra minúscula
    const sentences = organizedText.split(/[.!?]\s+|;\s+/);
    for (let i = 0; i < sentences.length; i++) {
        const sentence = sentences[i].trim();
        if (sentence.length > 0 && sentence[0] === sentence[0].toLowerCase() && sentence[0].match(/[a-z]/)) {
            alert('Por favor, inicie todas as frases após um ponto final ou ponto e vírgula com uma letra maiúscula.');
            return; // Aborta a função se encontrar um erro
        }
    }

    // Copia o texto organizado para a área de transferência
    navigator.clipboard.writeText(organizedText).then(() => {
        // Exibe mensagem de sucesso
        document.getElementById('mensagem').innerText = 'Texto copiado com sucesso!';
        // Remove a mensagem após 2 segundos
        setTimeout(() => {
            document.getElementById('mensagem').innerText = '';
        }, 2000);
    }).catch(err => {
        // Exibe mensagem de erro
        document.getElementById('mensagem').innerText = 'Erro ao copiar para a área de transferência.';
        // Remove a mensagem após 2 segundos
        setTimeout(() => {
            document.getElementById('mensagem').innerText = '';
        }, 2000);
    });
}

// Função para limpar o texto da área de texto
function limparTexto() {
    // Limpa o texto da área de texto
    document.getElementById('inputText').value = '';
    // Exibe mensagem de sucesso
    document.getElementById('mensagem').innerText = 'Área de texto limpa com sucesso!';
    // Remove a mensagem após 2 segundos
    setTimeout(() => {
        document.getElementById('mensagem').innerText = '';
    }, 2000);
}

// Função para fechar a popup inicial
function closePopup() {
    const popup = document.getElementById('initialPopup');
    popup.classList.remove('show'); // Remove a classe 'show' para iniciar a transição de fade-out

    // Define um tempo limite para remover a popup completamente após a transição
    setTimeout(() => {
        popup.style.display = 'none';
    }, 500); // Tempo de transição (0.5s)
}

// Mostra a popup quando a página carrega
window.onload = function() {
    document.getElementById('initialPopup').classList.add('show');
};