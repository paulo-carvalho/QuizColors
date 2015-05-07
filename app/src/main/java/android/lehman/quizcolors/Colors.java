package android.lehman.quizcolors;

import java.util.EnumMap;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public enum Colors {

    ACID_GREEN("Acid Green", "#B0BF1A"),
    AERO("Aero", "#7CB9E8"),
    AERO_BLUE("Aero Blue", "#C9FFE5"),
    AFRICAN_VIOLET("African Violet", "#B284BE"),
    AIR_SUPERIORITY_BLUE("Air Superiority Blue", "#72A0C1"),
    ALABAMA_CRIMSON("Alabama Crimson", "#AF002A"),
    ALICE_BLUE("Alice Blue", "#F0F8FF"),
    ALIZARIN_CRIMSON("Alizarin Crimson", "#E32636"),
    ALLOY_ORANGE("Alloy Orange", "#C46210"),
    ALMOND("Almond", "#EFDECD"),
    AMARANTH("Amaranth", "#E52B50"),
    AMARANTH_DEEP_PURPLE("Amaranth Deep Purple", "#AB274F"),
    AMARANTH_PINK("Amaranth Pink", "#F19CBB"),
    AMARANTH_PURPLE("Amaranth Purple", "#AB274F"),
    AMARANTH_RED("Amaranth Red", "#D3212D"),
    AMAZON("Amazon", "#3B7A57"),
    AMBER("Amber", "#FFBF00"),
    AMBER_SAE_ECE("Amber (SAE/ECE)", "#FF7E00"),
    AMERICAN_ROSE("Acid Green", "#FF033E"),
    AMETHYST("Amethyst", "#9966CC"),
    ANDROID_GREEN("Android Green", "#A4C639");

    private final String nameColor;
    private final String hexColor;
    public static final int COUNT_COLORS = 20;

    Colors(String nameColor, String hexColor) {
        this.nameColor = nameColor;
        this.hexColor = hexColor;
    }

    public String nameColor() {
        return nameColor;
    }

    public String hexColor() {
        return hexColor;
    }
}
