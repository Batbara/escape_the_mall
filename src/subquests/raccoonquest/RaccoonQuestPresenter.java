package subquests.raccoonquest;

import frames.MainFrame;
import subquests.ExpressionGraph;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class RaccoonQuestPresenter implements Observer {
    private RaccoonQuestModel model;
    private Observable observable;

    public RaccoonQuestPresenter(RaccoonQuestModel model, Observable observable) {
        this.model = model;
        this.observable = observable;
    }

    private void processInputExpression(String expressionText) {

        ExpressionGraph graph = model.getExpressions();
        List<String> adjacentExpressions = graph.getValuesAdjTo(expressionText);

        String nextExpression = adjacentExpressions.get(0);
        boolean isLast = graph.checkIsLast(nextExpression);
        if (isLast) {
            showExitMessage(nextExpression);
            return;
        }
        showQuestion(nextExpression);
        adjacentExpressions = graph.getValuesAdjTo(nextExpression);
        showAnswers(adjacentExpressions);

    }

    private void showExitMessage(String message) {
        RaccoonQuestDialog view = (RaccoonQuestDialog) observable;
        view.getDialogFrame().dispose();
        JFrame ownerFrame = view.getOwnerFrame();
        JOptionPane.showMessageDialog(ownerFrame,
                message,
                "Конец",
                JOptionPane.INFORMATION_MESSAGE);
        performEnding(message);
    }
    private void performEnding(String message){
        String endingType = "";
        Map<String,List<String>> endings = model.getEndingsList();
        for(String key : endings.keySet()){
            List<String> endingsList = endings.get(key);
            if(endingsList.contains(message))
                endingType = key;
        }
        switch (endingType){
            case "fatal":
                MainFrame.getInstance().showGameOverScreen();
                break;
        }
    }
    private void showQuestion(String questionText) {
        RaccoonQuestDialog view = (RaccoonQuestDialog) observable;
        JTextArea questionPane = view.getQuestionPane();
        questionPane.setText(questionText);
    }

    private void showAnswers(List<String> answers) {
        RaccoonQuestDialog view = (RaccoonQuestDialog) observable;
        List<JButton> buttons = view.getAnswerButtons();
        int answer = 0;
        for (JButton button : buttons) {
            String text = answers.get(answer);
            button.setText(text);
            button.setActionCommand(text);
            answer++;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        observable = o;
        String expressionValue = (String) arg;
        processInputExpression(expressionValue);
    }
}
