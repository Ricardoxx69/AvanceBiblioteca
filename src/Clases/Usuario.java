package Clases;

public class Usuario {

    protected int id;
    protected String usuario;
    protected String contraseña;
    protected int contador=0;
    
    // Podrías tener aquí también un campo de privilegio general (opcional)
    protected String privilegio;

    // Constructor, getters, setters

    public Usuario(int id, String usuario, String contraseña, String privilegio){

        this.id= ++ contador;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.privilegio=privilegio;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña= contraseña;
    }
    public String getPrivilegio(){
        return privilegio;
    }
    public void setPrivilegio(String privilegio){
        this.privilegio=privilegio;
    }

    public String toString(){
        return "Administrativo: " +"[" + "Id: " + id + " Usuario: " + usuario + " Contraseña: " + contraseña + 
        " Privilegio: " + privilegio + "]";
    }
}
