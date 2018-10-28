package scesvi.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraficosFluxoController {
	@FXML
	private LineChart<String, Number> lineFluxo;

	@FXML
	private CategoryAxis xl;

	@FXML
	private NumberAxis yl;

	@FXML
	private BarChart<?, ?> barFluxo;

	@FXML
	private CategoryAxis xb;

	@FXML
	private NumberAxis yb;
	
	@FXML
	public void initialize() {
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		
		series.getData().add(new XYChart.Data<String, Number>("Jan", 75));
		series.setName("Institucional");
		lineFluxo.getData().add(series);
		
	}

}
