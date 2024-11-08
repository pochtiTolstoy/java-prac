public class ErrorHandler {
  private boolean ioError;
  private boolean wrongOp;
  private boolean zeroDiv;
  private char op;
  private String ioErrorMsg;
  public ErrorHandler() {
    ioError = false;
    wrongOp = false;
    zeroDiv = false;
    op = ' ';
    ioErrorMsg = "";
  }
  public boolean isError() {
    return ioError || wrongOp || zeroDiv;
  }
  public void setIoError(String msg) { 
    ioError = true; 
    ioErrorMsg = msg;
  }
  public void setWrongOp(char op_) { 
    wrongOp = true; 
    op = op_;
  }
  public void setZeroDiv() { zeroDiv = true; }
  public void printMsg() {
    if (ioError) printIoErrorMsg();
    if (wrongOp) printWrongOpMsg();
    if (zeroDiv) printZeroDivMsg();
  }
  private void printIoErrorMsg() {
    System.out.println("Error: " + ioErrorMsg);
  }
  private void printWrongOpMsg() {
    System.out.println("Error: wrong operator: " + op);
  }
  private void printZeroDivMsg() {
    System.out.println("Error. Zero division.");
  }
}
