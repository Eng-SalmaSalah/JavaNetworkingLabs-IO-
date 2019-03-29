/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathexample;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author salma
 */
public class PathExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String originalPath = "d:\\data\\projects\\a-project\\..\\another-project";
        Path path = Paths.get("c:\\data\\myfile.txt");
        Path path1 = Paths.get(originalPath);
        System.out.println("path = " + path);
        System.out.println("path1 = " + path1);
        Path path2 = path1.normalize();
        System.out.println("path2 = " + path2);
        Path path3 = Paths.get("C:\\Users\\salma\\Desktop\\test");

        try {
            Path newDir = Files.createDirectory(path3);
        } catch (FileAlreadyExistsException e) {
// the directory already exists.
        } catch (IOException e) {
// something else went wrong
            e.printStackTrace();
        }
// Copying a file from one path to another
        
        Path sourcePath = Paths.get("F:\\ITI\\matrial\\javaIO\\labsFiles\\data\\logging.properties");
        Path destinationPath = Paths.get("F:\\ITI\\matrial\\javaIO\\labsFiles\\data\\logging-copy.properties");
        try {
            Files.copy(sourcePath, destinationPath);
        } catch (FileAlreadyExistsException e) {
// destination file already exists
        } catch (IOException e) {
// something else went wrong
            e.printStackTrace();
        }
    }

}
