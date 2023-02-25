/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.william.estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class Estructuras {

    public static void main(String[] args) {
        int opcion = 0, elemento, posicion;
        ListaDobleEnlazada lde = new ListaDobleEnlazada(); 
        
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                     1. Insertar al inicio
                     2. Insertar al Final
                     3. Recorrer hacia adelante
                     4. Recorrer hacia atras                                                       
                     5. Mostrar tamaño de la lista                                                       
                     6. Mostrar si la lista esta vacia                                                       
                     7. Buscar elemento por valor                                                       
                     8. Buscar elemento por indice                                                       
                     9. Borrar un elemento
                     10. Salir                                                                                                                                            
                     Menu de opciones                                                       """, "Menu de Opciones",
                        JOptionPane.INFORMATION_MESSAGE));
                
                switch(opcion){
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar elemento del nodo",
                                "Agregar nodo al inicio", JOptionPane.INFORMATION_MESSAGE));
                                lde.insertarAlInicio(elemento);
                        break;
                    }

                    case 2 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar elemento del nodo",
                                "Agregar nodo al final", JOptionPane.INFORMATION_MESSAGE));
                                lde.insertarAlFinal(elemento);
                        break;
                    }

                    case 3 -> {
                        if(!lde.vacio()){
                            lde.recorrerHaciaAdelante();
                        }
                        break;
                    }

                    case 4 -> {
                        if(!lde.vacio()){
                            lde.recorrerHaciaAtras();
                        }
                        break;
                    }

                    case 5 -> {
                        if(!lde.vacio()){
                            JOptionPane.showMessageDialog(null, "El tamaño de la lista es: " + lde.mostrarTamaño(), 
                                "Tamaño de la lista", JOptionPane.INFORMATION_MESSAGE); 
                        }
                                
                        break;
                    }

                    case 6 -> {
                        if(lde.vacio() == true){
                            JOptionPane.showMessageDialog(null, "La lista está vacia", 
                                "Tamaño de la lista", JOptionPane.INFORMATION_MESSAGE); 
                        }
                        break;
                    }

                    case 7 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Buscar por valor",
                                "Buscando por valor", JOptionPane.INFORMATION_MESSAGE));
                                lde.buscarPorValor(elemento);
                                JOptionPane.showMessageDialog(null, "El elemento buscado es: " + lde.buscarPorValor(elemento), 
                                "Elemento encontrado", JOptionPane.INFORMATION_MESSAGE); 
                        break;
                    }

                    case 8 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Buscar por indice",
                                "Buscando por indice", JOptionPane.INFORMATION_MESSAGE));
                                lde.buscarPorIndice(elemento);
                                JOptionPane.showMessageDialog(null, "El elemento buscado es: " + lde.buscarPorIndice(elemento), 
                                "Elemento encontrado", JOptionPane.INFORMATION_MESSAGE); 
                        break;
                    }

                    case 9 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Borrar elemento",
                                "Borrando elemento del nodo", JOptionPane.INFORMATION_MESSAGE));
                                lde.borrarElemento(elemento);
                        break;
                    }
                    
                    case 10 -> {
                        JOptionPane.showMessageDialog(null, "Saliendo", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                       /* default:
                            JOptionPane.showMessageDialog(null, "Opcion no disponible", "Error", JOptionPane.INFORMATION_MESSAGE);
                            break;*/
                            
                    }
        }
            
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }
        }while(opcion != 5);
    
    }
    
    /*public class ListaDoblementeEnlazada<E> {
        
	private Node<E> inicio;
	private Node<E> fin;
	private int tamaño = 0;
        
	public void insertarAlInicio(E value) {
		Node<E> newNode = new Node<E>(value);
		if (null == inicio) { 
			newNode.next = null;
			newNode.prev = null;
			inicio = newNode;
			fin = newNode;
			tamaño++;
		} else {
			newNode.next = inicio;
			newNode.prev = null;
			inicio.prev = newNode;
			inicio = newNode;
			tamaño++;
		}
	}

	public void insertarAlFinal(E value) {
		Node<E> newNode = new Node<E>(value);
		if (null == fin) { 
			newNode.next = null;
			newNode.prev = null;
			inicio = newNode;
			fin = newNode;
			tamaño++;
		} else {
			fin.next = newNode;
			newNode.next = null;
			newNode.prev = fin;
			fin = newNode;
			tamaño++;
		}
	}

	
	public void insertAtPosition(E value, int position) {
		if (position < 0 || position > tamaño) {
			throw new IllegalArgumentException("Position is Invalid");
		} 
		
		if (position == 0) { 
			
			insertarAlInicio(value);
		} else if (position == tamaño -1) { 
			
			insertarAlFinal(value);
		} else { 
			
			Node<E> currentNode = inicio;
			for (int i = 0; i < position; i++) {
				currentNode = currentNode.next;
			}
			Node<E> previousNode = currentNode.prev;
			
			Node<E> newNode = new Node<E>(value);
			newNode.next = currentNode;
			newNode.prev = previousNode;
			previousNode.next = newNode;
			currentNode.prev = newNode;
			tamaño++;
		}
	}


	public void recorrerHaciaAdelante() {
		Node<E> temp = inicio;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
	}


	public void recorrerHaciaAtras() {
		Node<E> temp = fin;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.prev;
		}
	}


	public int mostrarTamaño() {
		return tamaño;
	}


	public boolean vacio() {
		return tamaño == 0;
	}


	public Node<E> buscarPorIndice(int indice) {
		if (indice < 0 || indice >= tamaño) {
			throw new IndexOutOfBoundsException("Invalid index passed while searching for a value");
		} 
		
		Node<E> temp = inicio;
		for (int i = 0; i < indice; i++) { 
			
			temp = temp.next;
		}
		return temp;
	}


	public Node<E> buscarPorValor(E value) { 
		
		Node<E> temp = inicio;
		while (null != temp.next && temp.item != value) {
			temp = temp.next;
		}
		if (temp.item == value) {
			return temp;
		}
		return null;
	}


	public void deleteFromHead() {
		
		if (null == inicio) { 
			return;
		}
		Node<E> temp = inicio;
		inicio = temp.next;
		inicio.prev = null;
		tamaño--;
	}


	public void deleteFromTail() {
		
		if (null == fin) { 
			return;
		}
		Node<E> temp = fin;
		fin = temp.prev;
		fin.next = null;
		tamaño--;
	}


	public void borrarElemento(int position) {
		if (position < 0 || position >= tamaño) {
			throw new IllegalArgumentException("Position is Invalid");
		} 
		
		Node<E> nodeToBeDeleted = inicio;
		for (int i = 0; i < position; i++) {
			nodeToBeDeleted = nodeToBeDeleted.next;
		}
		Node<E> previousNode = nodeToBeDeleted.prev;
		Node<E> nextNode = nodeToBeDeleted.next;
		previousNode.next = nextNode;
		nextNode.prev = previousNode;
		tamaño--;
	}


	public Object[] toArray() {
		Object[] result = new Object[tamaño];
		int i = 0;
		for (Node<E> x = inicio; x != null; x = x.next) {
			result[i++] = x.item;
		}
		return result;
	}


	public class Node<T> {

		
		T item;

		
		Node<T> next;

		
		Node<T> prev;

		
		public Node(T item) {
			this.item = item;
		}

		
		@Override
		public String toString() {
			return String.valueOf(item);
		}

	}

}*/
}
