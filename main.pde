import java.util.Random;
import java.util.EventObject;

Simulation simulation = new Simulation();
Particle[] ps = simulation.getParticles();
ObstacleNode ol;
Obstacle o;
double minDistance;
double distance;
Obstacle obstacleTBR;
Random rd = new Random();


void setup() {
    size(400,400);
    noStroke();
}

void draw() {
    background(100,100,100);
    ps = simulation.getParticles();
    ol = simulation.getObstacles();
    for (int i = 0; i < simulation.getNumParticles(); i++) {
        if (ps[i].getX() > 1.1 || ps[i].getX() < -0.1) {
            ps[i] = new Particle(rd.nextFloat(), 1.0, 0.1);
            ps[i].setVelocityX(rd.nextFloat());
        }
        for (ObstacleNode n = ol; n != null; n = n.getNext()) {
            ps[i].handleCollision(n.getObstacle());
        }
        ps[i].update(0.01);
        fill(255,255,255);
        circle((int)(ps[i].getX()*width), (int)(height-ps[i].getY()*height), (int)(ps[i].getRadius()*width));
  
    }
    fill(0,0,255);
    for (ObstacleNode n = ol; n != null; n = n.getNext()) {
        circle((int)(n.getObstacle().getX()*width), (int)(height-n.getObstacle().getY()*height), (int)(n.getObstacle().getRadius()*width*2.5));
    }
}

void mousePressed() {
    if (mouseButton == LEFT) {
        o = new Obstacle((float)1.0*mouseX/width, (float)(1.0-1.0*mouseY/height),0.1);
        simulation.addObstacle(o);
        System.out.println("Job Complete");
    }
    if (mouseButton == RIGHT) {
        for (ObstacleNode n = ol; n != null; n = n.getNext()) {
            distance = Vector2DMath.magnitude(((float)1.0*mouseX/width)-(n.getObstacle().getX()),((float)(1.0-1.0*mouseY/height))-(n.getObstacle().getY()));
            if (n == ol || distance < minDistance){
                minDistance = distance;
                obstacleTBR = n.getObstacle();
            }
        }
        simulation.removeObstacle(obstacleTBR);
    }
}

void keyPressed() {
    if (key == '+' || keyCode == 61) {
        simulation.addParticles(50);
    }
    else if (key == '-') {
        simulation.removeParticles(50);
    }
}