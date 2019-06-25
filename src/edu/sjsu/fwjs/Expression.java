package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

/**
 * FWJS expressions.
 */
public interface Expression {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env);
}

// NOTE: Using package access so that all implementations of Expression
// can be included in the same file.

/**
 * FWJS constants.
 */
class ValueExpr implements Expression {
    private Value val;
    public ValueExpr(Value v) {
        this.val = v;
    }
    public Value evaluate(Environment env) {
        return this.val;
    }
}

/**
 * Expressions that are a FWJS variable.
 */
class VarExpr implements Expression {
    private String varName;
    public VarExpr(String varName) {
        this.varName = varName;
    }
    public Value evaluate(Environment env) {
        return env.resolveVar(varName);
    }
}

/**
 * A print expression.
 */
class PrintExpr implements Expression {
    private Expression exp;
    public PrintExpr(Expression exp) {
        this.exp = exp;
    }
    public Value evaluate(Environment env) {
        Value v = exp.evaluate(env);
        System.out.println(v.toString());
        return v;
    }
}
/**
 * Binary operators (+, -, *, etc).
 * Currently only numbers are supported.
 */
class BinOpExpr implements Expression {
    private Op op;
    private Expression e1;
    private Expression e2;
    public BinOpExpr(Op op, Expression e1, Expression e2) {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }
    
    @SuppressWarnings("incomplete-switch")
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
		IntVal r1 = (IntVal) e1.evaluate(env);
		IntVal r2 = (IntVal) e2.evaluate(env);
		
		int a = r1.toInt(), b = r2.toInt();
		int result = 0;
		// ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD, GT, GE, LT, LE, EQ
		switch(op)
		{
		case ADD:
			result = a + b;
			break;
		case SUBTRACT:
			result = a - b;
			break;
		case MULTIPLY:
			result = a * b;
			break;
		case DIVIDE:
			result = a / b;
			break;
		case MOD:
			result = a % b;
			break;
		case GT:
			return new BoolVal(a > b);
		case GE:
			return new BoolVal(a >= b);
		case LT:
			return new BoolVal(a < b);
		case LE:
			return new BoolVal(a <= b);
		case EQ:
			return new BoolVal(a == b);
	    default:
			return null;
		
		}
		return new IntVal(result);
        
    }
}

/**
 * If-then-else expressions.
 * Unlike JS, if expressions return a value.
 */
class IfExpr implements Expression {
    private Expression cond;
    private Expression thn;
    private Expression els;
    public IfExpr(Expression cond, Expression thn, Expression els) {
        this.cond = cond;
        this.thn = thn;
        this.els = els;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
        Value cond = this.cond.evaluate(env);
        if( cond.equals(new BoolVal(true)) ) {
            return this.thn.evaluate(env);
        } else if ( cond.equals(new BoolVal(false)) ) {
            if(this.els != null) {
                Value val = this.els.evaluate(env);
                return val;
            }
            return null;
        } else {
            throw new RuntimeException("Error/warning: Booleans accepted!");
        }
    }
}

/**
 * While statements (treated as expressions in FWJS, unlike JS).
 */
class WhileExpr implements Expression {
    private Expression cond;
    private Expression body;
    public WhileExpr(Expression cond, Expression body) {
        this.cond = cond;
        this.body = body;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
		BoolVal b = (BoolVal)cond.evaluate(env);
        if(b.toBoolean() == false)
        { 
            
            return new NullVal();
        }
		else
		{	
			body.evaluate(env);
			return this.evaluate(env);
		}
    }
}

/**
 * Sequence expressions (i.e. 2 back-to-back expressions).
 */
class SeqExpr implements Expression {
    private Expression e1;
    private Expression e2;
    public SeqExpr(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
        
        if(e1 == null) return null;
        e1.evaluate(env);  
        
        if(e2 == null) return null;
        Value r2 = e2.evaluate(env);
        
        return r2;
    
        
    }
}

/**
 * Declaring a variable in the local scope.
 */
class VarDeclExpr implements Expression {
    private String varName;
    private Expression exp;
    public VarDeclExpr(String varName, Expression exp) {
        this.varName = varName;
        this.exp = exp;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
    	Value value = exp.evaluate(env);
    	env.createVar(varName, value);
    return value;
    }
}

/**
 * Updating an existing variable.
 * If the variable is not set already, it is added
 * to the global scope.
 */
class AssignExpr implements Expression {
    private String varName;
    private Expression e;
    public AssignExpr(String varName, Expression e) {
        this.varName = varName;
        this.e = e;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
    	Value e1 = e.evaluate(env);
    	if(env.resolveVar(varName) == null)    		
    		env.createVar(varName, e1); 	
    	else env.updateVar(varName, e1);
    	return e1;
    }
}

/**
 * A function declaration, which evaluates to a closure.
 */

class FunctionDeclExpr implements Expression {
    private List<String> params;
    private Expression body;
    public FunctionDeclExpr(List<String> params, Expression body) {
        this.params = params;
        this.body = body;
    }
    public Value evaluate(Environment env) {
    // YOUR CODE HERE
    ClosureVal cv = new ClosureVal(params, body, env);
    return cv;
    }
}

/**
 * Function application.
 */
class FunctionAppExpr implements Expression {
    private Expression f;
    private List<Expression> args;
    public FunctionAppExpr(Expression f, List<Expression> args) {
        this.f = f;
        this.args = args;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
    	ClosureVal cv = (ClosureVal)f.evaluate(env);
    	List<Value> args1 = new ArrayList<>();
        for(int i = 0; i < args.size(); i++)
    		args1.add(i, args.get(i).evaluate(env));
        return cv.apply(args1);
    }
}

