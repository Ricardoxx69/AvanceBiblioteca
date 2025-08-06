package Clases;

public class UsuarioAdmin extends Usuario {

   String area;
   String puesto;

    public UsuarioAdmin(int id, String usuario, String contraseña, String privilegio,String area, String puesto){

        super(id, usuario, contraseña, privilegio);
        
        this.area = area;
        this.puesto= puesto;
    }

    public String getArea(){
        return area;
    }
    public void setArea(String area){
        this.area=area;
    }
    public String getPuesto(){
        return puesto;
    }
    public void setPuesto(String puesto){
        this.puesto=puesto;
    }

    public String toString(){
        return "Administrativo: " +"[" + "Id: " + id + " Usuario: " + usuario + " Contraseña: " + contraseña + 
        " Privilegio: " + privilegio + " Área: " +  area + " Puesto:" + puesto +"]";  
    }

    

    


}
