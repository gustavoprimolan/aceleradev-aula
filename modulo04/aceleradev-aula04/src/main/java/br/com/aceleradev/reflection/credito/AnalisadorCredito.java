package br.com.aceleradev.reflection.credito;

import br.com.aceleradev.reflection.externo.Pessoa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnalisadorCredito {

    private RegrasCreditoRepository repository;

    public AnalisadorCredito(){
        repository = new RegrasCreditoRepository();
    }

    public boolean analisarCredito(Pessoa pessoa) {
        Method[] declaredMethods = Pessoa.class.getDeclaredMethods();
        boolean regraValida = true;

        for(RegraCredito regra : repository.findAllRegras()) {
            for(Method method : declaredMethods){
                if(method.getName().toUpperCase().equals("GET" + regra.getReferencia().toUpperCase())){
                    try {
                        long valor = (long) method.invoke(pessoa);
                        regraValida = regra.valida(valor);
                        if(!regraValida) return false;
                        break;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return regraValida;
    }

}
