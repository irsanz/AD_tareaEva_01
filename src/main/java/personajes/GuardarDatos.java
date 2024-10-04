package personajes;

import java.io.*;
public class GuardarDatos {

	public static void main(String[] args) throws IOException{
		final int long_registro = 110; //Longitud del registro
		File fichero = new File("."+ File.separator + "src" + File.separator + "Marvel.dat");
		if(fichero.exists()) {
			fichero.delete();
		}
		try {
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		//Arrays con los datos de los personajes
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		StringBuffer bufferDnis = null;
		StringBuffer bufferNoms = null;
		StringBuffer bufferIdentidades = null;
		StringBuffer bufferTipos = null;
		int longitud = ids.length;
		int posicion=0;
		
		for (int i=0;i<longitud;i++) {
			posicion=i*long_registro;
			file.seek(posicion);
			
			file.writeInt(ids[i]);//con ids se identifica al personaje
			
			bufferDnis = new StringBuffer(dnis[i]); //guardamos el dato del dni
			bufferDnis.setLength(9);//9 caracteres para el dni
			file.writeChars(bufferDnis.toString());//inserta el dni
			
			bufferNoms = new StringBuffer(noms[i]); //guardamos el dato del nombre
			bufferNoms.setLength(10);//15 caracteres para el nombre
			file.writeChars(bufferNoms.toString());//inserta el nombre
			
			bufferIdentidades = new StringBuffer(identidades[i]); //guardamos el datos de la identidad
			bufferIdentidades.setLength(20);//15 caracteres para la identidad
			file.writeChars(bufferIdentidades.toString());//inserta la identidad
			
			bufferTipos = new StringBuffer(tipos[i]); //guardamos el dato del tipo
			bufferTipos.setLength(10);//7 caracteres para el tipo
			file.writeChars(bufferTipos.toString());//inserta el tipo
			
			file.writeInt(pesos[i]);//se inserta el peso
			
			file.writeInt(alturas[i]);//se inserta la altura
		}
					
		file.close();
		System.out.println("La carga de los personajes ha terminado correctamente");
			
	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
