document.addEventListener('DOMContentLoaded', () => {
  const typedText = document.querySelector('.typed-text');
  const cursor = document.querySelector('.cursor');
  const textArray = ["Transformando Ideias em Realidade"];
  const typingDelay = 100;
  const erasingDelay = 50;
  const newTextDelay = 2000;
  let textArrayIndex = 0;
  let charIndex = 0;

  const type = () => {
    if (charIndex < textArray[textArrayIndex].length) {
      if (!cursor.classList.contains('typing')) cursor.classList.add('typing');
      typedText.textContent += textArray[textArrayIndex].charAt(charIndex);
      charIndex++;
      setTimeout(type, typingDelay);
    } else {
      cursor.classList.remove('typing');
      setTimeout(erase, newTextDelay);
    }
  };

  const erase = () => {
    if (charIndex > 0) {
      if (!cursor.classList.contains('typing')) cursor.classList.add('typing');
      typedText.textContent = textArray[textArrayIndex].substring(0, charIndex - 1);
      charIndex--;
      setTimeout(erase, erasingDelay);
    } else {
      cursor.classList.remove('typing');
      textArrayIndex++;
      if (textArrayIndex >= textArray.length) textArrayIndex = 0;
      setTimeout(type, typingDelay + 1100);
    }
  };

  if (textArray.length) setTimeout(type, newTextDelay + 250);
});
