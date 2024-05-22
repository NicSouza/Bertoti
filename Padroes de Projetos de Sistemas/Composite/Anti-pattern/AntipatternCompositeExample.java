import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();
}

class Line implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a line");
    }
}

class Picture implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}


public class AntipatternCompositeExample {
    public static void main(String[] args) {
        Graphic line1 = new Line();
        Graphic line2 = new Line();
        
        Picture picture = new Picture();
        picture.add(line1);
        picture.add(line2);
        
        picture.draw();
    }
}
