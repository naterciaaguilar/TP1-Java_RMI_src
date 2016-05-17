package MonitorAcoesController;

import java.rmi.Naming;

import MonitorAcoesModel.IServidorAcoes;

public class MainClienteAdministradorController {
	public static void main (String[] args) {
		//int porta = Integer.parseInt(args[0]);
		int porta = 9995;
		try {
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");
			
			ClienteAdministradorController controlClienteAdministrador = new ClienteAdministradorController();
			controlClienteAdministrador.inicializaClienteAdministrador(obj);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}