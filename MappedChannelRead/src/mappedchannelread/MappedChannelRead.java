/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappedchannelread;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 *
 * @author salma
 */
public class MappedChannelRead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("F:\\ITI\\matrial\\javaIO\\labsFiles\\data\\myFile.txt"))) { // Get the size of the file.
            long fileSize = fileChannel.size();
// Now, map the file into a buffer.
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
// Read and display bytes from buffer.
            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) buffer.get());
            }
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }

}
