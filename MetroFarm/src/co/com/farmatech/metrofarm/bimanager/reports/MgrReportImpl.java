package co.com.farmatech.metrofarm.bimanager.reports;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.commons.io.FileUtils;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoReport;

public class MgrReportImpl implements MgrReportService{

	final String logo = getClass().getClassLoader().getResource("co/com/farmatech/metrofarm/reports/logo.png").toString();
	final String banner = getClass().getClassLoader().getResource("co/com/farmatech/metrofarm/reports/farma_reporte.png").toString();
	
	@Override
	public DtoReport createCalibrationForEquipment(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="CalibracionEquipo.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("CalibracionEquipo", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}catch (Exception e) {
			throw new JankinsMarshallException(e);
			// TODO: handle exception
		}
		
         
		return reporte;
	}
	
	@Override
	public DtoReport createCalibrationForMonth(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="CalibracionMes.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("CalibracionMes", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}
	
	@Override
	public DtoReport indicatorCalibration(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="IndicadorCalibracion.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("IndicadorCalibracion", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}
	
	@Override
	public DtoReport indicatorCalification(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="IndicadorCalificacion.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("IndicadorCalificacion", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}
	
	@Override
	public DtoReport indicatorMaintenanceGeneral(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="IndicadorMantenimientoGen.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("IndicadorMantenimientoGen", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}
	
	@Override
	public DtoReport maintenanceEquipment(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="MantenimientoEquipo.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("MantenimientoEquipo", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}
	
	@Override
	public DtoReport maintenanceGeneralMonth(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="MantenimientoGeneralMes.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("MantenimientoGeneralMes", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}	
	
	@Override
	public DtoReport maintenanceMonth(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="MantenimientoMes.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("MantenimientoMes", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}	

	@Override
	public DtoReport maintenanceMonthGeneral(DtoReport reporte) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		
		String reportName="report1.jasper";
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(reporte.getFechaReporte());
		 File file=null;
		
		 Map<String, Object> parametros = new HashMap();
		 parametros.clear();
         parametros.put("Year", calendar.get(Calendar.YEAR)+"");
         parametros.put("Logo", logo);
         parametros.put("Banner", banner);
         try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/com/farmatech/metrofarm/reports/" + reportName), parametros, datasource.getConexion());
			JRExporter ex = new JRPdfExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            file=File.createTempFile("report1", ".tmp");
            file.deleteOnExit();
            ex.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            ex.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
            reporte.setFileReporte(FileUtils.readFileToByteArray(file));
         } catch (JRException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
		
         
		return reporte;
	}		
	

}
