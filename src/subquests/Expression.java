package subquests;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private String text;
    private List<Expression> linkedExpressions;
    public Expression(String text){
        this.text = text;
        linkedExpressions = new ArrayList<>();
    }
    public void makeLinkWith (Expression expression){
        linkedExpressions.add(expression);
    }

    public String getText() {
        return text;
    }
}
