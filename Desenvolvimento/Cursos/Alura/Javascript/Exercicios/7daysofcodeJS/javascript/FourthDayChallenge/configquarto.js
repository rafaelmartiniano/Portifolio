// javascript/FourthDayChallenge/configquarto.js
document.addEventListener("DOMContentLoaded", function () {
    const mensagem = document.querySelector(".mensagem");
    // IDs dos botões corrigidos para corresponder ao HTML revisado
    const botaoIniciarFixo = document.getElementById('botao-iniciar-fixo');
    const botaoIniciarAleatorio = document.getElementById('botao-iniciar-aleatorio');
    const botaoReiniciar = document.getElementById('botao-reiniciar');
    const botaoVoltar = document.querySelector('.botao-voltar');
    const containerBotoesEscolha = document.querySelector('.botao-container');

    mensagem.textContent = "Bem-vindo ao Quarto Desafio! Escolha o modo de jogo de adivinhação.";

    function ocultarEscolhasEMostrarReiniciar() {
        mensagem.style.display = 'none';
        if (containerBotoesEscolha) containerBotoesEscolha.style.display = "none"; // Oculta o container dos botões de escolha
        botaoReiniciar.style.display = 'block';
    }

    function mostrarEscolhasEOcultarReiniciar() {
        mensagem.style.display = 'block';
        if (containerBotoesEscolha) containerBotoesEscolha.style.display = "flex"; // ou 'block', dependendo do seu CSS para .botao-container
        botaoReiniciar.style.display = 'none';
        // Remove scripts de desafios anteriores para evitar múltiplas execuções
        limparScriptsDesafio();
    }

    function limparScriptsDesafio() {
        // Ajuste no seletor para pegar qualquer script carregado por este config
        const scripts = document.querySelectorAll('script[src*="FourthChallenge"]');
        scripts.forEach(script => {
            if (script.src.includes("FourthChallenge-fixo.js") || script.src.includes("FourthChallenge-aleatorio.js")) {
                script.remove();
            }
        });
    }

    function carregarScriptDesafio(scriptSrc) {
        limparScriptsDesafio(); // Garante que não haja scripts duplicados
        const script = document.createElement('script');
        // Caminho corrigido: assume que os scripts estão na mesma pasta que configquarto.js
        script.src = scriptSrc; 
        script.defer = true;
        document.body.appendChild(script);
    }

    botaoIniciarFixo.addEventListener('click', () => {
        ocultarEscolhasEMostrarReiniciar();
        // Caminho corrigido
        carregarScriptDesafio('FourthChallenge-fixo.js'); 
    });

    botaoIniciarAleatorio.addEventListener('click', () => {
        ocultarEscolhasEMostrarReiniciar();
        // Caminho corrigido
        carregarScriptDesafio('FourthChallenge-aleatorio.js'); 
    });

    botaoReiniciar.addEventListener('click', function () {
        mostrarEscolhasEOcultarReiniciar();
    });

    botaoVoltar.addEventListener('click', () => {
        window.location.href = '../../index.html';
    });

    // Estado inicial
    mostrarEscolhasEOcultarReiniciar();
});