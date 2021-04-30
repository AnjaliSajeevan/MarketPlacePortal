/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.pojo.OrderItem;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class PdfView {



    public void createpdf(String file,List<OrderItem> orderItemList) throws DocumentException, FileNotFoundException{
       Document doc = new Document();
       PdfWriter.getInstance(doc, new FileOutputStream(file));
       doc.open();
        Paragraph para = new Paragraph("Order Information", FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, new Color(0, 0, 0)));
        para.setAlignment(1);
        doc.add(para);
        Paragraph para1 = new Paragraph(new Date().toString());
        doc.add(para1);
        doc.add(Chunk.NEWLINE);
        doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------"));
        doc.add(Chunk.NEWLINE);
        doc.add(Chunk.NEWLINE);
        PdfPTable tbl = new PdfPTable(4);
        PdfPCell cell = new PdfPCell(new Phrase("Order Details "));
        cell.setColspan(7);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.cyan);
        tbl.addCell(cell);

        tbl.addCell("OrderItem No.");
        tbl.addCell("Name");
        tbl.addCell("Quantity");
        tbl.addCell("Price");

        for (OrderItem orderitem:orderItemList ) {
            Integer id = orderitem.getOrderItemid();
            String orderid = id.toString();
            String name = orderitem.getProduct().getName();
            Integer quantity = orderitem.getQuantity();
            String quantitys = quantity.toString();
            Double price = orderitem.getPrice();
            String prices = price.toString();

            tbl.addCell(orderid);
            tbl.addCell(name);
            tbl.addCell(quantitys);
            tbl.addCell(prices);

        }
        doc.add(tbl);
        doc.close();
    }
    
    

       
    public ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) throws FileNotFoundException, IOException {
       
        InputStream inputStream = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {

            inputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];
            baos = new ByteArrayOutputStream();
           
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
                
                inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos;
    }


}
