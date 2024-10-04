package personajes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tipo {
	public static void main(String[] args) throws IOException {
		final int registro = 110;
File fichero = new File ("." + File.separator + "src" + File.separator + 
	"Marvel.dat"); //se crea el objeto fichero en la ruta
//crea el fichero de acceso aleatorio con permisos de lectura y escritura
RandomAccessFile file = new RandomAccessFile(fichero, "r");
//variables
String tipoConsola, dniFichero, nombreFichero, identidadesFichero, tiposFichero;
int pesoFichero, alturaFichero;
Boolean existeTipo = false;
int contador=0;
//introduce el tipo mediante el teclado
System.out.println("Introduce un tipo de personaje:");
tipoConsola = Consola.readString();

for(int p=0;p<file.length();p+=registro){
file.seek(p); //posiciona en puntero
file.skipBytes(82);//salta bytes
//Recojo el tipo de personaje
char[] auxTipos =new char[10];
for(int i=0;i<10;i++)
{
	auxTipos[i]=file.readChar();
}

tiposFichero = new String(auxTipos).trim();

//Se comprueba si los dos tipos coinciden
if(tiposFichero.equalsIgnoreCase(tipoConsola)){
	existeTipo = true;
	contador++;
	//Se vuelve a la posición inicial del registro
	file.seek(p);
	file.skipBytes(4);//Salto el código
	//Recojo el DNI
	char[] auxDni =new char[9];
	for(int i=0;i<9;i++)
	{
		auxDni[i]=file.readChar();
	}
	dniFichero = new String(auxDni).trim();
		
	//Recojo el nombre
	char[] auxNom =new char[10];
	for(int i=0;i<10;i++)
	{
		auxNom[i]=file.readChar();
	}
	nombreFichero = new String(auxNom).trim();
	
	//Recojo la identidad
	char[] auxIde =new char[20];
	for(int i=0;i<20;i++)
	{
		auxIde[i]=file.readChar();
	}
	identidadesFichero = new String(auxIde).trim();
		
	//Recojo el peso
	pesoFichero = file.readInt();
			
	//Recojo la altura
	alturaFichero = file.readInt();
	
	//Se muestran los datos del personaje
	
	System.out.println("Personaje [dni="+ dniFichero + ", nombre=" + nombreFichero
			+ ", identidad=" + identidadesFichero + ", tipo=" + tiposFichero + ", peso="
			+ pesoFichero + ", altura" + alturaFichero);
}
}
//Comprueba si existe el tipo y muestra el resultado
if(!existeTipo) {
System.out.println("No se ha encontrado ningún personaje del tipo: " + tipoConsola);
}else {System.out.println("Se han encontrado: " + contador + " "+ tipoConsola +"s");}
file.close();

}
}
