/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explicitchannelwrite;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author salma
 */
public class ExplicitChannelWrite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obtain a channel to a file within a try-with-resources block.
        try (FileChannel filechannel = (FileChannel) Files.newByteChannel(Paths.get("F:\\ITI\\matrial\\javaIO\\labsFiles\\data\\myFile.txt"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {
// Create a buffer.
            ByteBuffer buffer = ByteBuffer.allocate(26);
            for (int i = 0; i < 26; i++) {
                buffer.put((byte) ('A' + i));
            }
// Reset the buffer so that it can be written.
            buffer.rewind();
// Write the buffer to the output file.
            filechannel.write(buffer);
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            System.exit(1);
        }
    }

}
