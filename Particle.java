public class Particle{
    private double x;
    private double y;
    private double radius;
    private double velocityX;
    private double velocityY;
    private double gravity;
    public Particle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.radius = r;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.gravity = -1.0;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }
    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public double getGravity() { return gravity; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setRadius(double r) { 
        if (r > 0) { 
                this.radius = r; 
            } else {
                System.out.println("Radius must be positive");
                }
            }
    public void setVelocityX(double vx) { this.velocityX = vx; }
    public void setVelocityY(double vy) { this.velocityY = vy; }
    public void setGravity(double g) { this.gravity = g; }

    public void setVelocity(double vx, double vy) {
        velocityX = vx;
        velocityY = vy;
    }

    public void update(double dt){
        // velocity update
        velocityY = velocityY + gravity * dt;

        // position update
        x = x + velocityX * dt;
        y = y + velocityY * dt;

        // floor collision
        if (y <= radius) {
            // correction
            y = radius;

            // bounce
            velocityY *= -1.0 * 0.6;
        }
    }
    public void handleCollision(Obstacle obstacle) {
        if (obstacle.checkCollision(this)) {
            double[] normal = obstacle.collide(this);

            // bounce (reflect)
            if (Vector2DMath.magnitude(velocityX, velocityY) < 0.2) {
                velocityX = normal[0] * 0.5;
                velocityY = normal[1] * 0.5;
            } else {
                double[] reflect = Vector2DMath.reflect(normal, velocityX, velocityY);
                velocityX = reflect[0] * 0.5;
                velocityY = reflect[1] * 0.5;
            }
        }
    }
}