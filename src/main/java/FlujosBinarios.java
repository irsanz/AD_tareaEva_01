
import java.io.*;
import java.util.Arrays;

public class FlujosBinarios {

	public static void main(String[] args) {
			//Se crea un objeto file aportando la ruta del archivo
	    	File fic = new File ("." + File.separator + "src" + File.separator + "textopdf.pdf");
	    	
	        byte[] pdfcabecero = {37,80,68,70}; //cabecero de pdf
	 
	        try (
	            InputStream ficpdf = new FileInputStream(fic);
	        ) {
	            byte[] cabarchivo = new byte[4]; 
	            ficpdf.read(cabarchivo);
	            //Guarda los 4 primeros bytes del cabecero del archivo de la ruta especificada anteriormente
	            if (!Arrays.equals(cabarchivo, pdfcabecero)) {
	                System.out.println("No se trata de un archivo pdf");
	                System.exit(-1);
	            } else System.out.println("Es un archivo pdf.");
	            //Si los dos arrays son distintos no es un pdf, de lo cantrario sí
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
