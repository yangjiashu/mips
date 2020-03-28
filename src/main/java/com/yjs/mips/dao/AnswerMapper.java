package com.yjs.mips.dao;

import com.yjs.mips.pojo.MipsAnswer;
import com.yjs.mips.pojo.MipsMemory;
import com.yjs.mips.pojo.MipsRegister;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnswerMapper {
    public void createAnswer(MipsAnswer answer);
    public void createReg(MipsRegister reg);
    public void createMem(MipsMemory mem);
    public List<MipsRegister> findRegs(Integer id);
    public List<MipsMemory> findMems(Integer id);
}
