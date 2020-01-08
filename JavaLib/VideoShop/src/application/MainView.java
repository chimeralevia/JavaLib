package application;

import entities.Article;
import entities.ArticleType;
import entities.GamingConsole;
import entities.Genre;
import entities.Manufacturer;
import entities.VideoGame;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

	private BorderPane mainBorderPane = new BorderPane();
	private Scene scene = new Scene(this.mainBorderPane, 1000, 700);
	private BorderPane menuPane = new BorderPane();
	private ComboBox<ArticleType> articleTypePicker = new ComboBox<>();

	private VBox consoleMenuItems = new VBox();
	private TextField consoleNameInputField = new TextField();
	private ComboBox<Manufacturer> manufacturerPicker = new ComboBox<>();

	private VBox videoGamesMenuItems = new VBox();
	private TextField gameNameInputField = new TextField();
	private ComboBox<Genre> genrePicker = new ComboBox<>();
	private TextField ageRestrictionField = new TextField();

	private HBox buttonBox = new HBox();
	private Button sellButton = new Button("Verkaufen");
	private Button buyButton = new Button("Kaufen");

	private ListView<Article> articleListView = new ListView<>();

	@Override
	public void start(Stage primaryStage) {
		try {
			this.initNodesLayout();
			this.initNodesDefaultValues();
			this.initNodesEventHandlers();
			
			primaryStage.setScene(this.scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initNodesLayout() {
		this.mainBorderPane.setLeft(this.menuPane);
		this.mainBorderPane.setCenter(this.articleListView);
		this.menuPane.setTop(this.articleTypePicker);
		this.menuPane.setBottom(this.buttonBox);

		this.consoleMenuItems.getChildren().addAll(this.consoleNameInputField, this.manufacturerPicker);
		this.videoGamesMenuItems.getChildren().addAll(this.gameNameInputField, this.genrePicker,
				this.ageRestrictionField);
		this.buttonBox.getChildren().addAll(this.buyButton, this.sellButton);
	}
	
	private void initNodesDefaultValues() {
		this.consoleNameInputField.setPromptText("Name");
		this.gameNameInputField.setPromptText("Name");
		this.ageRestrictionField.setPromptText("Altersfreigabe");
		
		this.manufacturerPicker.getItems().addAll(Manufacturer.values());
		this.genrePicker.getItems().addAll(Genre.values());
		this.articleTypePicker.getItems().addAll(ArticleType.values());
		
		this.manufacturerPicker.getSelectionModel().selectFirst();
		this.genrePicker.getSelectionModel().selectFirst();
	}
	
	private void initNodesEventHandlers() {
		this.articleTypePicker.setOnAction(e -> {
			switch (this.articleTypePicker.getValue()) {
			case VIDEO_GAME:
				this.menuPane.setCenter(this.videoGamesMenuItems);
				this.articleListView
						.setItems(FXCollections.observableArrayList(VideoGame.getStorage().getStorageList()));
				break;
			case CONSOLE:
				this.menuPane.setCenter(this.consoleMenuItems);
				this.articleListView
						.setItems(FXCollections.observableArrayList(GamingConsole.getStorage().getStorageList()));
				break;
			default:
				break;
			}
		});

		this.buyButton.setOnAction(e -> {
			switch (this.articleTypePicker.getValue()) {
			case VIDEO_GAME:
				VideoGame game = new VideoGame(this.gameNameInputField.getText(),
						Integer.parseInt(this.ageRestrictionField.getText()), this.genrePicker.getValue());
				VideoGame.getStorage().addItem(game);
				this.articleListView
						.setItems(FXCollections.observableArrayList(VideoGame.getStorage().getStorageList()));
				break;
			case CONSOLE:
				GamingConsole console = new GamingConsole(this.consoleNameInputField.getText(),
						this.manufacturerPicker.getValue());
				GamingConsole.getStorage().addItem(console);
				this.articleListView
						.setItems(FXCollections.observableArrayList(GamingConsole.getStorage().getStorageList()));
				break;
			default:
				break;
			}
		});

		this.sellButton.setOnAction(e -> {
			Article itemToBeRemoved = this.articleListView.getSelectionModel().getSelectedItem();
			switch (this.articleTypePicker.getValue()) {
			case VIDEO_GAME:
				VideoGame.getStorage().removeItem((VideoGame) itemToBeRemoved);
				this.articleListView
						.setItems(FXCollections.observableArrayList(VideoGame.getStorage().getStorageList()));
				break;
			case CONSOLE:
				GamingConsole.getStorage().removeItem((GamingConsole) itemToBeRemoved);
				this.articleListView
						.setItems(FXCollections.observableArrayList(GamingConsole.getStorage().getStorageList()));
				break;
			default:

				break;
			}
		});
	}

}
