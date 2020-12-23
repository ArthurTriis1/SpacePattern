/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 * Interface Generica responsavel por possibilitar a implementação do padrão 
 * Observable no sistema. O observable dispara os eventos para os subjects
 * IMPLEMENTA O PADRÃO OBSERVABLE
 */
public interface Observable<T>{
    
    public void add(Subject<T> subject);
    
    public void next(T event);
}
