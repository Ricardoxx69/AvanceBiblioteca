package Logica;
import  Clases.Biblioteca;
import  Clases.Libro;
import Clases.ResultadoLogin;
import Clases.UsuarioAdmin;
import Clases.UsuarioEstudiante;
import Clases.Usuario;
import  java.util.Scanner;
import java.util.ArrayList;


/* ---------------------------- */

/* INICIO DE INICIAR SESIÓN. */

/*GENERAR MENÚ DE MOSTRAR PARA BIBLIOTECA.
 */

public class Logica {
    Scanner scanner = new Scanner(System.in);

    public  ArrayList<Biblioteca> biblioteca = new ArrayList<>();
    public  ArrayList<Libro> libro = new ArrayList<>();
    public ArrayList<UsuarioAdmin> admin = new ArrayList<>();
    private UsuarioAdmin usuarioActivo;
    public ArrayList<UsuarioEstudiante> estudiante = new ArrayList<>();
    public ArrayList<ResultadoLogin> resultado= new ArrayList<>();
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    
 public Logica(){
  usuarios.add(new UsuarioAdmin(1, "Ricardo1", "Chimoy1","A","Atención al cliente","Administrador"));
  usuarios.add (new UsuarioAdmin(2,"Ricardo","Chimoy1", "B","Atención al cliente", "Admisión"));
  usuarios.add(new UsuarioAdmin(3,"Mario","Chaval1", "B","Atención al cliente", "Admisión"));
    
  usuarios.add(new UsuarioEstudiante(1, "Alberto", "Castillo1","Estudiante","Alejandro","Gomez","Contabilidad"));
    }

    

     public void imprimir(){

        System.out.println("Nombre: " + admin.get(1));
        

     }

     public ResultadoLogin LoginUsuarioAdmin(){

        int idUsuario= ValidarUsuarioAdmin();
        int contraseñaA= validarContraseñaUsuarioA(idUsuario);
        
              for(UsuarioAdmin ad: admin){
                 if(ad.getId()== idUsuario){
                if(idUsuario == contraseñaA) {
                        usuarioActivo=ad;
                  return  new ResultadoLogin(true,ad.getId(), ad.getPrivilegio());
                }
            }
        }
                     
       return new ResultadoLogin(false, -1, null);  
        
}

    public int ValidarUsuarioAdmin(){

            System.out.println("Ingrese el usuario por favor.");

        String nombreLog=scanner.nextLine();
        int idUsuario=0;

        if(nombreLog.isEmpty()){
                System.out.println("El nombre de usuario esta vacío.");
        }
           
            for(UsuarioAdmin ad : admin){
           
           if(ad.getUsuario().equals(nombreLog)){
           System.out.println("Resultado 2: " + ad);
           
            // Si es Ricardo todo sus datos.
                // idGenerar=ad.getId();// 1 la primera vez, 2, 3
                 //System.out.println("Id de cambio: " + idGenerar);
                 idUsuario= ad.getId();
                 return idUsuario;
                 }
              
        
        }
        
        //System.out.println("Usuario incorrecto");
           return idUsuario;
    }

      public int validarContraseñaUsuarioA(int idUsuario){

        int idContraseña=0;
        System.out.println("Ingrese la contraseña por favor.");
                String contraseñaLog= scanner.nextLine();
                if(contraseñaLog.isEmpty()){
                    System.out.println("La contraseña esta vacía.");
                }
                for(UsuarioAdmin ad: admin){
                if(ad.getContraseña().equals(contraseñaLog)){

                    System.out.println("Resultado " + ad);
                    idContraseña= ad.getId();
                    System.out.println("Resultado 2: " + idContraseña);
                    
                }
                if( idUsuario != idContraseña ){
                    System.out.println("Credenciales incorrectas.");
                    }else{
                    System.out.println("Credenciales correctas");
                      
          }
        }
        
        System.out.println("Id: " + idContraseña);
         return idContraseña;
      }

public Boolean validarUsuarioEstudiante(){
    
    System.out.println("Ingrese el nombre de usuario.");
    String nombreLog=scanner.nextLine();

    if(nombreLog.isEmpty()){
        System.out.println("El nombre de usuario esta vacío.");
    }
    for(UsuarioEstudiante ue : estudiante){
          if(ue.getNombre() !=null && ue.getNombre().equals(nombreLog)){
        
           System.out.println("Ingrese la contraseña del usuario.");
           String contraseñaLog= scanner.nextLine();

           if(contraseñaLog.isEmpty()){
            System.out.println("Ingrese una contraseña válida.");
           }
           if(ue.getContraseña() != null && ue.getContraseña().equals(contraseñaLog)){
            return true;
           }
          }
    }
    return false; //return "Nombre incorrecto";
}


/* ---------------------------- */

/* INICIO DE BIBLIOTECA. */

/*GENERAR MENÚ DE MOSTRAR PARA BIBLIOTECA.
 */

