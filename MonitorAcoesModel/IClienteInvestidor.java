package MonitorAcoesModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClienteInvestidor extends Remote {
	public Acao getAcao() throws RemoteException;
	
	public void notificaAlteracao(String message) throws RemoteException;
	
	public void monitoraAcao(Acao acao) throws RemoteException;
}
