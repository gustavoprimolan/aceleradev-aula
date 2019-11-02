package br.com.aceleradev.services;

import br.com.aceleradev.annotations.Coluna;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

public class GeradorDeRelatorio {

    public void gerarRelatorio(List<Object> usuarios, int qtdColunas) {
        gerarTitulos(usuarios, qtdColunas);
        gerarLinhas(usuarios, qtdColunas);
    }

    private void gerarTitulos(List<Object> list, int qtdColunas) {
        for (int i = 1; i <= qtdColunas; i++) {
            Method metodoPorOrdem = getMetodoPorOrdem(list.get(0).getClass(), i);

            if(Objects.nonNull(metodoPorOrdem)){
                System.out.print(metodoPorOrdem.getAnnotation(Coluna.class).titulo());
            }

            if(i < qtdColunas) System.out.print(", ");
        }
        System.out.print("\n");
    }

    private void gerarLinhas(List<Object> list, int qtdColunas) {
        for(Object object : list){
            for (int i = 1; i <= qtdColunas; i++) {
                Method metodoPorOrdem = getMetodoPorOrdem(list.get(0).getClass(), i);

                if(Objects.nonNull(metodoPorOrdem)){
                    try {
                        System.out.print(metodoPorOrdem.invoke(object));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                if(i < qtdColunas) System.out.print(", ");
            }
            System.out.print("\n");
        }
    }

    private Method getMetodoPorOrdem(Class type, int ordem) {
        Method[] methods = type.getMethods();

        for(Method method : methods) {
            if(method.isAnnotationPresent(Coluna.class)
                    && method.getAnnotation(Coluna.class).posicao() == ordem) {
                return method;
            }
        }
        return null;
    }

}
