package MonitorAcoesModel;

import java.util.ArrayList;

public class InteresseAcao {
	private Acao acao;
	private ArrayList<IClienteInvestidor> clientesInteresse;
	
	public InteresseAcao(Acao acao) {
		this.acao = acao;
		this.clientesInteresse = new ArrayList<IClienteInvestidor>();
	}
	
	public void registraInteresse(IClienteInvestidor cliInvest) {
		this.clientesInteresse.add(cliInvest);
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public ArrayList<IClienteInvestidor> getClientesInteresse() {
		return clientesInteresse;
	}

	public void setClientesInteresse(ArrayList<IClienteInvestidor> clientesInteresse) {
		this.clientesInteresse = clientesInteresse;
	}
}