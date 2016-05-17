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
	
	public void setPrecoAcao(String nomeAcao, double novoPreco) throws RemoteException {
		// se ação existir, altera preço
		for (Acao acaoChange : this.acoesServidor) {
			if (acaoChange.getNomeAcao().equals(nomeAcao)) {
				acaoChange.getPrecosAcao().add(new HistoricoPrecos(novoPreco));
				comunicaAlteracao(acaoChange.getNomeAcao());
				return;
			}
		}
		
		// se ação não existir, cria uma nova ação
		Acao novaAcao = new Acao(nomeAcao, novoPreco);
		this.acoesServidor.add(novaAcao);
		InteresseAcao novoInteresse = new InteresseAcao(novaAcao);
		this.interesse.add(novoInteresse);
	}
	
	public void registraAcaoCliente(IClienteInvestidor registraCliente) throws RemoteException {
		// registra cliente com interesse de ser notificado numa lista
		String nomeAcao = registraCliente.getNomeAcao();

		for (InteresseAcao comunica : this.interesse){
			if (comunica.getAcao().getNomeAcao().equals(nomeAcao)) {
				comunica.getClientesInteresse().add(registraCliente);
			}
		}
	}

	public void comunicaAlteracao(String acao) throws RemoteException {
		// comunica alteração do preço a uma lista de clientes que escolheram ser notificados
		String mensagem;
		
		for (InteresseAcao comunica : this.interesse){
			if (comunica.getAcao().getNomeAcao().equals(acao)){
				mensagem = "A ação " + comunica.getAcao().getNomeAcao() 
						 + " foi alterada para R$ " + comunica.getAcao().getUltimoPreco().getPrecoAcao()
						 + " na data " + comunica.getAcao().getUltimoPreco().getDataAlt().toString() + "\n";
				for (IClienteInvestidor cliInvest : comunica.getClientesInteresse()) {
					cliInvest.notificaAlteracao(mensagem);
				}
			}
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
	
	public ArrayList<String> getListaAcoes() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (Acao acao : this.acoesServidor) {
			lista.add(acao.getNomeAcao());
		}
		
		return lista;
	}
}