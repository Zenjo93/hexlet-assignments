package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    String error;

    public NegativeRadiusException(String error){
        this.error = error;
    }

    public NegativeRadiusException(){
    }

}
// END
