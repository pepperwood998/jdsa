package com.moron.project.jdsa.dast;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

	private Node mHead;
	private Node mTail;

	public SinglyLinkedList() {
		mHead = null;
		mTail = null;
	}

	public void addToHead(T data) {
		mHead = new Node(data, mHead);

		if (mTail == null) {
			mTail = mHead;
		}
	}

	public void addToTail(T data) {
		if (this.isEmpty()) {
			mHead = new Node(data);
			mTail = mHead;
		} else {
			mTail.mNext = new Node(data);
			mTail = mTail.mNext;
		}
	}

	public T deleteFromHead() {
		if (this.isEmpty())
			return null;

		T data = mHead.mData;

		if (mHead == mTail) {
			mHead = null;
			mTail = null;
		} else {
			mHead = mHead.mNext;
		}

		return data;
	}

	public T deleteFromTail() {
		if (this.isEmpty())
			return null;

		T data = mTail.mData;

		if (mHead == mTail) {
			mTail = null;
			mHead = null;
		} else {
			Node tmp;

			for (tmp = mHead; tmp.mNext != mTail; tmp = tmp.mNext)
				;

			tmp.mNext = null;
			mTail = tmp;
		}

		return data;
	}

	public void deleteNode(final T data) {
		if (this.isEmpty())
			return;

		if (data.equals(mHead.mData)) {
			if (mHead == mTail) {
				mHead = null;
				mTail = null;
			} else {
				mHead = mHead.mNext;
			}
		} else {
			Node prev, tmp;
			for (prev = mHead, tmp = mHead.mNext; tmp != null
					&& !data.equals(tmp.mData); prev = prev.mNext, tmp = tmp.mNext)
				;

			if (tmp != null) {
				prev.mNext = tmp.mNext;
				if (tmp == mTail)
					mTail = prev;
			}
		}
	}

	public boolean isEmpty() {
		return mHead == null;
	}

	public boolean contain(final T data) {
		Node tmp;
		for (tmp = mHead; !data.equals(tmp.mData); tmp = tmp.mNext)
			;

		return tmp == null;
	}

	public Node getHead() {
		return mHead;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();

		for (Node tmp = mHead; tmp != null; tmp = tmp.mNext) {
			res.append(tmp.mData + " ");
		}

		return res.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new SLLIterator(this);
	}

	private class Node {

		T mData;
		Node mNext;

		public Node(T data) {
			this(data, null);
		}

		public Node(T data, Node next) {
			mData = data;
			mNext = next;
		}
	}

	private class SLLIterator implements Iterator<T> {

		private Node mCurrent;

		public SLLIterator(final SinglyLinkedList<T> sll) {
			mCurrent = sll.getHead();
		}

		@Override
		public boolean hasNext() {
			return mCurrent != null;
		}

		@Override
		public T next() {
			T data = mCurrent.mData;
			mCurrent = mCurrent.mNext;

			return data;
		}

	}
}
