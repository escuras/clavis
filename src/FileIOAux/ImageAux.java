package FileIOAux;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author toze
 */
public class ImageAux {

    public static String extensao;
    
    public static BufferedImage getImageFromFile(java.awt.Component comp) {
        JFileChooser fimagem = new JFileChooser();
        fimagem.getLocation();
        int retVal = fimagem.showOpenDialog(comp);
        BufferedImage bimagem = null;
        if (retVal == JFileChooser.APPROVE_OPTION) {
            extensao = verifyExtension(fimagem.getSelectedFile());
            System.out.println(extensao);
            try {
                if (validateExtension(extensao)) {
                    bimagem = ImageIO.read(fimagem.getSelectedFile());
                }
            } catch (IOException ex) {
            }
        }
        return bimagem;
    }

    public static String verifyExtension(java.io.File file) {
        ImageInputStream iis;
        try {
            iis = ImageIO.createImageInputStream(file);
            java.util.Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            ImageReader reader = iter.next();
            extensao = reader.getFormatName();
        } catch (IOException ex) {
            extensao = "NaNFile";
        } catch (java.util.NoSuchElementException ex) {
            extensao = "NaNImagem";
        }
        return extensao;
    }
  

    private static boolean validateExtension(String file) {

        if (file.equals("png")) {
            return true;
        } else if (file.equals("jpg")) {
            return true;
        } else if (file.equals("jpeg")) {
            return true;
        } else if (file.equals("JPEG")) {
            return true;
        } else if (file.equals("JPG")) {
            return true;
        } else if (file.equals("PNG")) {
            return true;
        } else if (file.equals("Jpg")) {
            return true;
        } else if (file.equals("Png")) {
            return true;
        } else if (file.equals("GIF")) {
            return true;
        } else if (file.equals("gif")) {
            return true;
        } else if (file.equals("BMP")) {
            return true;
        } else if (file.equals("bmp")) {
            return true;
        } else if (file.equals("WBMP")) {
            return true;
        } else {
            return file.equals("wbmp");
        }
    }

    public static BufferedImage resize(BufferedImage imagem, int largura, int altura) {
        BufferedImage img = null;
        if (imagem != null) {
            int l = imagem.getWidth();
            int a = imagem.getHeight();

            if (imagem.getType() > 0) {
                img = new BufferedImage(largura, altura, imagem.getType());
            } else {
                img = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            }
            Graphics2D g = img.createGraphics();
            g.drawImage(imagem, 0, 0, largura, altura, 0, 0, l, a, null);
            g.dispose();
        }
        return img;
    }
    
    public static BufferedImage makeWhiter(BufferedImage imagem, int valor) {
        BufferedImage img = null;
        if (imagem != null) {
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();

            if (imagem.getType() > 0) {
                img = new BufferedImage(largura, altura, imagem.getType());
            } else {
                img = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            }
            for (int x=0; x < largura; x++){
                for (int y=0; y < altura; y++){
                    Color cor  = new Color(imagem.getRGB(x,y));
                    int red = cor.getRed() + valor;
                    if (red > 255) red = 255;
                    int green = cor.getGreen() + valor;
                    if (green > 255) green = 255;
                    int blue = cor.getBlue() + valor;
                    if (blue > 255) blue = 255;
		    Color au = new Color(red,green,blue);
                    img.setRGB(x, y, au.getRGB());
		}
            }
        }
        return img;
    }
    
    public static BufferedImage makeDarker(BufferedImage imagem, int valor) {
        BufferedImage img = null;
        if (imagem != null) {
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();

            if (imagem.getType() > 0) {
                img = new BufferedImage(largura, altura, imagem.getType());
            } else {
                img = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            }
            for (int x=0; x < largura; x++){
                for (int y=0; y < altura; y++){
                    Color cor  = new Color(imagem.getRGB(x,y));
                    int red = cor.getRed() - valor;
                    if (red < 0) red = 0;
                    int green = cor.getGreen() - valor;
                    if (green < 0) green = 0;
                    int blue = cor.getBlue() - valor;
                    if (blue < 0) blue = 0;
		    Color au = new Color(red,green,blue);
                    img.setRGB(x, y, au.getRGB());
		}
            }
        }
        return img;
    }
    
    
    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int largura = image.getWidth();
        int altura = image.getHeight();
        BufferedImage output = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, largura, altura, cornerRadius, cornerRadius));
        g2.setComposite(java.awt.AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    return output;
}
    
    

}