    public void crearBiblioteca(){

        String nombre= generarNombreBiblioteca(scanner);

        if(biblioteca.stream().anyMatch(b -> b.getNombreBiblioteca() != null && b.getNombreBiblioteca().equalsIgnoreCase(nombre))){
        System.out.println("El nombre ya existe, pruebe con uno nuevo.");
        return;
        }
        String direccion = nombreDireccion(scanner);
        if(biblioteca.stream().anyMatch(b -> b.getDireccion() != null && b.getDireccion().equalsIgnoreCase(direccion))){
            System.out.println("El nombre de la dirección ya existe.");
            return;
        }

        Biblioteca biblio = new Biblioteca(0, nombre, direccion);
        biblioteca.add(biblio);

        System.out.println("Feddback de producto: ");
        System.out.println("");
        System.out.println("El número de biblioteca es: " + biblio.getId_Biblioteca());
        System.out.println("El nombre de la biblioteca es: " + nombre);
        System.out.println("El nombre de la dirección es: " + direccion);
        System.out.println("");
        System.out.println("Biblioteca agregada correctamente.");
      


    }
    public String generarNombreBiblioteca(Scanner scanner){

        System.out.println("Por favor ingrese el nombre de la nueva biblioteca.");

        while(true){
        String nombre=scanner.nextLine().trim();

        if(nombre.isEmpty()){
            System.out.println("El nombre esta vacío.");
        }
        else if(nombre.length() < 4){
            System.out.println("El nombre debe de tener al menos 5 caracteres");
        }
        else{
            return nombre;
        }
    }
}
 
    public String nombreDireccion(Scanner scanner){

        System.out.println("Por favor ingrese la dirección de la nueva biblioteca.");

        while(true){
            
           String direccion=scanner.nextLine().trim();

          if(direccion.isEmpty()){
            System.out.println("La dirección esta vacía.");
          }
          else if(direccion.length() < 5){
             System.out.println("Ingrese mas de 5 caracteres");
          }
          else{
            return direccion;
          }

        }
    }

    public void menuMosstrarBiblioteca(){


        int opcion=0;

        do{

         System.out.println("Menú de Búsqueda de Bibliotecas.");
         System.out.println("1. Mostrar todas las bibliotecas.");
         System.out.println("2. Mostrar biblioteca por ID.");
         System.out.println("3. Salir.");

         try{
            opcion=Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1:
                    monstrarBiblioteca();
                    break;
                case 2: mostrarBibliotecaPorID();
            
                default:
                    break;
            }


         }catch(NumberFormatException e){
            System.out.println("Ingrese un valor válido.");
         }
        }while(opcion != 3);



    }
    public void monstrarBiblioteca(){

         if(biblioteca.isEmpty()){
            System.out.println("No hay bibliotecas existentes.");
            return;
         }
            System.out.println("Bibliotecas existente:");
            System.out.println("");
            for(int i=0; i<biblioteca.size(); i++){
                 System.out.println((i+1) + "." + biblioteca.get(i));
            }
         }

         public void mostrarBibliotecaPorID(){

           int id=0;

           System.out.println(" Ingrese el id del libro a buscar");
         
           try{
           id=Integer.parseInt(scanner.nextLine());

           for(Biblioteca biblio : biblioteca ){
            if(biblio.getId_Biblioteca() == id){
                 System.out.println("Biblioteca encontrada: " + biblio);
            }else{
                System.out.println("El id de la biblioteca no existe.");
            }
           }
        }catch(NumberFormatException e){
            System.out.println("Ingrese un valor válido.");
        }
         }

    public  void OpcionesEditar(){

        int id=0;

        if(biblioteca.isEmpty()){
            System.out.println("No existe ninguna biblioteca en el sistema");
            return;
        }
       
        do{
        System.out.println("Ingrese el número de id de la biblioteca que desea editar o pulse 0 para salir.");

      if(biblioteca.isEmpty()){
         System.out.println("No hay bibliotecas añadidas.");
         return;
      }
      try{
         id=Integer.parseInt(scanner.nextLine());

        for(Biblioteca validar : biblioteca){
            if(validar.getId_Biblioteca()==id){
              int opcion=0;
      do{
        /*Sub menú editar datos:
         * Cada case tiene un método para que así, si este método retorna falso, te retorne al menú de editar
         *  y no al menú principal de Biblioteca
         */
         System.out.println("=== Editar datos 'El Virrey'  ===");
         System.out.println("Biblioteca: " + validar.getNombreBiblioteca() + "Id: " + id);
            System.out.println("1. Editar nombre.");
            System.out.println("2. Editar dirección.");
            System.out.println("3. Editar todos los datos.");
            System.out.println("4. Salir.");
            System.out.print("Ingrese una opción: ");

            try{
                opcion=Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                   nuevoNombre();
                        break;
                    
                    case 2:
                    nuevaDireccion();
                    break;
                    
                    case 3:

                    EditarTodoBiblioteca();

                    break;
                     
                  case 4:
                  System.out.println("");
                  return;
                
                    default:
                    System.out.println("Ingresa una de la opciones del 1 al 4.");
                        return;
                }
            }catch(NumberFormatException e){
                System.out.println("Ingrese un dato válido.");
                return;
            }

            
      }while(opcion != 4);

    } else{
        System.out.println("El número de id no existe, intente con otro.");
        break;
    }
    
}
      }catch(NumberFormatException e){
        System.out.println("Ingrese un valor válido.");
    }
    }while(id != 0);
}

