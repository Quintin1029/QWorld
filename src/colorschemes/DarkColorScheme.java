package colorschemes;

import java.awt.Color;

public class DarkColorScheme extends ColorScheme {

	@Override
	public Color getBackgroundColor() {
		return new Color(20, 20, 20); //dark gray
	}

	@Override
	public Color getTextColor() {
		return Color.YELLOW;
	}

	@Override
	public Color getButtonColor() {
		return new Color(58, 58, 58); //lighter gray
	}

	@Override
	public Color getButtonBorderColor() {
		return new Color(40, 40, 40); //darkish gray
	}

	@Override
	public Color getWorldBorderColor() {
		return new Color(100, 100, 100);
	}

}
