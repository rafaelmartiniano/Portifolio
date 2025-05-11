// javascript/SixthDayChallenge/configsexto.js
document.addEventListener("DOMContentLoaded", function() {
    const mensagem = document.querySelector(".mensagem");
    const botaoIniciar = document.getElementById("botao-iniciar");
    const botaoReiniciar = document.getElementById('botao-reiniciar');
    const botaoVoltar = document.querySelector('.botao-voltar');

    // Mensagem inicial do Sexto Desafio
    mensagem.textContent = "Bem-vindo ao Sexto Desafio! Gerencie sua lista de compras adicionando ou removendo itens. Clique em iniciar.";

    botaoIniciar.addEventListener('click', function() {
        mensagem.style.display = 'none';
        botaoIniciar.style.display = 'none';

        const script = document.createElement('script');
        script.src = 'sixthchallenge.js'; 
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