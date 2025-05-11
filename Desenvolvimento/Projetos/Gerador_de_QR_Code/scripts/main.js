// Função para exibir/ocultar o campo de tamanho personalizado
function toggleCustomSize(value) {
    const customSizeContainer = document.getElementById("customSizeContainer");
    if (value === "custom") {
        customSizeContainer.style.display = "flex";
    } else {
        customSizeContainer.style.display = "none";
    }
}

// Função para gerar o QR Code
async function gerarQRCode() {
    const link = document.getElementById("link").value.trim();
    const tamanhoSelecionado = document.getElementById("tamanho").value;
    const customWidth = document.getElementById("customWidth").value;
    const customHeight = document.getElementById("customHeight").value;
    const errorElement = document.getElementById("error");
    const qrCodeImg = document.getElementById("qrCodeImg");

    errorElement.textContent = '';
    qrCodeImg.src = '';

    if (!link) {
        errorElement.textContent = "Por favor, insira um link válido.";
        return;
    }

    if (tamanhoSelecionado === "custom") {
        if (!customWidth || !customHeight || customWidth < 100 || customHeight < 100 || customWidth > 1000 || customHeight > 1000) {
            errorElement.textContent = "Insira valores válidos para largura e altura (entre 100 e 1000).";
            return;
        }
    }

    const tamanho = tamanhoSelecionado === "custom" ? `${customWidth}x${customHeight}` : tamanhoSelecionado;

    qrCodeImg.src = `https://api.qrserver.com/v1/create-qr-code/?size=${tamanho}&data=${encodeURIComponent(link)}`;
    qrCodeImg.style.width = tamanho.split('x')[0] + 'px';
    qrCodeImg.style.height = tamanho.split('x')[1] + 'px';
    document.getElementById("qrCodeContainer").style.display = "block";
    document.getElementById("feedback").innerText = "QR Code gerado com sucesso!";
}

// Função para verificar se o URL é válido
function isValidURL(url) {
    const pattern = new RegExp('^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})([/\\w .-]*)*/?$', 'i');
    return pattern.test(url);
}

// Função para limpar os campos
function limparCampos() {
    document.getElementById("qrForm").reset();
    document.getElementById("qrCodeContainer").style.display = "none";
    document.getElementById("feedback").innerText = '';
    document.getElementById("linkEncurtado").innerText = '';
    document.getElementById("error").textContent = '';
}

document.getElementById("qrForm").addEventListener("submit", (event) => {
    event.preventDefault(); // Previne o comportamento padrão do formulário
    gerarQRCode(); // Chama a função para gerar o QR Code
});
