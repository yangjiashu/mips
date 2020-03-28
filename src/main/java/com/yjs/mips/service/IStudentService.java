package com.yjs.mips.service;

import com.yjs.mips.pojo.AnswerStatus;

public interface IStudentService {
    public AnswerStatus assemble(int student_id, int questionId, String filePath);
}
