import java.util.Scanner;
import Clases.ResultadoLogin;

import Logica.Logica;

public class Biblioteca_Main {
   private static Scanner scanner = new Scanner(System.in);
   private static Logica logica = new Logica();
   

   public static void main(String[] args){

      //logica.imprimir();

      int opcion=0;

      do{

         System.out.println("Bienvenido a la biblioteca de Markhan School.");
         System.out.println("1. Iniciar sesión.");
         System.out.println("2. Salir");
         
         try{

            opcion=Integer.parseInt(scanner.nextLine());

            switch (opcion) {
               case 1:
               OpcionIniciarSesion();
                  break;
             
               default:
                  break;
            } 

         }catch(NumberFormatException e){
            System.out.println("Ingrese un valor válido.");
         }


      }while(opcion !=2);

   }
         public static void OpcionIniciarSesion(){

            int opcion=0;

            do{
          System.out.println(" Bienvenido a la biblioteca de Markhan School.");
          System.out.println("1. Administrativo");
          System.out.println("2. Estudiante.");
          System.out.println("3.Salir.");

          try{
            opcion=Integer.parseInt(scanner.nextLine());

            switch (opcion) {
               case 1:

               ResultadoLogin resultado= logica.LoginUsuarioAdmin();
               System.out.println("Main 1: " + resultado );
               if (resultado.esValido) {
                 String privilegio = resultado.privilegio;
               System.out.println("Main privilegio: " +  privilegio );
                 if(privilegio != null){
                   if(privilegio.equalsIgnoreCase("A")) {
                       OpcionesAdmin(scanner);
                   }
                   if(privilegio.equalsIgnoreCase("B")){
                    opcionEstudiante(scanner);
                  }
               System.out.println("Privilegio no reconocido.");
              }
          } else {
             System.out.println("Credenciales incorrectas.");
        }
      

                break;
      
                case 2:
                boolean validar2= logica.validarUsuarioEstudiante();
                if(validar2){
                  opcionEstudiante(scanner);
                }else{
                  System.out.println("Credenciales incorrectas.");
                }
                break;
               default:
               break;
      
         }}catch(NumberFormatException e){
            System.out.println("Ingrese un valor válido.");
         }
         }while(opcion !=3);

      }
      public static void OpcionesAdmin(Scanner scanner){

         int opcion=0;

         do{

            System.out.println("Gestión de trabajo 'Colegio Markham'");
            System.out.println("1. Biblioteca.");
            System.out.println("2. Libro.");
            System.out.println("3. Salir.");
            try{

               opcion=Integer.parseInt(scanner.nextLine());

               switch (opcion) {
                  case 1:
                     OpcionBiblioteca(scanner);
                     break;
                     case 2:
                      opcionLibro(scanner);
               
                  default:
                     break;
               }

            }catch(NumberFormatException e){
               System.out.println("Inserte un valor válido.");
            }
         }while(opcion !=3);
      }

      public static void opcionEstudiante(Scanner scanner){

         int opcion=0;
         do{
         System.out.println("Bienvenido " );
         System.out.println("1. Solicitar préstamo.");
         System.out.println("2. Salir.");

         try{
            opcion=Integer.parseInt(scanner.nextLine());

            switch (opcion) {
               case 1:
                  
                  break;
            
               default:
                  break;
            }



         }catch(NumberFormatException e){
            System.out.println("Ingrese un valor válido.");
         }
        
      }while(opcion != 2);
   






      }


    public static void OpcionBiblioteca(Scanner scanner){
      int opcion=0; 
      do{
         System.out.println("=== Gestión de trabajo 'Colegio Markham' ===");
            System.out.println("1. Crear una biblioteca.");
            System.out.println("2. Menú mostrar bibliotecas.");
            System.out.println("3. Editar biblioteca.");
            System.out.println("4. Eliminar biblioteca.");
            System.out.println("5. Búsqueda de un libro.");
            System.out.println("6. Prestar Libro.");
            System.out.println("7. Recibir libro préstado.");
            System.out.println("8. Salir.");
            System.out.print("Ingrese una opción: ");

            try{
               opcion=Integer.parseInt(scanner.nextLine());
            switch (opcion) {
               case 1:
                  logica.crearBiblioteca();
                  break;

               case 2:
                  logica.menuMosstrarBiblioteca();
                  break;
               case 3: logica.OpcionesEditar();
                  break;
               case 4: logica.eliminarBiblioteca();
               break;
               case 5:
               logica.MostrarLibros();
               break;
               
            
            
               default:
                  break;
            }
         }catch(NumberFormatException e){
            System.out.println("Ingrese un número válido");
         }
      }while(opcion != 8);
    }

    public static void opcionLibro(Scanner scanner){

      int opcion=0;

      do{

         System.out.println("=== Gestión de trabajo 'El Virrey' ===");
            System.out.println("1. Añadir libro");
            System.out.println("2. Menú mostrar libros existentes.");
            System.out.println("3. Editar libro.");
            System.out.println("4. Eliminar libro.");
            /*System.out.println("5. Búsqueda de un libro.");
            System.out.println("6. Prestar Libro.");
            System.out.println("7. Recibir libro préstado.");*/
            System.out.println("5. Salir.");
            System.out.print("Ingrese una opción: ");

            try{

               opcion=Integer.parseInt(scanner.nextLine());

               switch (opcion) {
                  case 1:
                        logica.AñadirLibro();
                     break;
                  case 2:
                     logica.MostrarLibros();
                     break;
                  case 3:
                  logica.editarLibro();
                  break;
                  case 4:
                  logica.eliminarLibro();
                  break;
                  case 5:
                  return;
                  default:
                     break;
               }


            }catch(NumberFormatException e){

            System.out.println("Introduzca un valor válido.");
            }






      }while(opcion != 5);


   }
    }


