console.log("script.js (principal) carregado e executando.");
document.addEventListener('DOMContentLoaded', function() {
    console.log("DOM Principal carregado.");
    const botoesGradiente = document.querySelectorAll('.botao-gradiente');
    const botaoTemaEscuro = document.getElementById('botao-tema-escuro');
    const botaoTemaClaro = document.getElementById('botao-tema-claro');

    // Animação para os botões de desafio na página inicial
    botoesGradiente.forEach(botao => {
        botao.addEventListener('mouseover', function() {
            // A animação de hover será controlada pelo CSS para consistência
        });
        botao.addEventListener('mouseout', function() {
            // A animação de hover será controlada pelo CSS
        });
        // A navegação é feita pelo href do link, não precisa de JS extra aqui.
    });

    // --- Lógica de Tema ---
    const aplicarTema = (tema) => {
        if (tema === 'dark-theme') {
            document.body.classList.add('dark-theme');
            document.body.classList.remove('light-theme');
        } else { // Inclui 'light-theme' ou qualquer outro caso (default)
            document.body.classList.remove('dark-theme');
            document.body.classList.add('light-theme');
        }
    };

    if (botaoTemaEscuro) {
        botaoTemaEscuro.addEventListener('click', function() {
            aplicarTema('dark-theme');
            localStorage.setItem('theme', 'dark-theme');
        });
    }

    if (botaoTemaClaro) {
        botaoTemaClaro.addEventListener('click', function() {
            aplicarTema('light-theme');
            localStorage.setItem('theme', 'light-theme');
        });
    }

    // Carregar tema salvo ao iniciar a página ou usar preferência do sistema/default
    const temaSalvo = localStorage.getItem('theme');
    if (temaSalvo) {
        aplicarTema(temaSalvo);
    } else if (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches) {
        aplicarTema('dark-theme');
    } else {
        aplicarTema('light-theme'); // Padrão
    }
    // --- Fim da Lógica de Tema ---

    // Responsividade via JS removida, pois o CSS é mais apropriado para isso (Media Queries)
});

