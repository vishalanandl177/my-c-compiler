package MyGCC;

public class ArithmeticResult extends ParsingResult{

    public ResultType myType;
    public String left;
    public String op;
    public String right;
    public String value;

    public ArithmeticResult(String l, String op, String r, String val){
	super(ResultType.ARITHMETIC);
	this.left = l;
	this.op = op;
	this.right = r;
	this.value = val;
    }

    public void setValue(String expr){
	this.value = expr;
    }

    public String getValue(){
	return this.value;
    }
}
