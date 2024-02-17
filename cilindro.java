
package practicaFigura;

public class cilindro extends circulo{
    private float altura;

    public cilindro(float altura, float radio, int x, int y, String nombreFigura) {
        super(radio, x, y, nombreFigura);
        this.altura = altura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    
    @Override
    public float obtenerArea(){
        return (float)((2*super.obtenerArea())+(2*(Math.PI)*super.getRadio()*altura));
    }
    
    @Override
    public float obtenerVolumen(){
        return (float)(Math.PI*Math.pow(super.getRadio(), 2)*altura);
    }
    @Override
    public String obtenerNombre(){
        return "Tu figura es un cilindro y se llama: "+super.getNombreFigura();
    }
    @Override
    public String imprimir(){
        return super.imprimir()+"\nAltura: "+altura;
    }

    @Override
    public String toString() {
        return super.toString()+" altura: "+altura;
    }
    
    
}
