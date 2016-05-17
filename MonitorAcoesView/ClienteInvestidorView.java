package MonitorAcoesView;

import MonitorAcoesController.ClienteInvestidorController;

public class ClienteInvestidorView {
	private FrameAplicacao framePrincipal;
	
	private ClienteInvestidorPesquisa telaPesquisa;
	private ClienteInvestidorMonitoramento telaMonitoramento;
	
	public ClienteInvestidorView(ClienteInvestidorController controlClienteInvestidor) {
		this.framePrincipal = new FrameAplicacao("Monitoramento de Preços de Ações", 600, 400);
		
		// telas com possível navegação no cliente investidor
		this.telaPesquisa = new ClienteInvestidorPesquisa(600, 380, controlClienteInvestidor);
		this.telaMonitoramento = new ClienteInvestidorMonitoramento(600, 400, controlClienteInvestidor);
		
		// adiciona telas ao frame
		this.framePrincipal.add(this.telaPesquisa);
		this.framePrincipal.add(this.telaMonitoramento);
		
		// ao iniciar, tela pesquisa estará visível e o monitoramento
		telaPesquisa.setVisible(true);
		telaMonitoramento.setVisible(false);
	}

	public ClienteInvestidorPesquisa getTelaPesquisa() {
		return telaPesquisa;
	}
	
	public ClienteInvestidorMonitoramento getTelaMonitoramento() {
		return telaMonitoramento;
	}
}
