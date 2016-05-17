package MonitorAcoesView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MonitorAcoesController.ClienteInvestidorController;

public class ClienteInvestidorPesquisa extends JInternalFrame {
	private JLabel lblAcoesDisponiveis;
	private JLabel lblAcoesMonitoradas;
	private JComboBox comboAcoesDisponiveis;
	private JButton pesquisar;
	private JTextArea acoesMonitoradas;
	
	public ClienteInvestidorPesquisa(int largura, int altura, ClienteInvestidorController controlClienteInvestidor) {
		super();
		this.setSize(largura, altura);
		this.setFrameIcon(null);
		this.setBorder(null);
		
		// container da tela
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // cabecalho da tela com pesquisa
        JPanel panelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        this.lblAcoesDisponiveis = new JLabel("Ações Disponíveis: ");
        this.comboAcoesDisponiveis = new JComboBox();
        this.pesquisar = new JButton("Pesquisar");
        
        panelPesquisa.add(this.lblAcoesDisponiveis);
        panelPesquisa.add(this.comboAcoesDisponiveis);
        panelPesquisa.add(this.pesquisar);
        
        contentPane.add(panelPesquisa, "North");
        
        // painel central da tela contendo ações monitoradas
        JPanel panelListaMonitor = new JPanel(new BorderLayout());
        
        JPanel panelLblMonitor = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
              
        this.lblAcoesMonitoradas = new JLabel("Ações Monitoradas: ");
        
        panelLblMonitor.add(this.lblAcoesMonitoradas);
                
        JPanel panelQuadroMonitor = new JPanel();
        panelQuadroMonitor.setLayout(new BoxLayout(panelQuadroMonitor, BoxLayout.Y_AXIS));
        
        this.acoesMonitoradas = new JTextArea();
        this.acoesMonitoradas.setEnabled(false);
        
        panelQuadroMonitor.add(this.acoesMonitoradas);
        panelQuadroMonitor.add(Box.createRigidArea(new Dimension(0,5)));
        panelQuadroMonitor.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        panelListaMonitor.add(panelLblMonitor, "North");
        panelListaMonitor.add(panelQuadroMonitor, "Center");
        
        contentPane.add(panelListaMonitor, "Center");
        
        // tratamento de eventos
        this.pesquisar.addActionListener(controlClienteInvestidor);
	}	
	
	public JButton getPesquisar() {
		return this.pesquisar;
	}
	
	public String getAcaoSelecionada() {
		return (String)this.comboAcoesDisponiveis.getSelectedItem();
	}
	
	public void setComboAcoesDisponiveis(ArrayList<String> acoesServidor) {
		this.comboAcoesDisponiveis.setModel(new DefaultComboBoxModel(acoesServidor.toArray()));
	}
	
	public void setAcoesMonitoradas(ArrayList<String> acoesMonitoradas) {
		String texto = "";
		
		for (String acaoMonit : acoesMonitoradas) {
			texto += acaoMonit + "\n";
		}
		
		this.acoesMonitoradas.setText(texto);
	}
}
