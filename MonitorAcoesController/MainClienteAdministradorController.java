package MonitorAcoesController;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import MonitorAcoesModel.IServidorAcoes;

public class MainClienteAdministradorController {
	public static void main (String[] args) {
		int porta = Integer.parseInt(args[0]);
		
		try {
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");
			
			ClienteAdministradorController controlClienteAdministrador = new ClienteAdministradorController();
			controlClienteAdministrador.inicializaClienteAdministrador();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
