/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.diario;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author David Esteban Ortiz Ortiz 
 * @author Camilo Gordillo
 */
public class Diario {

    public static void main(String[] args) {
        // Definir el arry y el scanner
        ArrayList<Entrada> misEntradas= new ArrayList<>();
        Scanner lector= new Scanner(System.in);       

        boolean activo = true;
        
        int nuevoIdEntrada;
            do {
                //menu de opciones 
                System.out.println("========= MENU DE OPCIONES ===========");
                System.out.println("1. Agregar entrada");
                System.out.println("2. Mostrar entrada");
                System.out.println("3. Eliminar entrada");
                System.out.println("4. Modificar entrada");
                System.out.println("5. Finalizar programa");
                System.out.println("------------------------------------------------");

                int opcion = lector.nextInt();
                switch (opcion) {

                    case 1:
                        // capturar la fecha del sistema
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
                        String fecha = formato.format (new Date());
                        if(misEntradas.isEmpty())
                        {
                           nuevoIdEntrada=1;
                        } else {
                        // Obtener el ultimo IdEntrada ingresado y sumarle uno
                            int tamanoLista = misEntradas.size(); 
                            Entrada ultimaEntrada = misEntradas.get(tamanoLista - 1);
                            nuevoIdEntrada = ultimaEntrada.getIdEntrada()+ 1;
                        }
                        System.out.println("Ingrese la descripción de la entrada ");
                        lector.nextLine(); 
                        
                        String descripcion = lector.nextLine();
                        // Creación del objeto
                        Entrada miEntrada = new Entrada(nuevoIdEntrada, fecha, descripcion);
                        misEntradas.add(miEntrada);
                                                       
                        break;
                    case 2:
                        //Mostrar entradas
                        for(Entrada e: misEntradas)
                        {  
                            System.out.println("ID: "+e.getIdEntrada());
                            System.out.println("Fecha: "+e.getFecha());
                            System.out.println("Descripción: "+e.getDescripcion());
                            System.out.println("----------------------------------");
                        }
                        break;
                    case 3:
                        //Eliminar entrada
                        System.out.println("Ingresa el ID de la entrada que deseas eliminar: ");
                        int id = lector.nextInt();
                        // iterador para buscar en el arraylist
                        Iterator<Entrada> it = misEntradas.iterator();
                        while(it.hasNext())
                        {
                           Entrada e =(Entrada) it.next();
                           if(e.getIdEntrada()==id)
                               it.remove();                 
                        }
                        System.out.println("¡Entrada eliminada exitosamente!");
                        break;
                    case 4:
                        //Modificar entrada
                        System.out.println("Ingresa el id de la entrada que deseas modificar: ");
                        int id2 = lector.nextInt();
                        
                        System.out.println("Ingresar una nueva descripción:");
                        lector.nextLine();
                        String nuevaDescripcion = lector.nextLine();
                        
                        Iterator<Entrada> it2 = misEntradas.iterator();
                        while(it2.hasNext())
                        {
                           Entrada e =(Entrada) it2.next();
                           if(e.getIdEntrada()==id2)
                               e.setDescripcion(nuevaDescripcion);
                        }
                        System.out.println("¡ENTRADA MODIFICADA EXITOSAMENTE!");
                        
                        break;
                    case 5:
                        activo = false;
                        System.out.println("PROGRAMA TERMINADO");
                        break;
                    default:
                        System.out.println("Opción no válida, inténtelo nuevamente");
                }
            } while (activo);
    }
}
