
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import Alfo.codigobasegrafos.Genericos.*;

public interface IGrafoNoDirigido {

    public Collection <TVertice> bea();
    
	public Collection <TVertice> bea(Comparable etiquetaOrigen);
    
	public TGrafoNoDirigido Prim();

    public TGrafoNoDirigido Kruskal();
	
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen);
    
	boolean esConexo();

    public boolean conectados(TVertice origen, TVertice destino);
}