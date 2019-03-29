/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explicitchannelread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author salma
 */
public class ExplicitChannelRead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count;
        Path filepath = null;
// First, obtain a path to the file.
        try {
            filepath = Paths.get("F:\\ITI\\matrial\\javaIO\\labsFiles\\data\\myFile.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
            return;
        }
        // Next, obtain a channel to that file within a try-with-resources block.
        try (SeekableByteChannel fileChannel = Files.newByteChannel(filepath)) {
// Allocate a buffer.
            ByteBuffer buffer = ByteBuffer.allocate(128);
            do { // Read a buffer.
                count = fileChannel.read(buffer);
// Stop when end of file is reached.
                if (count != -1) {
// Rewind the buffer so that it can be read.
                    buffer.rewind();
// Read bytes from the buffer and show them on the screen as characters.
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) buffer.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }

}
