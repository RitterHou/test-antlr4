package com.nosuchfield.json;

import com.nosuchfield.json.code.JsonBaseListener;
import com.nosuchfield.json.code.JsonParser;

public class JsonListener extends JsonBaseListener {

    /**
     * 逗号加换行
     */
    private final String COMMA_NEWLINE = ",\n";

    /**
     * 缩进
     */
    private String indent = "";

    /**
     * 添加缩进
     */
    private void addTab() {
        indent += "  ";
    }

    /**
     * 移除缩进
     */
    private void removeTab() {
        indent = indent.replaceFirst(" {2}", "");
    }

    /**
     * 结果
     */
    private StringBuilder result = new StringBuilder();

    @Override
    public void enterJson(JsonParser.JsonContext ctx) {
        if (ctx.getChild(0) instanceof JsonParser.ArrayContext) {
            result.append("[\n");
            addTab();
        }
        if (ctx.getChild(0) instanceof JsonParser.ObjectContext) {
            result.append("{\n");
            addTab();
        }
    }

    @Override
    public void exitJson(JsonParser.JsonContext ctx) {
        if (ctx.getChild(0) instanceof JsonParser.ArrayContext) {
            result = removeLastComma(result);
            result.append("]");
            removeTab();
        }
        if (ctx.getChild(0) instanceof JsonParser.ObjectContext) {
            result = removeLastComma(result);
            result.append("}");
            removeTab();
        }
    }

    @Override
    public void enterObjectValue(JsonParser.ObjectValueContext ctx) {
        if (ctx.getParent() instanceof JsonParser.ArrayContext) {
            result.append(indent);
        }
        result.append("{\n");
        addTab();
    }

    @Override
    public void exitObjectValue(JsonParser.ObjectValueContext ctx) {
        result = removeLastComma(result);
        removeTab();
        result.append(indent).append("}" + COMMA_NEWLINE);
    }

    @Override
    public void enterArrayValue(JsonParser.ArrayValueContext ctx) {
        if (ctx.getParent() instanceof JsonParser.ArrayContext) {
            result.append(indent);
        }
        result.append("[\n");
        addTab();
    }

    @Override
    public void exitArrayValue(JsonParser.ArrayValueContext ctx) {
        result = removeLastComma(result);
        removeTab();
        result.append(indent).append("]" + COMMA_NEWLINE);
    }

    @Override
    public void enterKv(JsonParser.KvContext ctx) {
        result.append(indent).append(ctx.STRING().getText()).append(": ");
    }

    @Override
    public void exitValue(JsonParser.ValueContext ctx) {
        if (ctx.getParent() instanceof JsonParser.ArrayContext) {
            result.append(indent);
        }
        result.append(ctx.getText()).append(COMMA_NEWLINE);
    }

    public String getResult() {
        return result.toString();
    }

    /**
     * 将最后的逗号加换行替换为换行
     */
    private StringBuilder removeLastComma(StringBuilder data) {
        if (!data.toString().endsWith(COMMA_NEWLINE)) {
            return data;
        }
        data = new StringBuilder(data.substring(0, data.length() - 2));
        data.append("\n");
        return data;
    }

}
