import java.awt.*;
import java.util.ArrayList;

public class Fruit {
    private int x;
    private int y;

    public Fruit() {
        this.x = (int)(Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
        this.y = (int)(Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void drawFruit(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(this.x, this.y, Main.CELL_SIZE, Main.CELL_SIZE);
    }

    public void setNewLocation(Snake s) {
        int new_x;
        int new_y;
        boolean overlapping;
        do {
            new_x = (int)(Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
            new_y = (int)(Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
            overlapping = check_overlap(new_x, new_y, s);
        } while(overlapping);

        this.x = new_y;
        this.y = new_y;
    }

    private boolean check_overlap(int x, int y, Snake s) {
        ArrayList<Node> snake_body = s.getSnakeBody();
        for (int j = 0; j < s.getSnakeBody().size(); j++){
            if (x == snake_body.get(j).x && y == snake_body.get(j).y) {
                return true;
            }
        }
        return false;
    }
}
