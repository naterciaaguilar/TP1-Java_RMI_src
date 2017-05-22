Teste Branch

- Integrantes da dupla: Natércia Aguilar - 2013063185
			Robson Melo - 2008051212

- Para compilar os seguintes comandos devem ser executados:

javac MonitorAcoesController/ClienteAdministradorController.java
javac MonitorAcoesController/ClienteInvestidorController.java
javac MonitorAcoesController/MainClienteAdministradorController.java
javac MonitorAcoesController/MainInvestidorController.java
javac MonitorAcoesController/MainServidorAcoesController.java
javac MonitorAcoesModel/Acao.java
javac MonitorAcoesModel/ClienteInvestidor.java
javac MonitorAcoesModel/HistoricoPrecos.java
javac MonitorAcoesModel/IClienteInvestidor.java
javac MonitorAcoesModel/InteresseAcao.java
javac MonitorAcoesModel/IServidorAcoes.java
javac MonitorAcoesModel/ServidorAcoes.java
javac MonitorAcoesView/ClienteAdministradorEdicao.java
javac MonitorAcoesView/ClienteAdministradorPesquisa.java
javac MonitorAcoesView/ClienteAdministradorView.java
javac MonitorAcoesView/ClienteInvestidorMonitoramento.java
javac MonitorAcoesView/ClienteInvestidorPesquisa.java
javac MonitorAcoesView/ClienteInvestidorView.java
javac MonitorAcoesView/FrameAplicacao.java
rmic MonitorAcoesModel.ClienteInvestidor
rmic MonitorAcoesModel.ServidorAcoes

- Para executar o código, primeiro deve-se iniciar o rmiregistry. Em seguida deve-se iniciar
o servidor e depois os clientes da seguinte forma:

--Em uma janela de prompt de comando iniciamos o rmiregistry:

rmiregistry

--Inicia o servidor em outra janela de prompt de comando:

java MonitorAcoesController/MainServidorAcoesController [porta]

--Inicio os clientes em janelas separadas do prompt de comando:

java MonitorAcoesController/MainClienteAdministradorController [porta]

java MonitorAcoesController/MainInvestidorController [porta]