/*Aquí se crea un nuevoNombre, porque es necesario verificar si el nuevo nombre de la Biblioteca ya existe.
 * Si se trabajará con el método de generarNombre, no se podría realizar el trabajo de verificar si el nombre ya existe.
*/
public String nuevoNombre(){

    for(Biblioteca validar : biblioteca){
                    String nuevoNombre= generarNombreBiblioteca(scanner);
                    if(biblioteca.stream().anyMatch(b -> b.getNombreBiblioteca() !=null && b.getNombreBiblioteca().equalsIgnoreCase(nuevoNombre))){
                        return "El nombre ya existe.";
                        
                    }
                     validar.setNombreBiblioteca(nuevoNombre);
                     System.out.println("El nombre fue cambiado con exitó.");
                     return "Nombre: " + nuevoNombre;
                }
                return null;
            }
public String  nuevaDireccion(){
                    
    for(Biblioteca validar: biblioteca){
                    String nuevaDireccion= nombreDireccion(scanner);
                    if(biblioteca.stream().anyMatch(b -> b.getDireccion() != null && b.getDireccion().equals(nuevaDireccion))){
                        return  "El nombre de la dirección es la misma, prueba con una nueva.";
                        
                    }
                    validar.setDireccion(nuevaDireccion);
                    System.out.println("El nombre de la dirección fue cambiada con exito.");
                    return "Dirección: "+ nuevaDireccion;
                    
                }
                return null;
            }
