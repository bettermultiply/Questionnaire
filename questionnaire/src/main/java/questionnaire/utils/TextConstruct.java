package questionnaire.utils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * the class writes for JSON to convert data
 */
public class TextConstruct {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "value")
    private Integer value;

    public TextConstruct(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

