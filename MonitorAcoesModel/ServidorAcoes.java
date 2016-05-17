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
	
	public ArrayList<String> getAcoesServidor() throws RemoteException {
		ArrayList<String> listaAcoes = new ArrayList<String>();
		
		for (Acao acao : this.acoesServidor) {
			listaAcoes.add(acao.getNomeAcao());
		}
		
		return listaAcoes;
	}
	
	public void setPrecoAcao(String nomeAcao, double novoPreco) throws RemoteException {
		for (Acao acaoChange : this.acoesServidor) {
			if (acaoChange.getNomeAcao().equals(nomeAcao)) {
				acaoChange.getPrecosAcao().add(new HistoricoPrecos(novoPreco));
				comunicaAlteracao(acaoChange.getNomeAcao());
				return;
			}
		}
		
		// se ação não existir
		Acao novaAcao = new Acao(nomeAcao, novoPreco);
		this.acoesServidor.add(novaAcao);
		InteresseAcao novoInteresse = new InteresseAcao(novaAcao);
		this.interesse.add(novoInteresse);
	
		/*int i = 0;
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
		} else {
			HistoricoPrecos preco = new HistoricoPrecos(novoPreco);
			this.acoesServidor.get(i).getPrecosAcao().add(preco);
			comunicaAlteracao(this.acoesServidor.get(i).getNomeAcao());
		}*/	
	}
	
	public void registraAcaoCliente(IClienteInvestidor registraCliente)throws RemoteException {
		String nomeAcao = registraCliente.getNomeAcao();
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
		int k = 0;
		for(InteresseAcao comunica : this.interesse){
			if (comunica.getAcao().getNomeAcao().equals(acao)){
				i = this.interesse.indexOf(comunica);
			}
		}
		while (j<this.interesse.get(i).getClientesInteresse().size()){
			k = this.interesse.get(i).getAcao().getPrecosAcao().size()-1;
			String mensagem = this.interesse.get(i).getAcao().getPrecosAcao().get(k).getDataAlt().toString()+
					" - "+this.interesse.get(i).getAcao().getNomeAcao()+
					" - R$ "+this.interesse.get(i).getAcao().getPrecosAcao().get(k).getPrecoAcao();
			this.interesse.get(i).getClientesInteresse().get(j++).notificaAlteracao(mensagem);
		}
	}

	public String encontraAcao(String nomeAcao) {
		for(Acao acao : this.acoesServidor) {
			if(acao.getNomeAcao().equals(nomeAcao)) {
				return acao.getListaHistorico();
			}
		}
		
		return null;
	}
	
	public ArrayList<String> getAc() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (Acao acao : this.acoesServidor) {
			lista.add(acao.getNomeAcao());
		}
		
		return lista;
	}
}