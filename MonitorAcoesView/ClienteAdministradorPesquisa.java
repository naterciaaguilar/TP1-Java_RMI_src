package MonitorAcoesView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import MonitorAcoesController.ClienteAdministradorController;


public class ClienteAdministradorPesquisa extends JInternalFrame {
	private JLabel lblNomeAcao;
	private JTextField nomeAcao;
	private JButton pesquisar;
	private JButton novaAcao;
	private JButton editarAcao;
	private JTextArea pesquisaAcoes;
	
	public ClienteAdministradorPesquisa(int largura, int altura, ClienteAdministradorController controlClienteAdministrador) {
		super();
		this.setSize(largura, altura);
		this.setFrameIcon(null);
		this.setBorder(null);
		
		// container da tela
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // cabecalho da tela com caixa de pesquisa
        JPanel panelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        this.lblNomeAcao = new JLabel("Nome da Ação: ");
        this.nomeAcao = new JTextField(30);
        this.pesquisar = new JButton("Pesquisar");
        
        panelPesquisa.add(this.lblNomeAcao);
        panelPesquisa.add(this.nomeAcao);
        panelPesquisa.add(this.pesquisar);
        
        contentPane.add(panelPesquisa, "North");
        
        // area central da tela com painel para exibir ação consultada
        JPanel panelResult = new JPanel();
        panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
        
        this.pesquisaAcoes = new JTextArea();
        this.pesquisaAcoes.setEnabled(false);
        
        panelResult.add(this.pesquisaAcoes);
        panelResult.add(Box.createRigidArea(new Dimension(0,5)));
        panelResult.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        contentPane.add(panelResult, "Center");

        // rodapé com botões de pesquisa e nova ação
        JPanel panelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        this.editarAcao = new JButton("Editar Preço");
        this.novaAcao = new JButton("Nova Ação");
        
        panelRodape.add(editarAcao);
        panelRodape.add(novaAcao);
        
        contentPane.add(panelRodape, "South");
        
        // eventos da tela
        this.pesquisar.addActionListener(controlClienteAdministrador);
        this.novaAcao.addActionListener(controlClienteAdministrador);
        this.editarAcao.addActionListener(controlClienteAdministrador);
	}
	
	public String getNomeAcaoStr() {
		return this.nomeAcao.getText();
	}
	
	public JButton getPesquisar() {
		return this.pesquisar;
	}
	
	public JButton getNovaAcao() {
		return this.novaAcao;
	}
	
	public JButton getEditarAcao() {
		return this.editarAcao;
	}
	
	public JTextArea getPesquisaAcoes() {
		return this.pesquisaAcoes;
	}
}