public  void EditarTodoBiblioteca(){

    String nuevoNombre = nuevoNombre();
    String nuevaDireccion = nuevaDireccion();

    System.out.println("Los datos fueron cambiados con éxito.");
    System.out.println("Nuevo nombre: " + nuevoNombre);
    System.out.println("Nueva direción: " + nuevaDireccion);
}

    public  void eliminarBiblioteca(){

        System.out.println("Ingrese el id de la biblioteca a eliminar.");
        while(true){

            try{
                int busquedaId=Integer.parseInt(scanner.nextLine());
                String opcion="";
        
            for(Biblioteca validar : biblioteca){
                if(validar.getId_Biblioteca() == busquedaId){
                    System.out.println("Coloque S/N");
                    opcion=scanner.nextLine().trim();
                    if(opcion.equalsIgnoreCase("S")){
                        biblioteca.remove(validar);
                        System.out.println("La biblioteca ha sido eliminada.");
                        return;
                    }else if(opcion.equalsIgnoreCase("N")){
                        return;
                    }else{
                        System.out.println("Solo coloque S/N");
                    }

                }
            }
        
          }catch(NumberFormatException e){
            System.out.println("Ingrese un valor válido.");
          }

        }
    }

    /* -------------------------------------------------------------------------------------- */
    /* INICIO DE LIBRO */
    /* -------------------------------------------------------------------------------------- */

    public void AñadirLibro(){

        String nombreLibro = generarNombreLibro();
        if(libro.stream().anyMatch(l -> l.getTitulo() != null && l.getTitulo().equals(nombreLibro))){
          System.out.println("El nombre del libro ya existe, prueba con otro.");
          return;
        }
        String editorial=generarEditorial();
        String estado = generarEstadoDeLibro();
        String formato = generarFormato();
        String encuadernacion = generarEncuadernacion();
        String dimensiones = generarDimensiones();
        int año = generarAño();
        int numeroPaginas=generarNumeroPaginas();
        int stock = generarStock();
        String genero=generarGenero();

        Libro nuevo = new Libro(0,nombreLibro,editorial, estado, formato, encuadernacion, dimensiones, año,numeroPaginas, stock, genero);
        libro.add(nuevo);

        System.out.println("Libro agregado exitosamente.");
        System.out.println("ISBN" + nuevo.getISBN());
        System.out.println("Título: " + nombreLibro);
        System.out.println("Editorial: " + editorial);
        System.out.println("Estado: " + estado );
        System.out.println("Formato: " + formato);
        System.out.println("Encuadernación: " + encuadernacion);
        System.out.println("Dimensiones: " + dimensiones);
        System.out.println("Año: " + año);
        System.out.println("Número de páginas: " + numeroPaginas);
        System.out.println("Stock:" + stock);
        System.out.println("Género: " + genero);

    }

    public String generarNombreLibro(){

        String nombre="";

        while(true){

         System.out.println("Ingrese el título del libro");

         nombre=scanner.nextLine().trim();

         if(nombre.length()<2){
            System.out.println("Ingrese más de 2 carácteres.");
         }
         else if(nombre.isEmpty()){
            System.out.println("El título del libro esta vacío.");
         }
         else{
            return nombre;
         }
         

        }
    }
    public String generarEditorial(){
        String nombre="";

        while(true){

         System.out.println("Ingrese la editorial del libro");

         nombre=scanner.nextLine().trim();

         if(nombre.length()<2){
            System.out.println("Ingrese más de 2 carácteres.");
         }
         else if(nombre.isEmpty()){
            System.out.println("El título del libro esta vacío.");
         }
         else{
            return nombre;
         }
         

        }
    }
    public String generarEstadoDeLibro(){

        String[] estado={"Nuevo", "Conservardo","Usado","Antiguo","Null"};

        int ingresoEstado=0;

        while(true){

         System.out.println("Estado del libro");
         System.out.println("1. Nuevo");
         System.out.println("2. Conservado");
         System.out.println("3. Usado");
         System.out.println("4. Antiguo");
         System.out.println("5. Null");

         try{

         ingresoEstado=Integer.parseInt(scanner.nextLine());

         switch (ingresoEstado) {
            case 1:
             return estado[0];
                
            case 2:
                return estado[1];
            
            case 3:
            return estado[2];
            
            case 4: 
            return estado[3];

            case 5:
            return estado[4];

            default:
            System.out.println("Ingrese un número válido de la lista.");
            break;
         }

        }catch(NumberFormatException e){
            System.out.println("Ingrese un formato numeral válido.");
        }
        }
    }

    public String generarFormato(){

        String[] formato={"Libro Físico", "Digital"};

        int ingresoFormato=0;

         while(true){

         System.out.println("Formato del libro");
         System.out.println("1. Libro Físico");
         System.out.println("2. Digital");

         try{

            ingresoFormato=Integer.parseInt(scanner.nextLine());

            switch (ingresoFormato) {
                case 1:
                    
                  return formato[0];

                  case 2:
                  return formato[1];
            
                default:
                System.out.println("Ingrese una opción válida.");
                    break;
            }


         }catch(NumberFormatException e){
            System.out.println("Ingrese un formato de tipo número.");
         }
    }
   }

   public String generarEncuadernacion(){

    String[] encuadernacion={"Tapa Rústica", "Tapa dura"};

        int ingresoEncuadernacion=0;

         while(true){

         System.out.println("Encuadernación del libro");
         System.out.println("1. Tapa Rústica");
         System.out.println("2. Tapa Dura");

         try{

            ingresoEncuadernacion=Integer.parseInt(scanner.nextLine());

            switch (ingresoEncuadernacion) {
                case 1:
                    
                  return encuadernacion[0];

                  case 2:
                  return encuadernacion[1];
            
                default:
                System.out.println("Ingrese una opción válida.");
                    break;
            }


         }catch(NumberFormatException e){
            System.out.println("Ingrese un formato de tipo número.");
         }
    }

   }

   public String generarDimensiones(){

     String dimensiones="";

     System.out.println("Ingrese las dimensiones del libro : 1cm x 1cm(Ejemplo)");
     while(true){

        dimensiones=scanner.nextLine().trim();

        if(dimensiones.length() < 5){
            System.out.println("Guiese del ejemplo.");
        }
        else if(dimensiones.isEmpty()){
            System.out.println("Las dimensiones están vacías.");
        }else{
            return dimensiones;
        }


     }

   }

   public int generarAño(){

      int año=0;

      System.out.println("Ingrese el año de salida de la edición del libro.");

      while(true){

        try{


            año=Integer.parseInt(scanner.nextLine());

            if(año < 1890){
                System.out.println("Solo se aceptan libro de 1890 hacia delante.");
            }else{
                return año;
            }

        }catch(NumberFormatException e){
 
            System.out.println("Ingrese un número.");
        }

      }
   }

   public int generarNumeroPaginas(){

      int paginas=0;

      System.out.println("Ingrese el número de páginas del libro.");

      while(true){

        try{


            paginas=Integer.parseInt(scanner.nextLine());

                return paginas;
            

        }catch(NumberFormatException e){
 
            System.out.println("Ingrese un número.");
        }

      }
   }

   public int generarStock(){


    int stock=0;

    System.out.println("Ingrese el stock del libro.");

    while(true){


        try{

          stock=Integer.parseInt(scanner.nextLine());

          if(stock <= 0){
            System.out.println("No puedes introducir un stock menor o igual a 0.");
          }else{

            return stock;
          }


        }catch(NumberFormatException e){

            System.out.println("Ingrese un número.");
        }
    }
   }

   public String generarGenero(){

      String[] genero={"Literatura","Literatura Peruana","Ciencias","Clásicos","Informática","Derecho"};

      int ingresarGenero=0;

      System.out.println("Genéro del libro");
            System.out.println("1. Literatura");
            System.out.println("2. Literatura Peruana");
            System.out.println("3. Ciencias");
            System.out.println("4. Clásicos");
            System.out.println("5. Informática");
            System.out.println("5. Derecho");

      while(true){

        try{

            ingresarGenero=Integer.parseInt(scanner.nextLine());

            switch (ingresarGenero) {
                case 1:
                return genero[0];
                case 2:
                return genero[1];
                case 3: 
                return genero[2];
                case 4: 
                return genero[3];
                case 5:
                return genero[4];
                case 6:
                return genero[5];
                default:
                System.out.println("Ingrese una de las opciones.");
                    break;
            }
        }catch(NumberFormatException e){
            System.out.println("Ingre un número válido.");
        }
      }
   }
   public void MostrarLibros(){

    int opcion=0;

    do{
     System.out.println("Mostrar Libros");
     System.out.println("1. Buscar todos los libros.");
     System.out.println("2. Buscar por ISBN");
     System.out.println("3. Salir");
   
     try{

        opcion=Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                BuscarTodosLibros();
                break;
            case 2:
                buscarLibroPorId();
                break;
        
            default:
                break;
        }


     }catch(NumberFormatException e){
        System.out.println("Ingresa un número válido.");
     }
    }while(opcion != 3);


   }
   public void BuscarTodosLibros(){

    if(libro.isEmpty()){
        System.out.println("No hay ningún libro añadido.");
    }

    for(int i=0; i<libro.size(); i++){

        System.out.println((i+1) + "." + libro.get(i) );
    }
   }
   public void buscarLibroPorId(){

    int id=0;

    System.out.println("Ingrese el ISBN del libro.");

    try{

        id=Integer.parseInt(scanner.nextLine());

    for(Libro lib : libro){

     if(lib.getISBN() == id){
        System.out.println("Libro encontrado: " + lib);
     }else{
        System.out.println("IBNS incorrecto pruebe con otro.");
        return;
     }


    }
   }catch(NumberFormatException e){
    System.out.println("Ingresa un número válido.");
   }
  }

  public void editarLibro(){

    int id=0;

     if(libro.isEmpty()){
        System.out.println("No hay ningún libro creado.");
        return;
     }

     System.out.println("Ingrese el número de Id del libro.");

     try{
        id=Integer.parseInt(scanner.nextLine());

        for(Libro lib:libro){
            if(lib.getISBN() == id){

       System.out.println("--Ménu editar libro---");
       System.out.println("Libro: " + lib.getTitulo() + "" +  "ID: " + id);
       System.out.println("1. Editar todos los campos.");
       System.out.println("2. Editar Título.");
       System.out.println("3. Editar Editorial.");
       System.out.println("4. Editar Estado.");
       System.out.println("5. Editar Formato.");
       System.out.println("6. Editar Encuadernación.");
       System.out.println("7. Dimensiones");
       System.out.println("8. Editar Año");
       System.out.println("9. Editar número de páginas");
       System.out.println("10. Editar stock.");
       System.out.println("11. Editar Género.");
       System.out.println("12. Salir.");

       int opcion=Integer.parseInt(scanner.nextLine());

       switch (opcion) {
        case 1:
        editarTodoLibro();
             break;
        case 2:
         nuevoNombre();
         break;
         case 3:
         nuevoEditorial();
         break;
         case 4:
         nuevoEstado();
         break;
         case 5:
         nuevoFormato();
         break;
         case 6:
         nuevaEncuadernacion();
         break;
         case 7:
         nuevaDimensiones();
         break;
         case 8:
         nuevoAño();
         break;
         case 9: 
         nuevoNumeroPaginas();
         break;
         case 10:
         nuevoStock();
         break;
         case 11: 
         nuevoGenero();
         break;
         case 12:
         return;

        default:
            break;
       }
            }
        }

}catch(NumberFormatException e){
    System.out.println("Ingrese un valor válido.");
}
}

