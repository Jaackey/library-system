/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.runnable;

import business.book.Book;
import business.library.Library;
import business.qrcode.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.util.Hashtable;

/**
 *
 * @author Jackey
 */
public class GenerateQRCodeeRunnable implements Runnable{

    private Library library;
    private Book book;
    
    public GenerateQRCodeeRunnable(Library library, Book book){
        this.library = library;
        this.book = book;
    }
    
    @Override
    public void run() {
        try{
        String text = "Book Name: " + book.getName() + "\n"
                + "Author: " + book.getAuthor() + "\n"
                + "Press: " + book.getPress();
        int width = 300; 
        int height = 300; 
        //二维码的图片格式 
        String format = "gif"; 
        Hashtable hints = new Hashtable(); 
        //内容所使用编码 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, 
                BarcodeFormat.QR_CODE, width, height, hints); 
        //生成二维码 
        book.setQrCodePath("data/library/" + library.getName() + "/" + book.getName() + ".gif");
        File outputFile = new File("data/library/" + library.getName() + "/" + book.getName() + ".gif"); 
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
