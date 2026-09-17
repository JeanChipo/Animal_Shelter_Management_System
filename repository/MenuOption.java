package repository;

public enum MenuOption {
    VIEW(1),
    ADOPT(2),
    ADD(3),
    UPDATE(4),
    END(5),
    TEST(6);

    private final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public static MenuOption fromValue(int value) {
        for (MenuOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }

        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}