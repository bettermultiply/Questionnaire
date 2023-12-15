package questionnaire.utils;

/**
 * Created by zong chang on 2023/12/15 11:29
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtils {


    private static final int BLACK = 0xFF000000;

    private static final int WHITE = 0xFFFFFFFF;

    private static final int WIDTH = 500;

    private static final int HEIGHT = 500;

    private static final int PIC_HEIGHT = HEIGHT + 80;

    /**
     *Generate QR code
     *
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        BufferedImage image = new BufferedImage(width, PIC_HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < PIC_HEIGHT; y++) {
                image.setRGB(x, y, WHITE);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y+80, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    /**
     *
     * @param content Set the QR code content
     * @param format   Image Format:jpg
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static BufferedImage generateQrCode(String content, String format) throws Exception {

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        @SuppressWarnings("rawtypes")
        Map hints = new HashMap();
        // UTF-8
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // Set the size of the white area around the QR code
        hints.put(EncodeHintType.MARGIN, 5);
        // Set fault tolerance for QR codes
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // draw QRCode
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        BufferedImage image = toBufferedImage(bitMatrix);
        return image;
    }


    /**
     * Return the generated image to the user page
     *
     * @param qrCodeContent
     * @param pressText
     * @throws Exception
     */
    public static BufferedImage generateQrCodeBack( String qrCodeContent, String pressText) throws Exception {
        BufferedImage image = generateQrCode(qrCodeContent, "jpg");
        Graphics g = image.getGraphics();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("宋体", Font.PLAIN, 40);
        g.setFont(font);
        g.setColor(Color.black);
        FontMetrics metrics = g.getFontMetrics(font);
        // The text is above the QR code
        int startX = (WIDTH - metrics.stringWidth(pressText)) / 2;
        int startY = PIC_HEIGHT - HEIGHT;
        g.drawString(pressText, startX, startY);
        g.dispose();
        image.flush();
        return image;
    }

}



