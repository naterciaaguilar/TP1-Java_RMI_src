package MonitorAcoesView;

import MonitorAcoesController.ClienteAdministradorController;

public class ClienteAdministradorView {
	private FrameAplicacao framePrincipalAdmin;

	private ClienteAdministradorPesquisa telaPesquisa;
	private ClienteAdministradorEdicao telaEdicao;
	
	public ClienteAdministradorView(ClienteAdministradorController controlClienteAdministrador) {
		this.framePrincipalAdmin = new FrameAplicacao("Administrador de Preços de Ações", 600, 400);
		
		// telas com possível navegação no cliente administrador
		this.telaPesquisa = new ClienteAdministradorPesquisa(600, 400, controlClienteAdministrador);
		this.telaEdicao = new ClienteAdministradorEdicao(600, 400, controlClienteAdministrador);
		
		// adiciona telas ao frame
		this.framePrincipalAdmin.add(this.telaPesquisa);
		this.framePrincipalAdmin.add(this.telaEdicao);
		
		// ao iniciar, tela pesquisa estará visível e edição não
		this.telaPesquisa.setVisible(true);
		this.telaEdicao.setVisible(false);
	}
	
	public ClienteAdministradorPesquisa getTelaPesquisa() {
		return this.telaPesquisa;
	}
	
	public ClienteAdministradorEdicao getTelaEdicao() {
		return this.telaEdicao;
	}
}
