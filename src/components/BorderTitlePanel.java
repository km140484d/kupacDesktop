package components;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BorderTitlePanel extends VBox {
    private Label titleLabel = new Label();
    private VBox contentPane = new VBox();
    private Node content;

    public void setContent(Node content){
        content.getStyleClass().add("bordered-titled-content");
        contentPane.getChildren().add(content);
    }

    public Node getContent() { return content; }

    public void setTitle(String title) {
        titleLabel.setText(" " + title + " ");
    }

    public String getTitle() {
        return titleLabel.getText();
    }

    public BorderTitlePanel(){
        titleLabel.setText("default title");
        titleLabel.getStyleClass().add("bordered-titled-title");
        getStyleClass().add("bordered-titled-border");
        getChildren().addAll(titleLabel, contentPane);
    }

}
