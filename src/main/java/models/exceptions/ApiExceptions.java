package models.exceptions;

public class ApiExceptions extends  RuntimeException{
    private  final int statusCode;

    public ApiExceptions(int statusCode, String errorMsg){
        super(errorMsg);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
