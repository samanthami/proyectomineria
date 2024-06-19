package com.proyectokinesia.Service;

import com.proyectokinesia.Exception.CustomException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Locale;
import java.util.Map;

@Service
@Log
public class InformeSrv {


    private final DataSource dataSource;

    public InformeSrv(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public JasperPrint init(String reportName, Map<String, Object> params) throws  CustomException {
        JasperPrint print ;
        Connection connection = DataSourceUtils.getConnection(dataSource);
        Locale locale = new Locale("es", "ES"); // Español, España
        params.put(JRParameter.REPORT_LOCALE, locale);
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("report/" + reportName);
            print = JasperFillManager.fillReport(stream, params, connection);

        } catch (Exception ex) {
            throw new CustomException( ex.getMessage());
        }
        return print;
    }
     @Async
    public void writePdfReport(JasperPrint jp, HttpServletResponse response, final String reportName) throws IOException, JRException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=" + (reportName == null ? jp.getName() : reportName).replace('"', '_') + ".pdf");

        OutputStream outStream = response.getOutputStream();
        final byte[] pdfBytes = JasperExportManager.exportReportToPdf(jp);

        response.setContentLength(pdfBytes.length);
        final ByteArrayInputStream bais = new ByteArrayInputStream(pdfBytes);
        IOUtils.copy(bais, outStream);

        outStream.flush();

        IOUtils.closeQuietly(bais);
        IOUtils.closeQuietly(outStream);
    }
}
