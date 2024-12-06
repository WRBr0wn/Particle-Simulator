# Graphical Particle Simulator
Owner: Wyatt Brown

This graphical Particle Simulator uses Processing and Java to display and simulate the interaction between particles and obstacles.
It also used python's flask api and a csv file to store/retrive/save/update obstacles in the simulation.

To use this project:

- Run the flask api
  - This can be done through pulling and running the Docker image: "brow6946/particle-web-service"
  - Or by running the "api.py" file located in the "server" folder in the terminal.
- Then run the "main.pde" file in processing with the other java files in the "main" folder as a sketch.

Add particles using "+" and remove particles with "-".
Add Obstacles by left clicking in the simulation space, remove them by right clicking while hovering over the obstacle you would like to remove.
You can exit the simulation with "ESC."
