package com.wordsum.process.read.models.text;

public class Fragment {

    private Type type;
    private Integer order;
    private String text;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public enum Type {
        DIALOG, NARRATIVE, NONE;

        Type(){}
    }

    public static String DIALOG_OBJECT = "OBJECT";
    public static String DIALOG_SPACE = " ";

}