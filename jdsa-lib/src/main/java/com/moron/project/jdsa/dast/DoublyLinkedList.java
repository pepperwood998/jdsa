package com.moron.project.jdsa.dast;

public class DoublyLinkedList<T>
{
    private Node mHead;
    private Node mTail;

    public DoublyLinkedList()
    {
	mHead = null;
	mTail = null;
    }

    public void addToHead(final T data)
    {
	mHead = new Node(data, mHead, null);

	if (mTail == null)
	{
	    mTail = mHead;
	} else
	{
	    mHead.mNext.mPrev = mHead;
	}
    }

    public void addToTail(final T data)
    {
	mTail = new Node(data, null, mTail);

	if (mHead == null)
	{
	    mHead = mTail;
	} else
	{
	    mTail.mPrev.mNext = mTail;
	}
    }

    public T deleteFromHead()
    {
	if (this.isEmpty())
	    return null;

	T data = mHead.mData;

	if (mHead == mTail)
	{
	    mHead = null;
	    mTail = null;
	} else
	{
	    mHead = mHead.mNext;
	    mHead.mPrev = null;
	}

	return data;
    }

    public T deleteFromTail()
    {
	if (this.isEmpty())
	    return null;

	T data = mTail.mData;

	if (mHead == mTail)
	{
	    mHead = null;
	    mTail = null;
	} else
	{
	    mTail = mTail.mPrev;
	    mTail.mNext = null;
	}

	return data;
    }

    public void deleteNode(final T data)
    {
	if (this.isEmpty())
	    return;
	
	if (data.equals(mHead.mData))
	{
	    mHead = mHead.mNext;
	    mHead.mPrev = null;
	} else
	{
	    Node tmp;
	    for (tmp = mHead; tmp != null && !data.equals(tmp.mData); tmp = tmp.mNext)
		;

	    if (tmp != null)
	    {
		tmp.mPrev.mNext = tmp.mNext;

		if (tmp == mTail)
		    mTail = tmp.mPrev;
	    }
	}
    }

    public boolean isEmpty()
    {
	return mHead == null;
    }

    public boolean contain(final T data)
    {
	Node tmp;
	for (tmp = mHead; tmp != null && !data.equals(tmp.mData); tmp = tmp.mNext)
	    ;

	return tmp == null;
    }

    @Override
    public String toString()
    {
	StringBuilder res = new StringBuilder();

	for (Node tmp = mHead; tmp != null; tmp = tmp.mNext)
	{
	    res.append(tmp.mData + " ");
	}

	return res.toString();
    }

    private class Node
    {
	T mData;
	Node mNext;
	Node mPrev;

	public Node(T data)
	{
	    this(data, null, null);
	}

	public Node(T data, Node next, Node prev)
	{
	    mData = data;
	    mNext = next;
	    mPrev = prev;
	}
    }
}
