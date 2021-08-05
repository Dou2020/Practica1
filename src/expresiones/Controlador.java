/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones;

import java.util.ArrayList;

/**
 *
 * @author douglas2021
 */
public class Controlador {
    Visual visual;
    public Controlador(Visual visual){
        this.visual = visual;
    }
    public ArrayList<String> separar(String expresion,String separador){
        ArrayList<String> partes =new ArrayList();
        String cadena = "";
        for (int i = 0; i < expresion.length(); i++) {
            String a = expresion.substring(i,i+1);
            if (a.equals(separador)) {
                partes.add(cadena);
                System.out.println(partes.get(partes.size()-1));
                cadena = "";
            }else{
                if (i == expresion.length()-1) {
                    partes.add(cadena);
                    System.out.println(partes.get(partes.size()-1));
                }else{
                    cadena+=a;
                }
            } 
        }
        return partes;
    }
    public void evaluar(ArrayList<String> cadena){
        String abc[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
        String numero[] = {"1","2","3","4","5","6","7","8","9","0"};
        String simbolo[] = {"{","}","[","[","]",",","+","-","*","/","!"};
        Mensaje mensaje;
        
        for(String cadenas: cadena){
            if (parte(abc,cadenas)) {
                System.out.println(Mensaje.IDENTIFICADOR+" "+cadenas);
            }
            else if (parte(numero,cadenas)) {
                System.out.println(Mensaje.ENTERO+" "+cadenas);
            }
            else if (decimal(numero,cadenas)) {
                System.out.println(Mensaje.DECIMAL+" "+cadenas);
            }
            else if (parte(simbolo,cadenas)) {
                System.out.println(Mensaje.SIMBOLO+" "+cadenas);
            }else{
                System.out.println(Mensaje.ERROR+" "+cadenas);
            }
        }
    }
    public boolean decimal(String abc[],String valor){
        ArrayList<String> par = separar(valor,".");
        if (par.size()!=2) {
            return false;
        }
        boolean condicion1 = (par.get(0).length() == 1) && (par.get(0).equalsIgnoreCase("0"));
        boolean condicion2 = (1 < par.get(0).length()) && (!par.get(0).substring(0, 1).equals("0"));
        if (condicion1 || condicion2) {
            if (parte(abc,par.get(1))) {
                return true;
            }
        }
        return false;
    }
    public boolean parte(String abc[],String valor){
        int a = 0;
        for (int i = 0; i < valor.length(); i++) {
            for (int j = 0; j < abc.length; j++) {
                if (abc[j].equalsIgnoreCase(valor.substring(i, i+1))) {
                    ++a;
                    break;
                }
            }
        }
        System.out.println("longitud "+a+" valor "+valor.length());
        if (a == valor.length()) {
            return true;
        }else{
            return false;
        }
    }
}
