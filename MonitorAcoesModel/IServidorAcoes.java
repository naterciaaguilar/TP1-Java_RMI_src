package MonitorAcoesModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServidorAcoes extends Remote {
	public ArrayList<Acao> getAcoesServidor() throws RemoteException;
	
	//public String getNomeAcao(Acao acao) throws RemoteException;
	
	public void setPrecoAcao(String acao, double novoPreco) throws RemoteException;
	
	public void registraAcaoCliente (IClienteInvestidor registraCliente) throws RemoteException;
	
	public void comunicaAlteracao(String acao) throws RemoteException;
	
	//public Acao encontraAcao(Acao acao) throws RemoteException;
}