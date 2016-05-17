package MonitorAcoesModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorAcoes extends UnicastRemoteObject implements IServidorAcoes {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Acao> acoesServidor;
	private ArrayList<InteresseAcao> interesse;
	
	public ServidorAcoes() throws RemoteException {
		this.acoesServidor = new ArrayList<Acao>();
		this.interesse = new ArrayList<InteresseAcao>();
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
		for (Acao acaoInteracao : this.acoesServidor){
			if (acaoInteracao.getNomeAcao().equals(nomeAcao)){
				achou = true;
				i = this.acoesServidor.indexOf(acaoInteracao);
			}
		}
		if (!achou){
			Acao novaAcao = new Acao(nomeAcao, novoPreco);
			this.acoesServidor.add(novaAcao);
			InteresseAcao novoInteresse = new InteresseAcao(novaAcao);
			this.interesse.add(novoInteresse);
		}else{
			HistoricoPrecos preco = new HistoricoPrecos(novoPreco);
			this.acoesServidor.get(i).getPrecosAcao().add(preco);
			comunicaAlteracao(this.acoesServidor.get(i).getNomeAcao());
		}	
	}
	
	public void registraAcaoCliente(IClienteInvestidor registraCliente)throws RemoteException {
		String nomeAcao = registraCliente.getAcao().getNomeAcao();
		int i = 0;
		for(InteresseAcao comunica : this.interesse){
			if (comunica.getAcao().getNomeAcao().equals(nomeAcao)){
				i = this.interesse.indexOf(comunica);
			}
		}
		this.interesse.get(i).getClientesInteresse().add(registraCliente);
		
		
	}

	public void comunicaAlteracao(String acao) throws RemoteException {
		int i = 0;
		int j = 0;
		for(InteresseAcao comunica : this.interesse){
			if (comunica.getAcao().getNomeAcao().equals(acao)){
				i = this.interesse.indexOf(comunica);
			}
		}
		while (j<this.interesse.get(i).getClientesInteresse().size()){
			//tem q mudar a passagem aki
			this.interesse.get(i).getClientesInteresse().get(j++).notificaAlteracao("acao alterada");
		}
	}

}