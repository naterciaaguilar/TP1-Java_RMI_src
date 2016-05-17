package MonitorAcoesModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServidorAcoes extends Remote {
	public void setPrecoAcao(String acao, double novoPreco) throws RemoteException;
	
	public void registraAcaoCliente (IClienteInvestidor registraCliente) throws RemoteException;
	
	public void comunicaAlteracao(String acao) throws RemoteException;
	
	public String encontraAcao(String nomeAcao) throws RemoteException;
	
	public ArrayList<String> getListaAcoes() throws RemoteException;
}