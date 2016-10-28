package co.jankins.psf.common.global;

import co.janker.dto.context.Context;
import co.janker.dto.objresponse.ObjectResponse;
import co.janker.dto.objsend.ObjectSend;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoMantenimiento;
import com.co.farmatech.metrofarm.dto.DtoNotificacion;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;
import com.co.farmatech.metrofarm.dto.DtoProveedor;
import com.co.farmatech.metrofarm.dto.DtoRegistroCambios;
import com.co.farmatech.metrofarm.dto.DtoReport;
import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.DtoPerfil;
import com.co.farmatech.metrofarm.dto.PageData;

public class GlobalDto {
	
	public static final Class[] dtos={ObjectSend.class,ObjectResponse.class,DtoUsuario.class,Context.class,
		  DtoEquipo.class,DtoPerfil.class,DtoRegistroCambios.class,DtoCalibracion.class,DtoMantenimiento.class,DtoCalificacion.class,DtoProgramCalificacion.class,DtoProveedor.class,
		  DtoNotificacion.class,DtoReport.class,PageData.class/*,
		  Indicador.class,
		  Proveedor.class,RegistroCambios.class*/};

}
