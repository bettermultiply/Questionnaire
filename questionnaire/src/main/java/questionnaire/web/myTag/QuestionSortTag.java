package questionnaire.web.myTag;

import questionnaire.database.QuestionType;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/**
 * 将问卷的问题进行排序后添加到页面的属性中
 */
public class QuestionSortTag extends SimpleTagSupport {
    /**
     * 问卷问题的Set
     */
    private Set<QuestionType> questionSet;

    /**
     * questionSet的Set方法
     *
     * @param questionSet 问卷问题的Set
     */
    public void setQuestionSet(Set<QuestionType> questionSet) {
        this.questionSet = questionSet;
    }

    /**
     * 将问卷问题的Set转换为ArrayList,然后对其按问题顺序进行排序,将其以"questionList"为属性名,添加到页面的属性中
     */
    @Override
    public void doTag() {
        ArrayList<QuestionType> questionList = new ArrayList<>(questionSet);
        // 对问卷的问题进行排序
        questionList.sort(Comparator.comparing(QuestionType::getQuestionOrder));
        // 添加到页面的属性
        getJspContext().setAttribute("questionList", questionList);
    }
}
