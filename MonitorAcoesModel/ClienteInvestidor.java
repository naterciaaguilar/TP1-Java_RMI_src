package MonitorAcoesModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClienteInvestidor extends UnicastRemoteObject implements IClienteInvestidor {
	private static final long serialVersionUID = 1L;
	private Acao acao;
		
	public ClienteInvestidor(Acao acao) throws RemoteException {
		this.acao = acao;
	}
	
	public Acao getAcao() throws RemoteException {
		return this.acao;
	}
	
	public void notificaAlteracao(String message) throws RemoteException {
		
	}
	
	public void monitoraAcao(Acao acao) throws RemoteException {
		// registra interesse
	}
}
