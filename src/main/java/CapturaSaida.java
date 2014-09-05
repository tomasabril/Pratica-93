
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Allan and Tomas
 */
public class CapturaSaida extends Thread {

    private final InputStream is;
    private OutputStream os;

    public CapturaSaida(InputStream is, OutputStream os) {
        this.is = is;
        this.os = os;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osw);
            
            String linha;
            while ((linha = br.readLine()) != null) {
                bw.write(linha);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
