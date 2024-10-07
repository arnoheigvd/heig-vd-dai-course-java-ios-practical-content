package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;

import java.io.*;

/**
 * A class that reads binary files. This implementation reads the file using a buffered input
 * stream. It manages the input stream and the buffered input stream properly with a
 * try-with-resources block.
 */
public class BufferedBinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    /* Opening binary file */
    InputStream fis = null;
    BufferedInputStream bis = null;
    try {
      fis = new FileInputStream(filename);
      bis = new BufferedInputStream(fis);
    } catch (FileNotFoundException e) { throw new RuntimeException(e); }
    /* Reading file */
    int b;
    try {
      while ((b = bis.read()) != -1) ;
    } catch (IOException e) { throw new RuntimeException(e); }
    /* Closing binary file */
    if (bis != null) {
      try {
        bis.close();
      } catch (IOException e) { e.printStackTrace(); }
    }
  }
}
