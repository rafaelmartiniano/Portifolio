// javascript/FifthDayChallenge/configquinto.js
document.addEventListener("DOMContentLoaded", function() {
    const mensagem = document.querySelector(".mensagem");
    const botaoIniciar = document.getElementById("botao-iniciar");
    const botaoReiniciar = document.getElementById('botao-reiniciar');
    const botaoVoltar = document.querySelector('.botao-voltar');

    // Mensagem inicial do Quinto Desafio
    mensagem.textContent = "Bem-vindo ao Quinto Desafio! Neste desafio, você criará uma lista de compras interativa. Clique em iniciar para começar.";

    botaoIniciar.addEventListener('click', function() {
        mensagem.style.display = 'none';
        botaoIniciar.style.display = 'none';

        const script = document.createElement('script');
        script.src = 'fifthchallenge.js'; 
        script.defer = true; 
        document.body.appendChild(script);

        botaoReiniciar.style.display = 'block';
    });

    botaoReiniciar.addEventListener('click', function() {
        location.reload(); 
    });

    botaoVoltar.addEventListener('click', function() {
        window.location.href = '../../index.html'; 
    });
});