public String NuevoTitulo(){

    for(Libro lib : libro){

        String nuevoTitulo = generarNombreLibro();
        if(libro.stream().anyMatch(l-> l.getTitulo()!= null && l.getTitulo().equals(nuevoTitulo))){
           System.out.println("El nombre es el mismo.");
            break;
        }
         lib.setTitulo(nuevoTitulo);
        System.out.println("El nuevo Título es: " + nuevoTitulo);
        return nuevoTitulo;
    }
    return null;
}
public String nuevoEditorial(){

    for(Libro lib : libro){

        String nuevoEditorial = generarEditorial();
        if(libro.stream().anyMatch(l-> l.getEditorial() != null && l.getEditorial().equals(nuevoEditorial))){
             System.out.println("La editorial ya existe.");
             return null;
        }
        lib.setEditorial(nuevoEditorial);
        System.out.println("La nueva editorial es: " + nuevoEditorial);
        return nuevoEditorial;
    }
    return null;
}

public String nuevoEstado(){

    for(Libro lib: libro){

        String nuevoEstado= generarEstadoDeLibro();
        if(libro.stream().anyMatch(l-> l.getEstado() != null && l.getEstado().equals(nuevoEstado))){
            System.out.println("El estado del libro es el mismo.");
            return null;
        }
        lib.setEstado(nuevoEstado);
        System.out.println("El nuevo estado es: " + nuevoEstado);
        return nuevoEstado;
    }
    return null;
}

