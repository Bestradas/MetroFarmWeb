package co.com.farmatech.metrofarm.bimanager.synchronization;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import co.jankins.psf.common.exception.JankinsMarshallException;

public class MgrSynchronizationImp implements MgrSynchronizationService{
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
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
			e.printStackTrace();
			throw new JankinsMarshallException(e);
		}	
	}

}
