document.addEventListener('DOMContentLoaded', () => {
    const carregarDados = (url, tipo, elemento) => {
        const cache = localStorage.getItem(tipo);
        if (cache) {
            const dados = JSON.parse(cache);
            if (dados && Array.isArray(dados)) {
                preencherElementos(dados, elemento);
                return;
            }
        }
        fetch(url)
            .then(resposta => resposta.json())
            .then(dados => {
                if (dados && Array.isArray(dados)) {
                    localStorage.setItem(tipo, JSON.stringify(dados));
                    preencherElementos(dados, elemento);
                }
            })
            .catch(error => console.error(`Erro ao carregar ${tipo}:`, error));
    };

    const preencherElementos = (dados, elemento) => {
        elemento.replaceChildren();
        dados.forEach(item => {
            const li = document.createElement('li');
            li.classList.add('tag-card');
            li.dataset.tag = item.tag || item.classe || item.script;
            li.textContent = item.tag || item.classe || item.script;
            elemento.appendChild(li);
        });
    };

    carregarDados('data/tags.json', 'html', document.querySelector('#html .tags-grid'));
    carregarDados('data/classes.json', 'css', document.querySelector('#css .tags-grid'));
    carregarDados('data/scripts.json', 'js', document.querySelector('#js .tags-grid'));

    const tagsSelect = document.getElementById('tags-select');
    carregarDados('data/tags.json', 'html', tagsSelect);

    const modalDetalhes = document.getElementById('modalDetalhes');
    const modalTitulo = document.getElementById('modalTitulo');
    const modalDescricao = document.getElementById('modalDescricao');
    const modalSintaxe = document.getElementById('modalSintaxe');
    const modalExemploPratico = document.getElementById('modalExemploPratico');
    const modalResultadoExemplo = document.getElementById('modalResultadoExemplo');

    document.body.addEventListener('click', (evento) => {
        if (evento.target.classList.contains('tag-card')) {
            const tipo = evento.target.closest('.tags-grid').parentNode.id;
            const nome = evento.target.dataset.tag;
            const dados = JSON.parse(localStorage.getItem(tipo));
            if (dados) {
                const item = dados.find(i => (i.tag || i.classe || i.script) === nome);
                if (item) {
                    modalTitulo.textContent = item.tag || item.classe || item.script;
                    modalDescricao.textContent = item.descricao;
                    modalSintaxe.textContent = item.exemplo;
                    modalExemploPratico.textContent = item.exemplo;
                    modalResultadoExemplo.textContent = item.resultado;
                    modalDetalhes.style.display = 'flex';
                }
            }
        }
    });

    document.getElementById('fecharModalBtn').addEventListener('click', () => {
        modalDetalhes.style.display = 'none';
    });
});