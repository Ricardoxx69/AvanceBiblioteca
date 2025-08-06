
package Clases;
public class ResultadoLogin {

    /*  Este patrón es conocido como un objeto de respuesta o DTO (Data Transfer Object). Se usa para:
        - Transmitir datos entre capas (ej. entre lógica de negocio y presentación).
        - Dejar claro qué devuelve un método sin ambigüedad.*/


    public boolean esValido;
    public int usuarioId;
    public String privilegio;

    public ResultadoLogin(boolean esValido, int usuarioId, String privilegio) {
        this.esValido = esValido;
        this.usuarioId = usuarioId;
        this.privilegio = privilegio;
    }

    public String toString(){

         return "Administrativo: " +"[" + "Validez: "  + esValido + " Usuario: " + usuarioId + " Privilegio: " + privilegio + 
          " ]";  
    }
    }


