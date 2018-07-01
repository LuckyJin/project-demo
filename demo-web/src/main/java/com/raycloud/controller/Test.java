package com.raycloud.controller;

public class Test {

    private final String name;

    private final String stu;

    private final int age;

    private final Test test;

    private static final String tt = "test";

    public static class Builder{

        private final String name;

        private final String stu;

        private Test test;

        private int age;

        public Builder(String name, String stu) {
            this.name = name;
            this.stu = stu;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }
    }

    public String getTt() {
        return tt;
    }


    private Test(Builder builder){
        name = builder.name;
        stu = builder.stu;
        age = builder.age;
        test = builder.test;
    }

}
