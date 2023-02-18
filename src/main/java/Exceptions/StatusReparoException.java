package Exceptions;

/**
 * @author CrisMoura on 18/02/2023
 */
public class StatusReparoException extends Exception{
    @Override
    public String getMessage(){
        return "Status do reparo incorreto para essa ação";
    }
}
