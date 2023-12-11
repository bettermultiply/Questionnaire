package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.database.*;
import questionnaire.utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class DeleteTest {


    @RequestMapping(method = RequestMethod.GET)
    public String HomeDataInit() throws HibernateException {
//        Session session;
//        session = SessionFactorySource.getSessionFactory().openSession();
//        session.beginTransaction();
//        CommonUser user = new CommonUser();
//        QuestionnaireTable tables= new QuestionnaireTable();
//        QuestionType type = new QText();
//        user.setUserName("betmul");
//        user.setPassword("better");
//        session.save(user);
//        session.getTransaction().commit();
//        tables.setTableName("survey1");
//        tables.setUser(user);
//        tables.setIsChecked(true);
//        List<QuestionType> list = new ArrayList<QuestionType>();
//        list.add(type);
//        tables.setQuestions(list);
//        type.setParentTable(tables);
//        type.setDescription("choose you favorite");
//        QuestionnaireTools.createQuestionnaire(tables);
//        CommonUser uu = CommonUserTools.readOneUser("betmul");
//        List<QuestionnaireTable> tables1 = QuestionnaireTools.readOneUserCheckedQuestionnaires(uu.getUserId());
//        System.out.println(tables1.isEmpty());
//        System.out.println(uu.getQuestionnaireTables().isEmpty());
        CommonUserTools.createCommonUser(GenerateNewUserForTest.Generate("bet"));
//        QuestionTools.createQuestion(type);
//        session.close();
        return "welcome";
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String StatisticsDataInit() throws HibernateException {
        try (Session session = SessionFactorySource.getSessionFactory().openSession();){
            System.out.println("Create");
        }
        return "statistics";
    }
}
