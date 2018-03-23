package colorschemes;

import java.awt.Color;

public class LightColorScheme extends ColorScheme {

	@Override
	public Color getBackgroundColor() {
		return Color.WHITE;
	}

	@Override
	public Color getTextColor() {
		return Color.BLACK;
	}

	@Override
	public Color getButtonColor() {
		return Color.GRAY;
	}

	@Override
	public Color getButtonBorderColor() {
		return Color.BLACK;
	}

	@Override
	public Color getWorldBorderColor() {
		return Color.WHITE;
	}

}
