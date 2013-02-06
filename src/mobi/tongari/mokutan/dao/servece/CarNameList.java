package mobi.tongari.mokutan.dao.servece;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonRootName;

public class CarNameList {
	private List<CarName> carNames;

	public List<CarName> getCarNames() {
		return carNames;
	}

	public void setCarNames(List<CarName> carNames) {
		this.carNames = carNames;
	}
}
