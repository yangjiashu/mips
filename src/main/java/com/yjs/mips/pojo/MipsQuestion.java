package com.yjs.mips.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MipsQuestion {
    private Integer questionId;
    private List<Map<String, Integer>> memsInit;
    private List<Map<String, Integer>> regsInit;
    private List<Map<String, Integer>> memsRes;
    private List<Map<String, Integer>> regsRes;
    private Map<String, Object> stack;
}
