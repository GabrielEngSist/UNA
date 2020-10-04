package aplicacao;
import javax.swing.JOptionPane;
import entidade.One;

public class Programa {

    public static void main(String[] args){

        One sing1;
        One sing2;

        sing1 = One.obterUmaUnicaInstancia();
        sing2 = One.obterUmaUnicaInstancia();

        if(sing1.equals(sing2)) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO"
                    + " equals >> singleton1 e singleton2"
                    + " se referem a mesma instância de Singleton"
            );
        }
    }
}
