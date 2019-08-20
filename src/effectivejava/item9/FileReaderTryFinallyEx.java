package effectivejava.item9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTryFinallyEx {

    // old way. before java 7. close all resources manually.

    // try - finally is ugly when used with more than one resources.

    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader("filename.txt");
            br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch (IOException e){
            System.err.format("IOException : %s%n",e);

        }finally {
            try {
                if(br != null){
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            }catch (IOException e){
                System.err.format("IOException : %s%n",e);
            }
        }


    }
}
