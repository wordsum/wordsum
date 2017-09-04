package com.wordsum.read.models.text;

import java.util.List;
import java.util.Map;

/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2017 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */

public class FileState {

    private String file;
    private String version;
    private String gitSha;
    private String localDateTime;
    private String copyright;
    private List<String> writers;
    private List<String> editors;
    private List<String> publishers;
    private String fileState;
    private Integer wordCount;
    private Map<String, Map<String, List<Float>>> wordVectors;
    private List<ParagraphState> paragraphStates;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGitSha() {
        return gitSha;
    }

    public void setGitSha(String gitSha) {
        this.gitSha = gitSha;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getEditors() {
        return editors;
    }

    public void setEditors(List<String> editors) {
        this.editors = editors;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public String getFileState() {
        return fileState;
    }

    public void setFileState(String fileState) {
        this.fileState = fileState;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Map<String, Map<String, List<Float>>> getWordVectors() {
        return wordVectors;
    }

    public void setWordVectors(Map<String, Map<String, List<Float>>> wordVectors) {
        this.wordVectors = wordVectors;
    }

    public List<ParagraphState> getParagraphStates() {
        return paragraphStates;
    }

    public void setParagraphStates(List<ParagraphState> paragraphStates) {
        this.paragraphStates = paragraphStates;
    }

}
