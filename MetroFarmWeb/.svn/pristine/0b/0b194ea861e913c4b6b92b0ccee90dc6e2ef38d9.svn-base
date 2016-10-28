package co.jankins.thread.syncrhonize;

import java.util.Map;

import org.apache.log4j.Logger;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import co.jankins.monitor.IMonitorExecutor;
import co.jankins.psf.common.exception.JankinsMarshallException;

public class SynchronizeEquipment implements IMonitorExecutor{
	
	private static SynchronizeEquipment instance;
	Logger  logger = Logger.getLogger(SynchronizeEquipment.class.getName());
	
	/**
	 * Metodo que permite instanciar una sola vez la clase de AccessProperties
	 * 
	 * @return
	 * @author Bryan
	 */
	public static synchronized SynchronizeEquipment getInstance(){
		if (instance == null) {
			instance = new SynchronizeEquipment();
			return instance;
		}
		return instance;
	}
	
	@Override
	public void execute(Map<String, String> parametros) {
		// TODO Auto-generated method stub
		try {
			logger.info("--------EJECUTANDO PROCESO SINCRONIZACION DE EQUIPOS OFIMÁTICA--------");
			KettleEnvironment.init();
			EnvUtil.environmentInit();
			TransMeta transMeta = new TransMeta(getClass().getClassLoader().getResource("co/jankins/files/TransformacionEquipos.ktr")+"");
			Trans trans = new Trans(transMeta);

			trans.execute(null);
			//trans.startThreads();
			trans.waitUntilFinished();
			if(trans.getErrors()>0){
				throw new JankinsMarshallException("Ocurrio un error durante la sincronización de equipos con ofimática");
			}
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			logger.error("OCURRIO UN ERROR DURANTE LA EJECUCIÓN DE SINCRONIZACIÓN: "+e.getStackTrace());
			throw new JankinsMarshallException(e);
		}	
	}

}
