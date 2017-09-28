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

    public List<Expression> getAdjacentExpressions() {
        return linkedExpressions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Expression))return false;
        Expression otherExpression = (Expression) obj;
        return this.getText().equals(otherExpression.getText());
    }
}
