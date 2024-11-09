package controller;

import validation.InputOrderValidation;
import view.InputView;
import view.OutputView;

public final class OrderController {
    public static void order() {
        while (true) {
            try {
                orderInput();
                return;
            } catch (IllegalArgumentException error) {
                OutputView.outputErrorMessage(error);
            }
        }
    }

    private static void orderInput() throws IllegalArgumentException {
        String inputOrder = InputView.inputOrder();
        InputOrderValidation.inputOrderValidation(inputOrder);
    }
}
