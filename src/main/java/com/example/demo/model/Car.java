package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String name;
    private String color;
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "{name=" + this.name + ";color=" + this.color + "}";
    }
}
