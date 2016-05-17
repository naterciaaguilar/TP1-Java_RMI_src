package MonitorAcoesModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClienteInvestidor extends Remote {
	
	public String getNomeAcao() throws RemoteException;
	
	public void notificaAlteracao(String message) throws RemoteException;
}
