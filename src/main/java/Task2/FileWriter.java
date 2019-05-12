package Task2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {
    public void writeBooksFile() throws IOException {
        {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\books.csv");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            writer.println("Ala ma kota, a kot ma Alę");
            writer.close();
        }
    }
}
