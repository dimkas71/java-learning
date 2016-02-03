package demo;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Calendar;
import java.util.Stack;

public class CalculatorImpl extends CalculatorBaseListener implements Calculator {

    private DefaultErrorListener errorListener = new DefaultErrorListener();

    private int result = 0;

    private Stack<Integer> stack = new Stack<>();

    @Override
    public int evaluate(String expression) throws CalculatorException {

        ANTLRInputStream is = new ANTLRInputStream(expression);

        CalculatorLexer lexer = new CalculatorLexer(is);

        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(this, parser.prog());

        if (errorListener.HAS_ERRORS) {
            StringBuilder sb = new StringBuilder();
            for (String errorMessage : errorListener.getErrors()) {
                sb.append(errorMessage + "\n");
            }

            throw new CalculatorException(sb.toString());

        }

        return result;
    }


    @Override
    public void exitProg(CalculatorParser.ProgContext ctx) {
        result = stack.empty() ? 0 : stack.pop();
    }

    @Override
    public void exitAddSum(CalculatorParser.AddSumContext ctx) {
        //calculate result an push it back to the stack
        try {
            int right = stack.pop();
            int left = stack.pop();

            if (ctx.ADD() != null) {
                stack.push(left + right);
            }
            if (ctx.SUB() != null) {
                stack.push(left - right);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitMulDiv(CalculatorParser.MulDivContext ctx) {
        //calculate result an push it back to the stack
        try {
            int right = stack.pop();
            int left = stack.pop();

            if (ctx.MUL() != null) {
                stack.push(left * right);
            }
            if (ctx.DIV() != null) {
                stack.push(left / right);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterConst(CalculatorParser.ConstContext ctx) {
        stack.push(Integer.parseInt(ctx.NUMBER().getText()));
    }

}
