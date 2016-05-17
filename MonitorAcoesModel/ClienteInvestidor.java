package MonitorAcoesModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClienteInvestidor extends UnicastRemoteObject implements IClienteInvestidor {
	
	private static final long serialVersionUID = 1L;
	private Acao acao;
		
	public ClienteInvestidor(String acao, IServidorAcoes servidor) throws RemoteException {
		this.acao = new Acao(acao,0);
		this.acao.setNomeAcao(acao);
		servidor.registraAcaoCliente(this);
	}
	
	public Acao getAcao() throws RemoteException {
		return this.acao;
	}
	
	public String getNomeAcao() throws RemoteException {
		return this.acao.getNomeAcao();
	}
	
	public void notificaAlteracao(String message) throws RemoteException {
		System.out.println(message);
	}
	
	public void monitoraAcao(Acao acao) throws RemoteException {
		
	}

}
