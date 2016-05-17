package MonitorAcoesModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

public class ClienteInvestidor extends UnicastRemoteObject implements IClienteInvestidor {
	
	private static final long serialVersionUID = 1L;
	private String nomeAcao;
		
	public ClienteInvestidor(String acao, IServidorAcoes servidor) throws RemoteException {
		this.nomeAcao = acao;
		servidor.registraAcaoCliente(this);
	}
	
	
	public String getNomeAcao() throws RemoteException {
		return this.nomeAcao;
	}
	
	public void notificaAlteracao(String message) throws RemoteException {
		//System.out.println(message);
		JOptionPane.showMessageDialog(null, message);
	}
	
	//public void monitoraAcao(Acao acao) throws RemoteException {
		
	//}

}
