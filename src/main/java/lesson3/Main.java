package lesson3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        ArrayList<InputStream> al = new ArrayList<>();



        try (RandomAccessFile raf = new RandomAccessFile("third/Third1.txt", "r")){
            int m = 1800;

            int n = m * 1;
            for (int i = 0; i < n; i++){
                raf.seek(i);
                System.out.println((char) raf.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        try {
            al.add(new FileInputStream("second/Second1.txt"));
            al.add(new FileInputStream("second/Second2.txt"));
            al.add(new FileInputStream("second/Second3.txt"));
            al.add(new FileInputStream("second/Second4.txt"));
            al.add(new FileInputStream("second/Second5.txt"));
            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));

            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("first/first.txt"), "UTF-8")) {

          int x;

          while ((x = isr.read()) != -1) {
              System.out.println((byte) x);
          }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
