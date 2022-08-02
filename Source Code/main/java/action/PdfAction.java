package action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.CommandDao;
import entity.Command;
import util.HibernateUtil;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfAction extends ActionSupport implements ServletRequestAware, ServletResponseAware,SessionAware, ModelDriven {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<Command> commandes = new ArrayList<>();
	 private Map<String, Object> session;
	private Command cmd=new Command();
	
	
	
	
	
	//Fonction pour avoir facture d'une commande
	public String factureCmd() throws Exception
	{
		if (session.get("user") == null) {
            return "403";
        }
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		CommandDao CmdL = new  CommandDao(sessionFactory);
		Command c= CmdL.getCmdbyCode(cmd.getCodeCmd());
		// Creating document and set the page size
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		String imagePath = ServletActionContext.getServletContext().getRealPath("/Img");
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(imagePath + "/temp1" + ".pdf"));
		document.open();

		// Add image on the document
		Image image = Image.getInstance(imagePath + "/dior1.jpg");
		image.scaleToFit(90f, 90f);
		image.setAlignment(Image.MIDDLE);
		image.setAbsolutePosition(70, 770);
		image.scaleAbsolute(100, 40);
		document.add(image);

		// Creating the paragraph and add it to document
		Paragraph p1 = new Paragraph(" DIOR Gestion de Vente",
				FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new BaseColor(0, 0, 0)));

		Paragraph p2 = new Paragraph("Facture de Commande",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, new BaseColor(0, 0, 0)));
		Paragraph p3 = new Paragraph("\n\n\n");
		p1.setAlignment(Element.ALIGN_CENTER);
		p2.setAlignment(Element.ALIGN_CENTER);
		document.add(p1);
		document.add(p2);
		document.add(p3);
		// Create table and set the width of columns
					PdfPTable t = new PdfPTable(6);
					float widths[] = { 5, 6, 3, 3,3, 6 };
					t.setWidths(widths);
					t.setHeaderRows(1);
					t.setTotalWidth(100f);

					// Add table header row
					PdfPCell c1 = new PdfPCell(new Phrase("Code commande", FontFactory.getFont(FontFactory.HELVETICA, 8)));
					c1.setBorderWidth((float) 0.25);
					c1.setBackgroundColor(new BaseColor(232, 232, 232));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					t.addCell(c1);

					c1 = new PdfPCell(new Phrase("Nom de Client", FontFactory.getFont(FontFactory.HELVETICA, 8)));
					c1.setBorderWidth(0.25f);
					c1.setBackgroundColor(new BaseColor(232, 232, 232));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					t.addCell(c1);

					c1 = new PdfPCell(new Phrase("code Article", FontFactory.getFont(FontFactory.HELVETICA, 8)));
					c1.setBorderWidth(0.25f);
					c1.setBackgroundColor(new BaseColor(232, 232, 232));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					t.addCell(c1);

					c1 = new PdfPCell(new Phrase("quantite", FontFactory.getFont(FontFactory.HELVETICA, 8)));
					c1.setBorderWidth(0.25f);
					c1.setBackgroundColor(new BaseColor(232, 232, 232));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					t.addCell(c1);
					c1 = new PdfPCell(new Phrase("Prix Total", FontFactory.getFont(FontFactory.HELVETICA, 8)));
					c1.setBorderWidth(0.25f);
					c1.setBackgroundColor(new BaseColor(232, 232, 232));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					t.addCell(c1);

					c1 = new PdfPCell(new Phrase("Date Commande", FontFactory.getFont(FontFactory.HELVETICA, 8)));
					c1.setBorderWidth((float) 0.25);
					c1.setBackgroundColor(new BaseColor(232, 232, 232));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					t.addCell(c1);
					
					
					// Add the table details row
					Phrase ph;
		        	  PdfPCell c2;
		  			c2 = new PdfPCell();
		  			c2.setBorderWidth((float) 0.25);
		  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		  			ph = new Phrase(c.getCodeCmd().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		  			c2.addElement(ph);
		  			t.addCell(c2);

		  			c2 = new PdfPCell();
		  			c2.setBorderWidth((float) 0.25);
		  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		  			ph = new Phrase(c.getClient(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		  			c2.addElement(ph);
		  			t.addCell(c2);

		  			c2 = new PdfPCell();
		  			c2.setBorderWidth((float) 0.25);
		  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		  			ph = new Phrase(c.getCodeArt().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		  			c2.addElement(ph);
		  			t.addCell(c2);

		  			c2 = new PdfPCell();
		  			c2.setBorderWidth((float) 0.25);
		  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		  			ph = new Phrase(c.getQteCmd().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		  			c2.addElement(ph);
		  			t.addCell(c2);
		  			
		  			c2 = new PdfPCell();
		  			c2.setBorderWidth((float) 0.25);
		  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		  			ph = new Phrase(c.getPrixTotal().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		  			c2.addElement(ph);
		  			t.addCell(c2);

		  			c2 = new PdfPCell();
		  			c2.setBorderWidth((float) 0.25);
		  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		  			ph = new Phrase(c.getDateCmd().toLocaleString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
		  			c2.addElement(ph);
		  			t.addCell(c2);
		  			response.setHeader("Content-disposition", "inline; filename=\"Commands Rapport.pdf\"");
					document.add(t);
					document.close();
					addPageNumber("temp1.pdf", "newName.pdf", response, request);
		return SUCCESS;
	}
	
	
	
	//Fonction pour avoir tous les commandes sous-forme PDF
	public String allCommands() throws Exception {
		if (session.get("user") == null) {
            return "403";
        }
		try {
			SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
			// Creating document and set the page size
			Document document = new Document(PageSize.A4, 20, 20, 20, 20);
			String imagePath = ServletActionContext.getServletContext().getRealPath("/Img");
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(imagePath + "/temp1" + ".pdf"));
			document.open();

			// Add image on the document
			Image image = Image.getInstance(imagePath + "/dior1.jpg");
			image.scaleToFit(90f, 90f);
			image.setAlignment(Image.MIDDLE);
			image.setAbsolutePosition(70, 770);
			image.scaleAbsolute(100, 40);
			document.add(image);

			// Creating the paragraph and add it to document
			Paragraph p1 = new Paragraph(" DIOR Gestion de Vente ",
					FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new BaseColor(0, 0, 0)));

			Paragraph p2 = new Paragraph("Tous Les Commandes",
					FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, new BaseColor(0, 0, 0)));
			Paragraph p3 = new Paragraph("\n\n\n");
			p1.setAlignment(Element.ALIGN_CENTER);
			p2.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			document.add(p2);
			document.add(p3);

			// Create table and set the width of columns
			PdfPTable t = new PdfPTable(6);
			float widths[] = { 5, 6, 3, 3,3, 6 };
			t.setWidths(widths);
			t.setHeaderRows(1);
			t.setTotalWidth(100f);

			// Add table header row
			PdfPCell c1 = new PdfPCell(new Phrase("Code commande", FontFactory.getFont(FontFactory.HELVETICA, 8)));
			c1.setBorderWidth((float) 0.25);
			c1.setBackgroundColor(new BaseColor(232, 232, 232));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t.addCell(c1);

			c1 = new PdfPCell(new Phrase("Nom de Client", FontFactory.getFont(FontFactory.HELVETICA, 8)));
			c1.setBorderWidth(0.25f);
			c1.setBackgroundColor(new BaseColor(232, 232, 232));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t.addCell(c1);

			c1 = new PdfPCell(new Phrase("code Article", FontFactory.getFont(FontFactory.HELVETICA, 8)));
			c1.setBorderWidth(0.25f);
			c1.setBackgroundColor(new BaseColor(232, 232, 232));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t.addCell(c1);

			c1 = new PdfPCell(new Phrase("quantite", FontFactory.getFont(FontFactory.HELVETICA, 8)));
			c1.setBorderWidth(0.25f);
			c1.setBackgroundColor(new BaseColor(232, 232, 232));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Prix Total", FontFactory.getFont(FontFactory.HELVETICA, 8)));
			c1.setBorderWidth(0.25f);
			c1.setBackgroundColor(new BaseColor(232, 232, 232));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Date Commande", FontFactory.getFont(FontFactory.HELVETICA, 8)));
			c1.setBorderWidth((float) 0.25);
			c1.setBackgroundColor(new BaseColor(232, 232, 232));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t.addCell(c1);

			// Add the table details row
			
	    	  CommandDao CmdL = new  CommandDao(sessionFactory);
	          commandes=CmdL.findAll();
	          commandes.forEach(al->{
	        	  Phrase ph;
	        	  PdfPCell c2;
	  			c2 = new PdfPCell();
	  			c2.setBorderWidth((float) 0.25);
	  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	  			ph = new Phrase(al.getCodeCmd().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
	  			c2.addElement(ph);
	  			t.addCell(c2);

	  			c2 = new PdfPCell();
	  			c2.setBorderWidth((float) 0.25);
	  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	  			ph = new Phrase(al.getClient(), FontFactory.getFont(FontFactory.HELVETICA, 8));
	  			c2.addElement(ph);
	  			t.addCell(c2);

	  			c2 = new PdfPCell();
	  			c2.setBorderWidth((float) 0.25);
	  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	  			ph = new Phrase(al.getCodeArt().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
	  			c2.addElement(ph);
	  			t.addCell(c2);

	  			c2 = new PdfPCell();
	  			c2.setBorderWidth((float) 0.25);
	  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	  			ph = new Phrase(al.getQteCmd().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
	  			c2.addElement(ph);
	  			t.addCell(c2);
	  			
	  			c2 = new PdfPCell();
	  			c2.setBorderWidth((float) 0.25);
	  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	  			ph = new Phrase(al.getPrixTotal().toString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
	  			c2.addElement(ph);
	  			t.addCell(c2);
	  			c2 = new PdfPCell();
	  			c2.setBorderWidth((float) 0.25);
	  			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	  			ph = new Phrase(al.getDateCmd().toLocaleString(), FontFactory.getFont(FontFactory.HELVETICA, 8));
	  			c2.addElement(ph);
	  			t.addCell(c2);

	        	  
	        	  
	          });
			// Finally add all into the document
			response.setHeader("Content-disposition", "inline; filename=\"Commands Rapport.pdf\"");
			document.add(t);
			document.close();
			addPageNumber("temp1.pdf", "newName.pdf", response, request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Method for adding page number on the document
	public static void addPageNumber(String oldFileName, String newFileName, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			String realPath = ServletActionContext.getServletContext().getRealPath("/Img");
			FileInputStream fis = new FileInputStream(realPath + "/" + "temp1.pdf");
			PdfReader reader = new PdfReader(fis);
			int totalPages = reader.getNumberOfPages();
			PdfStamper stamper = new PdfStamper(reader, response.getOutputStream());
			for (int i = 1; i <= totalPages; i++) {
				getHeaderTable(i, totalPages).writeSelectedRows(0, -1, 34, 30, stamper.getOverContent(i));
			}
			stamper.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static PdfPTable getHeaderTable(int x, int y) {
		PdfPTable table = new PdfPTable(2);
		try {
			table.setTotalWidth(490);
			table.setLockedWidth(true);
			table.getDefaultCell().setFixedHeight(20);
			table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

			PdfPCell cell = new PdfPCell(new com.itextpdf.text.Phrase((""),
					new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 5)));
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);

			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

			cell = new PdfPCell(new com.itextpdf.text.Phrase(String.format("Page %d of %d", x, y),
					new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 5)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

			table.addCell(cell);

		} catch (Exception e) {
			System.out.println("getHeaderTable exception" + e.getMessage());
			e.printStackTrace();
		}
		return table;
	}
	
	public Command getModel() {
        return cmd;
    }
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getServletResponse() {
		return response;
	}

}
