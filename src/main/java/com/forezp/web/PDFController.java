package com.forezp.web;

import com.forezp.utils.ResultUtil;
import com.forezp.vo.Result;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/pdf")
public class PDFController {

    @RequestMapping(value = "/creatPdf", method = RequestMethod.POST)
    public Result creatPdf()throws Exception {
        ResultUtil resultUtil = new ResultUtil<>();
        Result result;
        try {
            Document document = new Document(PageSize.A4, 45, 45, 45, 60);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:\\ITextTest.pdf"));
            writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
            document.open();
            Anchor anchorTarget = new Anchor("First page of the document.");
            anchorTarget.setName("BackToTop");
            Paragraph paragraph1 = new Paragraph();
            paragraph1.setSpacingBefore(50);
            paragraph1.add(anchorTarget);
            document.add(paragraph1);
            document.add(new Paragraph("Some more text on the \\" +
                    " first page with different color and font type.",
                    FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD)));
            document.close();
            result = resultUtil.setSuccessMsg("生成pdf成功");
        } catch (DocumentException e) {
            e.printStackTrace();
            result = resultUtil.setSuccessMsg("生成pdf失败");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result = resultUtil.setSuccessMsg("生成pdf失败");
        }
        return result;
    }
}
