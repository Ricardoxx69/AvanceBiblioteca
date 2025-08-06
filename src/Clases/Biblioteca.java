package Clases;
public class Biblioteca {
    private int id_Biblioteca;
    private String nombreBiblioteca;
    private String Direccion;
    private static int contador=0;

    public Biblioteca(int id_Biblioteca, String nombreBiblioteca, String direccion){
        this.id_Biblioteca = ++contador;
        this.nombreBiblioteca = nombreBiblioteca;
        this.Direccion= direccion;
    }
    public int getId_Biblioteca(){
        return id_Biblioteca;
    }
    public void setid_Biblioteca(int id_Biblioteca){
        this.id_Biblioteca = id_Biblioteca;
    }
    public String getNombreBiblioteca(){
        return nombreBiblioteca;
    }
    public void setNombreBiblioteca(String nombreBiblioteca){
        this.nombreBiblioteca = nombreBiblioteca;
    }
    public String getDireccion(){
        return Direccion;
    }
    public void setDireccion(String direccion){
       this.Direccion = direccion;
    }

    /*El método toString sirve por ejemplo: Cuando un ArrayList quiere imprimir un resultado en cadena llama al método toString para que este imprima los atributos de la clase trabajada.*/
    @Override
    public String toString() {
        return "Biblioteca [ID: " + id_Biblioteca + ", Nombre: " + nombreBiblioteca + ", Dirección: " + Direccion + "]";
    }
}
    

