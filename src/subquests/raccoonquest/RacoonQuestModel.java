package subquests.raccoonquest;

import subquests.Expression;
import subquests.ExpressionGraph;

import java.util.List;

public class RacoonQuestModel {
   private ExpressionGraph expressions;
    public RacoonQuestModel(){
        expressions = new ExpressionGraph();
    }
    private void fillGraph(){
        List<Expression> expressions;
        Expression questionStrangeNoise = new Expression("Вы тянетесь за пакетиком с лимонами, но вдруг слышите странный звук позади себя. Что сделать?");
        Expression answerLookBack = new Expression("Смело оглянуться");

        Expression questionCuteRaccoon = new Expression("Вы понимаете, что источник звука - милый енот, который уронил пару пачек печенья с прилавка");
        Expression answerWonder = new Expression("Что? Енот в супермаркете?");
        Expression answerWonderResult = new Expression("Меньше лишних вопросов, с енотами шутки плохи.");
        Expression answerAllergy = new Expression("Господи, у меня аллергия на енотов и котиков из интернета, вызывайте врача!");
        Expression answerAllergyResult = new Expression("К сожалению, в этом супермаркете нет аптеки. И телефонной связи. Анафилактический шок - не очень приятная смерть.");

        Expression answerTenderness = new Expression("Ути бозе мой, какая прелесть");

        Expression questionManhole = new Expression("Вы пытаетесь погладить енота, однако он уворачивается и забегает в лаз.");
        Expression answerQuit = new Expression("Гоняться за енотами - бесполезная трата времени. Продолжить искать выход из этого места.");
        Expression answerLureOut = new Expression("Попытаться выманить енота печенькой");

        Expression answerOnward = new Expression("Полный вперед, да здравствует темная и опасная неизвестность!");
        Expression questionFeelColdThing = new Expression("Вы суете руку в лаз, пытаясь нашарить пушистого проказника. Ваша рука нащупывает что-то холодное");
        Expression answerGoOn = new Expression("Щупать дальше");
        Expression answerGetIt = new Expression("Достать предмет");

        Expression answerFreeze = new Expression("Замереть на полпути к пакетику");
        Expression questionParalysis = new Expression("Вас парализовало от страха, только и можете, что глазами вертеть. Сзади что-то коснулось вашей ноги.");
        Expression answerLookRight = new Expression("Поглазеть вправо");
        Expression answerLookLeft = new Expression("Поглазеть влево");
        Expression answerRollEyes = new Expression("Закатить глаза");
        Expression answerRollEyesResult = new Expression("Вы чувствуете себя довольно глупо. Через какое-то время вам надоело рассматривать свои веки изнутри, и вы видите, что магазин пуст.");



        Expression answerRun = new Expression("Бежать сломя голову неизвестно куда");
        Expression answerRunResult = new Expression("Вы неистово побежали, но не заметили стену и рассшиблись насмерть. Грустно:(");

        questionStrangeNoise.makeLinkWith(answerLookBack);
        questionStrangeNoise.makeLinkWith(answerFreeze);
        questionStrangeNoise.makeLinkWith(answerRun);
        answerRun.makeLinkWith(answerRunResult);

        answerFreeze.makeLinkWith(questionParalysis);
        questionParalysis.makeLinkWith(answerLookLeft);
        questionParalysis.makeLinkWith(answerLookRight);
        questionParalysis.makeLinkWith(answerRollEyes);

        answerLookLeft.makeLinkWith(questionCuteRaccoon);
        answerLookRight.makeLinkWith(questionCuteRaccoon);
        answerRollEyes.makeLinkWith(answerRollEyesResult);

        answerLookBack.makeLinkWith(questionCuteRaccoon);
        questionCuteRaccoon.makeLinkWith(answerWonder);
        questionCuteRaccoon.makeLinkWith(answerTenderness);
        questionCuteRaccoon.makeLinkWith(answerAllergy);

        answerAllergy.makeLinkWith(answerAllergyResult);
        answerWonder.makeLinkWith(answerWonderResult);

        answerTenderness.makeLinkWith(questionManhole);
        questionManhole.makeLinkWith(answerOnward);
        questionManhole.makeLinkWith(answerLureOut);
        questionManhole.makeLinkWith(answerQuit);

        answerOnward.makeLinkWith(questionFeelColdThing);
        questionFeelColdThing.makeLinkWith(answerGetIt);
        questionFeelColdThing.makeLinkWith(answerGoOn);
    }

}
