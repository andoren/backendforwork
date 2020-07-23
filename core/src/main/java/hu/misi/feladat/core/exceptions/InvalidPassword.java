package hu.misi.feladat.core.exceptions;

public class InvalidPassword extends Throwable {
    public InvalidPassword(String msg){
        super(msg);
    }
}
