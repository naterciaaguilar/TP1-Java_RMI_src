package MonitorAcoesController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MonitorAcoesView.ClienteInvestidorView;

public class ClienteInvestidorController implements ActionListener {
	private ClienteInvestidorView viewClienteInvestidor;
	
	public void inicializaClienteInvestidor() {
		this.viewClienteInvestidor = new ClienteInvestidorView(this);
	}
	
	public void alterarVisibilidadeTelas(boolean visibilidadeTelaPesquisa, boolean visibilidadeTelaMonitoramento) {
		// troca tela visível
		this.viewClienteInvestidor.getTelaPesquisa().setVisible(visibilidadeTelaPesquisa);
		this.viewClienteInvestidor.getTelaMonitoramento().setVisible(visibilidadeTelaMonitoramento);
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
    	if (obj == this.viewClienteInvestidor.getTelaPesquisa().getPesquisar()) {
    		this.alterarVisibilidadeTelas(false, true);
    		// procedimentos para realizar a pesquisa de uma ação
    		// this.investView.getTelaPesquisa().getAcaoSelecionada()
    	}
    	
    	// tratamento dos eventos da tela de Monitoramento
    	if (obj == this.viewClienteInvestidor.getTelaMonitoramento().getVoltar()) {
    		this.alterarVisibilidadeTelas(true, false);
    	} else if (obj == this.viewClienteInvestidor.getTelaMonitoramento().getMonitorar()) {
    		// procedimentos para o monitoramento de ações
    	}
    }
}
