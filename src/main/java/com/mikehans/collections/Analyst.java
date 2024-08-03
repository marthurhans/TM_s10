package com.mikehans.collections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements IEmployee, Apple {

    private int projectCount =0;

    String analystRegex = "\\w+=(?<projectCount>\\w+)";
    Pattern analystPat = Pattern.compile(analystRegex);


    public Analyst(String peopleText) {
        super(peopleText);
        Matcher analystMat= analystPat.matcher(peopleMat.group("details"));
        if (analystMat.find()) {
            this.projectCount = Integer.parseInt(analystMat.group("projectCount"));
        }
    }

    @Override
    public int getSalary() {
//        salary = 3500 + orgSize * directReports;
        return 2500 + projectCount * 2;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}

