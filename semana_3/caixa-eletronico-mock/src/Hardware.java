import expecptions.ErroLerEnvelopeException;
import expecptions.ErroNumeroContaException;

public class Hardware {
	
		public void  pegarNumeroDaContaCartao() throws  ErroNumeroContaException;
		public void entregarDinheiro() throws ErroEntregarDinheiroException;
		public void lerEnvelope() throws ErroLerEnvelopeException;
}

