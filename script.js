// Año dinámico en el footer (presente en todas las páginas)
const year = document.querySelector("#year");
if (year) {
  year.textContent = new Date().getFullYear();
}

// Lightbox de capturas — solo se activa si hay galerías en la página
const galleries = document.querySelectorAll(".shots");
if (galleries.length) {
  const lb = document.createElement("div");
  lb.className = "lightbox";
  lb.hidden = true;
  lb.innerHTML =
    '<button class="lightbox-prev" aria-label="Anterior">‹</button>' +
    '<img class="lightbox-img" alt="" />' +
    '<button class="lightbox-next" aria-label="Siguiente">›</button>' +
    '<button class="lightbox-close" aria-label="Cerrar">✕</button>';
  document.body.appendChild(lb);

  const lbImg = lb.querySelector(".lightbox-img");
  let current = [];
  let idx = 0;

  function show(i) {
    idx = (i + current.length) % current.length;
    lbImg.src = current[idx].full;
    lbImg.alt = current[idx].alt;
  }
  function open(items, i) {
    current = items;
    lb.hidden = false;
    document.body.style.overflow = "hidden";
    show(i);
  }
  function close() {
    lb.hidden = true;
    lbImg.removeAttribute("src");
    document.body.style.overflow = "";
  }

  galleries.forEach((g) => {
    const shots = [...g.querySelectorAll(".shot")];
    const items = shots.map((b) => ({
      full: b.getAttribute("data-full"),
      alt: b.querySelector("img") ? b.querySelector("img").alt : "",
    }));
    shots.forEach((b, i) => b.addEventListener("click", () => open(items, i)));
  });

  lb.querySelector(".lightbox-close").addEventListener("click", close);
  lb.querySelector(".lightbox-prev").addEventListener("click", (e) => {
    e.stopPropagation();
    show(idx - 1);
  });
  lb.querySelector(".lightbox-next").addEventListener("click", (e) => {
    e.stopPropagation();
    show(idx + 1);
  });
  lb.addEventListener("click", (e) => {
    if (e.target === lb) close();
  });
  document.addEventListener("keydown", (e) => {
    if (lb.hidden) return;
    if (e.key === "Escape") close();
    else if (e.key === "ArrowLeft") show(idx - 1);
    else if (e.key === "ArrowRight") show(idx + 1);
  });
}
