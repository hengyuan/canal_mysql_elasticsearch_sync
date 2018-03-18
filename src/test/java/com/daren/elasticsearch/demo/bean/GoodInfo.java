package com.daren.elasticsearch.demo.bean;

import io.searchbox.annotations.JestId;

/**
 * 作者：韩家富
 * 描述：
 */
public class GoodInfo {
    @JestId
    private Long id;
    private String darenNoteTitle;
    private String darenNoteReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDarenNoteTitle() {
        return darenNoteTitle;
    }

    public void setDarenNoteTitle(String darenNoteTitle) {
        this.darenNoteTitle = darenNoteTitle;
    }

    public String getDarenNoteReason() {
        return darenNoteReason;
    }

    public void setDarenNoteReason(String darenNoteReason) {
        this.darenNoteReason = darenNoteReason;
    }

    @Override
    public String toString() {
        return "GoodInfo{" +
                "id=" + id +
                ", darenNoteTitle='" + darenNoteTitle + '\'' +
                ", darenNoteReason='" + darenNoteReason + '\'' +
                '}';
    }

}
