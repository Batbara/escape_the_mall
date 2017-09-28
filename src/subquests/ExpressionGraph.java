package subquests;

import java.util.*;

public class ExpressionGraph {
    private List<Expression> expressionGraph;
    public ExpressionGraph(){
        expressionGraph = new ArrayList<>();
    }
    public void addExpressionsList(List<Expression> expressions){
        expressionGraph = expressions;
    }
    private List<String> getNodesText(){
        List<String> allText = new ArrayList<>();
        for(Expression node : expressionGraph){
            allText.add(node.getText());
        }
        return allText;
    }
    public void addEdge(int start, int end){
        Expression startExpression = expressionGraph.get(start);
        Expression endExpression = expressionGraph.get(end);
        startExpression.makeLinkWith(endExpression);

    }
    public boolean checkIsLast(String expressionText){
        Expression expression = search(expressionText);
        List<Expression> adj = expression.getAdjacentExpressions();
        return adj.isEmpty();
    }
    private Expression search(String toFind){
        Expression expToFind = new Expression(toFind);
        int startIndex = 0;
        Expression currentExpression = expressionGraph.get(startIndex);
        if(currentExpression.equals(expToFind))
            return currentExpression;
        LinkedList<Expression> queue =new LinkedList<>();
        Map<String, Boolean> visitedExpressions = getVisitedMap();

        visitedExpressions.put(currentExpression.getText(),true);
        queue.add(currentExpression);
        while (queue.size()!=0){
            currentExpression = queue.poll();
            List<Expression> adjExpressions = currentExpression.getAdjacentExpressions();
            for(Expression exp : adjExpressions){
                String expKey = exp.getText();
                if(!visitedExpressions.get(expKey)){
                    if(exp.equals(expToFind))
                        return exp;
                    visitedExpressions.put(expKey,true);
                    queue.add(exp);
                }
            }
        }
        return null;
    }
    private Map<String, Boolean> getVisitedMap(){
        Map<String,Boolean> visitedMap = new HashMap<>();
        for(String key : getNodesText()){
            visitedMap.put(key,false);
        }
        return visitedMap;
    }
    private List<Expression> getAdjList(Expression starter){
        Expression graphExpression = search(starter.getText());
        assert graphExpression != null;
        return graphExpression.getAdjacentExpressions();
    }
    //вход - узел ответа
    // выход - узел следующе
    public List<String> getValuesAdjTo(String startExpressionString){
        List<String> values = new ArrayList<>();
        Expression startExpression = new Expression(startExpressionString);
        List<Expression> adjExpressions = getAdjList(startExpression);
        for(Expression exp : adjExpressions){
            values.add(exp.getText());
        }
        return values;
    }

}
