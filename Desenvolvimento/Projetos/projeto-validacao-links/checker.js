
function analisar() {
    const url = document.getElementById('siteUrl').value;
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = '<p>Analisando... Aguarde...</p>';

    if (!url) {
        resultDiv.innerHTML = '<p class="error">Por favor, informe uma URL válida.</p>';
        return;
    }

    fetch(url)
        .then(response => {
            resultDiv.innerHTML = '';
            log(`Status HTTP: ${response.status}`, response.status === 200 ? 'success' : 'error');
            return response.text();
        })
        .then(html => {
            const parser = new DOMParser();
            const doc = parser.parseFromString(html, 'text/html');

            checkDuplicateIds(doc, resultDiv);
            checkBasicSEO(doc, resultDiv);

            log("Análise concluída.", "success");
        })
        .catch(err => {
            log(`Erro ao acessar a página: ${err.message}`, "error");
        });
}

function checkDuplicateIds(doc, resultDiv) {
    const allIds = {};
    const duplicates = [];

    doc.querySelectorAll('[id]').forEach(el => {
        const id = el.id;
        if (allIds[id]) {
            duplicates.push(id);
        } else {
            allIds[id] = true;
        }
    });

    if (duplicates.length) {
        log(`IDs duplicados encontrados: ${duplicates.join(', ')}`, 'warning');
    } else {
        log("Nenhum ID duplicado encontrado.", "success");
    }
}

function checkBasicSEO(doc, resultDiv) {
    const title = doc.querySelector('title');
    const description = doc.querySelector('meta[name="description"]');
    const viewport = doc.querySelector('meta[name="viewport"]');

    log(`Título: ${title ? title.textContent : 'Não encontrado'}`, title ? 'success' : 'warning');
    log(`Descrição: ${description ? description.getAttribute('content') : 'Não encontrada'}`, description ? 'success' : 'warning');
    log(`Viewport configurado: ${viewport ? 'Sim' : 'Não'}`, viewport ? 'success' : 'warning');
}

function log(msg, type = 'log') {
    const div = document.createElement('div');
    div.className = `log ${type}`;
    div.textContent = msg;
    document.getElementById('result').appendChild(div);
}

function limpar() {
    document.getElementById('siteUrl').value = '';
    document.getElementById('result').innerHTML = '';
}
