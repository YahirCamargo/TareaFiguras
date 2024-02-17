
package practicaFigura;


public class punto extends Figura {
    private int x,y;

    public punto(int x, int y, String nombreFigura) {
        super(nombreFigura);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    public String obtenerNombre(){
        return "Es un punto y se llama: "+super.obtenerNombre();
    }
    
    public String imprimir(){
        return super.imprimir()+" con las cordenadas ["+x+","+y+"]";
    }
    

    @Override
    public float obtenerVolumen() {
        return (float)0.0;
    }

    @Override
    public float obtenerArea() {
        return (float)0.0;
    }

    @Override
    public String toString() {
        return super.toString()+" [" + x + "," + y +"]";
    }
    
    
}
