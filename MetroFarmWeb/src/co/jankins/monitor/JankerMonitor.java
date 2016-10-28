package co.jankins.monitor;

import java.util.Calendar;
import java.util.Map;

import co.jankins.thread.syncrhonize.SynchronizeEquipment;

public class JankerMonitor extends Thread{

	private String nombre;			
	private static long MILIS_DAY = 86400000; //Milisegundos de un dia
	private boolean ejecutando=true;
	private Map<String, String> parameter;
	private String tiempoEjecucion;

	public JankerMonitor(String nombreClase,Map parametros,String tiempoEjecucion){

		super(nombreClase);
		this.parameter=parametros;
		this.nombre=nombreClase;
		this.tiempoEjecucion = tiempoEjecucion;
	}


	public void run() {
		String [] vectortiempo = tiempoEjecucion.split(":"); 

		boolean esHora = false;

		int hora = 0;
		int minutos =0;
		int segundos =0;

		if(vectortiempo.length==1){
			esHora = false;
		}else{
			hora = Integer.parseInt(vectortiempo[0].trim());
			minutos =Integer.parseInt(vectortiempo[1].trim());
			segundos =Integer.parseInt(vectortiempo[2].trim());
			esHora = true;
		}

		//Si el hilo no esta vivo no continua

		while(true){

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, hora);
			calendar.set(Calendar.MINUTE, minutos);
			calendar.set(Calendar.SECOND, segundos);
			calendar.set(Calendar.MILLISECOND, 0);

			// milisegundos de la hora de despertarse
			long wakeupTime = calendar.getTime().getTime();
			// milisegundos de la hora actual
			long currentMilisegundos = System.currentTimeMillis();
			// milisegundos que debe esperar para despertarse
			long tiempoEspera = wakeupTime - currentMilisegundos;

			if(esHora){

				if (tiempoEspera <= 0) {
					currentMilisegundos = System.currentTimeMillis();

					tiempoEspera = wakeupTime - currentMilisegundos;
					tiempoEspera = MILIS_DAY + (tiempoEspera);
				}

			}else{
				tiempoEspera=Long.parseLong(tiempoEjecucion); // 5 hrs
			}

			System.out.println("clase   "+nombre);
			System.out.println("hora/intervalo ejecucion   "+tiempoEjecucion);
			System.out.println("tiempo de espera   "+tiempoEspera);

			try{
				this.sleep(tiempoEspera);
				IMonitorExecutor monitorExecute = ( IMonitorExecutor )SynchronizeEquipment.getInstance();
				monitorExecute.execute(this.parameter);
			}catch(Throwable ex){
				ex.printStackTrace();
			}
		}
	}

}
