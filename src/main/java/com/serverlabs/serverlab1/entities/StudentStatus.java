package com.serverlabs.serverlab1.entities;

import java.io.Serializable;

public enum StudentStatus implements Serializable {
    ACTIVE,
    VACATION;

    public String getStatus() {
        return this.name();
    }
}
