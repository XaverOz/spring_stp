package com.example.demo.model;

public class Engine {
    private float power;
    private float volume;
    public float getPower() {
        return power;
    }
    public float getVolume() {
        return volume;
    }
    public void setPower(float power) {
        this.power = power;
    }
    public void setVolume(float volume) {
        this.volume = volume;
    }
    public String toString() {
        return "{power=" + this.power + ";volume=" + this.volume + "}";
    }
}
