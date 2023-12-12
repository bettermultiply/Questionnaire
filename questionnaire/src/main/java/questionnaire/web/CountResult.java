package questionnaire.web;

import com.alibaba.fastjson.JSON;
import questionnaire.database.*;
import questionnaire.utils.QuestionResultTools;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * calculate the Result and format it into which the eChartCloud can use
 */
public class CountResult extends SimpleTagSupport {

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


    @Override
    public void doTag() throws IOException {

        PageContext context = (PageContext)getJspContext();
        HttpSession session = context.getSession();
        JspWriter out = context.getOut();

        List<QuestionTypeResult> qResults= QuestionResultTools.readResultsByModel(this.question.getQuestionId());
        if(question.getQuestionType()){

            List<TextConstruct> lists = new ArrayList<>();
            for(QuestionTypeResult result: qResults){
                QTextResult temp = (QTextResult) result;
                lists.add(new TextConstruct(temp.getAnswer(), 1));

            }

            session.setAttribute("text", JSON.toJSONString(lists));

        } else {

            int count = ((QChoose)question).getChoices().size();

            for(int i=1 ; i<=count; i++){
                choiceCount.put(i, 0);
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
            for(Integer order: choiceCount.keySet()){
                xData += order.toString() + ",";
                sData += choiceCount.get(order).toString() + ",";
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

