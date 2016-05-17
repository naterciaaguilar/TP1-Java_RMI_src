package MonitorAcoesController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MonitorAcoesView.ClienteAdministradorView;

public class ClienteAdministradorController implements ActionListener {
	private ClienteAdministradorView viewClienteAdministrador;
	
	public void alterarVisibilidadeTelas(boolean visibilidadeTelaPesquisa, boolean visibilidadeTelaEdicao) {
		// troca tela visível
		this.viewClienteAdministrador.getTelaPesquisa().setVisible(visibilidadeTelaPesquisa);
		this.viewClienteAdministrador.getTelaEdicao().setVisible(visibilidadeTelaEdicao);
	}
	
	public void criarAlterarAcao(String nomeAcao, double preco, String operacao) {
		// procedimentos para alterar ação
		// operacao = NOVA ou EDITAR
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
    		// procedimentos para realizar a pesquisa de uma ação
    	} else if (obj == this.viewClienteAdministrador.getTelaPesquisa().getEditarAcao()) {
    		this.viewClienteAdministrador.getTelaEdicao().setModo("EDITAR");
    		this.alterarVisibilidadeTelas(false, true);
    	} else if (obj == this.viewClienteAdministrador.getTelaPesquisa().getNovaAcao()) {
    		this.viewClienteAdministrador.getTelaEdicao().setModo("NOVA");
    		this.alterarVisibilidadeTelas(false, true);
    	}
    	
    	// tratamento dos eventos da tela de Edição
    	if (obj == this.viewClienteAdministrador.getTelaEdicao().getVoltar()) {
    		this.alterarVisibilidadeTelas(true, false);
    	} else if (obj == this.viewClienteAdministrador.getTelaEdicao().getSalvar()) {
    		this.criarAlterarAcao(this.viewClienteAdministrador.getTelaEdicao().getNomeAcaoStr(), 
    							  Double.parseDouble(this.viewClienteAdministrador.getTelaEdicao().getPrecoAcaoStr()), 
    							  this.viewClienteAdministrador.getTelaEdicao().getModo());
    	}
    }
}
