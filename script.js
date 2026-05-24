// Year display
const year = document.querySelector("#year");
if (year) {
  year.textContent = new Date().getFullYear();
}

// Nav scroll spy — highlights the active section in the topbar
const navLinks = document.querySelectorAll(".nav a");
const sectionIds = [...navLinks]
  .map((a) => a.getAttribute("href").replace("#", ""))
  .filter(Boolean);

function updateActiveNav() {
  const scrollY = window.scrollY + 100;
  let current = sectionIds[0];

  for (const id of sectionIds) {
    const el = document.getElementById(id);
    if (el && el.offsetTop <= scrollY) {
      current = id;
    }
  }

  navLinks.forEach((link) => {
    const isActive = link.getAttribute("href") === "#" + current;
    link.classList.toggle("is-active", isActive);
    link.setAttribute("aria-current", isActive ? "true" : "false");
  });
}

window.addEventListener("scroll", updateActiveNav, { passive: true });
updateActiveNav();
