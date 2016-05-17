package MonitorAcoesController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import MonitorAcoesModel.IServidorAcoes;
import MonitorAcoesView.ClienteAdministradorView;

public class ClienteAdministradorController implements ActionListener {
	private ClienteAdministradorView viewClienteAdministrador;
	private IServidorAcoes servAcoes;
	private String acaoCorrente;
	private String historicoAcaoCorrente;
	
	public void inicializaClienteAdministrador(IServidorAcoes servAcoes) {
		this.viewClienteAdministrador = new ClienteAdministradorView(this);
		this.servAcoes = servAcoes;
	}
	
	public void alterarVisibilidadeTelas(boolean visibilidadeTelaPesquisa, boolean visibilidadeTelaEdicao) {
		// troca tela vis�vel
		this.viewClienteAdministrador.getTelaPesquisa().setVisible(visibilidadeTelaPesquisa);
		this.viewClienteAdministrador.getTelaEdicao().setVisible(visibilidadeTelaEdicao);
	}
	
	public void criarAlterarAcao(String nomeAcao, double preco, String operacao) throws RemoteException {
		// procedimentos para alterar a��o
		// operacao = NOVA ou EDITAR
		String msg;
		
		if (operacao.equals("NOVA")) {
			this.acaoCorrente = this.servAcoes.encontraAcao(nomeAcao);
			msg = "A��o criada com sucesso!";
			
			if(this.acaoCorrente != null) {
				JOptionPane.showMessageDialog(null, "A��o existente. Modo alterado para edi��o.");
				this.viewClienteAdministrador.getTelaEdicao().setModo("EDITAR");
				msg = "A��o alterada com sucesso!";
			}
		} else {
			msg = "A��o alterada com sucesso!";
		}
	
		this.servAcoes.setPrecoAcao(nomeAcao, preco);
		JOptionPane.showMessageDialog(null, msg);
		this.alterarVisibilidadeTelas(true, false);
	}
	
	public void pesquisarAcao(String nomeAcao) {
		try {
			this.acaoCorrente = nomeAcao;
			this.historicoAcaoCorrente = this.servAcoes.encontraAcao(this.acaoCorrente);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (this.historicoAcaoCorrente != null) {
			this.viewClienteAdministrador.getTelaPesquisa().getPesquisaAcoes().setText(this.historicoAcaoCorrente);
			this.viewClienteAdministrador.getTelaPesquisa().getEditarAcao().setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existe a��o com o nome informado!");
			this.viewClienteAdministrador.getTelaPesquisa().getPesquisaAcoes().setText("");
			this.viewClienteAdministrador.getTelaPesquisa().getEditarAcao().setEnabled(false);
		}
	}
	
	public void zerarCamposPesquisa() {
		this.viewClienteAdministrador.getTelaPesquisa().getPesquisaAcoes().setText("");
		this.viewClienteAdministrador.getTelaPesquisa().setNomeAcao();
	}
	
	/**
     * Trata os eventos que acontecem na interface com o usuario
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	
    	// tratamento dos eventos da tela de Pesquisa
    	if (obj == this.viewClienteAdministrador.getTelaPesquisa().getPesquisar()) {
    		// procedimentos para realizar a pesquisa de uma a��o
    		this.pesquisarAcao(this.viewClienteAdministrador.getTelaPesquisa().getNomeAcaoStr());
    	} else if (obj == this.viewClienteAdministrador.getTelaPesquisa().getEditarAcao()) {
    		this.viewClienteAdministrador.getTelaEdicao().setPrecoAcaoStr();
    		this.viewClienteAdministrador.getTelaEdicao().setNomeAcaoStr(this.acaoCorrente);
    		this.viewClienteAdministrador.getTelaEdicao().setModo("EDITAR");
    		this.alterarVisibilidadeTelas(false, true);
    	} else if (obj == this.viewClienteAdministrador.getTelaPesquisa().getNovaAcao()) {
    		this.viewClienteAdministrador.getTelaEdicao().setPrecoAcaoStr();
			this.viewClienteAdministrador.getTelaEdicao().setNomeAcaoStr("");
    		this.viewClienteAdministrador.getTelaEdicao().setModo("NOVA");
    		this.alterarVisibilidadeTelas(false, true);
    	}
    	
    	// tratamento dos eventos da tela de Edi��o
    	if (obj == this.viewClienteAdministrador.getTelaEdicao().getVoltar()) {
    		this.zerarCamposPesquisa();
    		this.alterarVisibilidadeTelas(true, false);
    	} else if (obj == this.viewClienteAdministrador.getTelaEdicao().getSalvar()) {
    		this.zerarCamposPesquisa();
    		try {
				this.criarAlterarAcao(this.viewClienteAdministrador.getTelaEdicao().getNomeAcaoStr(), 
									  Double.parseDouble(this.viewClienteAdministrador.getTelaEdicao().getPrecoAcaoStr()), 
									  this.viewClienteAdministrador.getTelaEdicao().getModo());
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
    	}
    }
}
