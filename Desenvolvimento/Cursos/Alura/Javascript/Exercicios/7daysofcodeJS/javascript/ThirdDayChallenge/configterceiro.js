document.addEventListener("DOMContentLoaded", function() {
    const mensagemElemento = document.querySelector(".mensagem"); // Renomeado
    const botaoIniciar = document.getElementById("botao-iniciar");
    const botaoReiniciar = document.getElementById('botao-reiniciar');
    const botaoVoltar = document.querySelector('.botao-voltar');

    if (mensagemElemento) {
        mensagemElemento.textContent = "Bem-vindo ao Terceiro Desafio! Você fará escolhas sobre áreas e tecnologias para sua carreira. Clique em iniciar.";
    }

    if (botaoIniciar) {
        botaoIniciar.addEventListener('click', function(){
            if (mensagemElemento) mensagemElemento.style.display = 'none';
            botaoIniciar.style.display = 'none';

            const script = document.createElement('script');
            script.src = 'thirdchallenge.js';
            script.defer = true;
            document.body.appendChild(script);

            if (botaoReiniciar) botaoReiniciar.style.display = 'block';
        });
    }

    if (botaoReiniciar) {
        botaoReiniciar.addEventListener('click', function(){
            location.reload();
        });
    }

    if (botaoVoltar) {
        botaoVoltar.addEventListener('click', function(){
            window.location.href='../../index.html';
        });
    }
});