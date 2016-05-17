package MonitorAcoesController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MonitorAcoesModel.ClienteInvestidor;
import MonitorAcoesModel.IServidorAcoes;
import MonitorAcoesView.ClienteInvestidorView;

public class ClienteInvestidorController implements ActionListener {
	private ClienteInvestidorView viewClienteInvestidor;
	private IServidorAcoes servidorAcoes;
	private ArrayList<String> listaAcoes;
	private String acaoCorrente;
	private String historicoPrecosAcaoCorrente;
	
	
	public void inicializaClienteInvestidor(IServidorAcoes objRemoto) throws RemoteException {
		this.viewClienteInvestidor = new ClienteInvestidorView(this);
		
		try {
			// carregar lista de ações disponíveis no servidor
			this.servidorAcoes = objRemoto;
			//this.listaAcoes = new ArrayList<String>();
			//listaAcoes.add("acao");
			//listaAcoes.add("nova");
			this.listaAcoes = this.servidorAcoes.getAc();
			//if (this.listaAcoes.size() > 0) {
				this.viewClienteInvestidor.getTelaPesquisa().setComboAcoesDisponiveis(listaAcoes);
			//}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterarVisibilidadeTelas(boolean visibilidadeTelaPesquisa, boolean visibilidadeTelaMonitoramento) throws RemoteException {
		// troca tela visível
		this.viewClienteInvestidor.getTelaPesquisa().setVisible(visibilidadeTelaPesquisa);
		this.viewClienteInvestidor.getTelaMonitoramento().setVisible(visibilidadeTelaMonitoramento);
		
		if (visibilidadeTelaPesquisa) {
			this.viewClienteInvestidor.getTelaPesquisa().setComboAcoesDisponiveis(servidorAcoes.getAc());
		}
	}
	
	public void pesquisarAcao(String nomeAcao) {
		try {
			this.acaoCorrente = nomeAcao;
			this.historicoPrecosAcaoCorrente = this.servidorAcoes.encontraAcao(this.acaoCorrente);
			this.viewClienteInvestidor.getTelaMonitoramento().setLblNomeAcao(this.acaoCorrente);
			this.viewClienteInvestidor.getTelaMonitoramento().setHistoricoPrecos(this.historicoPrecosAcaoCorrente);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void monitorarAcao() {
		try {
			new ClienteInvestidor(this.acaoCorrente, this.servidorAcoes);
			JOptionPane.showMessageDialog(null, "A ação está sendo monitorada!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
    		this.pesquisarAcao(this.viewClienteInvestidor.getTelaPesquisa().getAcaoSelecionada());
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
    		this.monitorarAcao();
    	}
    }
}
