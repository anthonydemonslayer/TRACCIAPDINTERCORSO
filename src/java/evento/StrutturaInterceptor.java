package evento;

import javax.interceptor.*;

@Interceptor
@Struttura

public class StrutturaInterceptor {
    private int contaMetodo = 0, contaMetodo2 = 0;
    @AroundInvoke
    public Object struttura(InvocationContext ic) throws Exception {
        if(ic.getParameters()[3].equals("giggetto")) {
            contaMetodo++;
            System.out.println("Tutti da giggetto!");
         }
        if(!ic.getParameters()[3].equals("giggetto")) {
            contaMetodo2++;
        }
        if((contaMetodo2-contaMetodo)>=20)
            System.out.println("Forza, andiamo anche da giggetto!");
         return ic.proceed();
    }
}