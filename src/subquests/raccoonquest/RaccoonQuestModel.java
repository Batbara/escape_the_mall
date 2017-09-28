package subquests.raccoonquest;

import subquests.Expression;
import subquests.ExpressionGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaccoonQuestModel {
   private ExpressionGraph expressions;
   private Map<String, List<String> > endingsList;
    public RaccoonQuestModel(){
        expressions = new ExpressionGraph();
        fillGraph();
        fillEndingsList();
    }
    private void fillEndingsList(){
        String[] fatalEndings = {
                "<html><center>Вы неистово побежали, но не заметили стену и рассшиблись насмерть.<br>Грустно:(</center>",
                "Меньше лишних вопросов, с енотами шутки плохи.",
                "<html><center>К сожалению, в этом супермаркете нет телефонной связи.<br>И аптеки. " +
                        "Анафилактический шок - не очень приятная смерть.</center>",
        };
        String[] justQuitEndings = {
                "<html><center>Вы больше ничего не нашли, скорее потеряли.<br>Понимание происходящего</center>",
                "<html><center>Вы так и не узнали, какие секреты<br>таил в себе лаз в супермаркете. Зато ручки чистые.</center>",
                "Эх, у вас нет печеньки :(",
                "<html><center>Вы решили продолжить искать выход из этого места.<br>Ну, бывает.</center>",
                "<html><center>Вы чувствуете себя довольно глупо. Через какое-то время<br>вам надоело рассматривать свои веки изнутри,<br>" +
                "и вы видите, что магазин пуст.</center>",

        };
        String[] getItemEndings = {
                "<html><center>Вы достаете бумажку, на которой написано \"2->9\".<br>А енотик убежал.</center>",
        };
        endingsList = new HashMap<>();
        endingsList.put("fatal", Arrays.asList(fatalEndings));
        endingsList.put("quit",Arrays.asList(justQuitEndings));
        endingsList.put("item",Arrays.asList(getItemEndings));
    }
    private void fillGraph(){
        List<Expression> expressionsList = new ArrayList<>();
        String[] expressionsValues = getExpressionsValues();
        for(String value : expressionsValues){
            Expression expressionNode = new Expression(value);
            expressionsList.add(expressionNode);
        }
        expressions.addExpressionsList(expressionsList);
        addConnections();
    }

    private String[] getExpressionsValues(){
        String[] expressionsValues = {
                "Вы тянетесь за пакетиком с лимонами, но вдруг слышите странный звук позади себя. Что сделать?",
                "Смело оглянуться",
                "Замереть на полпути к пакетику",
                "<html><center>Бежать сломя голову<br>неизвестно куда</center>",
                "Вы понимаете, что источник звука - милый енот, который уронил пару пачек печенья с прилавка",
                "Вас парализовало от страха, только и можете, что глазами вертеть. Сзади что-то коснулось вашей ноги.",
                "<html><center>Вы неистово побежали, но не заметили стену и рассшиблись насмерть.<br>Грустно:(</center>",
                "Что? Енот в супермаркете?",
                "Ути бозе мой, какая прелесть",
                "<html><center>Господи, у меня аллергия<br>на милоту, вызывайте врача!</center>",
                "Поглазеть вправо",
                "Поглазеть влево",
                "Закатить глаза",
                "Меньше лишних вопросов, с енотами шутки плохи.",
                "Вы пытаетесь погладить енота, однако он уворачивается и забегает в лаз.",
                "<html><center>К сожалению, в этом супермаркете нет телефонной связи.<br>И аптеки." +
                        " Анафилактический шок - не очень приятная смерть.</center>",
                "<html><center>Вы чувствуете себя довольно глупо. Через какое-то время<br>вам надоело рассматривать свои веки изнутри,<br>" +
                        "и вы видите, что магазин пуст.</center>",
                "<html><center>Полный вперед, да здравствует<br>темная и опасная неизвестность!</center>",
                "<html><center>Попытаться выманить енота<br>печенькой</center>",
                "<html><center>Гоняться за енотами -<br>бесполезная трата времени.</center>",
                "Вы суете руку в лаз, пытаясь нашарить пушистого проказника. Ваша рука нащупывает что-то сухое и шершавое",
                "Эх, у вас нет печеньки :(",
                "<html><center>Вы решили продолжить искать выход из этого места.<br>Ну, бывает.</center>",
                "Щупать дальше",
                "Достать предмет",
                "<html><center>ГОСПОДИБОЖЕМОЙ, В МУСОРКЕ<br>ШАРЮСЬ, ВЫХОД СРОЧНО</center>",
                "<html><center>Вы больше ничего не нашли, скорее потеряли.<br>Понимание происходящего</center>",
                "<html><center>Вы достаете бумажку, на которой написано \"2->9\".<br>А енотик убежал.</center>",
                "<html><center>Вы так и не узнали, какие секреты<br>таил в себе лаз в супермаркете. Зато ручки чистые.</center>"
        };
        return expressionsValues;
    }
    private void addConnections(){
        expressions.addEdge(0,1);
        expressions.addEdge(0,2);
        expressions.addEdge(0,3);

        expressions.addEdge(1,4);
        expressions.addEdge(2,5);
        expressions.addEdge(3,6);

        expressions.addEdge(4,7);
        expressions.addEdge(4,8);
        expressions.addEdge(4,9);

        expressions.addEdge(5,10);
        expressions.addEdge(5,11);
        expressions.addEdge(5,12);

        expressions.addEdge(7,13);
        expressions.addEdge(8,14);
        expressions.addEdge(9,15);

        expressions.addEdge(10,4);
        expressions.addEdge(11,4);
        expressions.addEdge(12,16);

        expressions.addEdge(14,17);
        expressions.addEdge(14,18);
        expressions.addEdge(14,19);

        expressions.addEdge(17,20);
        expressions.addEdge(18,21);
        expressions.addEdge(19,22);

        expressions.addEdge(20,23);
        expressions.addEdge(20,24);
        expressions.addEdge(20,25);

        expressions.addEdge(23,26);
        expressions.addEdge(24,27);
        expressions.addEdge(25,28);

    }

    public ExpressionGraph getExpressions() {
        return expressions;
    }

    public Map<String, List<String>> getEndingsList() {
        return endingsList;
    }
}
