package com.moron.project.jdsa;

import com.moron.project.jdsa.dast.DoublyLinkedList;
import com.moron.project.jdsa.dast.SinglyLinkedList;

/**
 * Hello world!
 *
 */
public class Sample_1 {

	public static void main(String[] args) {
//	SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
//	sll.addToHead(3);
//	sll.addToHead(1);
//	sll.addToHead(9);
//	System.out.println(sll);

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.deleteNode(5);
		dll.addToHead(3);
		dll.addToHead(1);
		dll.addToTail(100);
		dll.addToHead(5);
		System.out.println(dll.deleteFromTail());
		dll.addToTail(69);
		dll.addToTail(13);
		System.out.println(dll);
	}
}
