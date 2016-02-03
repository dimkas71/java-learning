package demo;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class DefaultErrorListener extends BaseErrorListener{

    public boolean HAS_ERRORS = false;
    private List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        HAS_ERRORS = true;
        errors.add(msg);
    }

    public List<String> getErrors() {
        return errors;
    }

}
