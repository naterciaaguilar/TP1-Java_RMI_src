package MonitorAcoesModel;


import java.util.ArrayList;

public class Acao {
	private String nomeAcao;
	private ArrayList<HistoricoPrecos> precosAcao;
	
	public Acao (String nomeAcao, double precoAcao) {
		this.nomeAcao = nomeAcao;
		this.precosAcao = new ArrayList<HistoricoPrecos>();
		this.precosAcao.add(new HistoricoPrecos(precoAcao));
	}

	public String getNomeAcao() {
		return this.nomeAcao;
	}
	
	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public ArrayList<HistoricoPrecos> getPrecosAcao() {
		return precosAcao;
	}
	
	public String getListaHistorico() {
		String historico = "";
		
		for (HistoricoPrecos hist : this.precosAcao) {
			historico += this.nomeAcao + " - " + hist.getDataAlt().toString() + " - R$ " + hist.getPrecoAcao() + "\n";
		}
		
		return historico;
	}
}