public String nuevoFormato(){

    for(Libro lib : libro){

        String nuevoFormato= generarFormato();
        if(libro.stream().anyMatch(l -> l.getFormato() != null && l.getFormato().equals(nuevoFormato))){
            System.out.println("El formarto del libro es el mismo");
            return null;
        }
        lib.setFormato(nuevoFormato);
        System.out.println("El nuevo Formato es: " + nuevoFormato); 
        return nuevoFormato;
    }
    return null;
}
public String  nuevaEncuadernacion(){


    for(Libro lib : libro){

        String nuevaEncuadernacion= generarEncuadernacion();

        if(libro.stream().anyMatch(l -> l.getEncuadernacion() != null && l.getEncuadernacion().equals(nuevaEncuadernacion))){
            System.out.println("El tipo de encuadernación es la misma.");
            break;
            
        }
        lib.setEncuadernacion(nuevaEncuadernacion);
        System.out.println("La nueva encuadernación es: " + nuevaEncuadernacion);
        return nuevaEncuadernacion;
    }
    return null;
}
public String nuevaDimensiones(){

    for(Libro lib : libro){

        String nuevaDimension = generarDimensiones();

        if(libro.stream().anyMatch(l -> l.getDimensiones() != null && l.getDimensiones().equals(nuevaDimension))){
            System.out.println("La dimension sigue siendo la misma.");
            break;
        }
        lib.setDimensiones(nuevaDimension);
        System.out.println("La nueva dimensión es: " +  nuevaDimension);
        return nuevaDimension;
    }
    return null;
}

