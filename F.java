import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.File;

public class VideoProcessorGUI extends Application {

    private String directory;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Video Processor");

        Button chooseDirectoryButton = new Button("Choose Directory");
        chooseDirectoryButton.setOnAction(e -> chooseDirectory(primaryStage));

        Button processButton = new Button("Process Videos");
        processButton.setOnAction(e -> processVideos());

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(chooseDirectoryButton, processButton);

        Scene scene = new Scene(vBox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void chooseDirectory(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Directory");
        File selectedDirectory = fileChooser.showDialog(primaryStage);

        if (selectedDirectory != null) {
            directory = selectedDirectory.getAbsolutePath();
        }
    }

    private void processVideos() {
        if (directory != null) {
            VideoProcessor videoProcessor = new VideoProcessor(directory, ".mp4", 30, 2.0);
            videoProcessor.processFiles();
        } else {
            System.out.println("Please choose a directory first.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
