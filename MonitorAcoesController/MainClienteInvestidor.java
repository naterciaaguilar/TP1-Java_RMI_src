package MonitorAcoesController;

import java.rmi.Naming;

import MonitorAcoesModel.IServidorAcoes;

public class MainClienteInvestidor {
	public static void main (String[] args) {
		int porta = Integer.parseInt(args[0]);
		try{
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");
			
			ClienteInvestidorController controlClienteInvestidor = new ClienteInvestidorController();
			controlClienteInvestidor.inicializaClienteInvestidor(obj);
			/*while (continua){
				String m = JOptionPane.showInputDialog("Digite uma acao para acompanhar: ");
				new comunicacaoCliente(m,obj);
				int a = obj.encontraAcao(m);
				if (a >= 0){
					//obj.getAcao();
				}else{
					//continua = false;
					//obj.setAcao(m,10);
				}
				JOptionPane.showMessageDialog(null, a);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
