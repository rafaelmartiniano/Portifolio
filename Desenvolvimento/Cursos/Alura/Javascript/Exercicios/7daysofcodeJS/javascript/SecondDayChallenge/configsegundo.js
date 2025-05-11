// javascript/SecondDayChallenge/configsegundo.js
document.addEventListener("DOMContentLoaded", function() {
    const mensagem = document.querySelector(".mensagem");
    const botaoIniciar = document.getElementById("botao-iniciar");
    const botaoReiniciar = document.getElementById('botao-reiniciar');
    const botaoVoltar = document.querySelector('.botao-voltar');

    // Mensagem inicial do Segundo Desafio
    mensagem.innerHTML = "Bem-vindo ao Segundo Desafio! Você continuará analisando variáveis. <strong>Os resultados serão exibidos no console.</strong> Clique em iniciar.";

    botaoIniciar.addEventListener('click', function(){
        alert("Lembre-se de abrir o console do seu navegador (pressione F12 e vá para a aba 'Console') para ver os resultados deste desafio.");
        // Oculta a mensagem e o botão iniciar
        mensagem.style.display = 'none';
        botaoIniciar.style.display = 'none';

        // Carrega o arquivo de desafio
        const script = document.createElement('script');
        script.src = 'secondchallenge.js';
        script.defer = true;
        document.body.appendChild(script);

        botaoReiniciar.style.display = 'block';
    });

    botaoReiniciar.addEventListener('click', function(){
        location.reload();
    });

    botaoVoltar.addEventListener('click', function(){
        window.location.href='../../index.html';
    });
});