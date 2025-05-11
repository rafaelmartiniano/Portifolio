// javascript/SeventhDayChallenge/configsetimo.js
document.addEventListener("DOMContentLoaded", function() {
    const botaoIniciar = document.getElementById("botao-iniciar");
    const botaoReiniciar = document.getElementById('botao-reiniciar');
    const botaoVoltar = document.querySelector('.botao-voltar'); // Assumindo que existe um botão voltar geral
    let mensagemElemento = document.querySelector(".mensagem");

    if (mensagemElemento) {
         mensagemElemento.textContent = "Bem-vindo ao Sétimo Desafio! Você usará uma calculadora simples. Clique em iniciar.";
    }

    if (botaoIniciar) {
        botaoIniciar.addEventListener('click', function() {
            if (mensagemElemento) mensagemElemento.style.display = 'none';
            botaoIniciar.style.display = 'none';
            
            const script = document.createElement('script');
            script.src = 'seventhchallenge.js'; 
            script.defer = true; 
            document.body.appendChild(script);

            if (botaoReiniciar) botaoReiniciar.style.display = 'block';
        });
    }

    if (botaoReiniciar) {
        botaoReiniciar.addEventListener('click', function() {
            location.reload(); 
        });
    }
    
    if (botaoVoltar) {
        botaoVoltar.addEventListener('click', function() {
            window.location.href = '../../index.html';
        });
    }
});