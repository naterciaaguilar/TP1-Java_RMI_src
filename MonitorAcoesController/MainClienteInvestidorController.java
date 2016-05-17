package MonitorAcoesController;

import java.rmi.Naming;

import MonitorAcoesModel.IServidorAcoes;

public class MainClienteInvestidorController {
	public static void main (String[] args){
		//int porta = Integer.parseInt(args[0]);
		int porta = 9995;
		
		try {
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");

			ClienteInvestidorController controlClienteInvestidor = new ClienteInvestidorController();
			controlClienteInvestidor.inicializaClienteInvestidor(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
