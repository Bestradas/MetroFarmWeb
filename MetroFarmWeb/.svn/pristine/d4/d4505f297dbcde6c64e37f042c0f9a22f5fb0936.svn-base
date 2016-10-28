package co.jankins.monitor;

import java.util.Properties;

import co.jankins.properties.AccessProperties;

public class CmdJankerMonitor {
	
	public void loadMonitor(){
		Properties properties=AccessProperties.getInstance().getProperties();

		try{
				String claseMonitor = properties.getProperty("MonitorSynchronizer.name");
				String horaDespertar = properties.getProperty("MonitorSynchronizer.hora");
				JankerMonitor monitor = new JankerMonitor(claseMonitor, null,horaDespertar);
				monitor.start();
				
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
