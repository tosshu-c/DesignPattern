package flyweight;

import javax.swing.*;
import java.awt.*;

public class DrawingClient extends JFrame {

    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeFactory.ShapeType[] SHAPES = {ShapeFactory.ShapeType.LINE, ShapeFactory.ShapeType.OVAL_FILL, ShapeFactory.ShapeType.OVAL_NO_FILL};
    private static final Color[] COLORS = {Color.RED, Color.GREEN, Color.YELLOW};

    public DrawingClient(int width, int height) {

        this.WIDTH = width;
        this.HEIGHT = height;

        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(event -> {
            Graphics g = panel.getGraphics();
            for (int i = 0; i < 20; ++i) {
                Shape shape = ShapeFactory.getShape(getRandomShape());
                shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
                        getRandomHeight(), getRandomColor());
            }
        });
    }

    private ShapeFactory.ShapeType getRandomShape() {
        return SHAPES[(int) (Math.random() * SHAPES.length)];
    }

    private int getRandomX() {
        return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
        return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
        return (int) (Math.random() * (WIDTH / 10));
    }

    private int getRandomHeight() {
        return (int) (Math.random() * (HEIGHT / 10));
    }

    private Color getRandomColor() {
        return COLORS[(int) (Math.random() * COLORS.length)];
    }
}