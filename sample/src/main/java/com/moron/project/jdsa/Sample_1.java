package com.moron.project.jdsa;

import com.moron.project.jdsa.dast.SinglyLinkedList;

/**
 * Hello world!
 *
 */
public class Sample_1
{
    public static void main(String[] args)
    {
	SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
	sll.addToHead(3);
	sll.addToHead(1);
	sll.addToHead(9);
	System.out.println(sll);
    }
}
