package controller;

public final class ApplicationController {
    public void run() {
        LoadDataController.loadData();
        OrderController.order();
    }
}
