package questionnaire.web;

import questionnaire.database.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateNewUserForTest {

    public static CommonUser Generate(String prefix){
        List<Choice> ch1 = new ArrayList<Choice>();
        Choice c1 = chGenerate(prefix+"1", 1);
        Choice c2 = chGenerate(prefix+"2", 2);
        Choice c3 = chGenerate(prefix+"3", 3);
        ch1.add(c1);
        ch1.add(c2);
        ch1.add(c3);
        List<Choice> ch2 = new ArrayList<Choice>();
        Choice c4 = chGenerate(prefix+"4", 4);
        Choice c5 = chGenerate(prefix+"5", 5);
        Choice c6 = chGenerate(prefix+"6", 6);
        ch1.add(c5);
        ch1.add(c6);
        ch1.add(c4);

        List<QuestionType> qs = new ArrayList<>();
        QuestionType q1 = qGenerate(prefix+"1", true, true);
        QuestionType q2 = qGenerate(prefix+"2", false, true);
        QuestionType q3 = qGenerate(prefix+"3", false, false);
        ((QChoose)q2).setChoices(ch1);
        c1.setParentQ((QChoose)q2);
        c2.setParentQ((QChoose)q2);
        c3.setParentQ((QChoose)q2);
        ((QChoose)q3).setChoices(ch2);
        c4.setParentQ((QChoose)q3);
        c5.setParentQ((QChoose)q3);
        c6.setParentQ((QChoose)q3);

        qs.add(q1);
        qs.add(q2);
        qs.add(q3);

        Set<QuestionnaireTable> ts = new HashSet<>();
        QuestionnaireTable table = tGenerate(prefix);
        table.setQuestions(qs);
        ts.add(table);
        q1.setParentTable(table);
        q2.setParentTable(table);
        q3.setParentTable(table);

        CommonUser user = cGenerate(prefix);
        user.setQuestionnaireTables(ts);
        table.setUser(user);
        return user;
    }

    public static CommonUser cGenerate(String prefix){


        return new CommonUser(null, prefix+"man", "pass", null);
    }

    public static QuestionnaireTable tGenerate(String prefix) {

        return new QuestionnaireTable(null, prefix+"table", false, false, null, null, null);
    }

    public static QuestionType qGenerate(String prefix, Boolean type, Boolean ctype) {
        QuestionType qType;
        if(type){
            qType = new QText(null, prefix+"d", type, null, null);
        }else {
            qType = new QChoose(null, prefix+"c", type, null, null, ctype, null);
        }
        return qType;
    }

    public static Choice chGenerate(String prefix, Integer i) {
        return new Choice(null, i+1 , null, prefix, null);
    }

    public static QuestionTypeResult qrGenerate(String prefix, Boolean type) {
        QuestionTypeResult qType;
        if(type){
            qType = new QTextResult(null, null, null, type, prefix+"a");
        }else {
            qType = new QChooseResult(null, null, null, type, null);
        }
        return qType;
    }

    public static ChoiceResult chrGenerate(String prefix, Integer i) {
        return new ChoiceResult(null, i , null, null);
    }

}
