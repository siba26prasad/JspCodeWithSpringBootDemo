package tech.csm.pdf;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tech.csm.entity.BatchDetailsBean;

public class PdfGeneratorBatchDetails {
public void generate(List <BatchDetailsBean> batchDetailsList, HttpServletResponse response) throws DocumentException, IOException {
    // Creating the Object of Document
    Document document = new Document(PageSize.A4);
    // Getting instance of PdfWriter
    PdfWriter.getInstance(document, response.getOutputStream());
    // Opening the created document to change it
    document.open();
    // Creating font
    // Setting font style and size
    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
    fontTiltle.setSize(20);
    // Creating paragraph
    Paragraph paragraph1 = new Paragraph("Mark Details", fontTiltle);
    // Aligning the paragraph in the document
    paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
    // Adding the created paragraph in the document
    document.add(paragraph1);
    // Creating a table of the 4 columns
    PdfPTable table = new PdfPTable(9);
    // Setting width of the table, its columns and spacing
    table.setWidthPercentage(110f);
    table.setWidths(new int[] {2,4,4,4,4,4,2,3,3});
    table.setSpacingBefore(5);
    // Create Table Cells for the table header
    PdfPCell cell = new PdfPCell();
    // Setting the background color and padding of the table cell
    cell.setBackgroundColor(CMYKColor.ORANGE);
    cell.setPadding(6);
    // Creating font
    // Setting font style and size
    Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
    font.setColor(CMYKColor.BLACK);
    // Adding headings in the created table cell or  header
    // Adding Cell to table
    cell.setPhrase(new Phrase("Slno", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Batch Name", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Batch Start Date", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Technology Name", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Employee Name", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Employee Phone", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Mark", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Grade", font));
    table.addCell(cell);
    cell.setPhrase(new Phrase("Status", font));
    table.addCell(cell);
    int i =1;
    for (BatchDetailsBean batchDetails: batchDetailsList) {
      table.addCell(String.valueOf(i));
      table.addCell(batchDetails.getBatchName());
      table.addCell(batchDetails.getBatchStartDate());
      table.addCell(batchDetails.getTechnologyName());

      table.addCell(batchDetails.getEmployeeName());
      table.addCell(batchDetails.getEmployeePhone());
      table.addCell(batchDetails.getMark());
      table.addCell(batchDetails.getGrade()); 
      table.addCell(batchDetails.getStatus());
      i++;
      
    }
    // Adding the created table to the document
    document.add(table);
    // Closing the document
    document.close();
  }
}
