package edu.java.deipss.common.enums;

import lombok.Getter;

@Getter
enum Season implements SeasonShow {
    SPRING("春天", "春风意人"),
    SUMMER("夏天", "夏日炎炎");

    private String name;
    private String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void show() {
        System.out.println(this.desc);
    }
}
