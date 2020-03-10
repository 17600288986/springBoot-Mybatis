package com.forezp.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 * @MethodName: pdf页码
 * @Param:
 * @Return:
 * @Author: gxw
 * @Date: 2019/9/3
 **/
public class TableFooter extends PdfPageEventHelper {


    String header;
    PdfTemplate total;

    public void setHeader(String header) {
        this.header = header;
    }

    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }

    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable table = new PdfPTable(3);
        try {
            table.setWidths(new int[]{24, 24, 2});
            table.setTotalWidth(505);
            table.setLockedWidth(true);
            table.getDefaultCell().setFixedHeight(20);
            table.getDefaultCell().setBorder(Rectangle.TOP);
            table.getDefaultCell().setBorderWidth(2);
            table.getDefaultCell().setBorderColor(BaseColor.BLACK);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(header);
            table.addCell(String.format("%d/", writer.getPageNumber()));
            PdfPCell cell = new PdfPCell(Image.getInstance(total));
            cell.setBorder(Rectangle.TOP);
            cell.setBorderWidth(2);
            cell.setBorderColor(BaseColor.BLACK);
            table.addCell(cell);
            table.writeSelectedRows(0, -1, 45, 45, writer.getDirectContent());

        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber())), 0, 2, 0);
    }

}