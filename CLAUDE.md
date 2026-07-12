# CLAUDE.md — Portafolio Sebastián Ramírez

Contexto persistente para Claude Code / Cowork. La base de conocimiento completa de
ingeniería está en [`docs/DIRECTRICES_INGENIERIA.md`](docs/DIRECTRICES_INGENIERIA.md).

## Qué es este proyecto

Portafolio profesional **estático**: HTML + CSS + JS vanilla, sin framework ni build step.
Desplegado en Netlify → https://sebastianramirezportfolio.netlify.app/

- `index.html` — página única, una sola columna
- `styles.css` — design system con variables CSS (tema oscuro tipo hectorvent.dev)
- `script.js` — año dinámico + scroll spy de navegación
- `assets/` — foto, favicon, OG cover, CV en PDF
- `docs/` — base de conocimiento de ingeniería

## Reglas duras (siempre)

- **Editar directamente los archivos del proyecto**, nunca en worktrees ni copias.
- **Verificar tras cada cambio** (abrir en navegador / revisar consola). Ver §"verificación".
- Ante conflicto de directrices, prioridad: **Seguridad > QA/Correctitud > Arquitectura > UX/UI > estilo**.
- No introducir complejidad "porque sí" (§1.4). Este es un sitio estático: las secciones de
  backend del documento (arquitectura de servicios, threat modeling, SAST/DAST, RAG) **no aplican**.
  Lo que aplica: **§6 UX/UI Frontend** y **§6.1.9 Accesibilidad**.

## Directrices UX/UI aplicables (§6 — resumen operativo)

1. **Carga cognitiva** — 7±2 ítems por lista; `:focus-visible` + hover en todo interactivo.
2. **Jerarquía** — color de acento (`--accent`) solo en interactivos/estados/métricas, nunca en cuerpo. Máx. 2 familias tipográficas.
3. **Navegación** — scroll spy con `aria-current="true"`; `scroll-padding-top` ≥ altura del header sticky; máx. 6 ítems; skip link.
4. **Tipografía** — cuerpo ≥16px en mobile; `line-height` 1.6–1.75 cuerpo; contraste ≥4.5:1.
5. **CTAs** — un CTA primario por sección; texto = acción concreta ("Ver código →").
6. **Confianza** — números concretos; señal de disponibilidad; enlazar evidencia real (GitHub/LinkedIn/CV/demo).
7. **Responsividad** — touch targets ≥44×44px; grids colapsan a 1 columna; `width`/`height` en `<img>` (evita CLS); sin `loading="lazy"` above-the-fold.
8. **Consistencia** — variables CSS para todo lo repetido; `prefers-reduced-motion`; en tema oscuro, tinte de acento ≤8% opacidad, nunca fondos claros.
9. **Accesibilidad** — HTML semántico; `alt` en imágenes; JSON-LD `Person` con `sameAs`; meta tags completos (title, description, Open Graph, Twitter Card).

## Git (§2)

- Conventional Commits: `feat|fix|refactor|docs|chore|ci(scope): descripción en imperativo`.
- No `console.log` de debug en producción.

## Verificación

Al tocar HTML/CSS/JS: abrir `index.html` en el navegador, revisar que no haya errores en consola,
probar el scroll spy (nav activa al hacer scroll), y validar el layout en mobile (≤640px).
