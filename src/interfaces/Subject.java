/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 * Interface Generica responsavel por possibilitar a implementação do padrão 
 * Observable no sistema. O Subject se increve nos Observables que desejar 
 * e roda 'execute' quando notificado.
 * IMPLEMENTA O PADRÃO OBSERVABLE
 */
public interface Subject<T> {
    public void execute(T event);
}
