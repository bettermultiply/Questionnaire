package questionnaire.web;

import questionnaire.database.*;
import questionnaire.utils.QuestionResultTools;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountResult extends SimpleTagSupport {
    QuestionType questionType;

    Map<Integer, Integer> choiceCount = new HashMap<>();


    String JsonList = "";
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        List<QuestionTypeResult> qResults= QuestionResultTools.readResults(this.questionType.getQuestionId());

        if(questionType.getQuestionType()){
            //TODO handle text
            for(QuestionTypeResult result: qResults){
                QTextResult temp = (QTextResult) result;
                this.JsonList += StructText(temp.getAnswer());
            }
            out.print(JsonList);
        } else {
            int count = ((QChoose)questionType).getChoices().size();
            for(int i=1 ; i<count; i++){
                choiceCount.put(i, 0);
            }
            //TODO handle choice
            for(QuestionTypeResult result: qResults){
                QChooseResult temp = (QChooseResult) result;
                for(ChoiceResult choice: temp.getResults()){
                    int order = choice.getcOrder();
                    choiceCount.replace(order, choiceCount.get(order)+1);
                }
            }
            String xData = "[";
            String sData = "[";
            for(Integer order: choiceCount.keySet()){
                xData += StructX(order);
                sData += StructS(choiceCount.get(order));
            }
            xData += "]";
            sData += "]";
            out.print(xData);
        }

    }

    private String StructInput(String id, String value){

        return "<input id=\"" + id + "\" type=\"hidden\" value=\""+ value +"\" />";
    }

    private String StructS(Integer num){
        return num.toString() +",";
    }

    private String StructX(Integer order){
        return "'"+ order.toString() +"',";
    }

    private String StructText(String content) {
        return "{name: \"" + ", value: \"1\"},";
    }

    public QuestionType getQuestion() {
        return questionType;
    }

    public void setQuestion(QuestionType question) {
        this.questionType = question;
    }
}
