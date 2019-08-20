package effectivejava.item9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTryWithResources1Ex {

    public static void main(String[] args) {
        // try-with-resources Java 7.

        try(BufferedReader br = new BufferedReader(new FileReader("filename.txt"))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.format("IO Exception : %s%n",e);
        }
    }
}
