package csu.web.petstore.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;



    public class ImageServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            int width = 100, height = 40;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            Random random = new Random();

            g.setColor(getRandColor(200, 250));
            g.fillRect(0, 0, width, height);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            g.setColor(getRandColor(160, 200));

            for (int i = 0; i < 155; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                g.drawLine(x, y, x + xl, y + yl);
            }

            String sRand = "";
            String string = "1234567890abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < 4; i++) {
                char rand = string.charAt(random.nextInt(string.length()));
                sRand += rand;
                g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
                g.drawString(Character.toString(rand), 13 * i + 25, 30);
            }

            request.getSession().setAttribute("rand", sRand);
            g.dispose();
            ImageIO.write(image, "JPEG", response.getOutputStream());
        }

        private Color getRandColor(int fc, int bc) {
            Random random = new Random();
            if (fc > 255) fc = 255;
            if (bc > 255) bc = 255;
            int r = fc + random.nextInt(bc - fc);
            int g = fc + random.nextInt(bc - fc);
            int b = fc + random.nextInt(bc - fc);
            return new Color(r, g, b);
        }
    }