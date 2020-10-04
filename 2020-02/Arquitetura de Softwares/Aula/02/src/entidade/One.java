package entidade;
import javax.swing.*;

public class One {
    private static One _objetoUnico;

    private One(){
        JOptionPane.showMessageDialog(null, "Mensagem do construtor\n\nSingleton foi criado!");
    }

    public static One obterUmaUnicaInstancia() {
        if (_objetoUnico == null){
            _objetoUnico = new One();
        }

        return _objetoUnico;
    }

    public void abrirConexao(){}
}
