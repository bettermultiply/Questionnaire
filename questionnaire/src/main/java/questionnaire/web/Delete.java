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
@RequestMapping("/test/")
public class Delete {


    @RequestMapping(method = RequestMethod.GET)
    public String HomeDataInit() throws HibernateException {

        CommonUser user = CommonUserTools.readOneUser("betmul");
        QuestionnaireTools.deleteQuestionnaire(user.getUserId());
        return "welcome";
    }
}
