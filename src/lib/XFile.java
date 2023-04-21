/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MY-PC
 */
public class XFile {

    //có thể dùng cho dự án 
    //read -inputStream
    //Dng BYTE
    //hàm này đang sài write - outputStream
    public static void WriteFile(String path) {
        File f = new File(path);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(f);
            byte[] arr = {10, 20, 30};//đưa số vào kiểm thử[kiểu mảng byte]
            //saì nó
            fos.write(arr);
            //đóng nó lại
            fos.close();

            //do hàng 29 tạo ra
        } catch (FileNotFoundException e) {

            System.err.println("File not Found");

            //do hàng 32 tạo ra
        } catch (IOException ex) {

            System.err.println("Failed");
        }
    }

    //read - inputStream
    public static void readFile(String path) {
        File f = new File(path);
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(f);
            int fileSize = (int) f.length();

            //do viết dô là kiểu mảng byte nên đọc cũng phải là mảng
            byte[] arr = new byte[fileSize];
            fis.read(arr);
            for (int i = 0; i < fileSize; i++) {
                System.out.println(arr[i] + " ");
            }
            fis.close();
//          byte[] arr = {10, 20, 30};
//          //sài nó
//          fis.write(arr);
            //đóng nó lại
            fis.close();

            //do hàng 29 tạo ra
        } catch (FileNotFoundException e) {

            System.err.println("File not Found");

            //do hàng 32 tạo ra
        } catch (IOException ex) {

            System.err.println("Failed");
        }
    }

    //dạng khác là viết vào sao thì đọc phải theo thứ tự y như vậy
    public static void writeDataFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            //bao lấy nó và buff cho nó
            DataOutputStream dos = new DataOutputStream(fos);
            //write  nó
            dos.writeInt(5);
            dos.writeUTF("Phi Pham");
            dos.writeDouble(8.0);
            //đóng nó lại
            dos.close();
        } catch (IOException e) {
            System.out.println("Failed");
        }
    }

    public static void readDataFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            //bao lấy nó và buff cho nó
            DataInputStream dis = new DataInputStream(fis);
            //read  nó
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
            System.out.println(dis.readDouble());
            //đóng nó lại
            dis.close();
        } catch (IOException e) {
            System.out.println();
        }
    }

    //dung CHAR
    public static void writeBuffer(String path, String text) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Failed");
        }
    }

    //dùng CHAR cho read
    public static String readBuffer(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String fistline = br.readLine();
            while (fistline != null) {//nếu khác null thì cho xuống hàng
                sb.append(fistline);
                fistline = br.readLine();//nextline tự động đọc xuống
                if (fistline != null) {
                    sb.append("\n");//nếu firstline khác null thì tự dộng xuống hàng
                }
            }
        } catch (IOException e) {
            System.err.println("Failed");
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
    
    //cặp hàm gặp khá nhiều là write Object va read Object
    public static void writeObject(String path, Object o){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(o);
            oos.close();
        }catch(IOException e){
            System.err.println("Failed");
            e.printStackTrace();//hiện ra lỗi
            
        }
    }
      public static Object readObject(String path){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object o = ois.readObject();
            ois.close();
            return o;
        }catch(IOException e){
            System.err.println("Failed");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not Found");
        }
        return null;
        
    }

    public static void main(String[] args) {
//        String filePath = "./src/lib/testFile.dat";//dấu chấm tượng chưng cho project
        //tạo file mới 
//        WriteFile(filePath);//xuất ra file không đọc được
//        readFile(filePath);//đọc file trong java 
//--------------------------------------
//        writeDataFile(filePath);
//        readDataFile(filePath);
//-----------------------------------------
//        String filePath = "./src/lib/testFile3.dat";
//        writeBuffer(filePath, "NGUYỄN PHI PHÀM \n ahihi");
//        readBuffer(filePath);
//
//------------------------------------
        //mỗi file chỉ chứa được một danh sách
//        List<Cat> catlist = new ArrayList<>();
//        catlist.add(new Cat("BO", 3.4, Boolean.FALSE, 1000.0));
//        catlist.add(new Cat("alice", 1.1, Boolean.FALSE, 1000.0));
//        String filePath = "./src/lib/cat.dat";
//        writeObject(filePath, catlist);
//        
//        //in ra cân nặng bằng for
//        List<Cat> readList = (List<Cat>) readObject(filePath);
//        for (Cat cat : readList) {
//            System.out.println(cat.getWeight());//in cân nặng
//            
//        }
        
    }
}
