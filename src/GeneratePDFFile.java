import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class GeneratePDFFile {

    public static void generateHistogram(){

        //generate histogram
    }
    public static void generatePDF(String file_path, String deck_ID, int total_cost, String histogram){

        try{
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file_path)); //write to file
            document.open();
            document.add(new Paragraph("======================================"));
            document.add(new Paragraph("SLAY THE SPIRE DECK COST TALLY REPORT"));
            document.add(new Paragraph("======================================"));
            document.add(new Paragraph("Deck ID: " + deck_ID));
            document.add(new Paragraph("Total Cost: " + total_cost));
            document.add(new Paragraph("Histogram of Cards:"));
            document.add(new Paragraph("----------------------------------------"));


            document.close();

            System.out.println("PDF generated!");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void generateVoidPDF(String file_path, String deck_ID){

        try{
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file_path)); //write to file
            document.open();
            document.add(new Paragraph("======================================"));
            document.add(new Paragraph("SLAY THE SPIRE DECK COST TALLY REPORT"));
            document.add(new Paragraph("======================================"));
            document.add(new Paragraph("Deck ID: " + deck_ID));
            document.add(new Paragraph("VOID"));


            document.close();

            System.out.println("PDF generated!");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        // Specify the path for the PDF file
        String filePath = "/Users/sophiabrix/Desktop/test pdf gen/SpireDeck_.pdf";

        // Call the generatePDF method
        generatePDF(filePath, "703856", 700, "histogram");
    }
}
