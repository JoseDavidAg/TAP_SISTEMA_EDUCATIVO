/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author ambro
 */


//saber de que curso es
//obtener nombre alumno, grado, grupo, alumnoID, periodo escolar, promedio escolar, fecha de admision, array nombre-materia,calf u1, calf u2, calf u3, calcular promedio
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportCardPDFGenerator {
    inicio inicio = new inicio();
    

    public String generarPDF(String nombre, String id, String grupo, ArrayList<String> materias, ArrayList<String> unidad1, ArrayList<String> unidad2, ArrayList<String> unidad3) throws FileNotFoundException, BadElementException, IOException {
        // Crear un nuevo documento
        Document document = new Document();
        String ruta= nombre + "_BOLETA.pdf";
        
        try {
            // Crear una instancia de PdfWriter para vincular el documento y el flujo de archivo
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
           
            // Abrir el documento para escritura
            document.open();
            
            Image image = Image.getInstance("C:\\Users\\ambro\\OneDrive\\Documentos\\INSTITUTO TECNOLOGICO DE OAXACA\\VERANO\\TOPICOS AVANZADOS DE PROGRAMCIÓN\\logoEducacion.jpg");
            image.scaleToFit(225, 107); // Ajusta el tamaño de la imagen si es necesario

            // Crear el título con la imagen a la izquierda
            Paragraph tituloConImagen = new Paragraph();
            tituloConImagen.add(new Chunk(image, -30, -70)); // Ajusta la posición vertical de la imagen si es necesario
            tituloConImagen.setAlignment(Element.ALIGN_LEFT);
            document.add(tituloConImagen);
            
            Paragraph titulo = new Paragraph("ESCUELA SECUNDARIA TÉCNICA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Font.BOLD, BaseColor.BLACK));
            Paragraph titulo2 = new Paragraph("NO.192", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo2.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(titulo2);
                      
            
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            // Información del estudiante
            Paragraph infoEstudiante = new Paragraph();
            infoEstudiante.setAlignment(Element.ALIGN_LEFT);
            infoEstudiante.add(new Phrase("Nombre del Estudiante: ", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            infoEstudiante.add(new Phrase(nombre, FontFactory.getFont(FontFactory.HELVETICA)));
            infoEstudiante.add(new Phrase("\nNúmero de Control: ", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            infoEstudiante.add(new Phrase(id, FontFactory.getFont(FontFactory.HELVETICA)));
            infoEstudiante.add(new Phrase("\nGrado y Grupo: ", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            infoEstudiante.add(new Phrase(grupo, FontFactory.getFont(FontFactory.HELVETICA)));
            document.add(infoEstudiante);
            
            document.add(new Paragraph(" "));
            
            // Título de la tabla
            Paragraph tablaTitulo = new Paragraph("Lista de Calificaciones", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Font.BOLD, BaseColor.GRAY));
            tablaTitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(tablaTitulo);
            document.add(new Paragraph(" "));
            
            // Crear tabla para la lista de calificaciones
            PdfPTable tablaCalificaciones = new PdfPTable(5);
            
            tablaCalificaciones.setWidthPercentage(100);
            tablaCalificaciones.setSpacingBefore(10f);
            tablaCalificaciones.setSpacingAfter(10f);
            
            float[] columnWidths = {3f, 1f, 1f, 1f, 1f}; // La primera columna es 3 veces más ancha que las otras
            tablaCalificaciones.setWidths(columnWidths);
            
            // Agregar encabezados de la tabla
            PdfPCell cell = new PdfPCell(new Phrase("Materia", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tablaCalificaciones.addCell(cell);
            
            cell = new PdfPCell(new Phrase("U1", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tablaCalificaciones.addCell(cell);
            
            cell = new PdfPCell(new Phrase("U2", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tablaCalificaciones.addCell(cell);
            
            cell = new PdfPCell(new Phrase("U3", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tablaCalificaciones.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Promedio", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tablaCalificaciones.addCell(cell);

            // Agregar datos a la tabla
           
            for (int i = 0; i < materias.size(); i++) {
                // Crear celdas con el contenido centrado
                
                tablaCalificaciones.addCell(materias.get(i));

                PdfPCell cellUnidad1 = new PdfPCell(new Paragraph(unidad1.get(i)));
                cellUnidad1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaCalificaciones.addCell(cellUnidad1);

                PdfPCell cellUnidad2 = new PdfPCell(new Paragraph(unidad2.get(i)));
                cellUnidad2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaCalificaciones.addCell(cellUnidad2);

                PdfPCell cellUnidad3 = new PdfPCell(new Paragraph(unidad3.get(i)));
                cellUnidad3.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaCalificaciones.addCell(cellUnidad3);

                double promedio = inicio.truncarADosDecimales(
                    (Double.parseDouble(unidad1.get(i)) + Double.parseDouble(unidad2.get(i)) + Double.parseDouble(unidad3.get(i))) / 3
                );

                PdfPCell cellPromedio = new PdfPCell(new Paragraph(String.valueOf(promedio)));
                cellPromedio.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaCalificaciones.addCell(cellPromedio);
            }
            
            document.add(tablaCalificaciones);
            
            // Espacio antes de la fecha
            document.add(new Paragraph(" "));
            
            // Agregar la fecha de emisión
            Paragraph fecha = new Paragraph("Fecha de emisión: " + LocalDate.now().toString(), FontFactory.getFont(FontFactory.HELVETICA));
            fecha.setAlignment(Element.ALIGN_RIGHT);
            document.add(fecha);
            
            System.out.println("Se ha generado el PDF exitosamente.");
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("No se ha podido generar el PDF.");
        } finally {
            // Asegúrate de cerrar el documento en el bloque finally
            if (document.isOpen()) {
                document.close();
            }
          
    }
         return ruta;
    }
   
}


