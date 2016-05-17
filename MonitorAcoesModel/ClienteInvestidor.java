package MonitorAcoesModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import MonitorAcoesController.ClienteInvestidorController;

public class ClienteInvestidor extends UnicastRemoteObject implements IClienteInvestidor {
	
	private static final long serialVersionUID = 1L;
	private String nomeAcao;
	private ClienteInvestidorController referenciaCliente;	
	
	public ClienteInvestidor(String acao, IServidorAcoes servidor, ClienteInvestidorController control) throws RemoteException {
		this.nomeAcao = acao;
		servidor.registraAcaoCliente(this);
		this.referenciaCliente = control;
	}
	
	public String getNomeAcao() throws RemoteException {
		return this.nomeAcao;
	}
	
	public void notificaAlteracao(String message) throws RemoteException {
		// cada vez que um pre�o de uma a��o monitorada � alterado, escreve na p�gina principal do cliente e muda automaticamente para esta p�gina
		String text = this.referenciaCliente.getViewClienteInvestidor().getTelaPesquisa().getTextoAcoesMonitoradas();
		this.referenciaCliente.getViewClienteInvestidor().getTelaPesquisa().setTextoAcoesMonitoradas(text + message + "\n");
		this.referenciaCliente.alterarVisibilidadeTelas(true, false);
	}
}
