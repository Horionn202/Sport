const tbody = document.querySelector('#tablaCalendario tbody');
const selectorMes = document.querySelector('#selectorMes');

function generarCalendario(año, mes) {
  tbody.innerHTML = '';
  
  const primerDia = new Date(año, mes, 1).getDay(); // 0 = domingo
  const ultimoDia = new Date(año, mes + 1, 0).getDate(); // último día del mes
  
  const hoy = new Date();
  let fila = document.createElement('tr');

  // Rellenar espacios antes del primer día
  for (let i = 0; i < primerDia; i++) {
    fila.appendChild(document.createElement('td'));
  }

  // Rellenar días del mes
  for (let dia = 1; dia <= ultimoDia; dia++) {
    const celda = document.createElement('td');
    celda.textContent = dia;

    if (
      dia === hoy.getDate() &&
      mes === hoy.getMonth() &&
      año === hoy.getFullYear()
    ) {
      celda.classList.add('hoy');
    }

    celda.addEventListener('click', () => {
      alert(`Seleccionaste: ${dia}/${mes + 1}/${año}`);
    });

    fila.appendChild(celda);

    if ((primerDia + dia) % 7 === 0) {
      tbody.appendChild(fila);
      fila = document.createElement('tr');
    }
  }

  // Completar última fila
  if (fila.children.length > 0) {
    tbody.appendChild(fila);
  }
}

// Fecha actual
const fechaActual = new Date();
const año = fechaActual.getFullYear();
const mes = fechaActual.getMonth();

selectorMes.value = `${año}-${String(mes + 1).padStart(2, '0')}`;
generarCalendario(año, mes);

selectorMes.addEventListener('change', e => {
  const [año, mes] = e.target.value.split('-').map(Number);
  generarCalendario(año, mes - 1);
});