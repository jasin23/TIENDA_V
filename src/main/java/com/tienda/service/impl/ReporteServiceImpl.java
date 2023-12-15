
package com.tienda.service.impl;


import com.tienda.domain.Usuario;
import com.tienda.service.ReporteService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos Solis
 */
@Service
public class ReporteServiceImpl implements ReporteService{

    @Autowired
    private DataSource dataSource;


    public ResponseEntity<Resource> generareporte(String reporte, Map<String, Object> parametros, String tipo) throws IOException {

        try {
            String estilo = tipo.equalsIgnoreCase("vPdf")?
                    "inline; ":"attachment; ";

            String reportePath="reportes";

            ByteArrayOutputStream salida = new ByteArrayOutputStream();

            ClassPathResource fuente = new ClassPathResource(
                    reportePath+
                            File.separator+
                            reporte+
                            ".jasper");

            InputStream elReporte = fuente.getInputStream();

            var reporteJasper = JasperFillManager
                    .fillReport(
                            elReporte,
                            parametros,
                            dataSource.getConnection());

            MediaType mediaType=null;
            String archivoSalida="";

            switch(tipo) {

                case "Pdf","vPdf" -> { // pdf
                    JasperExportManager
                           .exportReportToPdfStream(
                                   reporteJasper, 
                                   salida);
                    mediaType = MediaType.APPLICATION_PDF;
                    archivoSalida=reporte+".pdf";


            }
                case "Xls" -> { // excel
                    JRXlsxExporter paraExcel = new JRXlsxExporter();

                    paraExcel.setExporterInput(
                    new SimpleExporterInput( reporteJasper));

                    paraExcel.setExporterOutput(
                            new SimpleOutputStreamExporterOutput(
                                    salida));

                    SimpleXlsxReportConfiguration configuracion=
                            new SimpleXlsxReportConfiguration();
                    configuracion.setDetectCellType(true);
                    configuracion.setCollapseRowSpan(true);

                    paraExcel.setConfiguration(configuracion);
                    paraExcel.exportReport();

                    mediaType = MediaType.APPLICATION_OCTET_STREAM;
                    archivoSalida=reporte+".xlsx";

            }
                case "Csv" -> { // tipo CSV
                    JRCsvExporter paraCsv = new JRCsvExporter();

                    paraCsv.setExporterInput(
                    new SimpleExporterInput( reporteJasper));

                    paraCsv.setExporterOutput(
                            new SimpleWriterExporterOutput(
                                    salida));


                    paraCsv.exportReport();

                    mediaType = MediaType.TEXT_PLAIN;
                    archivoSalida=reporte+".csv";

            }

         }

           byte[]data=salida.toByteArray();
           HttpHeaders headers = new HttpHeaders();
           headers.set("Content-Disposition", 
                   estilo+"filename=\""+archivoSalida+"\"");

           return ResponseEntity
                   .ok()
                   .headers(headers)
                   .contentLength(data.length)
                   .contentType(mediaType)
                   .body(
                           new InputStreamResource(
                                   new ByteArrayInputStream(data)));


            //
        } catch (JRException | SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Usuario> getUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Usuario usuario, boolean crearRolUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<Resource> generareporte(String reporte, Object object, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}