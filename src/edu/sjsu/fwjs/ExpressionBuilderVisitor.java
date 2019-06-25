package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import edu.sjsu.fwjs.parser.FeatherweightJavaScriptBaseVisitor;
import edu.sjsu.fwjs.parser.FeatherweightJavaScriptParser;
import edu.sjsu.fwjs.parser.FeatherweightJavaScriptParser.ExprContext;

public class ExpressionBuilderVisitor extends FeatherweightJavaScriptBaseVisitor<Expression>{
    @Override
    public Expression visitProg(FeatherweightJavaScriptParser.ProgContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i=0; i<ctx.stat().size(); i++) { 
            Expression exp = visit(ctx.stat(i));
            if (exp != null) 
                stmts.add(exp);
        }
        return listToSeqExp(stmts);
    }

    @Override 
    public Expression visitBareExpr(FeatherweightJavaScriptParser.BareExprContext ctx) {
        Expression bareExp = visit(ctx.expr());
        return bareExp;
    }

    @Override
    public Expression visitIfThenElse(FeatherweightJavaScriptParser.IfThenElseContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression thn = visit(ctx.block(0));
        Expression els = visit(ctx.block(1));
        return new IfExpr(cond, thn, els);
    }

    @Override
    public Expression visitIfThen(FeatherweightJavaScriptParser.IfThenContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression thn = visit(ctx.block());
        IfExpr ifexp = new IfExpr(cond, thn, null);
        return ifexp;
    }

    @Override
    public Expression visitInt(FeatherweightJavaScriptParser.IntContext ctx) {
    	int val = Integer.valueOf(ctx.INT().getText());
        return new ValueExpr(new IntVal(val));
    }

    @Override
    public Expression visitParens(FeatherweightJavaScriptParser.ParensContext ctx) {
        Expression parens = visit(ctx.expr());
        return parens;
    }

    @Override
    public Expression visitFullBlock(FeatherweightJavaScriptParser.FullBlockContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i=1; i<ctx.getChildCount()-1; i++) {
            Expression exp = visit(ctx.getChild(i));
            stmts.add(exp);
        }
        return listToSeqExp(stmts);
    }

    /**
     * if the list has more than one expression,
     * this will convert the lists of expression to one sequence expression.
     */
    private Expression listToSeqExp(List<Expression> stmts) {
        
        if (stmts.isEmpty())
            return null; 
        Expression exp = stmts.get(0);
        for (int i=1; i<stmts.size(); i++) {
            exp = new SeqExpr(exp, stmts.get(i));
        }
        return exp;
    }

    @Override 
    public Expression visitSimpBlock(FeatherweightJavaScriptParser.SimpBlockContext ctx) {
        return visit(ctx.stat());
    }

    @Override
    public Expression visitWhile(FeatherweightJavaScriptParser.WhileContext ctx) {
		return new WhileExpr(visit(ctx.expr()), visit(ctx.block()));
    }
    
    @Override
    public Expression visitPrint(FeatherweightJavaScriptParser.PrintContext ctx) {
    	return new PrintExpr(visit(ctx.expr()));
    }
    
    @Override
    public Expression visitEmpty(FeatherweightJavaScriptParser.EmptyContext ctx) {
        return null;
    }
    
    public Expression visitFunctionDeclaration(FeatherweightJavaScriptParser.FunctionDeclarationContext ctx) {
    	List<String> params = new ArrayList<String>();
    	
    	List<TerminalNode> list = ctx.params().ID();
    	int listSize = list.size();
    	for(int i = 0; i < listSize; i++) {
    		params.add(String.valueOf(list.get(i)));
    	}
    	
    	Expression body = visit(ctx.block());
    	return new FunctionDeclExpr(params, body);
    }

	public Expression visitFunctionApplication(FeatherweightJavaScriptParser.FunctionApplicationContext ctx) {
    	Expression expr = visit(ctx.expr());
    	List<Expression> args = new ArrayList<Expression>();
    	
    	List<ExprContext> expList = ctx.args().expr();
    	int listSize = expList.size();
    	for(int i = 0; i < listSize; i++) {
    		args.add(visit(expList.get(i)));
    	}
    	
    	return new FunctionAppExpr(expr, args);
    }

    @Override
    public Expression visitAssignment(FeatherweightJavaScriptParser.AssignmentContext ctx) {
        Expression e = visit(ctx.expr());
        return new AssignExpr(ctx.ID().getText(), e);
    }
    
    @Override
    public Expression visitMulDivMod(FeatherweightJavaScriptParser.MulDivModContext ctx) {
        Expression exp1 = visit(ctx.expr(0));
    	Expression exp2 = visit(ctx.expr(1));
    	Op op = getEnum(String.valueOf(ctx.op.getText()));
    	return new BinOpExpr(op, exp1, exp2);
    }
    
    @Override
    public Expression visitBool(FeatherweightJavaScriptParser.BoolContext ctx) {
        boolean val = Boolean.valueOf(ctx.BOOL().getText());
    	return new ValueExpr(new BoolVal(val));
    }

    @Override
    public Expression visitNull(FeatherweightJavaScriptParser.NullContext ctx) {
        return new ValueExpr(new NullVal());
    }

    @Override
    public Expression visitAddSub(FeatherweightJavaScriptParser.AddSubContext ctx) {
        Expression exp1 = visit(ctx.expr(0));
    	Expression exp2 = visit(ctx.expr(1));
    	Op op = getEnum(String.valueOf(ctx.op.getText()));
    	return new BinOpExpr(op, exp1, exp2);
    }
    
    @Override
    public Expression visitVariableReference(FeatherweightJavaScriptParser.VariableReferenceContext ctx) {
    	return new VarExpr(String.valueOf(ctx.ID().getText()));
    }

    @Override
    public Expression visitComparison(FeatherweightJavaScriptParser.ComparisonContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i = 0; i < ctx.expr().size(); i++) {
            Expression exp = visit(ctx.expr(i));
            stmts.add(exp);
        }
        
        return new BinOpExpr(getEnum(ctx.op.getText()),stmts.get(0), stmts.get(1));
    }
    
    @Override
    public Expression visitVariableDeclaration(FeatherweightJavaScriptParser.VariableDeclarationContext ctx) {
        String name = String.valueOf(ctx.ID().getText());
    	Expression exp = visit(ctx.expr());
    	return new VarDeclExpr(name, exp);
    }

    private Op getEnum(String opSymbol) {
        if("+".equals(opSymbol)) {
            return Op.ADD;
        } else if ("-".equals(opSymbol)) {
            return Op.SUBTRACT;
        } else if ("*".equals(opSymbol)) {
            return Op.MULTIPLY;
        } else if ("/".equals(opSymbol)) {
            return Op.DIVIDE;
        } else if ("%".equals(opSymbol)) {
            return Op.MOD;
        } else if (">".equals(opSymbol) ) {
            return Op.GT;
        } else if (">=".equals(opSymbol) ) {
            return Op.GE;
        } else if ("<".equals(opSymbol) ) {
            return Op.LT;
        } else if ("<=".equals(opSymbol) ) {
            return Op.LE;
        } else if ("==".equals(opSymbol) ) {
            return Op.EQ;
        }  else {
            return null;
        }
    }
}