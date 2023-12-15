package questionnaire.web.myTag;

import questionnaire.database.Choice;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/**
 * 将问题的选项进行排序后添加到页面的属性中
 */
public class ChoiceSortTag extends SimpleTagSupport {
    /**
     * 问题选项的Set
     */
    private Set<Choice> choiceSet;

    /**
     * choiceSet的Set方法
     *
     * @param choiceSet 问题选项的Set
     */
    public void setChoiceSet(Set<Choice> choiceSet) {
        this.choiceSet = choiceSet;
    }

    /**
     * 将问题选项的Set转换为ArrayList,然后对其按选项顺序进行排序,将其以"choiceList"为属性名,添加到页面的属性中
     */
    @Override
    public void doTag() {
        ArrayList<Choice> choiceList = new ArrayList<>(choiceSet);
        // 对问题的选项进行排序
        choiceList.sort(Comparator.comparing(Choice::getcOrder));
        // 添加到页面的属性
        getJspContext().setAttribute("choiceList", choiceList);
    }
}
