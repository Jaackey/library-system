/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.runnable;

import business.library.Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jackey
 */
public class BookLentRunnable implements Runnable{

    private Library library;
    private String keyname;
    private int newAmount;
    private String newstr;
    
    public BookLentRunnable(Library library,String keyname,int newAmount){
        this.library = library;
        this.keyname = keyname;
        this.newAmount = newAmount;
    }
    
    public void writeFile(){
        newstr = String.valueOf(newAmount);
        String temp = "";
	String newTemp = "";
        try {
            File file = new File("data/library/" + library.getName() + "/bookList.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            //Scanner inLine = new Scanner(br);
            boolean flag = true;
            
            // 保存该行前面的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                Scanner sc = new Scanner(temp);
                sc.useDelimiter(",");
                String name = sc.next();
//                String author = sc.next();
//                String press = sc.next();
//                String date = sc.next();
//                String location = sc.next();
//                double inprice = sc.nextDouble();
//                int amount = sc.nextInt();
                sc.close();
                //System.out.println(temp);
                //System.out.println("=====" + name);
                if(name.equals(keyname)){
                	flag = false;
                	//System.out.println("*#*#*" + flag);
                	newTemp = temp;
                }
                if(flag){
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
                }
                if(!flag){
                	break;
                }
            }
            
            Pattern pattern = Pattern.compile("\\d\\d?\\d?$");
            Matcher matcher = pattern.matcher(newTemp);
            newTemp = matcher.replaceFirst(newstr);
            
            //System.out.println("***" + newTemp);
            // 将内容插入
            buf = buf.append(newTemp);

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
            	//System.out.println("###");
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        writeFile();
    }
    
}
