package questionnaire.web.myTag;

import questionnaire.database.QChoose;
import questionnaire.database.QuestionType;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 将QuestionType类型的对象进行类型转换为QChoose类型的对象,并将其添加到页面的属性中
 */
public class QuestionTypeConversionTag extends SimpleTagSupport {
    /**
     * QuestionType对象
     */
    private QuestionType question;

    /**
     * question的Set方法
     *
     * @param question QuestionType对象
     */
    public void setQuestion(QuestionType question) {
        this.question = question;
    }

    /**
     * 若question是QChoose的实例,将其转换为QChoose类型,并以"QChoose"为属性名,添加到页面的属性,使得在页面可以访问QChoose的属性.
     * 否则返回null
     */
    @Override
    public void doTag(){
        QChoose qChoose = null;
        // 判断question是否是QChoose的实例
        if (question instanceof QChoose){
            qChoose = (QChoose) question;
        }
        // 添加到页面的属性
        getJspContext().setAttribute("QChoose", qChoose);
    }
}
