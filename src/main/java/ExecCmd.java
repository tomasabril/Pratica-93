
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allan and Tomás
 */
public class ExecCmd extends Thread {

    String cmd;
    Process proc;
    Boolean fechou = false;

    public ExecCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Executando " + cmd);
        try {
            proc = rt.exec(cmd);
            proc.waitFor();

        } catch (IOException | InterruptedException ex) {
            System.out.println("oi");
            Logger.getLogger(ExecCmd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cancela() {
        proc.destroy();
    }

    public Boolean terminado() {
        return !proc.isAlive();
    }
//    public Boolean noticica(){
//        
//        notifyAll();
//        
//        
//}
}
