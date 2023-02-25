/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.william.estructuras;

/**
 *
 * @author William
 */
class ListaDobleEnlazada<E> {
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

	
	/*public void insertAtPosition(E value, int position) {
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
	}*/


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

}
