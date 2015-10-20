import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Gabriel on 20/10/2015.
 */
public class HistogramReader {

    public Histogram<String> readFromFile(String path){
        try {
            Histogram<String> histogram = new Histogram<>();
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                int atPos = currentLine.indexOf("@");
                histogram.increment(currentLine.substring(atPos+1));
            }
            reader.close();
            return histogram;
        } catch (IOException e) {
            System.err.println("Error reading file");
            return null;
        }
    }
}
