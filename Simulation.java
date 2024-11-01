import java.util.Random;


public class Simulation {
    Random rd = new Random();
    private int numParticles = 0;
    Particle[] particles = new Particle[50];
    private int direction = 1;

    public Particle[] getParticles(){
        return particles;
    }
    public int getNumParticles() {
        return numParticles;
    }
    public void addParticles(int amount) {
        if (numParticles + amount > particles.length) {
            Particle[] tempParticles = new Particle[particles.length * 2];
            for(int i = 0; i < particles.length; i++) {
                tempParticles[i] = particles[i];
            }
            particles = tempParticles;
        }
        for(int i = numParticles; i < numParticles + amount; i++) {
            particles[i] = new Particle(rd.nextFloat(), 1.0, 0.1);
            if(rd.nextFloat() > 0.5) {
                direction = 1;
            }
            else {
                direction = -1;
            }
            particles[i].setVelocity(rd.nextFloat()*direction,0.0);
        }
        numParticles += amount;
    }
    public void removeParticles(int amount) {
        if (numParticles - amount >= 0) {
            for(int i = numParticles - amount; i < numParticles; i++) {
                particles[i] = null;
            }
            numParticles -= amount;
        }
    }


    ObstacleNode obstacleList = null;

    public ObstacleNode getObstacles(){
        return obstacleList;
    }
    public void addObstacle(Obstacle obstacle) {
        ObstacleNode newNode = new ObstacleNode(obstacle);

        if (obstacleList == null) {
            obstacleList = newNode;
        } else {
            ObstacleNode current = obstacleList;
            while (current.getNext() != null) {
                current.setNext(current);
            }
            current.setNext(newNode);
        }
    }
    public void removeObstacle(Obstacle obstacle) {
        ObstacleNode currNode = obstacleList, prev = null;

        if (currNode != null && currNode.getObstacle() == obstacle) {
            obstacleList = currNode.getNext();
        }
        while (currNode != null && currNode.getObstacle() != obstacle) {
            prev = currNode;
            currNode = currNode.getNext();
        }
        if (currNode != null && prev != null) {
            prev.setNext(currNode.getNext());
        }
    }
}
