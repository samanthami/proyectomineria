package com.proyectokinesia.Service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import net.sf.jasperreports.engine.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

@Service
@Log
public class InformeSrv {


    private final DataSource dataSource;

    public InformeSrv(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public JasperPrint init(String reportName, Map<String, Object> params) throws JRException, IOException {
        JasperPrint print = null;
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("report/" + reportName);
            print = JasperFillManager.fillReport(stream, params, connection);

        } catch (Exception ex) {
            log.info("Error al generar reporte: "+ ex.getMessage());
        }
        return print;
    }

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
