// =============================
// TEMPLATES DOS DOCUMENTOS
// =============================

// Cada objeto em 'templates' representa um tipo de documento.
// Define os campos do formulário e uma função para gerar o layout final.
const templates = {
  // Template para TCC
  tcc: {
    fields: [
      { id: 'titulo', label: 'Título do TCC', type: 'text', required: true },
      { id: 'autor', label: 'Nome do Autor', type: 'text', required: true },
      { id: 'instituicao', label: 'Instituição', type: 'text', required: true },
      { id: 'data', label: 'Data', type: 'date', required: true },
      { id: 'resumo', label: 'Resumo', type: 'textarea', required: true },
      { id: 'introducao', label: 'Introdução', type: 'textarea', required: true },
      { id: 'metodologia', label: 'Metodologia', type: 'textarea', required: true },
      { id: 'resultados', label: 'Resultados', type: 'textarea', required: true },
      { id: 'conclusao', label: 'Conclusão', type: 'textarea', required: true },
      { id: 'referencias', label: 'Referências', type: 'textarea', required: true }
    ],
    // Função que gera o layout final do documento utilizando os dados fornecidos
    layout: function(data) {
      return `
        <h2>${data.titulo}</h2>
        <p><strong>Autor:</strong> ${data.autor}</p>
        <p><strong>Instituição:</strong> ${data.instituicao}</p>
        <p><strong>Data:</strong> ${formatDate(data.data)}</p>
        <h3>Resumo</h3>
        <p>${data.resumo}</p>
        <h3>Introdução</h3>
        <p>${data.introducao}</p>
        <h3>Metodologia</h3>
        <p>${data.metodologia}</p>
        <h3>Resultados</h3>
        <p>${data.resultados}</p>
        <h3>Conclusão</h3>
        <p>${data.conclusao}</p>
        <h3>Referências</h3>
        <p>${data.referencias}</p>
      `;
    }
  },
  // Template para Artigo Científico
  artigo: {
    fields: [
      { id: 'titulo', label: 'Título do Artigo', type: 'text', required: true },
      { id: 'autor', label: 'Nome do Autor', type: 'text', required: true },
      { id: 'instituicao', label: 'Instituição', type: 'text', required: true },
      { id: 'data', label: 'Data', type: 'date', required: true },
      { id: 'resumo', label: 'Resumo', type: 'textarea', required: true },
      { id: 'abstract', label: 'Abstract', type: 'textarea', required: true },
      { id: 'introducao', label: 'Introdução', type: 'textarea', required: true },
      { id: 'metodologia', label: 'Metodologia', type: 'textarea', required: true },
      { id: 'resultados', label: 'Resultados', type: 'textarea', required: true },
      { id: 'conclusao', label: 'Conclusão', type: 'textarea', required: true },
      { id: 'referencias', label: 'Referências', type: 'textarea', required: true }
    ],
    layout: function(data) {
      return `
        <h2>${data.titulo}</h2>
        <p><strong>Autor:</strong> ${data.autor}</p>
        <p><strong>Instituição:</strong> ${data.instituicao}</p>
        <p><strong>Data:</strong> ${formatDate(data.data)}</p>
        <h3>Resumo</h3>
        <p>${data.resumo}</p>
        <h3>Abstract</h3>
        <p>${data.abstract}</p>
        <h3>Introdução</h3>
        <p>${data.introducao}</p>
        <h3>Metodologia</h3>
        <p>${data.metodologia}</p>
        <h3>Resultados</h3>
        <p>${data.resultados}</p>
        <h3>Conclusão</h3>
        <p>${data.conclusao}</p>
        <h3>Referências</h3>
        <p>${data.referencias}</p>
      `;
    }
  },
  // Template para Relatório Técnico
  relatorio: {
    fields: [
      { id: 'titulo', label: 'Título do Relatório', type: 'text', required: true },
      { id: 'autor', label: 'Nome do Autor', type: 'text', required: true },
      { id: 'instituicao', label: 'Instituição', type: 'text', required: true },
      { id: 'data', label: 'Data', type: 'date', required: true },
      { id: 'resumo', label: 'Resumo', type: 'textarea', required: true },
      { id: 'introducao', label: 'Introdução', type: 'textarea', required: true },
      { id: 'desenvolvimento', label: 'Desenvolvimento', type: 'textarea', required: true },
      { id: 'conclusao', label: 'Conclusão', type: 'textarea', required: true },
      { id: 'referencias', label: 'Referências', type: 'textarea', required: true }
    ],
    layout: function(data) {
      return `
        <h2>${data.titulo}</h2>
        <p><strong>Autor:</strong> ${data.autor}</p>
        <p><strong>Instituição:</strong> ${data.instituicao}</p>
        <p><strong>Data:</strong> ${formatDate(data.data)}</p>
        <h3>Resumo</h3>
        <p>${data.resumo}</p>
        <h3>Introdução</h3>
        <p>${data.introducao}</p>
        <h3>Desenvolvimento</h3>
        <p>${data.desenvolvimento}</p>
        <h3>Conclusão</h3>
        <p>${data.conclusao}</p>
        <h3>Referências</h3>
        <p>${data.referencias}</p>
      `;
    }
  },
  // Template para Documento POE
  poe: {
    fields: [
      { id: 'titulo', label: 'Título do Documento POE', type: 'text', required: true },
      { id: 'autor', label: 'Nome do Responsável', type: 'text', required: true },
      { id: 'departamento', label: 'Departamento', type: 'text', required: true },
      { id: 'data', label: 'Data', type: 'date', required: true },
      { id: 'objetivo', label: 'Objetivo', type: 'textarea', required: true },
      { id: 'escopo', label: 'Escopo', type: 'textarea', required: true },
      { id: 'procedimentos', label: 'Procedimentos', type: 'textarea', required: true },
      { id: 'conclusao', label: 'Conclusão', type: 'textarea', required: true }
    ],
    layout: function(data) {
      return `
        <h2>${data.titulo}</h2>
        <p><strong>Responsável:</strong> ${data.autor}</p>
        <p><strong>Departamento:</strong> ${data.departamento}</p>
        <p><strong>Data:</strong> ${formatDate(data.data)}</p>
        <h3>Objetivo</h3>
        <p>${data.objetivo}</p>
        <h3>Escopo</h3>
        <p>${data.escopo}</p>
        <h3>Procedimentos</h3>
        <p>${data.procedimentos}</p>
        <h3>Conclusão</h3>
        <p>${data.conclusao}</p>
      `;
    }
  },
  // Template para Documento KB
  kb: {
    fields: [
      { id: 'titulo', label: 'Título do Documento KB', type: 'text', required: true },
      { id: 'autor', label: 'Nome do Responsável', type: 'text', required: true },
      { id: 'data', label: 'Data', type: 'date', required: true },
      { id: 'conteudo', label: 'Conteúdo', type: 'textarea', required: true }
    ],
    layout: function(data) {
      return `
        <h2>${data.titulo}</h2>
        <p><strong>Responsável:</strong> ${data.autor}</p>
        <p><strong>Data:</strong> ${formatDate(data.data)}</p>
        <h3>Conteúdo</h3>
        <p>${data.conteudo}</p>
      `;
    }
  },
  // Template para Documento RCA
  rca: {
    fields: [
      { id: 'titulo', label: 'Título do Documento RCA', type: 'text', required: true },
      { id: 'autor', label: 'Nome do Responsável', type: 'text', required: true },
      { id: 'data', label: 'Data', type: 'date', required: true },
      { id: 'analise', label: 'Análise', type: 'textarea', required: true },
      { id: 'acoes', label: 'Ações Propostas', type: 'textarea', required: true }
    ],
    layout: function(data) {
      return `
        <h2>${data.titulo}</h2>
        <p><strong>Responsável:</strong> ${data.autor}</p>
        <p><strong>Data:</strong> ${formatDate(data.data)}</p>
        <h3>Análise</h3>
        <p>${data.analise}</p>
        <h3>Ações Propostas</h3>
        <p>${data.acoes}</p>
      `;
    }
  }
};

// =============================
// FUNÇÃO AUXILIAR: FORMATAÇÃO DE DATAS
// Converte uma data do formato AAAA-MM-DD para "DD de mês de AAAA"
// =============================
function formatDate(dateISO) {
  if (!dateISO) return '';
  // Array com os nomes dos meses em português
  const meses = ['janeiro', 'fevereiro', 'março', 'abril', 'maio', 'junho',
                 'julho', 'agosto', 'setembro', 'outubro', 'novembro', 'dezembro'];
  // Divide a data em ano, mês e dia
  const [ano, mes, dia] = dateISO.split('-');
  // Retorna a data formatada
  return `${dia} de ${meses[parseInt(mes) - 1]} de ${ano}`;
}
