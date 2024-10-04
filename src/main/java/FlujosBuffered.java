import java.io.*;

public class FlujosBuffered {

	public static void main(String[] args) {
		try {
			// Se crea un objeto File del archivo "nombres.txt" y otro "cinco.txt"
			File fich = new File("."+ File.separator+ "src"+ File.separator+ "nombres.txt");
			File cinco = new File("."+ File.separator+ "src"+ File.separator+ "cinco.txt");
			// A partir del objeto File creamos el fichero
			try {if (cinco.createNewFile())
				System.out.println("Fichero creado");
			else System.out.println("No se ha podido crear el fichero");}
			catch (Exception ioe) { ioe.getMessage();}	
			//Se crea un objeto bufferedReader para leer el fichero
			BufferedReader fichero = new BufferedReader(new FileReader(fich));
			String linea;
			//Lee cada línea del fichero y la muestra por pantalla
			while ((linea = fichero.readLine())!=null) 
				System.out.println(linea);
				fichero.close();
			//Se crean un objeto bufferedReader para leer el fichero y un bufferedWriter para escribirlo	
			BufferedReader lectura = new BufferedReader(new FileReader(fich));
			BufferedWriter escrito= new BufferedWriter(new FileWriter(cinco));
			String fila;
			while ((fila = lectura.readLine())!=null) {//Lee cada línea hasta que se acaben
				String[] nombres = fila.split(" ");//almacena el contenido de la fila hasta que se encuentra un espacio
				
				//busca los nombres que tengan cinco letras y los escribe en el nuevo documento de texto
				for (String palabra : nombres) {
					if (palabra.length() == 5) {
						escrito.write(palabra);
						escrito.newLine();
					}
				}
			}
			lectura.close();
			escrito.close();
		}
		catch (FileNotFoundException fn) {
			System.out.println("Fichero no encontrado");}
		catch (IOException io) {
			System.out.println ("Error E/S");}
		}
	}