public int nuevoAño(){

    for(Libro lib: libro){

        int nuevoAño= generarAño();

        if(libro.stream().anyMatch(l ->  l.getAño() == nuevoAño)){
           System.out.println("El año es el mismo.");
           break;
        }
        lib.setAño(nuevoAño);
        System.out.println("El nuevo año es: " + nuevoAño);
        return nuevoAño;
    }
    return -1;
}

public int nuevoNumeroPaginas(){

    for(Libro lib : libro){

        int nuevoNumeroPaginas= generarNumeroPaginas();

        if(libro.stream().anyMatch(l -> l.getNumeroPaginas() == nuevoNumeroPaginas)){
            System.out.println("El número de páginas es el mismo.");
            break;
        }
        lib.setNumeroPagians(nuevoNumeroPaginas);
        System.out.println("El nuevo número de páginas es de: " + nuevoNumeroPaginas);
        return nuevoNumeroPaginas;
    }
    return -1;
}
public int nuevoStock(){
   
    for(Libro lib : libro){

        int nuevoStock = generarStock();

        if(libro.stream().anyMatch(l -> l.getStock() == nuevoStock)){
            System.out.println("El stock es el mismo.");
            break;
        }
        lib.setStock(nuevoStock);
        System.out.println("El nuevo stock es de: " + nuevoStock);
        return nuevoStock;
    }
    return -1;
}

public String nuevoGenero(){

    for(Libro lib : libro){
        String nuevoGenero = generarGenero();
        if(libro.stream().anyMatch(l -> l.getGenero() != null && l.getGenero().equals(nuevoGenero))){
            System.out.println("El género sigue siendo el mismo.");
            break;
        }
        lib.setGenero(nuevoGenero);
        System.out.println("El nuevo género del libro es de: " + nuevoGenero);
        return nuevoGenero;
    }
    return null;
}

public void editarTodoLibro(){
   String nuevoNombre = nuevoNombre();
   String nuevoEditorial = nuevoEditorial();
   String nuevoEstado = nuevoEstado();
   String nuevoFormato = nuevoFormato();
   String nuevaEncuadernacion = nuevaEncuadernacion();
   String nuevaDimensiones = nuevaDimensiones();
   int nuevoAño = nuevoAño();
   int nuevoNumeroPaginas = nuevoNumeroPaginas();
   int nuevoStock = nuevoStock();
   String nuevoGenero = nuevoGenero();

   System.out.println("Datos actualizados.");
   System.out.println("Nuevo Título: " + nuevoNombre);
   System.out.println("Nueva Editorial: " + nuevoEditorial);
   System.out.println("Nuevo Estado: " + nuevoEstado);
   System.out.println("Nuevo Formato: " + nuevoFormato);
   System.out.println("Nueva Encuadernación: " + nuevaEncuadernacion);
   System.out.println("Nuevas Dimensiones: " + nuevaDimensiones);
   System.out.println("Nuevo Año: " + nuevoAño);
   System.out.println("Nuevo Número de Páginas: " + nuevoNumeroPaginas);
   System.out.println("Nuevo Stock: " + nuevoStock);
   System.out.println("Nuevo Género: " + nuevoGenero);
}

public void eliminarLibro(){

    int id=0;

    do{
    System.out.println("Ingrese el id del Libro a eliminar  o ingrese 0 para salir.");

    try{

        id=Integer.parseInt(scanner.nextLine());

        for(Libro lib : libro){
            if(lib.getISBN() == id){
              
                System.out.println("Libro encontrado.");
                System.out.println("Confirme, S/N ");

                String opcion=scanner.nextLine().trim();
                if(opcion.equalsIgnoreCase("S")){
                    libro.remove(lib);
                }else if(opcion.equalsIgnoreCase("n")){
                    System.out.println("Eliminación cancelada.");
                    return;
                }else{
                    break;
                }

            }
        }
    }catch(NumberFormatException e){
        System.out.println("Ingrese un número válido.");
    }
    
}while(id != 0);
}


public void prestarLibro(){

}
   
}





















