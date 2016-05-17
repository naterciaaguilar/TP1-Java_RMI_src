package MonitorAcoesController;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import MonitorAcoesModel.ClienteInvestidor;
import MonitorAcoesModel.IServidorAcoes;

public class MainClienteInvestidorController {
	public static void main (String[] args){
		boolean continua = true;
		int porta = Integer.parseInt(args[0]);
		try{
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");
			while (continua){
				String m = JOptionPane.showInputDialog("Digite uma acao para acompanhar: ");
				new ClienteInvestidor(m,obj);
				
			}
			ClienteInvestidorController controlClienteInvestidor = new ClienteInvestidorController();
			controlClienteInvestidor.inicializaClienteInvestidor();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
