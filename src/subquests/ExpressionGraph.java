package subquests;

import subquests.Expression;

import java.util.*;

public class ExpressionGraph {
    private List<Expression> expressionGraph;
    public ExpressionGraph(){
        expressionGraph = new ArrayList<>();
    }
    public void addExpressionToGraph(Expression expression){
        expressionGraph.add(expression);
    }
    public void addExpressionsList(List<Expression> expressions){
        expressionGraph = expressions;
    }
    public Expression getExpressionByText(String text){
        for(Expression expression : expressionGraph){
            if(text.equals(expression.getText()))
                return expression;
        }
        return null;
    }
    private void peformBFS(Expression expression){
        int numberOfVertexes = expressionGraph.size();
        List<Boolean> visited = new ArrayList<>(Arrays.asList(new Boolean[numberOfVertexes]));
        Collections.fill(visited, Boolean.FALSE);

      //  Queue<Expression> expressionQueue = new
    }
}
