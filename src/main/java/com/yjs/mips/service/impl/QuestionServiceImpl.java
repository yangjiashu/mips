package com.yjs.mips.service.impl;

import com.yjs.mips.dao.QuestionMapper;
import com.yjs.mips.pojo.*;
import com.yjs.mips.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionMapper questionMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void addQuestion(MipsQuestion question, AddStatus addStatus) {
        try {
            int id = question.getQuestionId();

            Map<String, Object> stackInit = question.getStack();
            MipsStack stack = new MipsStack();
            stack.setQuestionId(id);
            stack.setSize((int) stackInit.get("size"));
            List<Integer> content = (List<Integer>) stackInit.get("content");
            stack.setContent(content.toString());

            if (stack.getSize() != 0) questionMapper.createStack(stack);

            for (Map<String, Integer> memory : question.getMemsInit()) {
                for(Map.Entry<String, Integer> entry : memory.entrySet()) { // 只有一个
                    MipsMemory mem = new MipsMemory();
                    mem.setId(id);
                    mem.setAddress(entry.getKey());
                    mem.setValue(entry.getValue());
                    questionMapper.createInitMemory(mem);
                }
            }

            for (Map<String, Integer> memory : question.getMemsRes()) {
                for(Map.Entry<String, Integer> entry : memory.entrySet()) { // 只有一个
                    MipsMemory mem = new MipsMemory();
                    mem.setId(id);
                    mem.setAddress(entry.getKey());
                    mem.setValue(entry.getValue());
                    questionMapper.createResMemory(mem);
                }
            }

            for (Map<String, Integer> register : question.getRegsInit()) {
                for(Map.Entry<String, Integer> entry : register.entrySet()) { // 只有一个
                    MipsRegister reg = new MipsRegister();
                    reg.setId(id);
                    reg.setName(entry.getKey());
                    reg.setValue(entry.getValue());
                    questionMapper.createInitRegister(reg);
                }
            }

            for (Map<String, Integer> register : question.getRegsRes()) {
                for(Map.Entry<String, Integer> entry : register.entrySet()) { // 只有一个
                    MipsRegister reg = new MipsRegister();
                    reg.setId(id);
                    reg.setName(entry.getKey());
                    reg.setValue(entry.getValue());
                    questionMapper.createResRegister(reg);
                }
            }

            addStatus.setSuccess(true);
            addStatus.setInfo("添加成功");
        } catch (Exception e) {
            addStatus.setSuccess(false);
            addStatus.setInfo("后台添加数据出错，请重试");
            throw e;
        }
    }
}
