//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.isoft.accounts.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

public class ModelException extends RuntimeException {
    private final List<RuntimeException> errors;

    public ModelException() {
        this("");
    }

    public ModelException(String message) {
        super(message);
        this.errors = new ArrayList<>();
    }

    public void addError(RuntimeException e) {
        this.errors.add(e);
    }

    public void throwIfHasError() {
        if (this.errors.size() > 0) {
            throw new ModelException("Errors=" + this.errors);
        }
    }

    @Generated
    public List<RuntimeException> getErrors() {
        return this.errors;
    }
}
