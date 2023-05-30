package com.example.englishv2.ui.theme;

import com.example.englishv2.QuestionList;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static List<QuestionList> animalQuestions()
    {
        final List<QuestionList> questionList = new ArrayList<>();
        final QuestionList question1 = new QuestionList("Как переводится cat?", "кот", "собака",
                "панда","жираф" ,"кот", "");
        final QuestionList question2 = new QuestionList("Как переводится lion", "кот", "баран",
                "тигр","лев" ,"лев", "");
        final QuestionList question3 = new QuestionList("Как переводится panda?", "енот", "зебра",
                "панда","иглохвост" ,"панда", "");
        final QuestionList question4 = new QuestionList("Как переводится wolf?", "лев", "волк",
                "курица","ящерица" ,"волк", "");
        final QuestionList question5 = new QuestionList("Как переводится dog?", "лошадь", "собака",
                "краб","летучая мышь" ,"собака", "");
        final QuestionList question6 = new QuestionList("Как переводится mouse?", "мышь", "верблюд",
                "кабан","бык" ,"мышь", "");
        final QuestionList question7 = new QuestionList("Как переводится elephant?", "лиса", "олень",
                "слон","ленивец" ,"слон", "");
        final QuestionList question8 = new QuestionList("Как переводится zebra?", "зебра", "бобр",
                "лось","обезьяна" ,"зебра", "");
        final QuestionList question9 = new QuestionList("Как переводится cow?", "медведь", "вомбат",
                "горилла","корова" ,"корова", "");
        final QuestionList question10 = new QuestionList("Как переводится rhinoceros?", "носорог", "корова",
                "овца","жираф" ,"носорог", "");



        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }

    private static List<QuestionList> foodQuestions()
    {
        final List<QuestionList> questionList = new ArrayList<>();
        final QuestionList question1 = new QuestionList("Как переводится bacon?", "вишня", " мясо ",
                "свинина","бекон" ,"бекон", "");
        final QuestionList question2 = new QuestionList("Как переводится beef", "говядина", "печень",
                "куропатка","сосиска" ,"говядина", "");
        final QuestionList question3 = new QuestionList("Как переводится pike?", "сардины", "щука",
                "форель","осетрина" ,"щука", "");
        final QuestionList question4 = new QuestionList("Как переводится avocado?", "бобы", "морковь",
                "курица","авокадо" ,"авокадо", "");
        final QuestionList question5 = new QuestionList("Как переводится carrot?", "баклажан", "морковь",
                "горох","шпинат" ,"морковь", "");
        final QuestionList question6 = new QuestionList("Как переводится cucumber?", "огурец", "шпинат",
                "спаржа","свекла" ,"огурец", "");
        final QuestionList question7 = new QuestionList("Как переводится шпинат?", "spinach", "chard",
                "brussels sprout","beans" ,"spinach", "");
        final QuestionList question8 = new QuestionList("Как переводится garlic?", "миндаль", "ягода",
                "лимон","чеснок" ,"чеснок", "");
        final QuestionList question9 = new QuestionList("Как переводится apple?", "яблоко", "ананас",
                "апельсин","корова" ,"яблоко", "");
        final QuestionList question10 = new QuestionList("Как переводится melon?", "черника", "дыня",
                "апельсин","вишня" ,"дыня", "");



        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }

    private static List<QuestionList> drinkQuestions()
    {
        final List<QuestionList> questionList = new ArrayList<>();
        final QuestionList question1 = new QuestionList("Как переводится Coffee?", "чай", "сок",
                "вода","кофе" ,"кофе", "");
        final QuestionList question2 = new QuestionList("Как переводится Kvass", "квас", "лимонад",
                "газировка","пиво" ,"квас", "");
        final QuestionList question3 = new QuestionList("Как переводится Compote?", "чай", "лимонад",
                "компот","кока кола" ,"компот", "");
        final QuestionList question4 = new QuestionList("Как переводится tea?", "компот", "чай",
                "коктейль","кофе" ,"чай", "");
        final QuestionList question5 = new QuestionList("Как переводится water?", "вода", "чай",
                "ель","чай" ,"вода", "");
        final QuestionList question6 = new QuestionList("Как переводится Lemonade?", "квас", "сок",
                "кофе","лимонад" ,"лимонад", "");
        final QuestionList question7 = new QuestionList("Как переводится juice?", "чай", "вода",
                "сок","эль" ,"сок", "");
        final QuestionList question8 = new QuestionList("Как переводится Hot chocolate?", "горячий шоколад", "травяной чай",
                "кока-кола","квас" ,"горячий шоколад", "");
        final QuestionList question9 = new QuestionList("Как переводится яблочный сок?", "apple juice", "melon juice",
                "orange juice","multi-fruit juice" ,"apple juice", "");
        final QuestionList question10 = new QuestionList("Как переводится Beer?", "чай", "пиво",
                "ликер","вино" ,"пиво", "");



        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }

    private static List<QuestionList> emotionQuestions()
    {
        final List<QuestionList> questionList = new ArrayList<>();
        final QuestionList question1 = new QuestionList("Как переводится Sad?", "грустный", "энергичный ",
                "ненавистный","раненый" ,"грустный", "");
        final QuestionList question2 = new QuestionList("Как переводится Empty?", "раненый", "заинтересованный",
                "опустошенный","любящий" ,"опустошенный", "");
        final QuestionList question3 = new QuestionList("Как переводится Happy?", "везучий", "довольный",
                "гордый","счастливый" ,"счастливый", "");
        final QuestionList question4 = new QuestionList("Как переводится Mad?", "испуганный", "безумный",
                "шокированный","сонный" ,"безумный", "");
        final QuestionList question5 = new QuestionList("Как переводится Lovely?", "заинтересованный", "враждебный",
                "прекрасный","изолированный" ,"прекрасный", "");
        final QuestionList question6 = new QuestionList("Как переводится Loving?", "любящий", "довольный",
                "сильный","грустный" ,"любящий", "");
        final QuestionList question7 = new QuestionList("Как переводится Hopeful?", "полный надежд", "оптимистично-настроенный",
                "пессимистично-настроенный","стеснительный" ,"полный надежд", "");
        final QuestionList question8 = new QuestionList("Как переводится обычный?", "Sleepy", "Tired",
                "Normal","Loving" ,"Normal", "");
        final QuestionList question9 = new QuestionList("Как переводится довольный?", "Sorry", "Surprised",
                "Open","Pleased" ,"Pleased", "");
        final QuestionList question10 = new QuestionList("Как переводится гордый?", "Open", "Proud",
                "Upset","Worried" ,"Proud", "");



        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }


    public static List<QuestionList> getQuestions (String topic)
    {
        switch (topic)
        {
            case "animal": return animalQuestions();
            case "food": return foodQuestions();
            case "drink": return drinkQuestions();
            default:  return emotionQuestions();
        }
    }
}
