import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o método de Flood Fill:");
        System.out.println("1 - Usar pilha (FloodFillStack)");
        System.out.println("2 - Usar fila (FloodFillQueue)");
        int escolha = scanner.nextInt();

        String inputPath = "src\\imagem\\maça3.png";
        String outputPath = "out\\production\\FloodFill\\imagem_preenchida.png";

        try {
            BufferedImage image = ImageIO.read(new File(inputPath));
            int startX = 500;
            int startY = 500;
            Color newColor = Color.RED;

            switch (escolha) {
                case 1:
                    System.out.println("Usando Flood Fill com pilha...");
                    FloodFillPilha.floodFillStack(image, startX, startY, newColor);
                    FloodFillPilha.saveImage(image, outputPath);
                    System.out.println("Imagem colorida salva em: " + outputPath);
                    break;

                case 2:
                    System.out.println("Usando Flood Fill com fila...");
                    FloodFillFila.floodFillQueue(image, startX, startY, newColor);
                    FloodFillFila.saveImage(image, outputPath);
                    System.out.println("Imagem colorida salva em: " + outputPath);
                    break;

                default:
                    System.out.println("Escolha inválida. Selecione 1 ou 2.");
                    break;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler ou salvar a imagem: " + e.getMessage());
        }
    }
}
