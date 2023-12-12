package questionnaire.web;

import questionnaire.database.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * this is the class to init data for test
 */
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
        Choice c4 = chGenerate(prefix+"4", 1);
        Choice c5 = chGenerate(prefix+"5", 2);
        Choice c6 = chGenerate(prefix+"6", 3);
        ch2.add(c5);
        ch2.add(c6);
        ch2.add(c4);


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

        Set<QuestionTypeResult> qrs = new HashSet<>();
        //text
        QuestionTypeResult qr1 = qrGenerate(prefix+"1", true);
        QuestionTypeResult qr2 = qrGenerate(prefix+"1", true);
        QuestionTypeResult qr3 = qrGenerate(prefix+"2", true);
        QuestionTypeResult qr4 = qrGenerate(prefix+"3", true);
        QuestionTypeResult qr5 = qrGenerate(prefix+"4", true);
        QuestionTypeResult qr6 = qrGenerate(prefix+"3", true);
        QuestionTypeResult qr7 = qrGenerate(prefix+"3", true);
        qrs.add(qr1);qrs.add(qr2);qrs.add(qr3);qrs.add(qr4);qrs.add(qr5);qrs.add(qr6);qrs.add(qr7);
        qr1.setModelType(q1);qr2.setModelType(q1);qr3.setModelType(q1);qr4.setModelType(q1);
        qr5.setModelType(q1);qr6.setModelType(q1);qr7.setModelType(q1);
        q1.setResults(qrs);
        //single
        Set<QuestionTypeResult> qrs1 = new HashSet<>();
        QuestionTypeResult qrc1 = qrGenerate(prefix+"1", false);
        QuestionTypeResult qrc2 = qrGenerate(prefix+"2", false);
        QuestionTypeResult qrc3 = qrGenerate(prefix+"3", false);
        qrs1.add(qrc1);qrs1.add(qrc2);qrs1.add(qrc3);
        qrc1.setModelType(q2);qrc2.setModelType(q2);qrc3.setModelType(q2);
        q2.setResults(qrs1);
        //TODO
        //multi
        Set<QuestionTypeResult> qrs2 = new HashSet<>();
        QuestionTypeResult qrc6 = qrGenerate(prefix+"6", false);
        QuestionTypeResult qrc7 = qrGenerate(prefix+"7", false);
        QuestionTypeResult qrc8 = qrGenerate(prefix+"8", false);
        qrs2.add(qrc6);qrs2.add(qrc7);qrs2.add(qrc8);
        qrc6.setModelType(q3);qrc7.setModelType(q3);qrc8.setModelType(q3);
        q3.setResults(qrs2);

        //single
        Set<ChoiceResult> chr1 = new HashSet<>();
        ChoiceResult cr11 = chrGenerate(prefix, 1);
        chr1.add(cr11);
        cr11.setParentChosenResult((QChooseResult) qrc1);
        cr11.setModelChoice(c1);
        ((QChooseResult)qrc1).setResults(chr1);

        Set<ChoiceResult> chr2 = new HashSet<>();
        ChoiceResult cr12 = chrGenerate(prefix, 1);
        ChoiceResult cr13 = chrGenerate(prefix, 2);
        chr2.add(cr12);
        chr2.add(cr13);
        cr12.setParentChosenResult((QChooseResult) qrc2);
        cr13.setParentChosenResult((QChooseResult) qrc2);
        cr12.setModelChoice(c1);
        cr13.setModelChoice(c1);
        ((QChooseResult)qrc2).setResults(chr2);
        Set<ChoiceResult> chr3 = new HashSet<>();
        chr3.add(cr11);chr3.add(cr12);
        c1.setResults(chr3);
        Set<ChoiceResult> chr4 = new HashSet<>();
        chr4.add(cr13);
        c2.setResults(chr4);


        Set<ChoiceResult> chr7 = new HashSet<>();
        ChoiceResult cr2 = chrGenerate(prefix, 1);
        ChoiceResult cr3 = chrGenerate(prefix, 3);
        chr7.add(cr2);
        chr7.add(cr3);
        ((QChooseResult)qrc6).setResults(chr7);
        cr2.setModelChoice(c4);
        cr3.setModelChoice(c4);
        cr2.setParentChosenResult((QChooseResult) qrc6);
        cr3.setParentChosenResult((QChooseResult) qrc6);

        Set<ChoiceResult> chr5 = new HashSet<>();
        ChoiceResult cr4 = chrGenerate(prefix, 2);
        chr5.add(cr4);
        ((QChooseResult)qrc7).setResults(chr5);
        cr4.setModelChoice(c5);
        cr4.setParentChosenResult((QChooseResult) qrc7);

        Set<ChoiceResult> chr6 = new HashSet<>();
        ChoiceResult cr5 = chrGenerate(prefix, 3);
        ChoiceResult cr6 = chrGenerate(prefix, 3);
        chr6.add(cr5);
        chr6.add(cr6);
        ((QChooseResult)qrc8).setResults(chr6);
        cr5.setModelChoice(c6);
        cr6.setModelChoice(c6);
        cr5.setParentChosenResult((QChooseResult) qrc8);
        cr6.setParentChosenResult((QChooseResult) qrc8);

        Set<ChoiceResult> ccc1 = new HashSet<>();
        Set<ChoiceResult> ccc2 = new HashSet<>();
        Set<ChoiceResult> ccc3 = new HashSet<>();
        ccc1.add(cr2);
        c4.setResults(ccc1);
        ccc2.add(cr4);
        c5.setResults(ccc2);
        ccc3.add(cr3);
        ccc3.add(cr5);
        ccc3.add(cr6);
        c6.setResults(ccc3);

        q1.setResults(qrs);

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

        return new QuestionnaireTable(null, prefix+"-table", false, false, null, null, null);
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
