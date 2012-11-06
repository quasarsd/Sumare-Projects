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
	
	public No<T> procurarNo(T valor)
	{
		if(root.getValor().equals(valor))
			return root;
		else
		{
			if(root.getFilhos() != null && root.getFilhos().size() > 0)
			{
				for(No<T> noFilho : root.getFilhos())
				{
					return procurarNo(noFilho, valor);
				}
			}
		}		
		return null;
	}
	public No<T> procurarNo(No<T> no, T valor)
	{
		if(no.getValor().equals(valor))
			return no;
		
		else if(no.getFilhos() != null && no.getFilhos().size() > 0)
		{
			for(No<T> noFilho : no.getFilhos())
			{
				return procurarNo(noFilho, valor);
			}
		}
		return null;
	}
}
