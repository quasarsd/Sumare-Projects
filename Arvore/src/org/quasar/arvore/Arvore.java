package org.quasar.arvore;

import java.util.List;

public class Arvore<T> 
{
	private No<T> root;
	
	public No<T> getRoot() {
		return root;
	}
	public void setRoot(No<T> root) {
		this.root = root;
	}
		
	public long getProfundidade()
	{
		return 0;
	}
	
	
	
	
}
