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
     * 变量表，以变量名为key，包括：变量idx、变量类型、变量的值
     */
    private final Map<String, ImmutableTriple<Integer, Integer, String>> variables = new HashMap<>();

    /**
     * 指令列表
     */
    private final List<Instruction> instructions = new ArrayList<>();

    @Override
    public void exitVariable(JinxParser.VariableContext ctx) {
        String id = ctx.ID().getText();
        JinxParser.ValueContext variable = ctx.value();
        String text = variable.getText();
        int type = variable.getStart().getType();
        int idx = variables.size();
        instructions.add(new VariableInstruction(idx, type, text));
        variables.put(id, ImmutableTriple.of(idx, type, text));
    }

    @Override
    public void exitPrint(JinxParser.PrintContext ctx) {
        String id = ctx.ID().getText();
        if (!variables.containsKey(id)) {
            System.err.printf("variable %s not exist\n", id);
            System.exit(1);
        }
        instructions.add(new PrintInstruction(variables.get(id).getLeft(), variables.get(id).getMiddle()));
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

}
