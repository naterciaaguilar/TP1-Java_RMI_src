package MonitorAcoesView;

import javax.swing.JFrame;

/**
 * Classe para criacao do frame principal da aplicacao
 * 
 * @author User
 */
public class FrameAplicacao extends JFrame {
    public FrameAplicacao (String titulo, int largura, int altura) {
        super();
        this.setSize(largura, altura);
        this.setTitle(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}