package MonitorAcoesController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import MonitorAcoesModel.Acao;
import MonitorAcoesModel.IClienteInvestidor;
import MonitorAcoesModel.IServidorAcoes;
import MonitorAcoesView.ClienteInvestidorView;

public class ClienteInvestidorController implements ActionListener {
	private ClienteInvestidorView viewClienteInvestidor;
	private IServidorAcoes servidorAcoes;
	private ArrayList<String> listaAcoes;
	
	public void inicializaClienteInvestidor(IServidorAcoes objRemoto) throws RemoteException {
		this.viewClienteInvestidor = new ClienteInvestidorView(this);
		
		try {
			// carregar lista de ações disponíveis no servidor
			this.servidorAcoes = objRemoto;
			this.atualizarListaAcoes(this.servidorAcoes.getAcoesServidor());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterarVisibilidadeTelas(boolean visibilidadeTelaPesquisa, boolean visibilidadeTelaMonitoramento) throws RemoteException {
		// troca tela visível
		this.viewClienteInvestidor.getTelaPesquisa().setVisible(visibilidadeTelaPesquisa);
		this.viewClienteInvestidor.getTelaMonitoramento().setVisible(visibilidadeTelaMonitoramento);
		
		if (visibilidadeTelaPesquisa) {
			this.atualizarListaAcoes(this.servidorAcoes.getAcoesServidor());
		}
	}
	
	public void atualizarListaAcoes(ArrayList<Acao> acoesServidor) {
		this.listaAcoes = new ArrayList<String>();
		
		for(Acao acao : acoesServidor) {
			listaAcoes.add(acao.getNomeAcao());
		}
		
		// atualiza lista no combobox
		this.viewClienteInvestidor.getTelaPesquisa().setComboAcoesDisponiveis(listaAcoes);
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
    		// procedimentos para realizar a pesquisa de uma ação
    		// this.viewClienteInvestidor.getTelaPesquisa().getAcaoSelecionada()
    		try {
				this.alterarVisibilidadeTelas(false, true);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
    	}
    	
    	// tratamento dos eventos da tela de Monitoramento
    	if (obj == this.viewClienteInvestidor.getTelaMonitoramento().getVoltar()) {
    		try {
				this.alterarVisibilidadeTelas(true, false);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
    	} else if (obj == this.viewClienteInvestidor.getTelaMonitoramento().getMonitorar()) {
    		// procedimentos para o monitoramento de ações
    	}
    }
}
