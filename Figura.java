
package practicaFigura;

public abstract class Figura {
    private String nombreFigura;

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }
    
    public Figura(String nombreFigura){
        this.nombreFigura=nombreFigura;
    }
    
    public String obtenerNombre(){
        return nombreFigura;
    }
    
    public String imprimir(){
        return "El nombre de la figura es "+nombreFigura;
    }
    
    public abstract float obtenerVolumen();
    
    public abstract float obtenerArea();

    @Override
    public String toString() {
        return "Nombre de la figura: " + nombreFigura;
    }
    
    
}
