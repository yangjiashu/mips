package com.yjs.mips.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MipsAnswer {
    private Integer id;
    private Integer studentId;
    private Integer questionId;
    private Timestamp datetime;
    private boolean correct;
    private String info;
}
