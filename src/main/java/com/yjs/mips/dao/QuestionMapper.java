package com.yjs.mips.dao;

import com.yjs.mips.pojo.MipsMemory;
import com.yjs.mips.pojo.MipsRegister;
import com.yjs.mips.pojo.MipsStack;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    public void createInitMemory(MipsMemory memory);
    public void createInitRegister(MipsRegister register);
    public List<MipsRegister> findInitRegisters(Integer id);
    public List<MipsMemory> findInitMemories(Integer id);
    public void createResMemory(MipsMemory memory);
    public void createResRegister(MipsRegister register);
    public List<MipsRegister> findResRegisters(Integer id);
    public List<MipsMemory> findResMemories(Integer id);
    public void createStack(MipsStack stack);
    public MipsStack findStack(Integer id);
}
