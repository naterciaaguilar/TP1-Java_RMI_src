package MonitorAcoesController;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import MonitorAcoesModel.IServidorAcoes;

public class MainClienteAdministradorController {
	public static void main (String[] args) {
		boolean continua = true;
		int porta = Integer.parseInt(args[0]);
		try{
			IServidorAcoes obj = (IServidorAcoes)Naming.lookup("rmi://localhost:" + porta + "/servidordeacoes");
			while (continua) {
				String acao = JOptionPane.showInputDialog("Digite a acao: ");
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
				if (acao.equals("ok")){
					continua = false;
					acao = "tchau";
					JOptionPane.showMessageDialog(null, acao);
				}else{
					obj.setVetorAcao(acao,valor);
					JOptionPane.showMessageDialog(null,obj.retornaAcao(acao));
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
