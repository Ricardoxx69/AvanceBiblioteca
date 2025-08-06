package Clases;

public class UsuarioEstudiante extends Usuario {

    private String nombre;
    private String apellido;
    private String carrera;

    public UsuarioEstudiante(int id, String usuario, String contraseña, String privilegio, String nombre, String apellido, String carrera){
          super(id, usuario, contraseña, privilegio);

          this.nombre= nombre;
          this.apellido = apellido;
          this.carrera= carrera;
        
    }

   
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        this.carrera= carrera;
    }


}
