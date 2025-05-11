document.addEventListener('DOMContentLoaded', () => {
    const carregarDados = (url, elemento) => {
        fetch(url)
            .then(resposta => resposta.json())
            .then(dados => {
                dados.forEach(item => {
                    const li = document.createElement('li');
                    li.classList.add('tag-card');
                    li.dataset.tag = item.tag || item.classe || item.script;
                    li.textContent = item.tag || item.classe || item.script;
                    elemento.appendChild(li);
                });
            });
    };

    carregarDados('data/tags.json', document.querySelector('#html .tags-grid'));
    carregarDados('data/classes.json', document.querySelector('#css .tags-grid'));
    carregarDados('data/scripts.json', document.querySelector('#js .tags-grid'));

    // Preencher o select de tags (menu)
    const tagsSelect = document.getElementById('tags-select');
    fetch('data/tags.json')
        .then(resposta => resposta.json())
        .then(dados => {
            dados.forEach(item => {
                const option = document.createElement('option');
                option.value = item.tag || item.classe || item.script;
                option.textContent = item.tag || item.classe || item.script;
                tagsSelect.appendChild(option);
            });
        });

    const modalDetalhes = document.getElementById('modalDetalhes');
    const fecharModalBtn = document.getElementById('fecharModalBtn');
    const modalTitulo = document.getElementById('modalTitulo');
    const modalDescricao = document.getElementById('modalDescricao');
    const modalSintaxe = document.getElementById('modalSintaxe');
    const modalExemploPratico = document.getElementById('modalExemploPratico');
    const modalResultadoExemplo = document.getElementById('modalResultadoExemplo');

    document.addEventListener('click', (evento) => {
        const tagCard = evento.target.closest('.tag-card');
        if (tagCard) {
            const tipo = tagCard.parentNode.parentNode.id;
            const nome = tagCard.dataset.tag;

            fetch(`data/${tipo}.json`)
                .then(resposta => resposta.json())
                .then(dados => {
                    const item = dados.find(i => (i.tag || i.classe || i.script) === nome);
                    if (item) {
                        modalTitulo.textContent = item.tag || item.classe || item.script;
                        modalDescricao.textContent = item.descricao;
                        modalSintaxe.textContent = item.exemplo;
                        modalExemploPratico.innerHTML = item.exemplo;
                        modalResultadoExemplo.innerHTML = item.resultado;
                        modalDetalhes.style.display = 'flex';
                    }
                });
        }
    });

    fecharModalBtn.addEventListener('click', () => {
        modalDetalhes.style.display = 'none';
    });
});