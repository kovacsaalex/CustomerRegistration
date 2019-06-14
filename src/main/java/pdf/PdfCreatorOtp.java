package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;

public class PdfCreatorOtp {
    public static void main(String[] args) {

        String name = "Borbás Veronika";
        String motherName = "Radványi";
        String birthDate = "1979.02.26.";
        String birthPlace = "Budapest";

        StringBuilder sr = new StringBuilder(birthDate);

        //sr.append(BLANK_SPACE);
        String pr = sr.substring(0, 5);

        System.out.println(pr);
        Document doc = new Document();


        try {
            //Create PdfReader instance.
            PdfReader pdfReader =
                    new PdfReader("/Users/alex/Documents/Dev_Projects/pdftest/otp_test2.pdf");

          /*  List<String> test = new ArrayList<>();
            test.add(PdfTextExtractor.getTextFromPage(pdfReader,1));
            for (String value : test){
                System.out.println(value);
            }*/



            //Create PdfStamper instance.
            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    new FileOutputStream("/Users/alex/Documents/Dev_Projects/CustomerRegistration/HelloWorld-modified.pdf"));

            //Create BaseFont instance.
            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.COURIER,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            //Iterate the pdf through pages.
            for (int i = 1; i <= pages; i++) {
                //Contain the pdf data.
                PdfContentByte pageContentByte =
                        pdfStamper.getOverContent(i);


                pageContentByte.beginText();
                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 10);
                pageContentByte.setTextMatrix(110, 734);

                //Write text
                pageContentByte.showText(name);

                //
                pageContentByte.setFontAndSize(baseFont, 10);
                pageContentByte.setTextMatrix(130, 710);
                pageContentByte.showText(motherName);
                //
                pageContentByte.setFontAndSize(baseFont, 10);
                pageContentByte.setTextMatrix(100, 695);
                pageContentByte.showText(birthPlace);
                //
                pageContentByte.setFontAndSize(baseFont, 8);
                pageContentByte.setTextMatrix(430, 695);
                pageContentByte.showText(sr.substring(0, 5));
                //
                pageContentByte.setFontAndSize(baseFont, 8);
                pageContentByte.setTextMatrix(500, 695);
                pageContentByte.showText(sr.substring(5, 7));
                //
                pageContentByte.setFontAndSize(baseFont, 8);
                pageContentByte.setTextMatrix(530, 695);
                pageContentByte.showText(sr.substring(8, 10));


                pageContentByte.endText();
            }

            //Close the pdfStamper.
            pdfStamper.close();

            System.out.println("PDF modified successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
