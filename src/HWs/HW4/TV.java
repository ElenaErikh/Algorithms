package HWs.HW4;

import java.util.Comparator;

public class TV {

    protected int weightGram;
    protected int numberOfChannel;
    protected int soundVolume;
    protected boolean isOn;

    public int getNumberOfChannel() {
        return numberOfChannel;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public int getWeightGram() {
        return weightGram;
    }



    public TV(int numberOfChannel, int soundVolume, boolean isOn, int wightGram) {
        this.numberOfChannel = numberOfChannel;
        this.soundVolume = soundVolume;
        this.isOn = isOn;
        this.weightGram = wightGram;
    }

    public TV() {
        this.numberOfChannel = 0;
        this.soundVolume = 0;
        this.isOn = false;
        this.weightGram = 0;
    }

    public String getTVProp() {
        return "wightGram=" + weightGram + ", numberOfChannel=" + numberOfChannel + ", soundVolume=" + soundVolume + ", isOn=" + isOn;
    }

    public boolean compare(int otherNumberOfChannel, int otherSoundVolume, boolean otherIsOn, int otherWeightGram) {
        return (this.numberOfChannel == otherNumberOfChannel) && (this.soundVolume == otherSoundVolume) && (this.isOn == otherIsOn)  && (this.weightGram == otherWeightGram);
    }

}
