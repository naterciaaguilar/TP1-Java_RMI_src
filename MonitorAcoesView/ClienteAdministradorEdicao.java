package MonitorAcoesView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MonitorAcoesController.ClienteAdministradorController;


public class ClienteAdministradorEdicao extends JInternalFrame {
	private JLabel lblNomeAcao;
	private JLabel lblPrecoAcao;
	private JTextField nomeAcao;
	private JTextField precoAcao;
	private JButton salvar;
	private JButton voltar;
	
	private String modo;
	
	public ClienteAdministradorEdicao(int largura, int altura, ClienteAdministradorController controlClienteAdministrador) {
		super();
		this.setSize(largura, altura);
		this.setFrameIcon(null);
		this.setBorder(null);
		
		// container da tela
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // paineis para edição da ação
        JPanel panelEdicao = new JPanel(new GridLayout(2, 1, 10, 10));
        
        JPanel panelNomeAcao = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        
        this.lblNomeAcao = new JLabel("Nome da Ação: ");
        this.nomeAcao = new JTextField(42);
        
        panelNomeAcao.add(this.lblNomeAcao);
        panelNomeAcao.add(this.nomeAcao);
        
        JPanel panelPrecoAcao = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        
        this.lblPrecoAcao = new JLabel("Preço: ");
        this.precoAcao = new JTextField(42);

        panelPrecoAcao.add(this.lblPrecoAcao);
        panelPrecoAcao.add(this.precoAcao);
        
        panelEdicao.add(panelNomeAcao);
        panelEdicao.add(panelPrecoAcao);
        
        contentPane.add(panelEdicao, "North");
        
        // rodapé com botões de salvar e voltar
        JPanel panelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        this.salvar = new JButton("Salvar");
        this.voltar = new JButton("Voltar");
        
        panelRodape.add(salvar);
        panelRodape.add(voltar);
        
        contentPane.add(panelRodape, "South");
        
        // eventos da tela
        this.voltar.addActionListener(controlClienteAdministrador);
        this.salvar.addActionListener(controlClienteAdministrador);
	}
	
	public void alteraModoExibicao() {
		if (this.modo.equals("EDITAR")) {
        	this.nomeAcao.setEnabled(false);
        	this.lblPrecoAcao.setText("Novo preço: ");
        } else {
        	this.nomeAcao.setEnabled(true);
        	this.lblPrecoAcao = new JLabel("Preço: ");
        }
	}
	
	public String getModo() {
		return this.modo;
	}
	
	public void setModo(String modo) {
		this.modo = modo;
		this.alteraModoExibicao();
	}
	
	public String getNomeAcaoStr() {
		return this.nomeAcao.getText();
	}
	
	public String getPrecoAcaoStr() {
		return this.precoAcao.getText();
	}
	
	public JButton getSalvar() {
		return this.salvar;
	}
	
	public JButton getVoltar() {
		return this.voltar;
	}
}