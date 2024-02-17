
package practicaFigura;


public class circulo extends punto {
    private float radio;

    public circulo(float radio, int x, int y, String nombreFigura) {
        super(x, y, nombreFigura);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    
    
    @Override
    public float obtenerArea(){
        return (float)(Math.PI*Math.pow(radio, 2));
        
    }
    @Override
    public String obtenerNombre(){
        return "La figura es un circulo y se llama: "+super.getNombreFigura();
    }
    @Override
    public String imprimir(){
        return super.imprimir()+"\nRadio= "+radio;
    }

    @Override
    public String toString() {
        return super.toString()+ " radio: " + radio;
    }
    
    
}
