package MonitorAcoesController;

import java.rmi.Naming;

import MonitorAcoesModel.IServidorAcoes;
import MonitorAcoesModel.ServidorAcoes;

public class MainServidorAcoesController {
	public static void main(String[] args) {
		//int porta = Integer.parseInt(args[0]);
		int porta = 9995;
		try {
			IServidorAcoes servidor = new ServidorAcoes();
			
			// registar porta no rmiregistry
			java.rmi.registry.LocateRegistry.createRegistry(porta);
			Naming.rebind("rmi://localhost:" + porta + "/servidordeacoes", servidor);
			
			System.out.println("Servidor de acoes no ar...");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}