public class Arrow {
    private double y = 1.0;
    private double x;
    private String filename;
    private Direction d;
    
    public static void main(String[] args) {
        Arrow a = new Arrow(Direction.LEFT);
        a.draw(a.y);
        Arrow b = new Arrow(Direction.DOWN);
        b.draw(b.y);
        Arrow c = new Arrow(Direction.UP);
        c.draw(c.y);
        Arrow d = new Arrow(Direction.RIGHT);
        d.draw(d.y);
    }
    
    public void decrementY() {
        y-=DDR.ONE_PIXEL;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public Direction getDirection() {
        return d;
    }
    
    public double getY() {
        return y;
    }
    
    public double getX() {
        return x;
    }
    
    public void draw(double y) {
        PennDraw.picture(x, y, filename, 125, 125);
    }
    
    public Arrow(Direction d) {
        if (d == Direction.LEFT) {
            this.d = d;
            this.x = 0.125;
            this.filename = "left_arrow.png";
        }
        if (d == Direction.DOWN) {
            this.d = d;
            this.x = 0.375;
            this.filename = "down_arrow.png";
        }
        if (d == Direction.UP) {
            this.d = d;
            this.x = 0.625;
            this.filename = "up_arrow.png";
        }
        if (d == Direction.RIGHT) {
            this.d = d;
            this.x = 0.875;
            this.filename = "right_arrow.png";
        }
    } 
}

enum Direction {UP, DOWN, LEFT, RIGHT}