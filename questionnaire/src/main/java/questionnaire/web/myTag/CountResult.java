package questionnaire.web.myTag;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import questionnaire.database.*;
import questionnaire.utils.TextConstruct;
import questionnaire.web.dao.QuestionResultDao;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.*;

/**
 * calculate the Result and format it into which the eChartCloud can use
 */
public class CountResult extends SimpleTagSupport {
    @Autowired
    private QuestionResultDao questionResultDao;

    /**
     * the question to be calculated
     */
    QuestionType question;

    /**
     * question order
     */
    Integer iCount;

    /**
     * record
     */
    Map<Integer, Integer> choiceCount = new HashMap<>();
    Map<Integer, String> choiceOrder = new HashMap<>();


    @Override
    public void doTag() throws IOException {

        PageContext context = (PageContext)getJspContext();
        HttpSession session = context.getSession();
        JspWriter out = context.getOut();

        List<QuestionTypeResult> qResults= questionResultDao.readResultsByModel(this.question.getQuestionId());
        if(question.getQuestionType()){

            List<TextConstruct> lists = new ArrayList<>();
            for(QuestionTypeResult result: qResults){
                QTextResult temp = (QTextResult) result;
                lists.add(new TextConstruct(temp.getAnswer(), 1));

            }

            session.setAttribute("text", JSON.toJSONString(lists));

        } else {

            Set<Choice> choices = ((QChoose)question).getChoices();

            for(Choice c: choices){
                choiceCount.put(c.getcOrder(), 0);
                choiceOrder.put(c.getcOrder(), c.getChoiceContent());
            }

            for(QuestionTypeResult result: qResults){
                QChooseResult temp = (QChooseResult) result;
                for(ChoiceResult choice: temp.getResults()){
                    int order = choice.getcOrder();
                    choiceCount.replace(order, choiceCount.get(order)+1);
                }
            }

            String xData = "";
            String sData = "[";
            for(int i=1; i<=choices.size(); i++){
                xData += choiceOrder.get(i) + ",";
                sData += choiceCount.get(i).toString() + ",";
            }
            xData = xData.substring(0, xData.length()-1);
            sData += "]";

            String n = iCount.toString();
            out.print(StructInput("xData-"+n, xData));
            out.print(StructInput("sData-"+n, sData));
        }

    }

    /**
     * construct input table
     * @param id id of input
     * @param value value to be transform
     * @return input label
     */
    private String StructInput(String id, String value){
        return "<input id='" + id + "' type='hidden' value='"+ value +"' />";
    }

    public QuestionType getQuestion() {
        return question;
    }

    public void setQuestion(QuestionType question) {
        this.question = question;
    }

    public Integer getiCount() {
        return iCount;
    }

    public void setiCount(Integer iCount) {
        this.iCount = iCount;
    }
}

