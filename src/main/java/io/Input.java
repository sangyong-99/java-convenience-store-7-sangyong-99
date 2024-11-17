package io;

import camp.nextstep.edu.missionutils.Console;
import validation.InputValidation;
import view.OutputView;

public final class Input {
    public static String inputMessage() {
        return Console.readLine();
    }

    public static String inputYOrN() {
        while(true) {
            try {
                return InputValidation.isYorN(inputMessage());
            } catch (IllegalArgumentException error){
                OutputView.outputErrorMessage(error);
            }
        }
    }
}
