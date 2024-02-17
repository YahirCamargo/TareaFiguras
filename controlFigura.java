
package practicaFigura;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class controlFigura {
    public ArrayList<Figura> figuras=new ArrayList<Figura>();
    Object[] figurasArray ;
        
    
    
    
    public JList convertirAJList(){  
        Object[] figurasArray = figuras.toArray();
        //creamos un arreglo Object que convertira el arrayList en un array 
        //ya que el JList solo puede manejar datos de este tipo
        figurasArray=new Object[figuras.size()];
        //despues ponemos el arreglo con el tamaño del arrayList
        for (int i = 0; i < figuras.size(); i++) {
            figurasArray[i] = figuras.get(i).getNombreFigura();
            //con esto obtenemos solo el nombre de la figura, ya que eso es lo que es requerido
        }
        JList<Object> list = new JList<>(figurasArray);
        //creamos la Jlist y le asignamos los nombres para despues returnarla
        return list;
        
    }

    public boolean agregar(Figura figura){
        figuras.add(figura);
        return true;
    }
    
    
    public int buscarIndex(String nombreDeFiguraParaBuscarIndex){
        int index=0;
        //inicializamos el index en 0 ya que es la primera posicion que toma el ArrayList
        for (Figura f:figuras){
            if(f.getNombreFigura().equals(nombreDeFiguraParaBuscarIndex)){
                //con este if buscamos que el nombre dado sea igual al que esta en esa posicion
                //de ser asi lo returnamos
                return index;
            }
            index++;
            //si no entro al if significa que la posicion en ese index no coincidia con la buscada
            //de ser así, tenemos que aumentar el index en 1
        }
        return -1;
        //si no encontro el index con el nommbre buscado se returna un -1
    }
    
    public boolean buscarPorNombre(String nombreDeFiguraABuscar){
        for (Figura f:figuras){
            if(f.getNombreFigura().equals(nombreDeFiguraABuscar)){
                return true;
                //si se encontro la figura returna que es cierto
                //con el cierto queremos decir que hay una figura con ese nombre
            }
        }
        return false;
    }
    
    
    public boolean borrar(int indexDeFiguraABorrar){
        if(indexDeFiguraABorrar<=figuras.size() && indexDeFiguraABorrar>=0){
            //verificamos de primera instancia que el index este dentro del rango de elementos guardados
            figuras.remove(indexDeFiguraABorrar);
            //de ser asi quitamos ese elemento
            return true;
            //returnamos un true que quiere decir que algo fue borrado
        }
        return false;
        //returnamos un false que nos informa que no se borro algo
    }
    
    
    
    public String CalcularAreaVolumen(String nombre){
        int index=buscarIndex(nombre);
        //inicializamos una variable donde se buscara la figura por su nombre para despues guardar
        //el valor en el
            if(index!=-1)
                //si el valor obtenido anteriormente es diferente a -1, queriendo decir que en
                //verdad existe ese elemento, lo returnamos a continuacion
                return "El area de la figura es de : "+figuras.get(index).obtenerArea()
                    +"\nEl volumen: "+figuras.get(index).obtenerVolumen();
            
            return "No existe la figura";
            //de no ser asi, returnamos que la figura no existe
        
    }
    
    
    public DefaultTableModel listarXTablas() {
        Figura figura;
        //esto nos va a servir para inicializar los siguientes elementos
        punto pun;
        circulo cir;
        cilindro cil;
        //estas lineas serviran para despues hacer referencia a sus respectivas clases

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("FIGURA");
        dtm.addColumn("NOMBRE");
        dtm.addColumn("X");
        dtm.addColumn("Y");
        dtm.addColumn("RADIO");
        dtm.addColumn("ALTURA");
        //añadimos las columnas con sus respectivos nombres
        for (int i = 0; i < figuras.size(); i++) {
            //recorremos el arraylist
            figura = figuras.get(i);
            //despues obtenemos la figura en ese punto
            
            if(figura instanceof cilindro){
                //ponemos a instanciar si figura es cilindro, ya que de inicializarlo al reves
                //como extienden de punto, nos da que esto es cierto/
                //por razones de evitar problemas se inicia con cilindro
                cil=(cilindro)figura;
                dtm.addRow(new Object[]{
                    "Cilindro",
                    figura.getNombreFigura(),
                    cil.getX(),
                    cil.getY(),
                    cil.getRadio(),
                    cil.getAltura()
                    //se agrega cada cosa a su respectiva columna
                });
            }else if (figura instanceof circulo) {
                //vemos si la figura es un circulo, de ser asi entra en este if
                cir = (circulo) figura;
                System.out.println(cir.getRadio());
                dtm.addRow(new Object[]{
                    "Circulo",
                    figura.getNombreFigura(),
                    cir.getX(),
                    cir.getY(),
                    cir.getRadio(),
                    null
                    //ponemos los respectivos valores en las columnas
                    //al final es nulo ya que en esa columna va la altura pero esta figura no la tiene
                });
            }else if (figura instanceof punto) {
                pun=(punto)figura;
                dtm.addRow(new Object[]{
                    "Punto",
                    figura.getNombreFigura(),
                    pun.getX(),
                    pun.getY(),
                    null,
                    null,
                    //ponemos los respectivos valores en las columnas
                    //los 2 ultimos son nulos ya que en estas columnas van la altura 
                    //y la radio pero esta figura no la tiene
                });
            } 
        }
        return dtm;
        //se returna la tabla
    }
}