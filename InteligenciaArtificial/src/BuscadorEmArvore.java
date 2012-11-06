import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BuscadorEmArvore<T> {
	public Set<List<No<T>>> buscaEmLargura(Arvore<T> arvore, T valorInicial, T valorFinal) 
	{	
		if(arvore != null && arvore.getRoot() != null)
		{
			Set<List<No<T>>> solucao;
			if(arvore.getRoot().getValor().equals(valorInicial))
			{
				return buscaEmLargura(arvore.getRoot(), valorFinal, new HashSet<List<No<T>>>());
			}
			else
			{
				No<T> novoRoot = arvore.procurarNo(valorInicial);
				if(novoRoot != null)
					return buscaEmLargura(novoRoot, valorFinal, new HashSet<List<No<T>>>());
				else
					return null;
			}		
		}		
		
		return null;
		
	}
	private Set<List<No<T>>> buscaEmLargura(No<T> raiz, T valorProcurado, Set<List<No<T>>> solucao) {
		if (!raiz.isConsultado()) {
			raiz.setConsultado(true);
			if (raiz.getValor().equals(valorProcurado)) {
				solucao.add(montarArvoreSolucao(raiz));
			} else {
				for (No<T> noFilho : raiz.getFilhos()) {
					noFilho.setPai(raiz);
					if (noFilho.getValor().equals(valorProcurado)) {
						solucao.add(montarArvoreSolucao(noFilho));
					}
				}
				for (No<T> noFilho : raiz.getFilhos()) {
					if (noFilho.getFilhos().size() > 0)
						buscaEmLargura(noFilho, valorProcurado, solucao);
				}
			}
		}
		return solucao;
	}

	private List<No<T>> montarArvoreSolucao(No<T> no) {
		List<No<T>> arvoreSolucao = new LinkedList<No<T>>();
		return montarArvoreSolucao(no, arvoreSolucao);
	}

	private List<No<T>> montarArvoreSolucao(No<T> no, List<No<T>> arvoreSolucao) {
		if (no.getPai() != null) {
			montarArvoreSolucao(no.getPai(), arvoreSolucao);
		}
		arvoreSolucao.add(no);
		return arvoreSolucao;
	}

	public List<No<T>> buscaGulosa(Arvore<T> arvore, T valorInicial, T valorFinal) {
		return null;
	}

	public List<No<T>> buscaAEstrela(Arvore arvore, No noInicial, No noFinal) {
		return null;
	}

}
