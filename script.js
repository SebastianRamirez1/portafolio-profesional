// Año dinámico en el footer (presente en todas las páginas)
const year = document.querySelector("#year");
if (year) {
  year.textContent = new Date().getFullYear();
}
