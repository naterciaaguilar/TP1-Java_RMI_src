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
		String nomeAcao = acao.getNomeAcao();
		int i = 0;
		boolean achou = false;
		for (Acao acaoInteracao : acoesServidor){
			if (acaoInteracao.getNomeAcao().equals(nomeAcao)){
				achou = true;
				i = acoesServidor.indexOf(acaoInteracao);
			}
		}
		if (!achou){
			Acao novaAcao = new Acao(nomeAcao, novoPreco);
			this.acoesServidor.add(novaAcao);
			//InteresseAcao novoInteresse = new InteresseAcao(novaAcao); duvida aki
		}else{
			HistoricoPrecos preco = new HistoricoPrecos(novoPreco);
			this.acoesServidor.get(i).getPrecosAcao().add(preco);
			//comunicaAlteracao();
		}
	}
}