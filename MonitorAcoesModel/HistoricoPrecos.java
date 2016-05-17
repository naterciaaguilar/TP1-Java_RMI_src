package MonitorAcoesModel;

import java.util.Date;

public class HistoricoPrecos {
	private double precoAcao;
	private Date dataAlt;
	
	public HistoricoPrecos(double precoAcao) {
		this.precoAcao = precoAcao;
		this.dataAlt = new Date();
	}

	public double getPrecoAcao() {
		return precoAcao;
	}

	public Date getDataAlt() {
		return dataAlt;
	}
}
