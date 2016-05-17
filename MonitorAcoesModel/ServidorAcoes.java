package MonitorAcoesModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorAcoes extends UnicastRemoteObject implements IServidorAcoes {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Acao> acoesServidor;
	
	public ServidorAcoes() throws RemoteException {
		this.acoesServidor = new ArrayList<Acao>();
	}
	
	public ArrayList<Acao> getAcoesServidor() throws RemoteException {
		return this.acoesServidor;
	}
	
	public String getNomeAcao(Acao acao) throws RemoteException {
		return "";
	}
	
	public void setPrecoAcao(Acao acao, double novoPreco) throws RemoteException {
		
	}
}
