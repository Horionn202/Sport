document.addEventListener("DOMContentLoaded", () => {
  const miniCalendario = document.getElementById("mini-calendario");
  const fecha = new Date();
  const mesActual = fecha.getMonth();
  const añoActual = fecha.getFullYear();

  // Días del mes actual
  const primerDia = new Date(añoActual, mesActual, 1).getDay();
  const ultimoDia = new Date(añoActual, mesActual + 1, 0).getDate();

  const diasSemana = ["D", "L", "M", "M", "J", "V", "S"];
  diasSemana.forEach(dia => {
    const div = document.createElement("div");
    div.textContent = dia;
    div.style.fontWeight = "bold";
    div.style.color = "#444646ff";
    miniCalendario.appendChild(div);
  });

  // Espacios vacíos antes del primer día
  for (let i = 0; i < primerDia; i++) {
    const espacio = document.createElement("div");
    espacio.textContent = "";
    miniCalendario.appendChild(espacio);
  }

  // Días del mes
  for (let dia = 1; dia <= ultimoDia; dia++) {
    const celda = document.createElement("div");
    celda.textContent = dia;

    if (dia === fecha.getDate()) {
      celda.classList.add("hoy");
    }

    miniCalendario.appendChild(celda);
  }
});