package ir.maktabsharif.util;

import jakarta.validation.ValidationException;

public class Ruls {

    private Ruls() {
    }

    public static void check(boolean validation, String message) {
        if (validation) throw new ValidationException(message);
    }
}
