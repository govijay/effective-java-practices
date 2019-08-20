package effectivejava.item9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderTryWithResourcesEx {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // Java 8 : nio Files 's new method newBufferedReader with Paths --> returning BufferedReader.

        // try-with-resources with catch clause.

        try(BufferedReader br = Files.newBufferedReader(Paths.get("filename.txt"))){
            String line;
            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
        }catch (IOException e){
            System.err.format("IOException : %s%n",e);
        }

        System.out.println(sb);


    }
}
