package Clases;
public class Libro {

        private int ISBN;
        private String Titulo;
        private String Editorial;
        private String Estado;
        private String Formato;
        private String Encuadernacion;
        private String Dimensiones;
        private int Año;
        private int numeroPaginas;
        private int stock;
        private String Genero;
        private static int contador=0;
        
      public Libro(int ISBN, String titulo,String estado ,String editorial, String formato, String encuadernacion,String dimensiones,
                   int año, int numeroPaginas, int stock, String genero){

          this.ISBN= ++contador;
          this.Titulo = titulo;
          this.Estado = estado;
          this.Editorial = editorial;
          this.Formato = formato;
          this.Encuadernacion = encuadernacion;
          this.Dimensiones = dimensiones;
          this.Año = año;
          this.numeroPaginas = numeroPaginas;
          this.stock = stock;
          this.Genero = genero;
                   }

         public int getISBN(){
            return ISBN;
         }
         public void setISBN(int ISBN){
            this.ISBN = ISBN;
         }
         public String getTitulo(){
            return Titulo;
         }
         public void setTitulo(String titulo){
            this.Titulo = titulo;
         }
         public String getEstado(){
             return Estado;
         }
         public void setEstado(String estado){
             this.Estado = estado;
         }
         public String getEditorial(){
            return Editorial;
         }
         public void setEditorial(String editorial){
            this.Editorial = editorial;
         }
         public String getFormato(){
            return Formato;
         }
         public void setFormato(String formato){
            this.Formato = formato;
         }
         public String getEncuadernacion(){
            return Encuadernacion;
         }
         public void setEncuadernacion(String encuadernacion){
            this.Encuadernacion = encuadernacion;
         }
         public String getDimensiones(){
            return Dimensiones;
         }
         public void setDimensiones(String dimensiones){
            this.Dimensiones = dimensiones;
         }
         public int getAño(){
            return Año;
         }
         public void setAño(int año){
            this.Año = año;
         }
         public int getNumeroPaginas(){
            return numeroPaginas;
         }
         public void setNumeroPagians(int numeroPaginas){
            this.numeroPaginas = numeroPaginas;
         }
         public int getStock(){
            return stock;
         }
         public void setStock(int stock){
            this.stock = stock;
         }
         public String getGenero(){
            return Genero;
         }
         public void setGenero(String genero){
            this.Genero = genero;
         }

         @Override
         public String toString(){
             return "Libro [ISBN: " + ISBN + " Título: " + Titulo + " Editorial: " + Editorial + " Estado: " + Estado + " Formato: " + Formato + 
             " Encuadernación: " + Encuadernacion + " Dimensiones: " + Dimensiones + " Año: " + Año + " Número de Páginas: " + numeroPaginas + 
             " Stock: " + stock + " Género: " + Genero + "]";
         }

}
    

