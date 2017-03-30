package com.wordsum.read.models.story;

import com.wordsum.read.models.text.FileState;

import java.util.List;

/**
 * Created by kalab on 9/6/15.
 */
public class NarrativeState {


    FileState fileState;
    List<NarratorState> narratorStates;
    List<PlotState> plotStates;
    List<SettingState> settingStates;


    public FileState getFileState() {
        return fileState;
    }

    public void setFileState(FileState fileState) {
        this.fileState = fileState;
    }

    public List<NarratorState> getNarratorStates() {
        return narratorStates;
    }

    public void setNarratorStates(List<NarratorState> narratorStates) {
        this.narratorStates = narratorStates;
    }

    public void addNarratorState(NarratorState narratorState) {
        this.narratorStates.add(narratorState);
    }

    public List<PlotState> getPlotStates() {
        return plotStates;
    }

    public void setPlotStates(List<PlotState> plotStates) {
        this.plotStates = plotStates;
    }

    public List<SettingState> getSettingStates() {
        return settingStates;
    }

    public void setSettingStates(List<SettingState> settingStates) {
        this.settingStates = settingStates;
    }


}
