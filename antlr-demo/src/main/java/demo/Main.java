package demo;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");
        CharStream is = new ANTLRInputStream(" x = 3");


        Lexer lexer = new ExampleLexer(is);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ExampleParser parser = new ExampleParser(tokens);

        System.out.println(parser.start().ID());

    }
}
