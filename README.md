# Graphical Particle Simulator
Owner: Wyatt Brown

This graphical Particle Simulator uses Processing and Java to display and simulate the interaction between particles and obstacles.
It also uses python's flask api and a csv file to store/retrive/save/update obstacles in the simulation.

To use this project:

- Run the flask api - This can be done one of 3 ways:
  1. Pulling and running the Docker image: "brow6946/particle-web-service" from DockerHub (Unable to instatiate or store obstacles)
  2. Creating and running a new docker image using the given Dockerfile and the "server" folder (Able to instantiate obstacles)
  3. Or by locally running the "api.py" file located in the "server" folder (Able to instatiate and store obstacles)
- Then run the "main.pde" file in processing with the other files/folders in the "main" folder as a sketch.

- Once the Simulation has started:
  - Add particles using "+" and remove particles with "-".
  - Add Obstacles by left clicking in the simulation space, remove them by right clicking while hovering over the obstacle you would like to remove.
  - You can exit the simulation with "ESC."
