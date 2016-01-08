/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.qrcode;

import java.awt.image.BufferedImage;
import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 *
 * @author Jackey
 */
public class MyQRCodeImage implements QRCodeImage{

    BufferedImage image;
    
    public MyQRCodeImage(BufferedImage image) { 
        this.image = image;
    }
    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }
    
}
