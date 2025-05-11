document.addEventListener('DOMContentLoaded', () => {
  const scrollIndicator = document.querySelector('.scroll-indicator');
  const introSection = document.querySelector('.intro-section');
  const themeToggleBtn = document.getElementById('theme-toggle-btn');
  const rootElement = document.documentElement;

  // Função para alternar tema
  const toggleTheme = () => {
    const currentTheme = rootElement.getAttribute('data-theme');
    const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
    rootElement.setAttribute('data-theme', newTheme);
    localStorage.setItem('theme', newTheme);
  };

  // Carregar tema salvo
  const savedTheme = localStorage.getItem('theme') || 'dark';
  rootElement.setAttribute('data-theme', savedTheme);

  // Evento de clique no botão de alternância de tema
  themeToggleBtn.addEventListener('click', toggleTheme);

  // Evento de rolagem suave
  scrollIndicator.addEventListener('click', () => {
    introSection.scrollIntoView({ behavior: 'smooth' });
  });
});
