package com.moron.project.jdsa;

import java.util.Iterator;

import com.moron.project.jdsa.dast.SinglyLinkedList;

public class DemoCustomIterator {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

		sll.addToHead(3);
		sll.addToHead(1);
		sll.addToHead(6);
		sll.addToHead(7);

		// iterate using enhanced for loop
		for (Integer x : sll) {
			System.out.println(x);
		}
		
		System.out.println();

		// iterate by getting the iterator object of our SLL
		Iterator<Integer> iterator = sll.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
