
package parcial.ii;

import java.util.Scanner;


public class PARCIALII {

     Scanner op = new Scanner(System.in);
    Procedimientos puntero = new Procedimientos();
    
    public void menu(){
        boolean salir = false;
        int opcion = 0;
        Procedimientos puntero = new Procedimientos();
        
        while(!salir){
           System.out.println("");
           System.out.println("|-----------------**BIENVENIDO**---------------------|"); 
           System.out.println("|             **SEGUNDO PARCIAL**                    |");
           System.out.println("|  1. Serie I                                        |"); 
           System.out.println("|  Evalúa si todas las (),{} y [] están cerradas.    |");
           System.out.println("|  2. Serie II                                       |");
           System.out.println("|  Evalúa si la palabra es palíndromo.               |");
           System.out.println("|  3. Serie III                                      |");
           System.out.println("|  Evalúa si hay paréntesis duplicados en la cadena. |");
           System.out.println("|  0. SALIR                                          |");
           System.out.println("| ------------Selecciona la opción------------------ |");
           opcion = op.nextInt();
           op.nextLine();
           switch(opcion){
            case 1:
                System.out.println("Ingrese dato: ");
                puntero.pushPila(op.nextLine());
                puntero.equilibrada();
                puntero.limpiar();
                break;
            case 2:
                System.out.println("Ingrese dato: ");
                puntero.pushPila(op.nextLine());
                puntero.reversePilaCadena();
                
                boolean acceso = puntero.palindromo();
                if (acceso == true){
                    System.out.println("LA PALABRA ES PALÍNDROMO");
                }else{
                    System.out.println("LA PALABRA NO ES PALÍNDROMO");
                }
                puntero.limpiar();
                break;             
            case 3:
                System.out.println("Ingrese dato: ");
                puntero.pushPila(op.nextLine());   
                boolean a = puntero.duplicados();
                if ( a == true ){
                    System.out.println("SI EXISTEN PARENTESIS DUPLICADOS");
                
                }else{
                    System.out.println("NO HAY PARÉNTESIS DUPLICADOS");
                }
                puntero.limpiar();
                break;
            case 4:
                
            case 0:
                salir = true;               
                break;
            default:
                System.out.println("La opción ingresada es incorrecta");          
            }
        }
    }
    public static void main(String[] args) {
        PARCIALII objeto = new PARCIALII();
        objeto.menu();
    }
    
}
