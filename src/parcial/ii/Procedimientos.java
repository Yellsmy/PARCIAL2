
package parcial.ii;


public class Procedimientos {  
    Nodo cima;
    private NodoP2 cima2;
    int tamanio;
    int tamanio2;
    
    public Procedimientos(){
        cima = null;
        tamanio = 0;
        cima2 = null;
        tamanio2 = 0;
    }

    public void pushPila( String cadena){ 
        char arreglo[]= cadena.toCharArray();
        for(int i = 0; i < arreglo.length; i ++){
            Nodo nuevo = new Nodo(arreglo[i]);
            nuevo.siguienteA = cima;
            cima = nuevo;
            tamanio++;
        }
    }
    
    public boolean equilibrada(){
        int abierto = 0;
        int cerrado= 0;
        Nodo temp = cima;
        while(temp!= null){
            if(temp.datoS == '(' || temp.datoS == '{' || temp.datoS == '['){
                abierto++;
            }else if(temp.datoS == ')' || temp.datoS == '}' || temp.datoS == ']' ){
                cerrado++;             
            }
            temp = temp.siguienteA;
        }
        int resultado = abierto-cerrado;
        if (resultado ==0){
            System.out.println("true");
            return true;           
        }
        System.out.println("false");
        return false;       
    }
    
    public void reversePilaCadena(){ //Método para invertir la pila A y guardarla en una pila B
        Nodo aux = cima;
        NodoP2 nuevoB = new NodoP2(cima.datoS);
        nuevoB.siguiente2 = cima2;
        cima2 = nuevoB;
        tamanio2 ++;
        while( cima != null){
            aux = aux.siguienteA;
            nuevoB = new NodoP2(aux.datoS);
            nuevoB.siguiente2 = cima2;
            cima2 = nuevoB;
            tamanio2++;               
            if ( tamanio == tamanio2){
                break;
            }
        }
    }
    
    
    public boolean palindromo(){
        NodoP2 tempC = cima2;
        Nodo tempP = cima;       
        while(tempC!= null && tempP != null){           
            if(tempP.datoS == tempC.dato2){
                tamanio --;
                tamanio2 --;
            }else{
                return false;
            }            
            tempC = tempC.siguiente2;
            tempP = tempP.siguienteA;
        }
        return true;
    }   
    
    public boolean duplicados(){
        int abierto = 0;
        int cerrado = 0;
        Nodo temp = cima;
        while(temp!= null){
            if(temp.datoS == '('){
                abierto++;
            }
            else if (temp.datoS == ')'){
                cerrado ++;
            }
            temp = temp.siguienteA;
        }        
        if (abierto < cerrado || abierto > cerrado){
            System.out.println("LA CADENA TIENE PARÉNTESIS SIN CERRAR O ABRIR");
            return true;
        }
        if( abierto  == 1&& cerrado == 1){
            return false;
        }
        return true;
    }

    public void eliminar(){ //Método para eliminar paréntesis de la pila
        char aux = cima.datoS;
        cima= cima.siguienteA;
        tamanio--;
        if (cima.siguienteA == null){
            cima= null;
            tamanio= 0;
        }
    }
    public void limpiar (){
        while(cima != null){
            eliminar();
        }        
    }    
}
