package main;

import entidades.Cliente;
import entidades.Domicilio;
import entidades.Cliente;
import entidades.Telefono;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import baseDeDatos.UsuariosDAO;




public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Telefono telefono = new Telefono("Laboral", "47639865");
//		Domicilio domicilio = new Domicilio (123, "lavalle", "caba");
//		Cliente cliente = new Cliente("pepe", "juarez", telefono, domicilio, 424234242);
//		System.out.println(telefono);
//		System.out.println(cliente);
		
//		ArrayList<String> lista = new ArrayList<String>();
//		lista.add("hola");
//		lista.add("hola1");
//		lista.add("hola2");
//		lista.add("hola3");
//		System.out.println(lista.isEmpty());
//		
		
//		HashSet<Cliente> clientes = new HashSet<Cliente>();
//		
//		Cliente p = new Cliente();
//		p.setNombre("Martin");
//		
//		Cliente p1 = new Cliente();
//		p1.setNombre("Martin");
//		
//		clientes.add(p);
//		System.out.println(clientes.size());
//		
//
//		clientes.add(p1);
//		System.out.println(clientes.size());
		
		/* 
        Para que funcione correctamente deberá:
        · tener un archivo fuente.txt en el directorio archivosES\entrada
        · tener creado el directorio archivosES\salida
        */

//       // Instancia un objeto File de entrada y otro de salida
//       File inputFile = new File("WebContent/images/imagecafe.png");
//       File outputFile = new File("WebContent/test1/imagecafe.png");
//
//       // Instancia un FileReader y un FileWriter que se encargaran de leer y escribir archivos respectivamente
//       FileReader in = new FileReader(inputFile);
//       FileWriter out = new FileWriter(outputFile);
//
//       // Instancia una variable que contendrá el caracter a leer
//       int unCaracter;
//
//       // Informa que se está copiando el archivo
//       System.out.println("\n\tEl archivo está siendo copiado....");
//
//       // Lee el archivo in y guarda la informacion en el archivo out
//       while ((unCaracter = in.read()) != -1) {
//           out.write(unCaracter);
//       }
//
//       // Cierra los archivos
//       in.close();
//       out.close();
//
//       // Informa que se ha copiado el archivo
//       System.out.println("\tEl archivo ha sido copiado con éxito....\n");
		
		UsuariosDAO u= new UsuariosDAO(null);
		System.out.println(u.IdCliente("glombardo@cronista.com"));
	}

}
