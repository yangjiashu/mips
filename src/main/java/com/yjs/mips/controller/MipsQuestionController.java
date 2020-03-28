package com.yjs.mips.controller;

import com.yjs.mips.pojo.*;
import com.yjs.mips.service.IQuestionService;
import com.yjs.mips.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class MipsQuestionController {

    @Autowired
    IQuestionService questionService;
    @Autowired
    IStudentService studentService;

    @RequestMapping("mips-add")
    @ResponseBody
    public AddStatus addQuestion(@RequestBody Map<String, Object> map) {
        AddStatus addStatus = new AddStatus();
        MipsQuestion question = new MipsQuestion();

        int questionId = (int) map.get("questionId");
        List<Map<String, Integer>> regsInit = (List<Map<String, Integer>>) ((Map<String, Object>) map.get("init")).get("reg");
        List<Map<String, Integer>> memsInit = (List<Map<String, Integer>>) ((Map<String, Object>) map.get("init")).get("mem");
        Map<String, Object> stackInit = (Map<String, Object>) map.get("stack");
        List<Map<String, Integer>> regsRes = (List<Map<String, Integer>>) ((Map<String, Object>) map.get("result")).get("reg");
        List<Map<String, Integer>> memsRes = (List<Map<String, Integer>>) ((Map<String, Object>) map.get("result")).get("mem");

        question.setQuestionId(questionId);
        question.setRegsInit(regsInit);
        question.setMemsInit(memsInit);
        question.setStack(stackInit);
        question.setRegsRes(regsRes);
        question.setMemsRes(memsRes);

        questionService.addQuestion(question, addStatus);

        return addStatus;
    }

    @RequestMapping("mips-file")
    @ResponseBody
    public AnswerStatus answerQuestion(@RequestBody Map<String, Object> map) {
        int studentId = (int) map.get("studentId");
        int questionId = (int) map.get("questionId");
        String filePath = (String) map.get("path");

        AnswerStatus status = studentService.assemble(studentId, questionId, filePath);

        return status;
    }
}
