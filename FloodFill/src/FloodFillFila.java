import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FloodFillFila {

    public static void floodFillQueue(BufferedImage image, int x, int y, Color newColor) {
        Color targetColor = new Color(image.getRGB(x, y));

        if (targetColor.equals(newColor)) return;

        Fila queue = new Fila(image.getWidth() * image.getHeight());
        queue.enqueue(new Pixel(x, y));

        while (!queue.isEmpty()) {
            Pixel p = queue.dequeue();
            int px = p.x;
            int py = p.y;

            if (px < 0 || py < 0 || px >= image.getWidth() || py >= image.getHeight()) {
                continue;
            }

            if (!new Color(image.getRGB(px, py)).equals(targetColor)) {
                continue;
            }

            image.setRGB(px, py, newColor.getRGB());

            queue.enqueue(new Pixel(px + 1, py));
            queue.enqueue(new Pixel(px - 1, py));
            queue.enqueue(new Pixel(px, py + 1));
            queue.enqueue(new Pixel(px, py - 1));
        }
    }
    public static void saveImage(BufferedImage image, String outputPath) throws IOException {
        File output = new File(outputPath);
        ImageIO.write(image, "png", output);
    }
}

