package no.hvl.data102.filmarkiv2.impl;

public class LinearNode<T> {

	public T data;
	public LinearNode<T> neste;
	
	public LinearNode(T data) {
		super();
		this.data = data;
		this.neste = null;
	}
	
}
