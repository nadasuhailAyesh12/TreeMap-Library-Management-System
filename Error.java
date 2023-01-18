public class Error extends Stage {
    private Label errorMessage;
    private Scene scene;
    private StackPane errorWindow;
    private Button closeBtn = new Button("close");

    Error(String errorMessage) {
        super();
        this.errorMessage = new Label(errorMessage);
        GridPane pane = new GridPane();
        pane.setHgap(15);
        pane.add(this.errorMessage, 0, 0);
        pane.add(closeBtn, 1, 1);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        errorWindow = new StackPane(pane);
        scene = new Scene(errorWindow, 300, 300);
        this.setScene(scene);
        closeBtn.setOnAction(evt -> {
            this.close();
        });

    }
}