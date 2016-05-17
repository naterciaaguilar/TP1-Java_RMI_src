package MonitorAcoesController;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import MonitorAcoesModel.Acao;
import MonitorAcoesModel.IServidorAcoes;

public class MainClienteAdministradorController {
	public static void main (String[] args) {
		int porta = Integer.parseInt(args[0]);
		boolean continua = true;
		try {
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");
			while (continua){
				String acao = JOptionPane.showInputDialog("Digite a acao: ");
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
				if (acao.equals("ok")){
					continua = false;
					acao = "tchau";
					JOptionPane.showMessageDialog(null, acao);
				}else{
					obj.setPrecoAcao(acao,valor);
					//int i = obj.getAcoesServidor().size();
					//JOptionPane.showMessageDialog(null,obj.getAcoesServidor().get(i).getNomeAcao());
				}
			}
			ClienteAdministradorController controlClienteAdministrador = new ClienteAdministradorController();
			controlClienteAdministrador.inicializaClienteAdministrador();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}