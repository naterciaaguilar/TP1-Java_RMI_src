package MonitorAcoesView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MonitorAcoesController.ClienteInvestidorController;

public class ClienteInvestidorMonitoramento extends JInternalFrame {
	private JLabel lblNomeAcaoCabecalho;
	private JLabel lblNomeAcao;
	private JLabel lblHistoricoPrecos;
	private JTextArea historicoPrecos;
	private JButton voltar;
	private JButton monitorar;
	
	public ClienteInvestidorMonitoramento(int largura, int altura, ClienteInvestidorController controlClienteInvestidor) {
		super();
		this.setSize(largura, altura);
		this.setFrameIcon(null);
		this.setBorder(null);
		
		// container da tela
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // panel cabeçalho nome ação
        JPanel panelCabecalho = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        this.lblNomeAcaoCabecalho = new JLabel("Nome da Ação: ");
        this.lblNomeAcao = new JLabel();
        
        panelCabecalho.add(this.lblNomeAcaoCabecalho);
        panelCabecalho.add(this.lblNomeAcao);
                
        contentPane.add(panelCabecalho, "North");
        
        // panel com histórico de preços
        JPanel panelHistoricoPrecos = new JPanel(new BorderLayout());
        
        JPanel panelLblHistPreco = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        this.lblHistoricoPrecos = new JLabel("Histórico de Preços: ");
        
        panelLblHistPreco.add(this.lblHistoricoPrecos);
        
        JPanel panelQuadroHistPreco = new JPanel();
        panelQuadroHistPreco.setLayout(new BoxLayout(panelQuadroHistPreco, BoxLayout.Y_AXIS));
        
        this.historicoPrecos = new JTextArea();
        this.historicoPrecos.setEnabled(false);
        
        panelQuadroHistPreco.add(this.historicoPrecos);
        panelQuadroHistPreco.add(Box.createRigidArea(new Dimension(0,5)));
        panelQuadroHistPreco.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        panelHistoricoPrecos.add(panelLblHistPreco, "North");
        panelHistoricoPrecos.add(panelQuadroHistPreco, "Center");
        
        contentPane.add(panelHistoricoPrecos, "Center");
        
        // rodapé com botões de pesquisa e nova ação
        JPanel panelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        this.voltar = new JButton("Voltar");
        this.monitorar = new JButton("Monitorar");
        
        panelRodape.add(this.voltar);
        panelRodape.add(this.monitorar);
        
        contentPane.add(panelRodape, "South");
        
        // eventos
        this.voltar.addActionListener(controlClienteInvestidor);
        this.monitorar.addActionListener(controlClienteInvestidor);
	}
	
	public JButton getVoltar() {
		return this.voltar;
	}
	
	public JButton getMonitorar() {
		return this.monitorar;
	}
	
	public void setLblNomeAcao(String nome) {
		this.lblNomeAcao.setText(nome);
	}
	
	public void setHistoricoPrecos(String historico) {
		this.historicoPrecos.setText(historico);
	}
}
