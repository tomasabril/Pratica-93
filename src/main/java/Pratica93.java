
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * Template de projeto de programa Java usando Maven. por Tomás Abril
 */
public class Pratica93 {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String cmd;
        System.out.println("digite o comando: ");
        List<ExecCmd> execCmd = new ArrayList<>();
        int i = 0;
        while (true) {

            cmd = leitura.next();
            if (cmd.equals("fim")) {
                for (ExecCmd c : execCmd) {
                    if (!c.terminado()) {
                        i++;
                    }
                }
                if (i > 0) {
                    System.out.println(" " + i + " processos abertos");
                    System.out.println("quer cancelar os processos? s ou n");
                    if (leitura.next().equals("s")) {
                        for (ExecCmd c : execCmd) {
                            if (!c.terminado()) {
                                c.cancela();
                            }
                        }
                        break;
                    }
                }
            } else {
                ExecCmd e = new ExecCmd(cmd);
                execCmd.add(e);
                e.start();
            }
            i = 0;
        }
    }
}
