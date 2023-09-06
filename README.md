# Game of Life - Clon
## Introducción
El juego de la vida (Conway's game of life) es un juego de cero jugadores, el cual determina sus próximos estados a partir de un estado inicial y sin necesidad de una interacción externa. Fue creado por el matemático John Conway en 1970.

![MostrarGif](readme-rsc/GOF2gif.gif)


## Reglas
Las celdas se ajustan a las siguientes reglas:
- Nace: Si una celda muerta tiene exactamente 3 celdas vecinas vivas "nace" (es decir, al turno siguiente estará viva).
- Muere: una celda viva puede morir por uno de 2 casos:
  - Sobrepoblación: si tiene más de tres vecinos alrededor.
  - Aislamiento: si tiene solo un vecino alrededor o ninguno.
- Vive: una celda se mantiene viva si tiene 2 o 3 vecinos a su alrededor.
  
## Cómo jugar
Para poder jugar, se utilizan las siguientes teclas del teclado:
- S (del inglés "Slower"): Ralentiza la velocidad a la que la simulación cambia de estado.
- D (del inglés "Delete"): Borra el estado actual de la simulación.
- F (del inglés "Faster"): Acelera la velocidad a la que la simulación cambia de estado.
- P (del inglés "Pause"): Pausa/despausa la simulación.
- Botón izq. del mouse: activa/desactiva la celda que se presiona.
  
ACLARACIÓN: El botón izq. y la tecla 'D' solo funcionan cuando el juego está en pausa.

## Estructura del código
El código se basa en el patrón de arquitectura MVC. 
- Modelo: El modelo se encarga de retornar y cambiar el estado actual de la simulación, así como los datos del tamaño de las celdas, la pantalla, y otros.
- Vista: La vista se encarga de actualizar el estado del modelo una vez que este cambia.
- Controlador: El controlador se encarga de recibir las entradas de usuario y manejarlas para cambiar la simulación. Cuando la simualción debe cambiar, envía un mensaje al modelo para actualizar las celdas, así como un mensaje a la vista para actualizar la interfaz de usuario.

La vista utiliza la biblioteca gráfica Swing para generar la interfaz de usuario.
