package com.nosuchfield.jinx;

import com.nosuchfield.jinx.code.JinxBaseListener;
import com.nosuchfield.jinx.code.JinxParser;
import com.nosuchfield.jinx.instruction.Instruction;
import com.nosuchfield.jinx.instruction.PrintInstruction;
import com.nosuchfield.jinx.instruction.VariableInstruction;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loader extends JinxBaseListener {

    /**
     * 变量表，以变量名为key，包括：变量索引idx、变量类型
     */
    private final Map<String, ImmutablePair<Integer, Integer>> variables = new HashMap<>();

    /**
     * 指令列表
     */
    private final List<Instruction> instructions = new ArrayList<>();

    @Override
    public void exitVariable(JinxParser.VariableContext ctx) {
        // 变量名
        String id = ctx.ID().getText();
        JinxParser.ValueContext variable = ctx.value();
        // 变量值
        String text = variable.getText();
        // 变量类型
        int type = variable.getStart().getType();
        // 变量索引（表示这是第几个变量）
        int idx = variables.size();

        // 把这个变量保存在内存，方便后面知道这个变量的索引和类型
        variables.put(id, ImmutablePair.of(idx, type));
        // 创建保存这个变量的指令
        instructions.add(new VariableInstruction(idx, type, text));
    }

    @Override
    public void exitPrint(JinxParser.PrintContext ctx) {
        String id = ctx.ID().getText();
        if (!variables.containsKey(id)) {
            System.err.printf("variable %s not exist\n", id);
            System.exit(1);
        }
        int idx = variables.get(id).getLeft();
        int type = variables.get(id).getRight();
        // 创建打印的指令
        instructions.add(new PrintInstruction(idx, type));
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

}
