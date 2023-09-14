package org.example.antlr.csv;

import org.example.antlr.csv.code.CsvBaseListener;
import org.example.antlr.csv.code.CsvParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvListener extends CsvBaseListener {

    /**
     * CSV的多行数据
     */
    private final List<Map<String, String>> rows = new ArrayList<>();

    /**
     * CSV的头部
     */
    private List<String> header;

    /**
     * 一行CSV数据
     */
    private List<String> row;

    /**
     * 进入一行
     */
    @Override
    public void enterRow(CsvParser.RowContext ctx) {
        // 创建一个list用来保存这一行的数据
        row = new ArrayList<>();
    }

    /**
     * 离开TEXT
     */
    @Override
    public void exitText(CsvParser.TextContext ctx) {
        // 添加这一列的数据
        row.add(ctx.TEXT().getText());
    }

    @Override
    public void exitString(CsvParser.StringContext ctx) {
        // 获取字符
        String field = ctx.STRING().getText();
        // 移除头部和尾部的双引号
        field = field.substring(1, field.length() - 2);
        // 因为CSV在双引号中用两个双引号代表单引号，这里转回来
        field = field.replaceAll("\"\"", "\"");
        row.add(field);
    }

    @Override
    public void exitEmpty(CsvParser.EmptyContext ctx) {
        // 添加空字符串
        row.add("");
    }

    /**
     * 离开某一行
     */
    @Override
    public void exitRow(CsvParser.RowContext ctx) {
        if (ctx.getParent() instanceof CsvParser.HdrContext) {
            // 如果某一行的父节点是header头部
            // 那么就把header的值设置成这一行的数据
            header = row;
            return;
        }
        Map<String, String> data = new HashMap<>();
        // 某一行已经遍历完毕，将这一行的数据和header组合起来，构成一个map
        for (int i = 0; i < row.size(); i++) {
            data.put(header.get(i), row.get(i));
        }
        // 将这一行数据添加到数据集中
        rows.add(data);
    }

    public List<Map<String, String>> getRows() {
        return rows;
    }

}
