
import java.io.*;

public class FlujosFile {
  public static void main (String[] args) throws IOException {
	// Crea un objeto File del archivo "HolaMundo.txt"
	  File fichero = new File("."+ File.separator+ "src"+ File.separator+ "HolaMundo.txt");
	  // Abre el archivo para lectura mediante FileReader
	  FileReader fich = new FileReader(fichero); 
	  
	  int i;	
	  // Crea un array de char para almacenar lo leído
	  char[] frase = new char[14];
	  int longitud=0;
	  // Leer el archivo carácter por carácter hasta el final (-1)
	  while ((i = fich.read()) !=-1) {
		  // Muestra lo leído en la consola
		  System.out.print((char)i);
		  // Almacena el carácter leído en el array 'frase'
		  frase[longitud] = (char) i;
		  longitud++;}
	  
	  // Abre el archivo para escribir
	  FileWriter fichw = new FileWriter(fichero);
	  // Escribe el archivo al revés
	  for (int j=longitud; j>0; j--) {
		  frase[longitud] = (char) j;
		  fichw.write(frase[j]);}// Escribe el carácter en la posición j
		  
	  longitud--;  
	  // Cierra el flujo de lectura
	  fich.close();
	  // Cierra el flujo de escritura
	  fichw.close();
	 
			  
  }
}
